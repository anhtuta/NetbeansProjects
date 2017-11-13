package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import frames.FrameListMusic;
import listmusic.ListMusic;
import listmusic.MusicFile;

public class ButtonAdd extends JButton {
	public ButtonAdd(ListMusic listMusic, FrameListMusic frameListMusic) {
		this.setText("Add");
		this.setBounds(30, 170, 70, 30);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String workingdir = System.getProperty("user.dir");
				JFileChooser fileChooser = new JFileChooser(new File(workingdir));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("MUSIC FILE", "mp3", "wav");
				fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showSaveDialog(new JFrame());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String nameFile = file.getName();
					if (nameFile.length() > 4) {
						String txt = nameFile.substring(nameFile.length() - 4);
						if (txt.equals(".mp3")) {

						} else {
							file = new File(file.toString() + ".mp3");
							file = new File(file.getParentFile(), nameFile + ".mp3");
						}
					} else {
						file = new File(file.toString() + ".mp3");
						file = new File(file.getParentFile(), nameFile + ".mp3");
					}

					String audioName = file.getName();
					String audioURL = file.getPath();
					listMusic.addToCurrentListURL(audioURL);
					listMusic.addToCurrentListName(audioName);
					listMusic.addToListMusicFile(audioURL, audioName);
					frameListMusic.addNewMusic(new MusicFile(audioURL,audioName));

				}

			}
		});
		this.setMnemonic(KeyEvent.VK_A);
	}
}
