package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Input;
import com.dacin.test.sprite.Sprite;

public class Player extends Sprite {
	// Const
	private static final int CORNERS = 15;
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
			xVel = -2;
		else {
			if (input.right)
				xVel = 2;
			else xVel = 0;
		}
		
		if (jump < 5) {
			if (input.w) {
				if ((jump & 1) == 1) {
					jump++;
					yVel = 4.875f;
				}

			} else {
				if ((jump & 1) == 0) {
					jump++;
				}
			}

		}

		yVel -= 0.25;

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
