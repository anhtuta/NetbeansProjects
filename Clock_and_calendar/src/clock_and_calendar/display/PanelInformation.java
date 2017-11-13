package tovanlam.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class PanelInformation {
	private PanelClock panelClock;
	private JButton btnTime;
	private JButton btnCalendar;
	private PanelCalendar panelCalendar;
	private JPanel panel;
	private PanelTime panelTime;
	private Timer timer;

	public PanelInformation(PanelClock panelClock, PanelCalendar panelCalendar) {
		this.panel = new JPanel();

		this.panel.setBorder(new LineBorder(Color.BLACK));

		this.panelClock = panelClock;
		this.panelCalendar = panelCalendar;
		this.panelTime = new PanelTime(this.panelClock);
		this.panel.setLayout(new GridLayout(2, 2));
		addInformation();
	}

	public void addInformation() {
		this.panel.add(new JLabel("              Time is : "));
		this.panel.add(panelTime);
		createButton();
		this.panel.add(btnTime);
		this.panel.add(btnCalendar);
	}

	private void createButton() {
		btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelClock.setVisible(true);
				panelCalendar.setVisible(false);
				panelTime.setVisible(true);
			}
		});
		btnCalendar = new JButton("Calendar");
		btnCalendar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelClock.setVisible(false);
				panelCalendar.setVisible(true);
				panelTime.setVisible(false);
				
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}

	private class PanelTime extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Timer timer;
		PanelClock panelClock;

		public PanelTime(PanelClock panelClock) {
			this.panelClock = panelClock;

			this.setBackground(Color.LIGHT_GRAY);
			this.setFocusable(true);
			timer = new Timer(10, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
			timer.start();
		}

		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.BLACK);
			g2D.drawString("           " + panelClock.getKimGio().getCurrentTime() + ":"
					+ panelClock.getKimPhut().getCurrentMinute() + ":" + panelClock.getKimGiay().getCurrentSecond(), 20,
					20);

		};
	}
}
