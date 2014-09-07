package com.dacin.test.sprite.text;

import org.lwjgl.opengl.GL11;

import com.dacin.test.sprite.Sprite;
import com.dacin.test.tile.Tile;

public class StringSprite extends Tile {
	private Tile[] charSprites;
	private int charcount = 0;

	public StringSprite(int setX, int setY, String string) {
		super(setX, setY);
		CharSprite.reline();
		charSprites = new Tile[string.length()];
		for (char e : string.toCharArray())
			parseChar(e);
	}

	public void render() {

		GL11.glColor3f(0.99f, 0.3f, 0.0f);
		for (Tile e : charSprites)
			e.render();
	}

	protected void parseString(String string) {
		char[] chars = string.toCharArray();
		for (char e : chars)
			parseChar(e);
	}

	protected void parseChar(char ch) {
		// 12x8 char
		if(ch == '/'){
			y-=15*CharSprite.SCALE;
			ch=' ';
			CharSprite.reline();
		}
		charSprites[charcount] = new CharSprite((int) (x), (int) y, ch);
		charcount++;

	}

}
