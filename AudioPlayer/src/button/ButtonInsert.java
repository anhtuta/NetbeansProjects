package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import frames.FrameInsert;

public class ButtonInsert extends JButton {
	private String type;

	public ButtonInsert(FrameInsert frameInsert) {
		this.setText("Insert");
		this.setBounds(510, 1, 100, 30);
		this.setBackground(Color.YELLOW);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!frameInsert.isVisible()) {

					frameInsert.setVisible(true);
				} else {
					frameInsert.setVisible(false);
				}
			}
		});
		this.setMnemonic(KeyEvent.VK_L);

	}

}