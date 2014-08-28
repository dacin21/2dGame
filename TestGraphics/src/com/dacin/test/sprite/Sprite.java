package com.dacin.test.sprite;

import org.lwjgl.opengl.GL11;

import com.dacin.test.tile.Tile;

public abstract class Sprite extends Tile {
	//const
	//protected
	protected boolean dead = false;
	//public
	public float xVel, yVel;
	

	public Sprite(int setX, int setY) {
		super(setX, setY);
	}
	
	public void tick(){
		x += xVel;
		y += yVel;
	}
	
	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		if (dead) {
			GL11.glColor3f(0.0f, 1.0f, 0.0f);
		}

		final double pi2 = Math.PI * 2 / 20;

		GL11.glVertex3f(x, y, 0);
		for (int i = 0; i <= 20; i++) {
			GL11.glVertex2f(x + (float) (8 * Math.cos(pi2 * i)), y
					+ (float) (8 * Math.sin(pi2 * i)));
		}
		// GL11.glVertex3f(x + 8, y , 0);
		// GL11.glVertex3f(x, y + 8, 0);
		// GL11.glVertex3f(x - 8, y , 0);
		GL11.glEnd();

		GL11.glPopMatrix();
	}
	
	
	public float getNewX() {
		return x + xVel;
	}

	public float getNewY() {
		return y + yVel;
	}

	public void kill() {
		dead = true;
	}
	public boolean getUseless(){
		return dead;
	}
	
	public void floor(float y){
	}
	public void ceil(float y){
	}
	public void wall(float x){
		
	}

}
