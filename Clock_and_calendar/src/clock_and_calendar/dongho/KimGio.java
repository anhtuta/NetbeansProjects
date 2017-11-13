package tovanlam.dongho;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class KimGio extends KimDongHo {
	private int currentTime;
	private static final int MAX_CURRENT_TIME = 24;

	public KimGio() {
		this.currentTime = DateAndTime.getHour();
		this.gocLech = (this.currentTime % 12) *30;
	}

	public void setCoord() {
		this.coordX = 130 + 50 * Math.sin(Math.toRadians(gocLech));
		this.coordY = 130 - 50 * Math.cos(Math.toRadians(gocLech));
	}

	public static int getMaxCurrentTime() {
		return MAX_CURRENT_TIME;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.RED);
		g2D.setStroke(new BasicStroke(4));
		g2D.drawLine(130, 130, (int) coordX, (int) coordY);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/facebook.png"));
		g2D.drawImage(icon.getImage(), (int) (coordX - icon.getIconWidth()/2), (int) (coordY - icon.getIconHeight()/2), null);

	}

}
