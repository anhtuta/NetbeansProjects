package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import listmusic.MusicFile;
import main.AudioPlayer;
import panel.PanelView;

public class ButtonOpen extends JButton {

	public ButtonOpen(PanelView panelView, AudioPlayer audioPlayer) {
		this.setText("Open");
		this.setBounds(120, 170, 70, 30);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String workingdir = System.getProperty("user.dir");
				JFileChooser fileChooser = new JFileChooser(new File(workingdir));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MUSIC FILES", "mp3", "wav");
				fileChooser.addChoosableFileFilter(filter);

				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(new JFrame());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();

					audioPlayer.getSoundJLayer().setFilePath(file.getPath());
					audioPlayer.getSoundJLayer().play(0);
					audioPlayer.getButtonPlay().setIcon(AudioPlayer.createImageIcon("/icon-pause copy.png"));
					audioPlayer.getButtonPlay().setIsPlay(true);
					audioPlayer.setCurrentMusicFile(new MusicFile(file));
					System.out.println(audioPlayer.getCurrentMusicFile().getTimeEnd());
					panelView.run();
				}
				
			}

		});
		this.setMnemonic(KeyEvent.VK_O);
	}

}
