package com.dacin.test.stage;

import com.dacin.test.sprite.player.Player;

public class SavePoint {
	float px,py;
	byte screenNum;
	
	public SavePoint(Player player, byte screenNum){
		this.px =player.getNewX();
		this.py = player.getNewY();
		this.screenNum = screenNum;
	}
	
	public void resetPlayer(Player player){
		player.wall(px);;
		player.floor(py);
		player.air();
	}

}
