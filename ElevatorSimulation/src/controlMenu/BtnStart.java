package controlMenu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BtnStart extends JLabel {
	private ImageIcon icon;
	private static final long serialVersionUID = 1L;

	public BtnStart() {
		icon = new ImageIcon(this.getClass().getResource("/image/startControl.png"));
		this.setIcon(icon);
	}
}