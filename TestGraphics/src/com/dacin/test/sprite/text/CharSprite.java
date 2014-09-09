package com.dacin.test.sprite.text;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.dacin.test.tile.Tile;

public class CharSprite extends Tile {
	// const
	private static int usedX = 0;
	public static int SCALE = 4;
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
		dotsY.add((int) (rely + y));

	}

	private void parseChar(char ch) {
		switch (ch) {
		// TODO: add all Chars
			case ' ':
				usedX+=8*SCALE;
				return;
			case 'a':
				addDot(2, 9);
				addDot(3, 10);
				addDot(6, 10);
				addDot(8, 8);
				addDot(8, 1);
				addDot(8, 6);
				addDot(3, 6);
				addDot(1, 4);
				addDot(1, 3);
				addDot(3, 1);
				addDot(8, 1);
				usedX += 9 * SCALE;
				return;
			case 'b':
				addDot(1, 15);
				addDot(1, 2);
				addDot(2, 1);
				addDot(6,1);
				addDot(8,3);
				addDot(8,7);
				addDot(6, 9);
				addDot(4, 9);
				addDot(1, 6);
				usedX += 9 * SCALE;
				return;
			case 'c':
				addDot(8, 8);
				addDot(6, 10);
				addDot(4, 10);
				addDot(1, 7);
				addDot(1, 4);
				addDot(4, 1);
				addDot(6, 1);
				addDot(8, 3);
				usedX += 9 * SCALE;
				return;
			case 'd':
				//b
				addDot(8, 15);
				addDot(8, 2);
				addDot(7, 1);
				addDot(3,1);
				addDot(1,3);
				addDot(1,7);
				addDot(3, 9);
				addDot(5, 9);
				addDot(8, 6);
				addDot(8,1);
				usedX += 9 * SCALE;

				return;
			case 'e':
				addDot(1, 5);
				addDot(7, 5);
				addDot(7, 8);
				addDot(5, 10);
				addDot(3, 10);
				addDot(1, 8);
				addDot(1, 3);
				addDot(3, 1);
				addDot(5, 1);
				addDot(6, 2);
				usedX += 8 * SCALE;
				return;
			case 'f':
				addDot(6,13);
				addDot(4,13);
				addDot(3,8);
				addDot(1,8);
				addDot(5,8);
				addDot(3,8);
				addDot(3,1);
				usedX+=6*SCALE;
				return;
			case 'g':
				addDot(5,3);
				addDot(2,3);
				addDot(1,5);
				addDot(1,7);
				addDot(2,10);
				addDot(6,10);
				addDot(6,1);
				addDot(5,-1);
				addDot(1,-1);
				usedX+=7*SCALE;
				return;
			case 'h':
				addDot(1, 15);
				addDot(1, 1);
				addDot(1, 6);
				addDot(4, 9);
				addDot(6, 9);
				addDot(8, 7);
				addDot(8, 1);
				usedX += 9 * SCALE;
				return;
				
			case '^':
				//used for dots on i/j
				addDot(1, 9);
				addDot(1, 11);
				usedX += 2 * SCALE;
				return;

			case 'i':
				//use ^ afterwards
				addDot(1, 1);
				addDot(1, 7);
				return;

			case 'j':
				addDot(1, -3);
				addDot(1, 7);
				//use ^ afterwards
				return;

			case 'k':
				addDot(1, 15);
				addDot(1, 1);
				addDot(1, 6);
				addDot(7, 10);
				addDot(1, 6);
				addDot(7, 1);
				usedX += 8 * SCALE;
				return;

			case 'l':
				addDot(1, 1);
				addDot(1, 15);
				usedX+=2*SCALE;
				return;
				
			case 'm':
				addDot(1,1);
				addDot(1,7);
				addDot(3,9);
				addDot(4,9);
				addDot(6,7);
				addDot(6,2);
				addDot(6,7);
				addDot(8,9);
				addDot(9,9);
				addDot(11,7);
				addDot(11,1);
				usedX+=12*SCALE;
				return;
			case 'n':
				addDot(1,1);
				addDot(1,9);
				addDot(1,6);
				addDot(3,8);
				addDot(5,8);
				addDot(7,6);
				addDot(7,1);
				usedX+=8*SCALE;
				return;
			case 'o':
				addDot(3,9);
				addDot(5,9);
				addDot(7,7);
				addDot(7,4);
				addDot(5,2);
				addDot(3,2);
				addDot(1,4);
				addDot(1,7);
				addDot(3,9);
				usedX+=8*SCALE;
				return;
			case 'p':
				addDot(1,-3);
				addDot(1,8);
				addDot(5,8);
				addDot(7,6);
				addDot(7,3);
				addDot(5,1);
				addDot(1,1);
				usedX+=8*SCALE;
				return;
			case 'q':
				addDot(7,-3);
				addDot(7,9);
				addDot(3,9);
				addDot(1,6);
				addDot(1,4);
				addDot(3,2);
				addDot(7,2);
				usedX+=8*SCALE;
				return;
			case 'r':
				addDot(1,1);
				addDot(1,9);
				addDot(1,7);
				addDot(3,9);
				usedX+=3*SCALE;
				return;
			case 's':
				addDot(1,2);
				addDot(3,2);
				addDot(5,4);
				addDot(5,5);
				addDot(4,6);
				addDot(2,6);
				addDot(1,7);
				addDot(1,8);
				addDot(3,10);
				addDot(5,10);
				usedX+=6*SCALE;
				return;
			case 't':
				addDot(3,1);
				addDot(1,3);
				addDot(1,11);
				addDot(1,9);
				addDot(3,9);
				usedX+=4*SCALE;
				return;
			case 'u':
				addDot(1,11);
				addDot(1,4);
				addDot(4,1);
				addDot(5,1);
				addDot(8,4);
				addDot(8,1);
				addDot(8,11);
				usedX+=9*SCALE;
				return;
			case 'v':
				addDot(1,10);
				addDot(4,1);
				addDot(7,10);
				usedX+=8*SCALE;
				return;
			case 'w':
				addDot(1,9);
				addDot(3,1);
				addDot(5,4);
				addDot(7,1);
				addDot(9,9);
				usedX+=10*SCALE;
				return;
			case 'x':
				addDot(1,1);
				addDot(7,9);
				addDot(4,5);
				addDot(1,9);
				addDot(7,1);
				usedX+=8*SCALE;
				return;
			case 'y':
				addDot(6,10);
				addDot(6,4);
				addDot(0,-2);
				addDot(4,2);
				addDot(1,5);
				addDot(1,10);
				usedX+=7*SCALE;
				return;
			case 'z':
				addDot(1,10);
				addDot(7,10);
				addDot(1,1);
				addDot(7,1);
				usedX+=8*SCALE;
				return;
			//TODO: Uppercase Letters

				
				
			case 'J':
				addDot(7,14);
				addDot(7,5);
				addDot(6,2);
				addDot(4,1);
				addDot(2,2);
				addDot(1,5);
				usedX+=8* SCALE;
				
				return;
				
			case 'P':
				addDot(1,1);
				addDot(1,14);
				addDot(5,14);
				addDot(8,11);
				addDot(8,9);
				addDot(5,6);
				addDot(1,6);
				usedX+=9*SCALE;
				return;
			case 'S':
				addDot(1,3);
				addDot(3,1);
				addDot(7,1);
				addDot(9,3);
				addDot(9,6);
				addDot(7,8);
				addDot(3,8);
				addDot(1,10);
				addDot(1,13);
				addDot(3,15);
				addDot(7,15);
				addDot(9,13);
				usedX+=10*SCALE;
				return;
				
			case 'T':
				addDot(1,14);
				addDot(5,14);
				addDot(5,1);
				addDot(5,14);
				addDot(9,14);
				usedX+=10*SCALE;
				return;
				
			case 'U':
				addDot(1,14);
				addDot(1,5);
				addDot(3,2);
				addDot(5,1);
				addDot(7,2);
				addDot(9,5);
				addDot(9,14);
				usedX+=10*SCALE;
				return;

			case 'W':

				addDot(1,14);
				addDot(3,1);
				addDot(5,6);
				addDot(7,1);
				addDot(9,14);
				usedX+=10*SCALE;
				return;


		}
	}
	public static void reline(){
		usedX=0;
	}
}
