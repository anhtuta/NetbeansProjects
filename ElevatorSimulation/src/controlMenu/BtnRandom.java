package controlMenu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BtnRandom extends JLabel {
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;

	public BtnRandom() {
		icon = new ImageIcon(this.getClass().getResource("/image/random.png"));
		this.setIcon(icon);
	}
}
