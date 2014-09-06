package com.dacin.test.tile;

import com.dacin.test.sprite.Sprite;

public class SolidBlock extends Block {
	
	

	public SolidBlock(int setX, int setY) {
		super(setX, setY);
		Size=32;
	}
	

	protected void collideTop(Sprite sprite) {
		sprite.floor(y + Size + sprite.yr);
	}

	protected void collideBot(Sprite sprite) {
		sprite.ceil(y - sprite.yr);
	}

	protected void collideR(Sprite sprite) {
		sprite.wall(x - sprite.xr);
	}

	protected void collideL(Sprite sprite) {
		sprite.wall(x + Size + sprite.xr);
	}

}
