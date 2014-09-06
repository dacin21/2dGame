package com.dacin.test.tile;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;

import com.dacin.test.Main;
import com.dacin.test.shader.ShaderUtils;
import com.dacin.test.shader.Texture;
import com.dacin.test.sprite.Sprite;
import com.dacin.test.stage.Stage;

public class Block extends Tile {
	
	protected static Texture texture = new Texture("res/Textures/Tile/Block.jpg");
	protected int Size=16;
	public Block(int setX, int setY) {
		super(setX, setY);
	}

	public void tick() {
		colideSprite(Stage.player, 8);
		for(Sprite e:Main.stage.friendlySprites) colideSprite(e,4);

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
	/**Use to test for colision of a Square with a Square of same orientation
	 * 
	 * @param QuadraticSprite
	 */

	public void colideSprite(Sprite sprite, int radius) {
		float px = sprite.x;
		float py = sprite.y;
		float pnx = sprite.getNewX();
		float pny = sprite.getNewY();
		//TODO: Fix wall bug
		// floor
		if (py >= y + Size + radius && pny < y + Size + radius) {
			if (((pnx > x - radius)||(px > x - radius)) && ((px < x + Size + radius)||(pnx < x + Size + radius))) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py <= y - radius && pny > y - radius) {
			if (((pnx > x - radius)||(px > x - radius)) && ((px < x + Size + radius)||(pnx < x + Size + radius))) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		pny = sprite.getNewY();
		if (py < y + Size + radius && py > y - radius) {
			// right
			if (px <= x - radius && pnx > x - radius) {
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
			}
			// left
			if (px >= x + Size + radius && pnx < x + Size + radius) {
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
