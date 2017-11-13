
package frames;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import listmusic.MusicFile;
import main.AudioPlayer;

public class FrameInsert extends JFrame {
	
	private JTextArea textArea;
	private JButton btnOk;
	private AudioPlayer audioPlayer;

	public FrameInsert(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
		this.setTitle("Frame Insert");
		this.setSize(300, 250);
		this.setVisible(false);
		this.setLayout(null);
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2 - audioPlayer.getWidth(),
				(int) (screenSize.getHeight() / 2 - getHeight() / 2));
		this.setLocation(middle);
		addTextField();
		addButton();
	//	setInformation();
	}

//	public void setInformation() {
//		if (audioPlayer.getCurrentMusicFile() != null) {
//			timeStart.setText(audioPlayer.getCurrentMusicFile().getTitle());
//		}
//	}

	private void addTextField() {
//		timeStart = new JTextField(30);
//		timeEnd = new JTextField(30);
//
//		timeStart.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				timeEnd.requestFocus();
//			}
//		});
//		timeEnd.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				timeEnd.requestFocus();
//			}
//		});
//
		textArea = new JTextArea(7, 23);
		textArea.setText("Nhan Ok" + "\n");
		textArea.setEditable(false);
		JPanel panelArea = new JPanel();
		panelArea.setBounds(0, 0, 280, 140);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelArea.add(scrollPane);
		this.add(panelArea);
//		JPanel panelSet = new JPanel();
//		panelSet.setLayout(new GridLayout(2, 2));
//		panelSet.setBounds(0, 75, 300, 80);
//		panelSet.add(new JLabel("   TimeStart : "));
//		panelSet.add(timeStart);
//		panelSet.add(new JLabel("   TimeEnd : "));
//		panelSet.add(timeEnd);
//
//		this.add(panelSet);
	}

	private void addButton() {
		btnOk = new JButton("OK");
		btnOk.setBounds(40, 165, 100, 30);
		btnOk.addActionListener(new ActionListener() {

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
					String nameFile = file.getName();
					if (nameFile.length() > 4) {
						String mp3 = nameFile.substring(nameFile.length() - 4);
						if (mp3.equals(".mp3")) {

						} else {
							file = new File(file.toString() + ".mp3");
							file = new File(file.getParentFile(), nameFile + ".mp3");
						}
					} else {
						file = new File(file.toString() + ".mp3");
						file = new File(file.getParentFile(), nameFile + ".mp3");
					}
					textArea.setText(
							textArea.getText() + "Open file : " + file.getPath() + "  " + "\n" + "Doi chut...." + "\n");
					MusicFile musicFile = new MusicFile(file);

					JFileChooser fileChooserSave = new JFileChooser(new File(workingdir));

					fileChooserSave.addChoosableFileFilter(filter);
					fileChooserSave.setFileFilter(filter);
					int returnValSave = fileChooserSave.showSaveDialog(new JFrame());
					if (returnValSave == JFileChooser.APPROVE_OPTION) {
						File fileSave = fileChooserSave.getSelectedFile();
						String nameFileSave = fileSave.getName();
						if (nameFileSave.length() > 4) {
							String mp3 = nameFileSave.substring(nameFileSave.length() - 4);
							System.out.println(mp3);
							if (mp3.equals(".mp3")) {

							} else {
								fileSave = new File(fileSave.toString() + ".mp3");
								fileSave = new File(fileSave.getParentFile(), nameFileSave + ".mp3");
							}
						} else {
							fileSave = new File(fileSave.toString() + ".mp3");
							fileSave = new File(fileSave.getParentFile(), nameFileSave + ".mp3");
						}
//
//						musicFile.cutFile(fileSave, Integer.valueOf(timeStart.getText()),
//								Integer.valueOf(timeEnd.getText()));
						musicFile.insertFile(fileSave);
						textArea.setText("Ok da tao File Xong");
					}

				}
			}
		});
		this.add(btnOk);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(160, 165, 100, 30);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		this.add(btnCancel);

	}
}
