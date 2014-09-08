package com.dacin.test.intro;

import com.dacin.test.sprite.text.CharSprite;
import com.dacin.test.sprite.text.StringSprite;
import com.dacin.test.stage.Screen;
import com.dacin.test.stage.Stage;
import com.dacin.test.stage.screenFromFile;
import com.dacin.test.tile.BackGround;

public class IntroStage extends Stage {
	private static IntroStage intro;
	/*
	 * 
	 * 
	 */
	private IntroStage(){
		height = 1;
		//Intro; Walk ; jump ; Shoot/Save ; end
		width = 5;
		Screen tmpScreen;
		final BackGround bg = new BackGround("res/Textures/Intro/BackGround.jpg");
		//0
		tmpScreen = screenFromFile.loadScreen("res/Levels/Intro/0.png", bg);
		CharSprite.SCALE=6;
		tmpScreen.addTile(new StringSprite(20,500,"Tutorial"));
		CharSprite.SCALE=2;
		tmpScreen.addTile(new StringSprite(20,460," welcome to the tutorial/This is gonna teach you some things/you probably know already /have fun"));
		this.addScreen(tmpScreen);
		//1
		tmpScreen = screenFromFile.loadScreen("res/Levels/Intro/1.png", bg);
		CharSprite.SCALE=6;
		tmpScreen.addTile(new StringSprite(20,500,"walking"));
		CharSprite.SCALE=2;
		tmpScreen.addTile(new StringSprite(20,460," Use the arrow keys to walk arround"));
		this.addScreen(tmpScreen);
		//2
		tmpScreen = screenFromFile.loadScreen("res/Levels/Intro/2.png", bg);
		CharSprite.SCALE=6;
		tmpScreen.addTile(new StringSprite(20, 500, "Jumping"));
		CharSprite.SCALE=2;
		tmpScreen.addTile(new StringSprite(20, 460, " Press y to jump/Press y in midair to perform a double jump"));
		this.addScreen(tmpScreen);
		//3
		this.addScreen(screenFromFile.loadScreen("res/Levels/Intro/3.png", bg));
		this.addScreen(screenFromFile.loadScreen("res/Levels/Intro/4.png", bg));
	}
	/**
	 * Initializes the Stage class
	 * @return The IntroStage
	 */
	public static Stage getStage(){
		if(intro == null) intro =new IntroStage();
		return intro;
		
	}

}
