package com.dacin.test.stage;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.Display;

import com.dacin.test.tile.BackGround;
import com.dacin.test.tile.ConveyorBelt;
import com.dacin.test.tile.SaveBlock;
import com.dacin.test.tile.SolidBlock;
import com.dacin.test.tile.Spike;

public abstract class screenFromFile {
	private static final int GRIDPOWER = 3;

	protected static int width = (Display.getWidth() + 32) >> GRIDPOWER;
	protected static int height = (Display.getHeight() + 32) >> GRIDPOWER;


	public static Screen loadScreen(String filePath) {
		Screen screen = new Screen();
		convertPixels(loadImage(filePath), screen);
		screen.addTile(new SaveBlock(200, 100));
		return screen;

	}
	public static Screen loadScreen(String filePath, BackGround bg) {
		Screen screen = new Screen(bg);
		convertPixels(loadImage(filePath), screen);
		screen.addTile(new SaveBlock(200, 100));
		return screen;

	}

	public static int[] loadImage(String filePath) {

		int[] pixels = null;
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(filePath));
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}
		catch (IOException e) {
			System.err.println("Level Image was either of wrong Size or not found");
			e.printStackTrace();
		}
		// 1 Pixel => 8x8 Grid

		return pixels;

	}

	protected static void convertPixels(int[] pixels, Screen screen) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (pixels[x + y * width] == 0xFF000000) continue;
				parsePixel(x, height-y, pixels[x + y * width], screen);
			}
		}
	}

	protected static void parsePixel(int x, int y, int pixel, Screen screen) {
		x <<= GRIDPOWER;
		y <<= GRIDPOWER;
		switch (pixel) {
			case 0xFF00FF00:
				screen.addTile(new SolidBlock(x - 32, y - 32));
				return;
			case 0xFFFFFFFF:
				screen.addTile(new Spike(x - 16, y - 16, 0));
				return;
			case 0xFFFFFFFE:
				screen.addTile(new Spike(x - 16, y - 16, 1));
				return;
			case 0xFFFFFFFD:
				screen.addTile(new Spike(x - 16, y - 16, 2));
				return;
			case 0xFFFFFFFC:
				screen.addTile(new Spike(x - 16, y - 16, 3));
				return;
			case 0xFF009900:
				screen.addTile(new ConveyorBelt(x-32, y-32, 16, 16));

		}
	}

}
