package com.dacin.test.stage;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import com.dacin.test.Main;
import com.dacin.test.tile.Player;

public class Stage {
	// public
	public static Player player = new Player(100,100,Main.input);
	// protected
	protected ArrayList<Screen> screens = new ArrayList<Screen>();
	protected Screen activScreen = null;
	protected byte width, height;
	protected byte screenNum = 0;

	public Stage() {
		width = height = 2;

	}

	protected boolean transistScreen(int newX, int newY, int dir) {
		System.out.println(screenNum);
		// up right left down
		switch (dir) {
		case 0:
			if (screenNum < width){
				player.ceil(Display.getHeight());
				return false;
			}
			screenNum -= width;
			break;
		case 1:
			if((screenNum + 1) % width == 0){
				player.wall(Display.getWidth());
				return false;
			}
			screenNum++;
			break;
		case 2:
			if (screenNum >= width * (height-1)){
				player.floor(0);
				return false;
			}
			screenNum+=width;
			break;
		case 3:
			if(screenNum % width == 0){
				player.wall(0);
				return false;
			}
			screenNum--;
			break;
		default:
			System.err.println("Direction: " + dir + " is Invalid");
			throw new IllegalArgumentException();

		}
		player.teleport(newX, newY);
		activScreen = screens.get(screenNum);
		return true;

	}

	public void tick() {
		activScreen.tick();
		player.tick();
		//up
		if(player.getNewY()>Display.getHeight()) transistScreen((int)(player.getNewX()),(int)(player.getNewY()-Display.getHeight()),0);
		//right
		if(player.getNewX()>Display.getWidth()) transistScreen((int)(player.getNewX()-Display.getWidth()),(int)(player.getNewY()),1);
		//down
		if(player.getNewY()<0) transistScreen((int)(player.getNewX()),(int)(player.getNewY()+Display.getHeight()),2);
		//left
		if(player.getNewX()<0) transistScreen((int)(player.getNewX()+Display.getWidth()),(int)(player.getNewY()),3);
	}

	public void render() {
		activScreen.Render();
		player.render();

	}
	
	public void addScreen(Screen screen){
		screens.add(screen);
		if(activScreen == null) activScreen=screens.get(0);
	}

}
