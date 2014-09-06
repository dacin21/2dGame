package com.dacin.test.sprite.player;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.dacin.test.sprite.Sprite;

public class PlayerShot extends Sprite {
	public static byte shotCount = 0;

	public PlayerShot(int setX, int setY, int xVel) {
		super(setX, setY);
		shotCount++;
		this.xVel=xVel;
		xr=yr=2;
		// TODO Auto-generated constructor stub
	}
	
	public void render() {
		GL11.glPushMatrix();
		GL11.glLoadIdentity();

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glColor3f(0.8f, 0.8f, 0.8f);
		
		GL11.glVertex3f(x-5, y, 0);
		GL11.glVertex3f(x-5, y+5, 0);
		GL11.glVertex3f(x, y+5, 0);
		GL11.glVertex3f(x, y, 0);
		GL11.glEnd();

		GL11.glPopMatrix();
	}
	public void kill(){
		super.kill();
		shotCount--;
	}
	
	public void tick(){
		x+=xVel;
		if(x<0||x>(Display.getWidth())){
			this.kill();
			shotCount--;
		}
	}
	
	public void wall(float x){
		this.kill();
	}

}
