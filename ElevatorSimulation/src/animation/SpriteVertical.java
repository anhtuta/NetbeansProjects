package animation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.DemoElevator;

public class SpriteVertical extends Sprite {

	public SpriteVertical(String namePicture, int size, int speed, int x0, int y0) throws IOException {
		super(namePicture, size, speed, x0, y0);
		BufferedImage spriteSheet = ImageIO
				.read(new File(DemoElevator.getCurrentDirectory() + "//image//" + namePicture));
		this.width = spriteSheet.getWidth();
		this.height = spriteSheet.getHeight() / size;

		for (int i = 0; i < size; i++) {
			listFrame.add(new Frame(spriteSheet.getSubimage(width * i, 0, width, height), speed));
		}
		size = listFrame.size();
	}

	public SpriteVertical(String namePicture, int size, int speed) throws IOException {
		super(namePicture, size, speed);
		BufferedImage spriteSheet = ImageIO
				.read(new File(DemoElevator.getCurrentDirectory() + "//image//" + namePicture));
		this.width = spriteSheet.getWidth();
		this.height = spriteSheet.getHeight() / size;
		for (int i = 0; i < size; i++) {
			listFrame.add(new Frame(spriteSheet.getSubimage(0, height * i, width, height), speed));
		}
		size = listFrame.size();
	}

}
