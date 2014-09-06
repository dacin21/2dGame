package com.dacin.test.tile;

import com.dacin.test.Main;
import com.dacin.test.sprite.PlayerShot;
import com.dacin.test.sprite.Sprite;

public class SaveBlock extends Block {

	public SaveBlock(int setX, int setY) {
		super(setX, setY);
		// TODO Auto-generated constructor stub
	}
	
	public void colideSprite(Sprite sprite, int radius){
		if(sprite instanceof PlayerShot) super.colideSprite(sprite, radius);
	}
	
	protected void collideTop(Sprite sprite){
		save();
		sprite.kill();
	}
	protected void collideBot(Sprite sprite){
		save();
		sprite.kill();
	}
	protected void collideR(Sprite sprite){
		save();
		sprite.kill();
	}
	protected void collideL(Sprite sprite){
		save();
		sprite.kill();
	}
	
	protected void save(){
		Main.stage.save();
	}

}
