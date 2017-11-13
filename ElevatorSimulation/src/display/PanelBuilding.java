package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import object.Building;

public class PanelBuilding extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Building building;

	public PanelBuilding() {

		this.setBorder(new LineBorder(Color.BLACK));
		this.setFocusable(true);
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();

			}
		});
		try {
			building = new Building();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		timer.start();
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.white);
		building.draw(g);

	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
