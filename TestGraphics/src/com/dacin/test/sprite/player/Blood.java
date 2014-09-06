package com.dacin.test.sprite.player;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.dacin.test.sprite.Sprite;

public class Blood extends Sprite {
	// const
	private static final float SPREAD = 20.0f;
	// private
	private Random random = new Random();

	// public
	public Blood(int setX, int setY) {
		super(setX, setY);
		xr = yr = 1;
		xVel = random.nextFloat() * SPREAD - SPREAD / 2;
		yVel = random.nextFloat() * SPREAD - SPREAD / 2;
		// TODO Auto-generated constructor stub
	}


	public void tick() {
		x += xVel;
		y += yVel;
		calcVel();
		if (x < 0 || x > Display.getWidth()) kill();
		if (y < 0 || y > Display.getHeight()) kill();
	}

	public void render() {

		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(1.0f, 0.0f, 0.0f);
		GL11.glVertex2f(x - 1, y - 1);
		GL11.glVertex2f(x - 1, y + 1);
		GL11.glVertex2f(x + 1, y + 1);
		GL11.glVertex2f(x + 1, y - 1);

		GL11.glEnd();

		GL11.glPopMatrix();

	}

	private void calcVel() {
		yVel -= 0.2;

	}

	public void floor(float y) {
		this.y = y;
		this.yVel = 0.0f;
		this.xVel *= 0.95;
	}

	public void ceil(float y) {
		this.y = y;
		this.yVel = 0.0f;
	}

	public void wall(float x) {
		this.x = x;
		this.xVel = 0;
	}

}
