
package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInstruction extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel instruction;
	private JLabel btnBack;
	private ImageIcon icon;

	public PanelInstruction(String link) {
		icon = new ImageIcon(this.getClass().getResource(link));
		setLayout(new BorderLayout());
		instruction = new JLabel(new ImageIcon(this.getClass().getResource("/image/instruction1.png")));
		ImageIcon backIcon = new ImageIcon(this.getClass().getResource("/image/back.png"));
		btnBack = new JLabel(backIcon);
		this.add(instruction, BorderLayout.NORTH);
		this.add(btnBack, BorderLayout.SOUTH);
	}

	public JLabel getBtnBack() {
		return btnBack;
	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
