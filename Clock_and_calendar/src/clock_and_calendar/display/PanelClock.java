package tovanlam.display;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import tovanlam.dongho.KimGiay;
import tovanlam.dongho.KimGio;
import tovanlam.dongho.KimPhut;

public class PanelClock extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private KimGio kimGio;
	private KimPhut kimPhut;
	private KimGiay kimGiay;
	private int backgroundColor;
	public static int inst = 1;
	public PanelClock() {
	
		this.setBorder(new LineBorder(Color.BLACK));
		this.backgroundColor = 0xff0000;
		this.setFocusable(true);
		kimGio = new KimGio();
		kimPhut = new KimPhut(this.kimGio);
		kimGiay = new KimGiay(this.kimPhut);
		timer = new Timer(1, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
			   
			       repaint();
			    }

		
		});
		timer.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (kimGiay.getCurrentSecond() % 2 == 0) {
			backgroundColor = backgroundColor + 2;
		}
		this.setBackground(new Color(0xff0000 - backgroundColor%0x00ffdf));
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(new Color(0xff0000 - (backgroundColor + (0x00ffdf - 0xff0000)/2)%0x00ffdf ));
		g2D.fillOval(0, 0, 260, 260);
		g2D.setColor(Color.white);
		g2D.fillOval(30, 30, 200, 200);
		g2D.setColor(Color.BLACK);
		
		g2D.drawOval(30, 30, 200, 200);
		for(int alpha=0; alpha <360 ; alpha = alpha +6){
			double x =  130 + 100 * Math.sin(Math.toRadians(alpha));
			double y = 130 - 100 * Math.cos(Math.toRadians(alpha));
			g2D.fillRect((int)(x-1), (int)(y-1), 2, 2);
		}
		g2D.setColor(Color.RED);
		for(int alpha=0; alpha <360 ; alpha = alpha +30){
			double x =  130 + 100 * Math.sin(Math.toRadians(alpha));
			double y = 130 - 100 * Math.cos(Math.toRadians(alpha));
			g2D.fillRect((int)(x-2), (int)(y-2), 4, 4);
		}
		g2D.setColor(Color.RED);
		for(int alpha=0; alpha <360 ; alpha = alpha +30){
			double x =  130 + 90 * Math.sin(Math.toRadians(alpha));
			double y = 130 - 90 * Math.cos(Math.toRadians(alpha));
			g2D.drawString(String.valueOf(alpha/30),(int) (x-2), (int)(y+3));
		}
	
		g2D.setStroke(new BasicStroke(4));
		kimGiay.testTime();
		kimGiay.draw(g);
		kimPhut.draw(g);
		kimGio.draw(g);
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public KimGio getKimGio() {
		return kimGio;
	}

	public void setKimGio(KimGio kimGio) {
		this.kimGio = kimGio;
	}

	public KimPhut getKimPhut() {
		return kimPhut;
	}

	public void setKimPhut(KimPhut kimPhut) {
		this.kimPhut = kimPhut;
	}

	public KimGiay getKimGiay() {
		return kimGiay;
	}

	public void setKimGiay(KimGiay kimGiay) {
		this.kimGiay = kimGiay;
	}
}
