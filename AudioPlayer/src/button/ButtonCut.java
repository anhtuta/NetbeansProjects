package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import frames.FrameCutMp3;

public class ButtonCut extends JButton {
	public ButtonCut(FrameCutMp3 frameCutMp3) {
		this.setText("Cut");
		this.setBounds(555, 170, 55, 30);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!frameCutMp3.isVisible()) {
					frameCutMp3.setVisible(true);
					frameCutMp3.setInformation();
				} else {
					frameCutMp3.setVisible(false);
				}

			}
		});
		this.setMnemonic(KeyEvent.VK_X);
	}
}
