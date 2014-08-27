package com.dacin.test;

import org.lwjgl.opengl.GL11;

public class Cube {
	
	private float x,y,z,rotationZ,rotationX,rotationY;
	private float cosX,sinX,cosY,sinY,cosZ,sinZ,rx,ry,rz;
	private Input input;
	public Cube(Input input){
		x=400.0f;
		y=300.0f;
		z=50.0f;
		rotationZ=rotationX=rotationY=0.0f; // up
		this.input=input;
	}
	
	public void tick(){
		rx=(float)Math.toRadians(rotationX);
		ry=(float)Math.toRadians(rotationY);
		rz=(float)Math.toRadians(rotationZ);
		if(input.left){  rotationZ+=0.15f;} 
		if(input.right){ rotationZ-=0.15f;}
		if(input.w)  {rotationX+=0.15f;}
		if(input.s) {rotationX-=0.15f;} 
		if(input.q)  {rotationY+=0.15f;} 
		if(input.e) {rotationY-=0.15f;}
		if(input.up){
			y+= cosZ*0.35f;
			x-= sinZ*0.35f;
		}
		if(input.down){
			y-= cosZ*0.35f;
			x+= sinZ*0.35f;
		}
		limit(x, 0.0f, 800.0f);
		limit(y, 0.0f, 600.0f);
		rotationX=loop(rotationX, 0.0f, 360.0f);
		rotationY=loop(rotationY, 0.0f, 360.0f);
		rotationZ=loop(rotationZ, 0.0f, 360.0f);
		radians();
	}
	
	public void render(){
		

		// draw quad
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
			GL11.glTranslatef(x, y, 0);
			GL11.glRotatef(rotationX, 1.0f, 0.0f, 0f);
			GL11.glRotatef(rotationY, 0.0f, cosX , -sinX);
			GL11.glRotatef(rotationZ, sinY, -sinX*cosX, cosY*cosX);//TODO: fix

			
 
			//GL11.glRotatef(rotationX+rotationY+rotationZ, rotationX, rotationY, rotationZ);
			//System.out.println("X: " +rotationX +" Y: "+  rotationY +" Z:" +  rotationZ);
			GL11.glTranslatef(-x, -y, 0);
			

			

			
			GL11.glBegin(GL11.GL_QUADS);
				if(sinX*cosY>0){
	
					GL11.glColor3f(0.0f, 0.0f, 1.0f);
					GL11.glVertex3f(x - 50, y + 50, z + 50);
					GL11.glVertex3f(x + 50, y + 50, z + 50);
					GL11.glVertex3f(x + 50, y + 50, z - 50);
					GL11.glVertex3f(x - 50, y + 50, z - 50);
				}else{
	
					GL11.glColor3f(1.0f, 1.0f, 0.0f);
					GL11.glVertex3f(x - 50, y - 50, z + 50);
					GL11.glVertex3f(x + 50, y - 50, z + 50);
					GL11.glVertex3f(x + 50, y - 50, z - 50);
					GL11.glVertex3f(x - 50, y - 50, z - 50);
				}

				
				if(sinY*cosX<0){

					GL11.glColor3f(1.0f, 0.0f, 1.0f);
					GL11.glVertex3f(x + 50, y - 50, z + 50);
					GL11.glVertex3f(x + 50, y + 50, z + 50);
					GL11.glVertex3f(x + 50, y + 50, z - 50);
					GL11.glVertex3f(x + 50, y - 50, z - 50);

				}else{

					GL11.glColor3f(0.0f, 1.0f, 1.0f);
					GL11.glVertex3f(x - 50, y - 50, z + 50);
					GL11.glVertex3f(x - 50, y + 50, z + 50);
					GL11.glVertex3f(x - 50, y + 50, z - 50);
					GL11.glVertex3f(x - 50, y - 50, z - 50);
				}

				
				if(cosX*cosY<0){

					GL11.glColor3f(1.0f, 0.0f, 0.0f);
					GL11.glVertex3f(x - 50, y - 50, z - 50);
					GL11.glVertex3f(x + 50, y - 50, z - 50);
					GL11.glVertex3f(x + 50, y + 50, z - 50);
					GL11.glVertex3f(x - 50, y + 50, z - 50);
				}else{

					GL11.glColor3f(0.0f, 1.0f, 0.0f);
					GL11.glVertex3f(x - 50, y - 50, z + 50);
					GL11.glVertex3f(x + 50, y - 50, z + 50);
					GL11.glVertex3f(x + 50, y + 50, z + 50);
					GL11.glVertex3f(x - 50, y + 50, z + 50);
				}


			GL11.glEnd();
			

			/*GL11.glColor3f(0.0f, 1.0f, 0.0f);

			GL11.glBegin(GL11.GL_LINE_LOOP);
			GL11.glVertex3f(x - 50, y - 50, z - 50);
			GL11.glVertex3f(x + 50, y - 50, z - 50);
			GL11.glVertex3f(x + 50, y + 50, z - 50);
			GL11.glVertex3f(x - 50, y + 50, z - 50);

			GL11.glVertex3f(x - 50, y + 50, z + 50);
			GL11.glVertex3f(x + 50, y + 50, z + 50);
			GL11.glVertex3f(x + 50, y - 50, z + 50);
			GL11.glVertex3f(x - 50, y - 50, z + 50);
			
			GL11.glEnd();
			*/
			



		GL11.glPopMatrix();
		
	}
	
	public static void limit(float num, float min, float max){
		if(num<min) num=min;
		if(num>max) num=max;
	}
	public static float loop(float num, float min, float max){
		if(num<min) num=num+max-min;
		if(num>max) num=num-max+min;
		return num;
	}

	private void radians(){
		rx=(float)Math.toRadians(rotationX);
		ry=(float)Math.toRadians(rotationY);
		rz=(float)Math.toRadians(rotationZ);
		cossin();
	}
	private void cossin(){
		cosX=(float)Math.cos(rx); sinX=(float)Math.sin(rx);
		cosY=(float)Math.cos(ry); sinY=(float)Math.sin(ry);
		cosZ=(float)Math.cos(rz); sinZ=(float)Math.sin(rz);
	}

}
