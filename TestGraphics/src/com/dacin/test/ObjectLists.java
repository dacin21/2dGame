package com.dacin.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.dacin.test.tile.Block;
import com.dacin.test.tile.Spike;
import com.dacin.test.tile.Tile;

public class ObjectLists {
	public static ObjectLists objList = new ObjectLists();
	private ArrayList<Spike> spikes = new ArrayList<Spike>();
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ObjectLists(){
	}
	
	public void addSpike(int x, int y, int r){
		spikes.add(new Spike(x,y,r));
	}
	public void addBlock(int x, int y){
		blocks.add(new Block(x,y));
	}
	
	public void tick(){
		tickList(spikes);
		tickList(blocks);
	}
	
	public void render(){
		renderList(spikes);
		renderList(blocks);
	}
	
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

}
