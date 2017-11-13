package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.UIManager;

import frames.FrameChangeInformation;

public class ButtonChangeInformation extends JButton {
	public ButtonChangeInformation(FrameChangeInformation frameChangeInformation) {
		this.setText("ChangeInformation");
		this.setBounds(380, 170, 150, 30);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!frameChangeInformation.isVisible()) {
					frameChangeInformation.setInformation();
					frameChangeInformation.setVisible(true);
				} else {
					frameChangeInformation.setVisible(false);
				}
				
			}
		});
		this.setMnemonic(KeyEvent.VK_C);
	}
}
