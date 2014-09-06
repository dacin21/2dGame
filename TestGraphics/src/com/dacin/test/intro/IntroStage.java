package com.dacin.test.intro;

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
		tmpScreen = screenFromFile.loadScreen("res/Levels/Intro/0.png", bg);
		tmpScreen.addTile(new StringSprite(100,100,"accaa"));
		this.addScreen(tmpScreen);
		this.addScreen(screenFromFile.loadScreen("res/Levels/Intro/1.png", bg));
		this.addScreen(screenFromFile.loadScreen("res/Levels/Intro/2.png", bg));
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
