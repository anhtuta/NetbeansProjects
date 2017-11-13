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
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;

import listmusic.MusicFile;
import main.AudioPlayer;

public class FrameChangeInformation extends JFrame {
	private JTextField tfNewTitle;
	private JTextField tfNewArtist;
	private JTextField tfNewAlbum;
	private JTextField tfNewYear;
	private JTextField tfComment;
	private JTextArea textArea;
	private JButton btnOk;
	private AudioPlayer audioPlayer;

	public FrameChangeInformation(AudioPlayer audioPlayer) {
		this.audioPlayer =audioPlayer;
		this.setTitle("Frame ChangeInformation");
		this.setSize(305, 330);
		this.setVisible(false);
		this.setLayout(null);
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point( (int) (audioPlayer.getWidth()/2+screenSize.getWidth()/2), screenSize.height / 2 - getHeight()/2);
		this.setLocation(middle);
		addTextField();
		addButton();
		setInformation();
	}
	public void setInformation(){
		if(audioPlayer.getCurrentMusicFile()!=null){
		tfNewTitle.setText(audioPlayer.getCurrentMusicFile().getTitle());
		tfNewArtist.setText(audioPlayer.getCurrentMusicFile().getArtist());
		tfNewAlbum.setText(audioPlayer.getCurrentMusicFile().getAlbum());
		tfNewYear.setText(audioPlayer.getCurrentMusicFile().getYear());
		tfComment.setText(audioPlayer.getCurrentMusicFile().getComment());
		}
	}

	private void addTextField() {
		tfNewTitle = new JTextField(30);
		tfNewArtist = new JTextField(30);
		tfNewAlbum = new JTextField(30);
		tfNewYear = new JTextField(4);
		tfComment = new JTextField(31);
		tfNewTitle.requestFocus();
		tfNewTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfNewArtist.requestFocus();
			}
		});
		tfNewArtist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfNewAlbum.requestFocus();
			}
		});
		tfNewAlbum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfNewYear.requestFocus();
			}
		});
		tfNewYear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfComment.requestFocus();
			}
		});
		tfComment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnOk.doClick();
			}
		});
		textArea = new JTextArea(3, 23);
		textArea.setText("Nhap cac thong so roi nhan Ok" + "\n");
		textArea.setEditable(false);
		JPanel panelArea = new JPanel();
		panelArea.setBounds(10, 0, 280, 70);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelArea.add(scrollPane);
		this.add(panelArea);
		JPanel panelSet = new JPanel();
		panelSet.setLayout(new GridLayout(5, 2));
		panelSet.setBounds(0, 73, 300, 180);
		panelSet.add(new JLabel("   NewTitle : "));
		panelSet.add(tfNewTitle);
		panelSet.add(new JLabel("   NewArtist : "));
		panelSet.add(tfNewArtist);
		panelSet.add(new JLabel("   NewAlbum : "));
		panelSet.add(tfNewAlbum);
		panelSet.add(new JLabel("   NewYear : "));
		panelSet.add(tfNewYear);
		panelSet.add(new JLabel("   NewComment : "));
		panelSet.add(tfComment);
		this.add(panelSet);
	}

	private void addButton() {
		btnOk = new JButton("OK");
		btnOk.setBounds(40, 260, 100, 30);
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
					textArea.setText(textArea.getText() + "Open file : " + file.getPath() + "  "+"\n"+ "Doi chut...."+"\n");
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
						
						musicFile.changeInformation(fileSave, tfNewTitle.getText(), tfNewArtist.getText(),
								tfNewAlbum.getText(), tfNewYear.getText(), tfComment.getText());
						textArea.setText("Ok da tao File Xong");
					}

				}
			}
		});
		this.add(btnOk);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(160, 260, 100, 30);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		this.add(btnCancel);

	}
}
