package com.dacin.test.tile;

import com.dacin.test.shader.Texture;
import com.dacin.test.sprite.Sprite;

public class ConveyorBelt extends RectangleBlock {
	
	private static final  Texture texture = new Texture("res/Textures/Intro/ConveyorBelt.png");

	public ConveyorBelt(int setX, int setY, int sizeY, int sizeX) {
		super(setX, setY, sizeY, sizeX);
		// TODO Auto-generated constructor stub
	}
	
	public void tick(){
		super.tick();
	}
	
	public void render(){
		renderWithTexture(texture);
	}

	protected void collideTop(Sprite sprite) {
		sprite.move(1.0f, 0.0f);
	}
	
	public void colideSprite(Sprite sprite) {
		float pnx = sprite.getNewX();
		float pny = sprite.getNewY();
		int xr = sprite.xr;
		int yr = sprite.yr;

		// floor
		if (pny <= y + ySize + yr) {
			if ((pnx > x) && (pnx <= x + xSize)) {
					collideTop(sprite);

			}
		}
	}

}
