package com.dacin.test;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.dacin.test.tile.Player;
import com.dacin.test.tile.Spike;

public class Main {
	public static Input input = new Input();
	public static int x,y;
    public static long lastFPS;
	public static int fps;
	public static Cube cube;
	public static Player player;
	public static Spike spike;
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 0, 600, 200, -200);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		lastFPS = getTime();
		cube = new Cube(input);
		player = new Player(200,200,input);
		
		
		for(int i=0;i<8;i++){
		ObjectLists.objList.addSpike(150+i*32*2, 172,2);
		ObjectLists.objList.addSpike(150+i*32*2, 236,0);
		}
		
		for(int i=0;i<40;i++){
			ObjectLists.objList.addBlock(50+i*16, 140);
			
		}
		ObjectLists.objList.addBlock(150, 200);
		ObjectLists.objList.addBlock(190, 216);
		// init OpenGL here
		
		
		
		
		
		
		
		
		
		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			Display.sync(40);
			tick();
			render();
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		Main displayExample = new Main();
		displayExample.start();
	}
	
	
	public static void tick(){
		updateFPS();
		input.getKeys();
		cube.tick();
		player.tick();
		ObjectLists.objList.tick();
		//System.out.println("     " + ", Up " + input.up+ ", Down " + input.down+ ", Left " + input.left + ", right " + input.right );
	
	}
	
	public static void render(){
		
		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
		
		cube.render();
		player.render();
		ObjectLists.objList.render();
		Display.update();
	}
	
	
	public static void updateFPS() {
		if (getTime() - lastFPS > 1000) {
	        Display.setTitle("FPS: " + fps); 
	        fps = 0; //reset the FPS counter
	        lastFPS += 1000; //add one second
	    }
	    fps++;
	   
	}
	public static long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	
	
	
	
}