package com.dacin.test;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.dacin.test.Stage1.Stage1;
import com.dacin.test.intro.IntroStage;
import com.dacin.test.stage.Stage;
import com.dacin.test.stage.screenFromFile;

public class Main {
	private Random random = new Random();
	public static boolean pause=false;
	public static Controls input = new Controls();
	public static int x,y;
    public static long lastFPS;
	public static int fps;
	//public static Cube cube;
	public static Stage stage;
	public void start() {
		System.out.println("New Thread Started");
		try {
			Display.setDisplayMode(new DisplayMode(800,608));
			Display.create();
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 0, 608, 200, -200);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			//Transparency
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		lastFPS = getTime();
		loadingScreen();
		initLevels();

		while (!Display.isCloseRequested()) {
			
			// render OpenGL here
			Display.sync(50);
			tick();
			render();
		}
		
		Display.destroy();
	}
	
	public static void main(String[] argv) {
		Main displayExample = new Main();
		System.out.print("Run :   ");
		displayExample.start();
	}
	
	private void initLevels(){
		//cube = new Cube(input);
		stage = new Stage1();
		
		
		for(int a=0;a<9;a++){
			stage.addScreen(screenFromFile.loadScreen("res/Levels/1/" + (a/3+1) + "_" + (a%3+1) +".png"));
		}
		stage = IntroStage.getStage();
		stage.setScreen(0);
	}
	
	
	private static void tick(){
		updateFPS();
		input.checkKeys();
		if(pause) return;
		//cube.tick();
		stage.tick();
		if(input.reset) stage.restart();
	
	}
	
	private static void render(){
		
		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
        GL11.glLoadIdentity();
		
		stage.render();
		//cube.render();
		Display.update();
	}
	
	
	private static void updateFPS() {
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
	private void loadingScreen(){
		
	}

}