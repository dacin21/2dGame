package com.dacin.test.intro;

import com.dacin.test.shader.Texture;
import com.dacin.test.tile.BackGroundTile;

public class TreeBackGroundTile extends BackGroundTile {
	private byte usedNr;
	private static Texture[] texs = {new Texture("res/Textures/Intro/Tree_TL.png"), new Texture("res/Textures/Intro/Tree_T.png"), new Texture("res/Textures/Intro/Tree_TR.png")
			, new Texture("res/Textures/Intro/Tree_L.png"), new Texture("res/Textures/Intro/Tree_.png"), new Texture("res/Textures/Intro/Tree_R.png")
			, new Texture("res/Textures/Intro/Tree_BL.png"), new Texture("res/Textures/Intro/Tree_B.png"), new Texture("res/Textures/Intro/Tree_BR.png")
			, new Texture("res/Textures/Intro/Tree_TLI.png"), new Texture("res/Textures/Intro/Tree_TRI.png")};

	/** Nums for Tree ('=Inside Corner)<br>
	 * 	9'	0	1	2	10'<br>
	 * 		3	4	5	<br>
	 * 		6	7	8
	 * 
	 */
	public TreeBackGroundTile(int setX, int setY, int sizeY, int sizeX, int num) {
		super(setX, setY, sizeY, sizeX);
		usedNr=(byte)num;
	}
	public void render(){
		renderWithTexture(texs[usedNr]);
	}

}
