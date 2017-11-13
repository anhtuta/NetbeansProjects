package controlMenu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BtnAdd extends JLabel {
	private ImageIcon icon;

	private static final long serialVersionUID = 1L;

	public BtnAdd() {
		icon = new ImageIcon(this.getClass().getResource("/image/add.png"));
		this.setIcon(icon);

	}

}
