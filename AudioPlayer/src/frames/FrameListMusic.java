package frames;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import listmusic.ListRender;
import listmusic.MusicFile;
import main.AudioPlayer;
import panel.PanelView;

public class FrameListMusic extends JFrame {
	private AudioPlayer audioPlayer;
	private DefaultListModel<MusicFile> listMusic = new DefaultListModel<>();
	private ArrayList<MusicFile> listFile;
	private JList<MusicFile> tllistMusic;
	private PanelView panelView;

	public FrameListMusic(AudioPlayer audioPlayer, PanelView panelView) {
		this.audioPlayer = audioPlayer;
		this.panelView = panelView;
		this.listFile = audioPlayer.getListMusic().getListMusicFile();
		this.setTitle("Frame ListMusic");
		this.setSize(800, 250);
		this.setVisible(false);
		//this.setLayout(null);
		addListMusic();
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2 - getWidth()/2, screenSize.height/2 +  audioPlayer.getHeight()/3);
		
		this.setLocation(middle);
	}

	private void addListMusic() {
		JPanel panel = new JPanel();
		for (int i = 0; i < listFile.size(); i++)
			listMusic.addElement(listFile.get(i));
		tllistMusic = creatListMusic();
		panel.add(new JScrollPane(tllistMusic));
		this.add(panel);
	}

	public JList<MusicFile> getTllistMusic() {
		return tllistMusic;
	}

	public DefaultListModel<MusicFile> getListMusic() {
		return listMusic;
	}

	public JList<MusicFile> creatListMusic() {
		JList<MusicFile> List = new JList<MusicFile>(listMusic);
		List.setCellRenderer(new ListRender());
		List.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				File file = listFile.get(List.getSelectedIndex()).getFile();

				audioPlayer.getSoundJLayer().setFilePath(file.getPath());
				audioPlayer.getSoundJLayer().play(0);
				audioPlayer.getButtonPlay().setIcon(AudioPlayer.createImageIcon("/icon-pause copy.png"));
				audioPlayer.getButtonPlay().setIsPlay(true);
				audioPlayer.setCurrentMusicFile(new MusicFile(file));
				panelView.run();
			}
		});
		return List;
	}

	public void addNewMusic(MusicFile musicFile) {
		listMusic.addElement(musicFile);
		tllistMusic = creatListMusic();
	}
}