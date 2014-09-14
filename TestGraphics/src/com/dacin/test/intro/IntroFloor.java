package com.dacin.test.intro;

import com.dacin.test.shader.Texture;
import com.dacin.test.tile.RectangleBlock;

public class IntroFloor extends RectangleBlock {
	private static Texture tex = new Texture("res/Textures/Intro/Floor.png");
	

	public IntroFloor(int setX, int setY, int xSize, int ySize) {
		super(setX, setY, ySize, xSize);
		// TODO Auto-generated constructor stub
	}
	
	public void render(){
		renderWithTexture(tex);
	}

}
