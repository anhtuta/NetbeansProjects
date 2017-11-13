package tovanlam.display;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import tovanlam.dongho.DateAndTime;
import tovanlam.lich.CalendarMonth;
import tovanlam.lich.Day;
import tovanlam.lich.Nam;
import tovanlam.lich.Ngay;
import tovanlam.lich.Thang;
import tovanlam.lich.Thu;

public class PanelCalendar extends JPanel {
	private Timer timer;
	private CalendarMonth CurrentCalendarMonth;
	private JButton btnNext;
	private JButton btnPrev;	
	private JLabel labelMonth;
	private ArrayList<JLabel> listLabel;

	public PanelCalendar() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setFocusable(true);
		CurrentCalendarMonth = new CalendarMonth(new Thang(DateAndTime.getMonth(), new Nam(DateAndTime.getYear())));
		timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
		this.setLayout(null);

		addPanelSetting();

		addListLabel();

	}

	private void addPanelSetting() {
		JPanel panelSetting = new JPanel();
		panelSetting.setFocusable(true);
		panelSetting.setLayout(new GridLayout(1, 3));
		btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CurrentCalendarMonth = CurrentCalendarMonth.getPrevCalendarMonth();
				for (int i = 7; i < 49; i++) {
					listLabel.get(i).setText(
							String.valueOf(CurrentCalendarMonth.getListDay().get(i - 7).getNgay().getNumberOfDay()));
				}
				labelMonth.setText("       " + CurrentCalendarMonth.getMonth().getNumberOfMonth() + " : "
						+ CurrentCalendarMonth.getMonth().getYear().getNumberOfYear());
				setColorCalendar();
			}
		});
		panelSetting.add(btnPrev);
		labelMonth = new JLabel("       " + CurrentCalendarMonth.getMonth().getNumberOfMonth() + " : "
				+ CurrentCalendarMonth.getMonth().getYear().getNumberOfYear());
		panelSetting.add(labelMonth);
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CurrentCalendarMonth = CurrentCalendarMonth.getNextCalendarMonth();
				for (int i = 7; i < 48; i++) {
					listLabel.get(i).setText(
							String.valueOf(CurrentCalendarMonth.getListDay().get(i - 7).getNgay().getNumberOfDay()));
				}
				labelMonth.setText("       " + CurrentCalendarMonth.getMonth().getNumberOfMonth() + " : "
						+ CurrentCalendarMonth.getMonth().getYear().getNumberOfYear());
				setColorCalendar();
			}
		});
		panelSetting.add(btnNext);
		this.add(panelSetting);
		panelSetting.setBounds(0, 0, 260, 37);
	}

	private void setColorCalendar() {
		for (int i = 7; i < 49; i++) {
			listLabel.get(i).setOpaque(true);
			if ((i <= 20 && Integer.valueOf(listLabel.get(i).getText()) > 15)
					|| (i >= 30 && Integer.valueOf(listLabel.get(i).getText()) < 15)) {
				listLabel.get(i).setBackground(Color.LIGHT_GRAY);
			} else {
				listLabel.get(i).setBackground(Color.CYAN);
				if (Integer.valueOf(listLabel.get(i).getText()) == DateAndTime.getDay()
						&& CurrentCalendarMonth.getMonth().getNumberOfMonth() == DateAndTime.getMonth()
						&& CurrentCalendarMonth.getMonth().getYear().getNumberOfYear() == DateAndTime.getYear()) {
					listLabel.get(i).setBackground(Color.RED);
				}
			}

		}
	}

	private void addListLabel() {
		JPanel panelLabel = new JPanel();
		panelLabel.setFocusable(true);
		panelLabel.setLayout(new GridLayout(7, 7));
		listLabel = new ArrayList<>();
		listLabel.add(new JLabel("Su"));
		listLabel.add(new JLabel("Mo"));
		listLabel.add(new JLabel("Tu"));
		listLabel.add(new JLabel("We"));
		listLabel.add(new JLabel("Th"));
		listLabel.add(new JLabel("Fr"));
		listLabel.add(new JLabel("Sa"));
		for (int i = 0; i < 42; i++) {
			listLabel.add(
					new JLabel(String.valueOf(CurrentCalendarMonth.getListDay().get(i).getNgay().getNumberOfDay())));
		}
		setColorCalendar();
		for (int i = 0; i < 49; i++) {
			panelLabel.add(listLabel.get(i));
		}
		this.add(panelLabel);
		panelLabel.setBounds(0, 38, 260, 256);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.BLACK);

	};

	public Day currentDay() {
		Thu thu = CurrentCalendarMonth.getFirstDayOfMonth().getThu();
		Ngay ngay = new Ngay(DateAndTime.getDay(), CurrentCalendarMonth.getMonth());
		for (int i = 1; i < ngay.getNumberOfDay(); i++) {
			thu = thu.getNextThu();
		}
		return new Day(thu, ngay);
	}

	public CalendarMonth getCurrentCalendarMonth() {
		return CurrentCalendarMonth;
	}

}
