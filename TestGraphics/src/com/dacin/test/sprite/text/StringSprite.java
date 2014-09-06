package com.dacin.test.sprite.text;

import org.lwjgl.opengl.GL11;

import com.dacin.test.sprite.Sprite;
import com.dacin.test.tile.Tile;

public class StringSprite extends Tile {
	private Tile[] charSprites;
	private int charcount = 0;

	public StringSprite(int setX, int setY, String string) {
		super(setX, setY);
		charSprites = new Tile[string.length()];
		for(char e:string.toCharArray()) parseChar(e);
	}
	
	public void render(){

		GL11.glColor3f(1.0f, 0.0f, 0.9f);
		for(Tile e:charSprites) e.render();
	}

	protected void parseString(String string){
		char[] chars = string.toCharArray();
		for(char e:chars) parseChar(e);
	}
	
	protected void parseChar(char ch){
		//12x8 char
		charSprites[charcount] = new CharSprite((int)(x), (int)y, ch);
		charcount++;
		
	}

}
