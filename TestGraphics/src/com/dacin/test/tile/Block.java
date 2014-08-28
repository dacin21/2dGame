package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Main;
import com.dacin.test.sprite.Sprite;

public class Block extends Tile {

	public Block(int setX, int setY) {
		super(setX, setY);
	}

	public void tick() {
		colideSprite(Main.player);

	}

	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + 16, y);
		GL11.glVertex2f(x + 16, y + 16);
		GL11.glVertex2f(x, y + 16);
		GL11.glEnd();

		GL11.glPopMatrix();

	}

	public void colideSprite(Sprite sprite) {
		float px = sprite.x;
		float py = sprite.y;
		float pnx = sprite.getNewX();
		float pny = sprite.getNewY();

		// floor
		if (py >= y + 16 + 8 && pny < y + 16 + 8) {
			if (((pnx >= x - 8)||(px >= x - 8)) && ((px < x + 16 + 8)||(pnx < x + 16 + 8))) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py <= y - 8 && pny > y - 8) {
			if (((pnx >= x - 8)||(px >= x - 8)) && ((px < x + 16 + 8)||(pnx < x + 16 + 8))) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		pny = sprite.getNewY();
		if (py < y + 16 + 8 && py > y - 8) {
			// right
			if (px < x - 8 && pnx >= x - 8) {
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
			}
			// left
			if (px >= x + 16 + 8 && pnx < x + 16 + 8) {
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
