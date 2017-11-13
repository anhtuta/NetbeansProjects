package animation;

import java.awt.Image;

public class Frame {
	private Image imageFrame;
	private int speedFrame;

	public Frame(Image imageFrame, int speedFrame) {
		this.imageFrame = imageFrame;
		this.speedFrame = speedFrame;
	}

	public Image getImageFrame() {
		return imageFrame;
	}

	public void setImageFrame(Image imageFrame) {
		this.imageFrame = imageFrame;
	}

	public int getSpeedFrame() {
		return speedFrame;
	}

	public void setSpeedFrame(int speedFrame) {
		this.speedFrame = speedFrame;
	}

}
