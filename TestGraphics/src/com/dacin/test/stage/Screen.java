package com.dacin.test.stage;

import java.util.ArrayList;

import com.dacin.test.ObjectLists;
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

		ObjectLists.objList.tickList(sprites);
		ObjectLists.objList.tickList(tiles);
		ObjectLists.objList.cleanList(sprites);

	}

	public void Render() {
		background.render();
		ObjectLists.objList.renderList(tiles);
		ObjectLists.objList.renderList(sprites);
	}


}
