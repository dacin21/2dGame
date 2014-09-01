package com.dacin.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.opengl.Display;

import com.dacin.test.sprite.Sprite;
import com.dacin.test.tile.SolidBlock;
import com.dacin.test.tile.Spike;
import com.dacin.test.tile.Tile;

public class ObjectLists {
	//singleton class
	public static ObjectLists objList = new ObjectLists();
	/*
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private ArrayList<Spike> spikes = new ArrayList<Spike>();
	private ArrayList<SolidBlock> blocks = new ArrayList<SolidBlock>();
	private ObjectLists(){
	}
	
	public void addSpike(int x, int y, int r){
		spikes.add(new Spike(x,y,r));
	}
	public void addBlock(int x, int y){
		blocks.add(new SolidBlock(x,y));
	}
	public void addSprite(Sprite sprite){
		sprites.add(sprite);
	}
	
	public void tick(){
		tickList(spikes);
		tickList(blocks);
		tickList(sprites);
	}
	
	public void render(){
		renderList(spikes);
		renderList(blocks);
		renderList(sprites);
	}
	*/
	public void tickList(ArrayList<? extends Tile> list){
		Iterator<? extends Tile> iter=list.iterator();
		while(iter.hasNext()){
			iter.next().tick();
			
		}
	}
	public void renderList(ArrayList<? extends Tile> list){
		Iterator<? extends Tile> iter=list.iterator();
		while(iter.hasNext()){
			iter.next().render();
			
		}
	}
	public void cleanList(ArrayList<? extends Sprite> list){
		Iterator<? extends Sprite> iter=list.iterator();
		while(iter.hasNext()){
			if(iter.next().getUseless()) iter.remove();
			
		}
	}
	public void moveSpritesOnScreen(ArrayList<? extends Sprite> list, float xPart, float yPart){
		Iterator<? extends Sprite> iter=list.iterator();
		while(iter.hasNext()){
			iter.next().move(Display.getWidth()*xPart, Display.getHeight()*yPart);
		}
	}

}
