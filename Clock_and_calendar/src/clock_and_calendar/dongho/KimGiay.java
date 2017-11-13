package tovanlam.dongho;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class KimGiay extends KimDongHo {
	private int currentSecond;
	private static final int MAX_CURRENT_SECOND = 60;
	private KimPhut kimPhut;
	private long beforeTime;
	public KimGiay(KimPhut kimPhut) {
		this.currentSecond = DateAndTime.getSecond();
		this.gocLech = this.currentSecond *6;
		this.kimPhut = kimPhut;
		this.kimPhut.setGocLech(this.kimPhut.getGocLech() + this.gocLech / 60);
		this.kimPhut.setCoord();
		beforeTime = 0;
	}

	public void setCoord() {
		this.coordX = 130 + 100 * Math.sin(Math.toRadians(gocLech));
		this.coordY = 130 - 100 * Math.cos(Math.toRadians(gocLech));
	}

	public void testTime() {
		long timeNow = System.currentTimeMillis();
		if (timeNow - beforeTime >= 1000) {
			beforeTime = timeNow;
			upTime();
		}
	}

	public void upTime() {
		this.currentSecond = this.currentSecond + 1;
		this.gocLech = this.gocLech + 6;
		this.setCoord();
		this.kimPhut.setGocLech(this.kimPhut.getGocLech() + (double)1/10);
		this.kimPhut.setCoord();
		this.kimPhut.getKimGio().setGocLech(this.kimPhut.getKimGio().getGocLech() + (double)1/120);
		this.kimPhut.getKimGio().setCoord();
		if (this.currentSecond == KimGiay.MAX_CURRENT_SECOND) {
			this.currentSecond = 0;
			this.kimPhut.setCurrentMinute(this.kimPhut.getCurrentMinute() + 1);
			if (this.kimPhut.getCurrentMinute() == KimPhut.getMaxCurrentMinute()) {
				this.kimPhut.setCurrentMinute(0);
				this.kimPhut.getKimGio().setCurrentTime(this.kimPhut.getKimGio().getCurrentTime() + 1);
				this.kimPhut.getKimGio();
				if (this.kimPhut.getKimGio().getCurrentTime() == KimGio.getMaxCurrentTime()) {
					this.kimPhut.getKimGio().setCurrentTime(0);
				}
			}
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.orange);
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(130, 130, (int) coordX, (int) coordY);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon_tron.png"));
		g2D.drawImage(icon.getImage(), (int) (coordX - icon.getIconWidth()/2), (int) (coordY - icon.getIconHeight()/2), null);

	}

	public int getCurrentSecond() {
		return currentSecond;
	}

	public void setCurrentSecond(int currentSecond) {
		this.currentSecond = currentSecond;
	}

	public static int getMaxCurrentSecond() {
		return MAX_CURRENT_SECOND;
	}

	public KimPhut getKimPhut() {
		return kimPhut;
	}
}
