package com.dacin.test.tile;

import org.lwjgl.opengl.GL11;

public abstract class Tile {		
		protected float x,y;
		public Tile(int setX,int setY){
			this.x=setX;
			this.y=setY;
		}
		
		public void tick(){
		}
		
		public void render(){
	
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
	
			GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(0.0f, 0.0f, 1.0f);
				GL11.glVertex3f(x - 8, y , 0);
				GL11.glVertex3f(x + 8, y , 0);
				GL11.glVertex3f(x, (y + 8), 0);
			GL11.glEnd();
	
			GL11.glPopMatrix();
			
		}

}


