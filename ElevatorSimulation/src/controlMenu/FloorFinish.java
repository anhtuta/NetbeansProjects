package controlMenu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FloorFinish extends JPanel {
	/**
	 * 
	 */
	private ImageIcon icon;
	private JLabel floor1;
	private JLabel floor2;
	private JLabel floor3;
	private JLabel floor4;
	private JLabel floor5;
	private JLabel floor6;
	private int selectedIndex;

	private static final long serialVersionUID = 1L;

	public FloorFinish() {
		icon = new ImageIcon(this.getClass().getResource("/image/pane1.png"));
		Box box = Box.createHorizontalBox();
		floor1 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish1.png")));
		floor2 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish2.png")));
		floor3 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish3.png")));
		floor4 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish4.png")));
		floor5 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish5.png")));
		floor6 = new JLabel(new ImageIcon(this.getClass().getResource("/image/finish6.png")));
		box.add(floor1);
		box.add(floor2);
		box.add(floor3);
		box.add(floor4);
		box.add(floor5);
		box.add(floor6);
		this.add(box);

		floor1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(0);
				setIcon();
				floor1.setIcon(new ImageIcon(this.getClass().getResource("/image/1.png")));
			}
		});

		floor2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(1);
				setIcon();
				floor2.setIcon(new ImageIcon(this.getClass().getResource("/image/2.png")));
			}
		});

		floor3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(2);
				setIcon();
				floor3.setIcon(new ImageIcon(this.getClass().getResource("/image/3.png")));
			}
		});

		floor4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(3);
				setIcon();
				floor4.setIcon(new ImageIcon(this.getClass().getResource("/image/4.png")));
			}
		});

		floor5.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(4);
				setIcon();
				floor5.setIcon(new ImageIcon(this.getClass().getResource("/image/5.png")));
			}
		});

		floor6.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				setSelectedIndex(5);
				setIcon();
				floor6.setIcon(new ImageIcon(this.getClass().getResource("/image/6.png")));
			}
		});
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public void setIcon() {
		floor1.setIcon(new ImageIcon(this.getClass().getResource("/image/finish1.png")));
		floor2.setIcon(new ImageIcon(this.getClass().getResource("/image/finish2.png")));
		floor3.setIcon(new ImageIcon(this.getClass().getResource("/image/finish3.png")));
		floor4.setIcon(new ImageIcon(this.getClass().getResource("/image/finish4.png")));
		floor5.setIcon(new ImageIcon(this.getClass().getResource("/image/finish5.png")));
		floor6.setIcon(new ImageIcon(this.getClass().getResource("/image/finish6.png")));
	}
}
