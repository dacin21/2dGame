package com.dacin.test.stage;

import java.util.ArrayList;

import com.dacin.test.sprite.Sprite;
import com.dacin.test.tile.BackGround;
import com.dacin.test.tile.Tile;

public class Screen {
	// public

	// protected
	protected ArrayList<Tile> tiles = new ArrayList<Tile>();
	protected ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	protected BackGround background = new BackGround("Textures/Background/GenericBackGround.jpg");

	public Screen() {

	}

	public void addTile(Tile tile) {
		tiles.add(tile);
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
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


}
