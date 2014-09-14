package com.dacin.test.Stage1;


import com.dacin.test.stage.Screen;
import com.dacin.test.stage.Stage;
import com.dacin.test.stage.screenFromFile;
import com.dacin.test.tile.BackGround;
import com.dacin.test.tile.Teleporter;

public class Stage1 extends Stage {

	private static Stage1 stage1;

	/*
	 * 
	 * 
	 */
	private Stage1() {
		height = 3;
		width = 3;
		Screen tmpScreen;
		final BackGround bg = new BackGround("res/Textures/1/BackGround.jpg");
		
		// (0,0)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/1_1.png", bg);
		this.addScreen(tmpScreen);

		// (1,0)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/1_2.png", bg);
		this.addScreen(tmpScreen);

		// (2,0)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/1_3.png", bg);
		this.addScreen(tmpScreen);

		// (1,0)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/2_1.png", bg);
		this.addScreen(tmpScreen);

		// (1,1)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/2_2.png", bg);
		this.addScreen(tmpScreen);

		// (1,2)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/2_3.png", bg);
		this.addScreen(tmpScreen);

		// (2,0)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/3_1.png", bg);
		this.addScreen(tmpScreen);

		// (2,1)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/3_2.png", bg);
		this.addScreen(tmpScreen);

		// (2,2)
		tmpScreen = screenFromFile.loadScreen("res/Levels/1/3_3.png", bg);
		this.addScreen(tmpScreen);
		
		
		
	}

	/**
	 * Initializes the Stage class
	 * 
	 * @return The Stage1
	 */
	public static Stage getStage() {
		if (stage1 == null) stage1 = new Stage1();
		return stage1;

	}
	public static void unload(){
		stage1 = null;
	}

}
