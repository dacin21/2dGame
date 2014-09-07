package com.dacin.test.sprite.player;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Controls;
import com.dacin.test.Main;
import com.dacin.test.sprite.player.PlayerShot;
import com.dacin.test.sprite.Sprite;

public class Player extends Sprite {
	// Const
	private static final int CORNERS = 15;
	private static final float GRAVITY = 0.5f;
	private static final float maxXVel = 3;
	private static final float maxYVel = -8;
	private Random random = new Random();
	// private
	private Controls input;
	private byte jump = 1;
	private boolean faceingRight = true;
	private int shotCD = 0;
	private boolean oldShot = false;

	// public

	public Player(int setX, int setY, Controls input2) {
		super(setX, setY);
		this.input = input2;
		xVel = yVel = 0;
		xr=yr=8;
	}

	public void tick() {
		if (input.reset) dead = false;
		if(dead) return;
		super.tick();
		calcVel();
	}

	public void render() {
		if(dead) return;
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(0.3f, 0.2f, 0.9f);

		final double pi2 = Math.PI * 2 / CORNERS;
		
		GL11.glVertex3f(x, y, 0);
		for (int i = 0; i <= CORNERS; i++) {
			GL11.glVertex2f(x + (float) (8 * Math.cos(pi2 * i)), y + (float) (8 * Math.sin(pi2 * i)));
		}
		// GL11.glVertex3f(x + 8, y , 0);
		// GL11.glVertex3f(x, y + 8, 0);
		// GL11.glVertex3f(x - 8, y , 0);
		GL11.glEnd();

		GL11.glPopMatrix();
	}

	public void calcVel() {
		if(input.shoot && shotCD == 0 && PlayerShot.shotCount < 5 && !oldShot){
			shotCD=2;
			Main.stage.addFriendlySprite(new PlayerShot((int)this.x, (int)this.y, faceingRight ? 7 : -7));
		} else shotCD = shotCD == 0 ? 0 : shotCD-1;
		oldShot = input.shoot;
		
		
		
		
		if (input.right) {
			faceingRight=true;
			if (++xVel > maxXVel) xVel--;
		}else {if (input.left) {
			faceingRight=false;
			if (--xVel < -maxXVel) xVel++;
			} else xVel = 0;
		}
			/*
			 * Even/Odd: W= 0/1 0/2/4 jumps done
			 */
			if (input.jump) {
				if (jump == 1) {
					jump ++;
					yVel = 8.0f;
					return;
				} else if (jump == 3) {
					jump ++;
					yVel = 7.0f;
					return;
				}
				if((jump & 1) == 1) jump ++;
			} else {
				if ((jump & 1) == 0) {
					jump++;
				}
				if (yVel > 2) yVel = 2;
			}

		yVel -= GRAVITY;
		air();


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

	public void teleport(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public void kill(){
		if(dead) return;
		super.kill();
		for(int i=0;i<100;i++){
			Main.stage.addFriendlySprite(new Blood((int)x,(int)y));
		}
	}
	public void air(){
		jump|=2;
	}

}
