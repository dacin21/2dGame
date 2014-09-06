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

public class RecktangleBlock extends Tile {
	
	protected Texture texture;
	protected int ySize, xSize;

	public RecktangleBlock(int setX, int setY, int sizeY, int sizeX, String Texturepath) {
		super(setX, setY);
		texture = new Texture(Texturepath);
		this.ySize=sizeY;
		this.xSize=sizeX;
		// TODO Auto-generated constructor stub
	}
	public void tick(){
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
	
	public void colideSprite(Sprite sprite, int radius) {
		float px = sprite.x;
		float py = sprite.y;
		float pnx = sprite.getNewX();
		float pny = sprite.getNewY();

		// floor
		if (py >= y + ySize + radius && pny < y + ySize + radius) {
			if (((pnx > x - radius)||(px > x - radius)) && ((px < x + xSize + radius)||(pnx < x + xSize + radius))) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py <= y - radius && pny > y - radius) {
			if (((pnx > x - radius)||(px > x - radius)) && ((px < x + xSize + radius)||(pnx < x + xSize + radius))) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		pny = sprite.getNewY();
		if (py < y + ySize + radius && py > y - radius) {
			// right
			if (px <= x - radius && pnx > x - radius) {
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
			}
			// left
			if (px >= x + xSize + radius && pnx < x + xSize + radius) {
				if (sprite.xVel < 0) {
					collideL(sprite);
				}
			}
		}
		


	}
	protected void collideTop(Sprite sprite) {
		sprite.floor(y + ySize + 8);
	}

	protected void collideBot(Sprite sprite) {
		sprite.ceil(y - 8);
	}

	protected void collideR(Sprite sprite) {
		sprite.wall(x - 8);
	}

	protected void collideL(Sprite sprite) {
		sprite.wall(x + xSize + 8);
	}

}
