package com.dacin.test.stage;

import com.dacin.test.tile.Player;

public class SavePoint {
	float px,py;
	byte screenNum;
	
	public SavePoint(Player player, byte screenNum){
		this.px =player.getNewX();
		this.py = player.getNewY();
		this.screenNum = screenNum;
	}
	
	public void resetPlayer(Player player){
		player.xVel=0;
		player.yVel=0;
		player.teleport(px, py);
	}

}
