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

public class RectangleBlock extends Tile {
	
	private static final  Texture texture = new Texture("res/Textures/Tile/Block.jpg");
	protected int ySize, xSize;

	public RectangleBlock(int setX, int setY, int sizeY, int sizeX) {
		super(setX, setY);
		this.ySize=sizeY;
		this.xSize=sizeX;
	}
	public void tick(){
		colideSprite(Stage.player);
		for(Sprite e:Main.stage.friendlySprites) colideSprite(e);
	}
	
	public void render() {
		renderWithTexture(texture);
	}
	protected void renderWithTexture(Texture tex){

		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		
		ARBShaderObjects.glUseProgramObjectARB(ShaderUtils.TextureShaderId);
		glBindTexture(GL_TEXTURE_2D,tex.getID());

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glTexCoord2f(0,1);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x + xSize, y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x + xSize, y + ySize);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x, y + ySize);
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
		int xr = sprite.xr;
		int yr = sprite.yr;

		// floor
		if (py >= y + ySize + yr && pny < y + ySize + yr) {
			if ((pnx > x - xr) && (pnx < x + xSize + xr)) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py <= y - yr && pny > y - yr) {
			if ((px > x - xr) && (px < x + xSize + xr)) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		pny = sprite.getNewY();
		if (pny < y + ySize + yr && pny > y - yr) {
			// right
			if (px <= x - xr && pnx > x - xr) {
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
			}
			// left
			if (px >= x + xSize + xr && pnx < x + xSize + xr) {
				if (sprite.xVel < 0) {
					collideL(sprite);
				}
			}
		}
		


	}
	protected void collideTop(Sprite sprite) {
		sprite.floor(y + ySize + sprite.yr);
	}

	protected void collideBot(Sprite sprite) {
		sprite.ceil(y - sprite.yr);
	}

	protected void collideR(Sprite sprite) {
		sprite.wall(x - sprite.xr);
	}

	protected void collideL(Sprite sprite) {
		sprite.wall(x + xSize + sprite.xr);
	}

}
