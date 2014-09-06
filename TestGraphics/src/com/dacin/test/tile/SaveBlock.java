package com.dacin.test.tile;

import com.dacin.test.Main;
import com.dacin.test.shader.Texture;
import com.dacin.test.sprite.player.PlayerShot;
import com.dacin.test.sprite.Sprite;

public class SaveBlock extends Block {
	protected byte shot = 0;
	protected static final Texture texture0 = new Texture("res/Textures/Tile/Save.PNG");
	protected static final Texture texture1 = new Texture("res/Textures/Tile/Save_Hit.png");

	public SaveBlock(int setX, int setY) {
		super(setX, setY);
		this.Size=16;
		// TODO Auto-generated constructor stub
	}
	public void tick(){
		if(shot-- == 0) shot = 0;
		super.tick();
	}
	public void render(){
		super.renderWithTexture(shot == 0 ? texture0 : texture1);
		
	}
	
	public void colideSprite(Sprite sprite){
		if(!(sprite instanceof PlayerShot)) return;
		float px = sprite.getNewX();
		float py = sprite.getNewY();
		int xr = sprite.xr;
		int yr = sprite.yr;

		// floor
		if (py < y + Size + yr) {
			if (((px > x - xr)) && (px < x + Size + xr)) {
				if (sprite.yVel < 0) {
					collideTop(sprite);
				}

			}
		}
		// ceil
		if (py > y - yr) {
			if ((px > x - xr) && (px < x + Size + xr)) {
				if (sprite.yVel > 0) {
					collideBot(sprite);
				}
			}
		}
		// wall
		if (py < y + Size + yr && py > y - yr) {
			if (px > x - xr && px < x + Size + xr) {
				// right
				if (sprite.xVel > 0) {
					collideR(sprite);
				}
				//left
				if (sprite.xVel < 0) {
					collideL(sprite);
				}
			}
		}
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
		shot = 60;
		Main.stage.save();
	}

}
