package tovanlam.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import tovanlam.display.PanelCalendar;
import tovanlam.display.PanelClock;
import tovanlam.display.PanelInformation;
import tovanlam.lich.CalendarMonth;
import tovanlam.lich.Thang;

public class Clock {
	private PanelClock panelClock;
	private PanelInformation panelInformation;
	private static PanelCalendar panelCalendar;
	private JFrame frame;

	public Clock() {
		frame = new JFrame("DongHoToVanLam");
		frame.setSize(260, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		System.out.println("OK1");
		panelClock = new PanelClock();
		frame.add(panelClock);
		panelClock.setBounds(0, 0, 260, 260);
		panelClock.setBackground(Color.yellow);
		System.out.println("OK2");
		panelCalendar = new PanelCalendar();
		frame.add(panelCalendar);
		panelCalendar.setBounds(0, 0, 260, 295);
		panelCalendar.setBackground(Color.CYAN);
		panelCalendar.setVisible(false);
		System.out.println("OK3");
		panelInformation = new PanelInformation(panelClock, panelCalendar);
		frame.add(panelInformation.getPanel());
		panelInformation.getPanel().setBounds(0, 260, 260, 70);
		panelInformation.getPanel().setBackground(Color.LIGHT_GRAY);
		frame.setLocationRelativeTo(null);
		System.out.println("OK4");
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Clock();
		
		
	}
}
