package com.dacin.test.tile;

import com.dacin.test.shader.Texture;

public class BackGroundTile extends RectangleBlock{

	public BackGroundTile(int setX, int setY, int sizeY, int sizeX) {
		super(setX, setY, sizeY, sizeX);
	}
	public void tick(){
		return;
	}
	protected void renderWithTexture(Texture tex){
		super.renderWithTexture(tex);
	}

}
