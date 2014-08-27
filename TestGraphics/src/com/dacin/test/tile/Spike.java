package com.dacin.test.tile;


import org.lwjgl.opengl.GL11;

import com.dacin.test.Main;


public class Spike extends Tile {
	
	private int rotation; // 0^  1>    2v   3<
	public Spike(int setX,int setY,int r){
		super(setX,setY);
		rotation=r;
	}
	
	public void tick(){
		colidePlayer();

	}
	
	public void render(){
		

		// draw quad
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glTranslatef(x, y, 0);
		GL11.glRotatef(rotation*90, 0.0f, 0.0f, 1f);
		GL11.glTranslatef(-x, -y, 0);
			
		GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(0.4f, 0.4f, 1.0f);
				GL11.glVertex3f(x - 16, y , 0);
				GL11.glVertex3f(x + 16, y , 0);
				GL11.glVertex3f(x, (y + 16), 0);
		GL11.glEnd();

		GL11.glPopMatrix();
		
	}
	
	public void colidePlayer(){
		float plx=Main.player.x;
		float ply=Main.player.y;
		if(((plx-this.x)*(plx-this.x)+(ply-this.y-8)*(ply-this.y-8))>550) return;
		Main.player.kill();
	}
	


}

