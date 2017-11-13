package tovanlam.dongho;

import java.awt.Graphics;

public abstract class KimDongHo {
	protected double coordX;
	protected double coordY;
	protected double gocLech;

	public abstract void setCoord();

	public abstract void draw(Graphics g);

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	public double getGocLech() {
		return gocLech;
	}

	public void setGocLech(double gocLech) {
		this.gocLech = gocLech;
	}

}
