package tovanlam.dongho;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class KimPhut extends KimDongHo {
	private int currentMinute;
	private static final int MAX_CURRENT_MINUTE = 60;
	private KimGio kimGio;
	private double gocLech;

	public KimPhut(KimGio kimGio) {
		this.currentMinute = DateAndTime.getMinute();
		this.gocLech = this.currentMinute *6;
		this.kimGio = kimGio;
		this.kimGio.setGocLech(this.kimGio.getGocLech() + this.gocLech / 12);
		this.kimGio.setCoord();
	}

	public void setCoord() {
		this.coordX = 130 + 85 * Math.sin(Math.toRadians(gocLech));
		this.coordY = 130 - 85 * Math.cos(Math.toRadians(gocLech));
	}

	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.GREEN);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(130, 130, (int) coordX, (int) coordY);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/image[1].png"));
		g2D.drawImage(icon.getImage(), (int) (coordX - icon.getIconWidth()/2), (int) (coordY - icon.getIconHeight()/2), null);

	}

	public static int getMaxCurrentMinute() {
		return MAX_CURRENT_MINUTE;
	}
	public double getGocLech() {
		return gocLech;
	}

	public void setGocLech(double gocLech) {
		this.gocLech = gocLech;
	}
	public int getCurrentMinute() {
		return currentMinute;
	}

	public void setCurrentMinute(int currentMinute) {
		this.currentMinute = currentMinute;
	}

	public KimGio getKimGio() {
		return kimGio;
	}

}
