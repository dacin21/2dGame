package com.dacin.test.tile;

import com.dacin.test.shader.Texture;
import com.dacin.test.sprite.Sprite;

public class ConveyorBelt extends RectangleBlock {
	
	private static final  Texture texture = new Texture("res/Textures/Intro/ConveyorBelt.jpg");

	public ConveyorBelt(int setX, int setY, int sizeY, int sizeX) {
		super(setX, setY, sizeY, sizeX);
		// TODO Auto-generated constructor stub
	}
	
	public void render(){
		renderWithTexture(texture);
	}

	protected void collideTop(Sprite sprite) {
		sprite.floor(y + ySize + sprite.yr);
		sprite.move(2.0f, 0.0f);
	}

}
