package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Input;
import com.dacin.test.sprite.Sprite;

public class Player extends Sprite {
	// Const
	private static final int CORNERS = 15;
	private static final float GRAVITY = 0.5f;
	private static final float maxXVel = 3;
	private static final float maxYVel = -8;
	// private
	private Input input;
	private byte jump = 0;

	// public

	public Player(int setX, int setY, Input input) {
		super(setX, setY);
		this.input = input;
		xVel = yVel = 0;
	}

	public void tick() {
		super.tick();
		if (input.r) dead = false;
		calcVel();
	}

	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(0.3f, 0.2f, 0.9f);
		if (dead) {
			GL11.glColor3f(1.0f, 0.0f, 0.0f);
		}

		final double pi2 = Math.PI * 2 / CORNERS;

		GL11.glVertex3f(x, y, 0);
		for (int i = 0; i <= CORNERS; i++) {
			GL11.glVertex2f(x + (float) (8 * Math.cos(pi2 * i)), y
					+ (float) (8 * Math.sin(pi2 * i)));
		}
		// GL11.glVertex3f(x + 8, y , 0);
		// GL11.glVertex3f(x, y + 8, 0);
		// GL11.glVertex3f(x - 8, y , 0);
		GL11.glEnd();

		GL11.glPopMatrix();
	}

	public void calcVel() {
		if (input.left)
			xVel--;
		else {
			if (input.right)
				xVel++;
			else xVel = 0;
		}
		if (jump < 5) {
			/*
			 * Even/Odd: W= 0/1 0/2/4 jumps done
			 */
			if (input.w) {
				if (jump == 1) {
					jump++;
					yVel = 8.0f;
					return;
				} else if (jump == 3) {
					jump++;
					yVel = 7.0f;
					return;
				}
			} else {
				if ((jump & 1) == 0) {
					jump++;
				}
				if (yVel > 2) yVel = 2;
			}

		}

		yVel -= GRAVITY;

		if (xVel < -maxXVel) xVel = -maxXVel;
		if (xVel > maxXVel) xVel = maxXVel;
		if (yVel < maxYVel) yVel = maxYVel;

	}

	public void floor(float y) {
		this.y = y;
		this.yVel = 0;
		jump &= 1;

	}

	public void ceil(float y) {
		this.y = y;
		this.yVel = 0;
	}

	public void wall(float x) {
		this.x = x;
		this.xVel = 0;
	}

}
