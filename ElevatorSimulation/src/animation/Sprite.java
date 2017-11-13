package animation;

import java.io.IOException;
import java.util.ArrayList;

public class Sprite {
	protected ArrayList<Frame> listFrame;
	private int size;
	protected int width;
	protected int height;
	private int currentFrame;
	protected double x, y;
	private long beforeTime;

	public Sprite(String namePicture, int size, int speed, int x0, int y0) throws IOException {
		this.size = size;
		listFrame = new ArrayList<Frame>();
		currentFrame = 0;
		x = x0;
		y = y0;
		beforeTime = System.currentTimeMillis();
	}

	public Sprite(String namePicture, int size, int speed) throws IOException {
		this.size = size;
		listFrame = new ArrayList<Frame>();

		currentFrame = 0;
		beforeTime = System.currentTimeMillis();
	}

	public void nextFrame() {
		if (size <= 1)
			return;
		if ((System.currentTimeMillis() - beforeTime) > listFrame.get(currentFrame).getSpeedFrame()) {
			currentFrame = (currentFrame + 1) % size;
			beforeTime = System.currentTimeMillis();
		}

	}

	public ArrayList<Frame> getListFrame() {
		return listFrame;
	}

	public void setListFrame(ArrayList<Frame> listFrame) {
		this.listFrame = listFrame;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public long getBeforeTime() {
		return beforeTime;
	}

	public void setBeforeTime(long beforeTime) {
		this.beforeTime = beforeTime;
	}

	public int getSize() {
		return size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
