package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import frames.FrameListMusic;
import listmusic.ListMusic;
import main.AudioPlayer;
import panel.PanelView;

public class ButtonList extends JButton {
	public ButtonList(FrameListMusic frameListMusic) {
		this.setText("List");
		this.setBounds(210, 170, 70, 30);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!frameListMusic.isVisible()) {
					frameListMusic.setVisible(true);
				} else {
					frameListMusic.setVisible(false);
				}

			}
		});
		this.setMnemonic(KeyEvent.VK_L);
	}
}
