package com.dacin.test.tile;

import com.dacin.test.Main;
import com.dacin.test.sprite.Sprite;

public class SolidBlock extends Block {

	public SolidBlock(int setX, int setY) {
		super(setX, setY);
	}
	

	protected void collideTop(Sprite sprite) {
		sprite.floor(y + 16 + 8);
	}

	protected void collideBot(Sprite sprite) {
		sprite.ceil(y - 8);
	}

	protected void collideR(Sprite sprite) {
		sprite.wall(x - 8);
	}

	protected void collideL(Sprite sprite) {
		sprite.wall(x + 16 + 8);
	}

}
