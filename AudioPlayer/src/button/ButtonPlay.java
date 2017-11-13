package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import main.AudioPlayer;
import panel.PanelView;

public class ButtonPlay extends JButton {
	private boolean isPlay;
	public ButtonPlay(PanelView panelView, AudioPlayer audioPlayer) {
		isPlay = false;
		this.setBounds(305, 170, 50, 30);
		
		this.setIcon(AudioPlayer.createImageIcon("/play copy.png"));
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isPlay) {
					isPlay = false;
					setIcon(AudioPlayer.createImageIcon("/play copy.png"));
					audioPlayer.getSoundJLayer().stop();
					panelView.pause();
				} else {
					isPlay = true;
					setIcon(AudioPlayer.createImageIcon("/icon-pause copy.png"));
					audioPlayer.getSoundJLayer().play(audioPlayer.getCurrentMusicFile().getCurrentTimeSecond());
					panelView.run();
				}

			}
		});
		this.setMnemonic(KeyEvent.VK_P);
		
	}
	public void setIsPlay(boolean isPlay){
		this.isPlay = isPlay;
	}
	
}
