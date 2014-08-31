package com.dacin.test.tile;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;

import com.dacin.test.shader.ShaderUtils;
import com.dacin.test.shader.Texture;
import com.dacin.test.sprite.Sprite;
import com.dacin.test.stage.Stage;

public class Block extends Tile {
	
	protected static Texture texture = new Texture("Textures/Tile/Block.jpg");
	protected int Size=16;
	public Block(int setX, int setY) {
		super(setX, setY);
	}

	public void tick() {
		colideSprite(Stage.player);

	}

	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		
		ARBShaderObjects.glUseProgramObjectARB(ShaderUtils.TextureShaderId);
		glBindTexture(GL_TEXTURE_2D,texture.getID());

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x + Size, y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x + Size, y + Size);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x, y + Size);
		GL11.glEnd();
		
		glBindTexture(GL_TEXTURE_2D,0);
		ARBShaderObjects.glUseProgramObjectARB(0);

		GL11.glPopMatrix();

	}

	public void colideSprite(Sprite sprite) {
		float px = sprite.x;
		float py = sprite.y;
		float pnx = sprite.getNewX();
		float pny = sprite.getNewY();

		// floor
		if (py >= y + Size + 8 && pny < y + Size + 8) {
			if (((pnx > x - 8)||(px > x - 8)) && ((px < x + Size + 8)||(pnx < x + Size + 8))) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py <= y - 8 && pny > y - 8) {
			if (((pnx >= x - 8)||(px >= x - 8)) && ((px < x + Size + 8)||(pnx < x + Size + 8))) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		pny = sprite.getNewY();
		if (py < y + Size + 8 && py > y - 8) {
			// right
			if (px <= x - 8 && pnx > x - 8) {
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
			}
			// left
			if (px >= x + Size + 8 && pnx < x + Size + 8) {
				if (sprite.xVel < 0) {
					collideL(sprite);
				}
			}
		}


	}
	
	
	protected void collideTop(Sprite sprite){
	}
	protected void collideBot(Sprite sprite){
	}
	protected void collideR(Sprite sprite){
	}
	protected void collideL(Sprite sprite){
	}
	

}
