package com.dacin.test.tile;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.dacin.test.shader.ShaderUtils;
import com.dacin.test.shader.Texture;

public class BackGround extends Tile {
	
	protected static Texture texture = null;

	public BackGround(String texturePath) {
		super(0, 0);
		texture= new Texture(texturePath);
	}
	public void render(){

		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		
		ARBShaderObjects.glUseProgramObjectARB(ShaderUtils.TextureShaderId);
		glBindTexture(GL_TEXTURE_2D,texture.getID());

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x + Display.getWidth(), y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x + Display.getWidth(), y + Display.getHeight());
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x, y + Display.getHeight());
		GL11.glEnd();
		
		glBindTexture(GL_TEXTURE_2D,0);
		ARBShaderObjects.glUseProgramObjectARB(0);

		GL11.glPopMatrix();

		
	}

}
