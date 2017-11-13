package controlMenu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BtnPause extends JLabel {
	private ImageIcon icon;
	private static final long serialVersionUID = 1L;

	public BtnPause() {
		icon = new ImageIcon(this.getClass().getResource("/image/pause.png"));
		this.setIcon(icon);
	}
}
