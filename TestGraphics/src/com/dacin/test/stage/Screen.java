package com.dacin.test.stage;

import java.util.ArrayList;

import com.dacin.test.sprite.player.PlayerShot;
import com.dacin.test.sprite.Sprite;
import com.dacin.test.tile.BackGround;
import com.dacin.test.tile.Tile;

public class Screen {
	// public

	// protected
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	protected ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	protected ArrayList<Sprite> origSprites = new ArrayList<Sprite>();
	protected BackGround background;

	public Screen() {
		this.background= new BackGround("res/Textures/Background/GenericBackGround.jpg");
	}
	public Screen(BackGround bg){
		this.background=bg;
	}

	public void addTile(Tile tile) {
		tiles.add(tile);
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}
	public void addOrigSprite(Sprite sprite){
		origSprites.add(sprite);
	}

	public void tick() {

		for(Sprite e:sprites) e.tick();
		for(Tile e:tiles) e.tick();
		for(Sprite e:sprites) if(e.getUseless()) sprites.remove(e);

	}

	public void Render() {
		background.render();
		for(Sprite e:sprites) e.render();
		for(Tile e:tiles) e.render();
	}
	
	public void Init(){
		sprites = origSprites;
		PlayerShot.shotCount=0;
	}


}
