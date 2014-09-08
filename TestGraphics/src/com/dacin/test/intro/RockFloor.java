package com.dacin.test.intro;

import com.dacin.test.shader.Texture;
import com.dacin.test.tile.RectangleBlock;

public class RockFloor extends RectangleBlock {
	private static final Texture tex = new Texture("res/Textures/Intro/RockFloor.png");

	public RockFloor(int setX, int setY, int sizeY, int sizeX) {
		super(setX, setY, sizeY, sizeX);
	}
	
	public void render(){
		renderWithTexture(tex);
	}

}
