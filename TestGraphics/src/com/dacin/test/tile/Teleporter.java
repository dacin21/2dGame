package com.dacin.test.tile;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;

import com.dacin.test.Main;
import com.dacin.test.shader.ShaderUtils;
import com.dacin.test.shader.Texture;
import com.dacin.test.stage.Stage;

public class Teleporter extends Tile {
	private int animCounter = 0;
	private static final int RADIUS = 128;
	private static final Texture[] tex = {new Texture("res/Textures/Tile/Teleporter.png"),new Texture("res/Textures/Tile/Teleporter1.png"),new Texture("res/Textures/Tile/Teleporter2.png")};
	// Circle => 64 Triangles
	private final int TIMES = 64;
	private final double PARTANGLE = Math.PI * 2 / TIMES;

	/**
	 * This Tile has its x,y in the Centre
	 * 
	 * @param setX
	 * @param setY
	 */
	public Teleporter(int setX, int setY) {
		super(setX, setY);
	}

	public void tick() {
		if (animCounter == 0){
			if ((Stage.player.x - x) * (Stage.player.x - x) + (Stage.player.y - y) * (Stage.player.y - y) < (RADIUS + 8) * (RADIUS + 8)) animCounter = 1;
			return;
		}
		if(animCounter++ == 150){
			animCounter = 0;
			Main.nextLevel();
		}
	}

	public void render() {
		if(animCounter > 0){
			renderAnim();
			return;
		}
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		glBindTexture(GL_TEXTURE_2D,tex[0].getID());
		renderTexture();

	}
	
	private void renderAnim(){
		//epic but wrong:
		//GL11.glColor4f((float)Math.cos(animCounter/10.0f), (float)Math.cos(animCounter/10.0f-11), (float)Math.cos(animCounter/10.0f-22),1.0f);
		GL11.glColor4f((float)Math.cos(animCounter/8.0f), (float)Math.cos(animCounter/8.0f-20.9f), (float)Math.cos(animCounter/8.0f+20.9f),1.0f);
		glBindTexture(GL_TEXTURE_2D,tex[((animCounter&32)==32 ? 1:2)].getID());
		renderTexture();
		
	}
	
	private void renderTexture(){

		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		ARBShaderObjects.glUseProgramObjectARB(ShaderUtils.RGBTextureShaderId);
		
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glTexCoord2f(0.5f,0.5f);
		GL11.glVertex3f(x, y, 0);
		for (int i = 0; i <= TIMES; i++) {
			GL11.glTexCoord2f(((float)Math.cos(PARTANGLE * i)/2+0.5f),((float)Math.sin(PARTANGLE * i))/2+0.5f);
			GL11.glVertex2f(x + (float) (RADIUS * Math.cos(PARTANGLE * i)), y + (float) (RADIUS * Math.sin(PARTANGLE * i)));
		}

		GL11.glEnd();
		glBindTexture(GL_TEXTURE_2D,0);
		ARBShaderObjects.glUseProgramObjectARB(0);
		GL11.glPopMatrix();
	}

	public void move() throws IllegalAccessException {
		throw new IllegalAccessException();
	}

}
