package com.dacin.test.sprite.text;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.dacin.test.tile.Tile;

public class CharSprite extends Tile {
	// const
	private static int usedX = 0;
	private static final int SCALE = 1;
	// private
	private ArrayList<Integer> dotsX = new ArrayList<Integer>();
	private ArrayList<Integer> dotsY = new ArrayList<Integer>();

	public CharSprite(int setX, int setY, char ch) {
		super(setX, setY);
		parseChar(ch);
	}

	public void render() {

		GL11.glBegin(GL11.GL_LINE_STRIP);
		int l = dotsX.size();
		for (int i = 0; i < l; i++) {
			GL11.glVertex3i(dotsX.get(i), dotsY.get(i), 0);
		}
		GL11.glEnd();
	}

	private void addDot(int relx, int rely) {
		relx *= SCALE;
		rely *= SCALE;
		dotsX.add((int) (relx + usedX + x));
		dotsY.add( (int) (rely + y));

	}

	private void parseChar(char ch){
		switch(ch){
			//TODO: add all Chars
			case 'a':
				addDot(2,9);
				addDot(3, 10);
				addDot(6,10);
				addDot(8,8);
				addDot(8,1);
				addDot(8,6);
				addDot(3,6);
				addDot(1,4);
				addDot(1,3);
				addDot(3,1);
				addDot(8,1);
				usedX+=9;
				return;
			case 'b':
				
				return;
			case 'c':
				addDot(8,8);
				addDot(6,10);
				addDot(4,10);
				addDot(1,7);
				addDot(1,4);
				addDot(4,1);
				addDot(6,1);
				addDot(8,3);
				usedX+=9;
				return;
			case 'd':
				
				return;
			case 'e':
				addDot(1,5);
				addDot(7,5);
				addDot(7,8);
				addDot(5,10);
				addDot(3,10);
				addDot(1,8);
				addDot(1,3);
				addDot(2,2);
				addDot(6,2);
				return;
			
		}
	}
}
