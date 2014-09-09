package com.dacin.test.stage;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.Display;

import com.dacin.test.intro.IntroGrass;
import com.dacin.test.intro.RockFloor;
import com.dacin.test.intro.TreeBackGroundTile;
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
	public static Screen loadScreen(String filePath, Screen screen) {
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
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (pixels[x + y * width] == 0xFF000000) continue;
				parsePixel(x, height-y, pixels[x + y * width], screen);
			}
		}
	}

	protected static void parsePixel(int x, int y, int pixel, Screen screen) {
		/* erste 32x32 pixel => Ecke unten Links offScreen!
		 * 
		 */
		y-=4;
		x-=4;
		x <<= GRIDPOWER;
		y <<= GRIDPOWER;
		switch (pixel) {
			case 0xFF00FF00:
				screen.addTile(new SolidBlock(x, y));
				return;
			case 0xFFFFFFFF:
				screen.addTile(new Spike(x + 16, y + 16, 0));
				return;
			case 0xFFFFFFFE:
				screen.addTile(new Spike(x + 16, y + 16, 1));
				return;
			case 0xFFFFFFFD:
				screen.addTile(new Spike(x + 16, y + 16, 2));
				return;
			case 0xFFFFFFFC:
				screen.addTile(new Spike(x + 16, y + 16, 3));
				return;
			case 0xFF009900:
				screen.addTile(new ConveyorBelt(x, y, 16, 16));
				return;
			case 0xFF01FF00:
				screen.addTile(new IntroGrass(x,y,32 , 32));
				return;
			case 0xFFCC9000:
				screen.addTile(new RockFloor(x,y,32 , 32));
				return;
				//Tree start
			case 0xFF00FFF0:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,0));
				return;
			case 0xFF00FFF1:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,1));
				return;
			case 0xFF00FFF2:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,2));
				return;
			case 0xFF00FFF3:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,3));
				return;
			case 0xFF00FFF4:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,4));
				return;
			case 0xFF00FFF5:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,5));
				return;
			case 0xFF00FFF6:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,6));
				return;
			case 0xFF00FFF7:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,7));
				return;
			case 0xFF00FFF8:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,8));
				return;
			case 0xFF00FFF9:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,9));
				return;
			case 0xFF00FFFA:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,10));
				return;
			case 0xFF00FFFB:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,11));
				return;
			case 0xFF00FFFC:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,12));
				return;
				//TreeTrunk
			case 0xFF00FFFD:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,13));
				return;
			case 0xFF00FFFE:
				screen.addBgTile(new TreeBackGroundTile(x,y-8,32,32,14));
				return;
			case 0xFF00FFFF:
				screen.addBgTile(new TreeBackGroundTile(x-32,y-8-32,64,64,15));
				return;
				//TreeTrunk stop
				//Tree stop
				

		}
	}

}
