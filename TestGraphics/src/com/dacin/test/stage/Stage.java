package com.dacin.test.stage;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;

import com.dacin.test.Main;
import com.dacin.test.sprite.Sprite;
import com.dacin.test.sprite.player.Player;

public abstract class Stage {
	// public
	public static Player player = new Player(700, 100, Main.input);
	// protected
	protected ArrayList<Screen> screens = new ArrayList<Screen>();
	protected ArrayList<Sprite> globalSprites = new ArrayList<Sprite>();
	public ArrayList<Sprite> friendlySprites = new ArrayList<Sprite>();
	protected Screen activScreen = null;
	protected SavePoint save = new SavePoint(player, (byte) 0);
	protected byte width, height;
	protected byte screenNum = 0;

	public Stage() {
		width = height = 2;

	}

	protected boolean transistScreen(float newX, float newY, int dir) {
		// up right left down
		switch (dir) {
			case 0:
				if (screenNum < width) {
					player.ceil(Display.getHeight());
					return false;
				}
				for(Sprite e:globalSprites) e.move(0, Display.getHeight());
				for(Sprite e:friendlySprites) e.move(0, Display.getHeight());
				screenNum -= width;
				break;
			case 1:
				if ((screenNum + 1) % width == 0) {
					player.wall(Display.getWidth());
					return false;
				}
				for(Sprite e:globalSprites) e.move(Display.getWidth(), 0);
				for(Sprite e:friendlySprites) e.move(Display.getWidth(), 0);
				screenNum++;
				break;
			case 2:
				if (screenNum >= width * (height - 1)) {
					player.floor(0);
					return false;
				}
				for(Sprite e:globalSprites) e.move(0, -Display.getHeight());
				for(Sprite e:friendlySprites) e.move(0, -Display.getHeight());
				screenNum += width;
				break;
			case 3:
				if (screenNum % width == 0) {
					player.wall(0);
					return false;
				}
				for(Sprite e:globalSprites) e.move(-Display.getWidth(), 0);
				for(Sprite e:friendlySprites) e.move(-Display.getWidth(), 0);
				screenNum--;
				break;
			default:
				System.err.println("Direction: " + dir + " is Invalid");
				throw new IllegalArgumentException();

		}
		player.teleport(newX, newY-player.yVel);
		activScreen = screens.get(screenNum);
		activScreen.Init();
		activScreen.tick();
		return true;

	}

	public void tick() {
		for(Sprite e:globalSprites) e.tick();
		for(Sprite e:friendlySprites) e.tick();
		for(Iterator<Sprite> i = globalSprites.iterator(); i.hasNext();) if(i.next().getUseless()) i.remove();
		for(Iterator<Sprite> i = friendlySprites.iterator(); i.hasNext();) if(i.next().getUseless()) i.remove();
		activScreen.tick();
		player.tick();
		// up
		if (player.getNewY() > Display.getHeight()) transistScreen( (player.getNewX()),  (player.getNewY() - Display.getHeight()), 0);
		// right
		if (player.getNewX() > Display.getWidth()) transistScreen( (player.getNewX() - Display.getWidth()),  (player.getNewY()), 1);
		// down
		if (player.getNewY() < 0) transistScreen( (player.getNewX()), (player.getNewY() + Display.getHeight()), 2);
		// left
		if (player.getNewX() < 0) transistScreen( (player.getNewX() + Display.getWidth()), (player.getNewY()), 3);
	}

	public void render() {
		activScreen.Render();
		for(Sprite e:globalSprites) e.render();
		for(Sprite e:friendlySprites) e.render();
		player.render();

	}

	public void addScreen(Screen screen) {
		screens.add(screen);
	}
	
	public void setScreen(int index){setScreen((byte) index );}

	public void setScreen(byte index) {
		activScreen = screens.get(index);
		save = new SavePoint(player, index);
	}
	public void addGlobalSprite(Sprite sprite){
		globalSprites.add(sprite);
	}
	public void addFriendlySprite(Sprite sprite){
		friendlySprites.add(sprite);
	}
	
	public void restart(){
		globalSprites = new ArrayList<Sprite>();
		friendlySprites = new ArrayList<Sprite>();
		save.resetPlayer(player);
		screenNum = save.screenNum;

		activScreen = screens.get(screenNum);
		activScreen.Init();
	}
	
	public void save(){
		if(player.getUseless()) return;
		save = new SavePoint(player, screenNum);
	}
	


}
