package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

import com.dacin.test.Main;

public class Block extends Tile {

	public Block(int setX, int setY) {
		super(setX, setY);
	}
	
	public void tick(){
		colidePlayer();

	}
	
	public void render(){
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
			
		GL11.glBegin(GL11.GL_QUADS);
				GL11.glColor3f(1.0f, 0.0f, 1.0f);
				GL11.glVertex2f(x , y);
				GL11.glVertex2f(x + 16, y );
				GL11.glVertex2f(x + 16, y + 16);
				GL11.glVertex2f(x , y + 16);
		GL11.glEnd();

		GL11.glPopMatrix();
		
	}
	
	
	
	public void colidePlayer(){
		float px=Main.player.x;
		float py=Main.player.y;
		float pnx=Main.player.getNewX();
		float pny=Main.player.getNewY();

		//floor
		if(py>=y+16+8 && pny<=y+16+8){
			if(px>x-8 && px< x+16+8){
				if(Main.player.yVel<0){
					Main.player.floor(y+16+8);
					return;
				}
				
			}
		}
		//ceil
		if(py<=y-8 && pny>y-8){
			if(px>=x-8 && px < x+16+8){
				if(Main.player.yVel>0){
					Main.player.ceil(y-8);
				}
			}
		}
		//wall
		if(py<y+16+8 && py > y-8){
			//right
			if(px<=x-8 && pnx > x-8){
				if(Main.player.xVel > 0){
					Main.player.wall(x-8);
				}
			}
			//left
			if(px>=x+16+8 && pnx < x+16+8){
				if(Main.player.xVel < 0){
					Main.player.wall(x+16+8);
				}
			}
		}
		
		
		
		
		
		
		
	}

}
