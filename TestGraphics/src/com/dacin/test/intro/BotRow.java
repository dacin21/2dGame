package com.dacin.test.intro;

import com.dacin.test.sprite.Sprite;
import com.dacin.test.sprite.player.Player;
import com.dacin.test.tile.RectangleBlock;

public class BotRow extends RectangleBlock {
	private int saveX,saveY;

	public BotRow(int setX, int setY, int sizeY, int sizeX, int saveX, int saveY) {
		super(setX, setY, sizeY, sizeX);
		this.saveX=saveX;
		this.saveY=saveY;
	}
	
	public void render(){
		return;
	}
	public void colideSprite(Sprite sprite){
		if(sprite instanceof Player)  super.colideSprite(sprite);
	}
	

	protected void collideTop(Sprite sprite) {
		sprite.floor(saveY);
		sprite.wall(saveX);
	}


}
