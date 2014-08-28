package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Input;

public class Player extends Tile {
	private Input input;
	public float xVel, yVel;
	private static final int CORNERS=15;
	private byte jump = 0;
	private boolean dead = false;
	public float floor = 0;

	public Player(int setX, int setY, Input input) {
		super(setX, setY);
		this.input = input;
		xVel = yVel = 0;
	}

	public void tick() {
		if (input.r) dead = false;
		x += xVel;
		y += yVel;
		super.tick();
		if (input.left)
			xVel = -2;
		else {
			if (input.right)
				xVel = 2;
			else xVel = 0;
		}
		gravity();
	}

	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(0.7f, 0.4f, 0.5f);
		if (dead) {
			GL11.glColor3f(1.0f, 0.0f, 0.0f);
		}
		
		
		
		final double pi2 = Math.PI*2/CORNERS;
		
		GL11.glVertex3f(x , y , 0);
		for(int i=0;i<=CORNERS;i++){
			GL11.glVertex2f(x+(float)(8*Math.cos(pi2*i)), y+(float)(8*Math.sin(pi2*i)));
		}
		//GL11.glVertex3f(x + 8, y , 0);
		//GL11.glVertex3f(x, y + 8, 0);
		//GL11.glVertex3f(x - 8, y , 0);
		GL11.glEnd();

		GL11.glPopMatrix();
	}

	public void gravity() {
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

	public void kill() {
		dead = true;
	}

	public float getNewX() {
		return x + xVel;
	}

	public float getNewY() {
		return y + yVel;
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