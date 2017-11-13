package main;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import button.ButtonAdd;
import button.ButtonChangeInformation;
import button.ButtonCut;
import button.ButtonInsert;
import button.ButtonList;
import button.ButtonLookAndFeel;
import button.ButtonOpen;
import button.ButtonPlay;
import frames.FrameChangeInformation;
import frames.FrameCutMp3;
import frames.FrameInsert;
import frames.FrameListMusic;
import listmusic.ListMusic;
import listmusic.MusicFile;
import panel.PanelControl;
import panel.PanelView;

public class AudioPlayer extends JFrame {
	private PanelControl panelControl;
	private PanelView panelView;
	private ButtonAdd buttonAdd;
	private ButtonOpen buttonOpen;
	private ButtonList buttonList;
	private ButtonPlay buttonPlay;
	private ButtonChangeInformation buttonChangInformation;
	private ButtonCut buttonCut;
	private ListMusic listMusic;
	private SoundJLayer soundJLayer;
	private MusicFile currentMusicFile;
	private ButtonLookAndFeel buttonLookAndFeel;
private ButtonInsert buttonInsert;
	public AudioPlayer() {
		this.currentMusicFile = new MusicFile();
		this.setSize(620, 240);
		FrameChangeInformation frameChangeInformation = new FrameChangeInformation(this);
		FrameCutMp3 frameCutMp3 = new FrameCutMp3(this);
		FrameInsert frameInsert = new FrameInsert(this);
		this.setIconImage(createImageIcon("podcast_mp3[1].png").getImage());
		this.soundJLayer = new SoundJLayer();
		this.setTitle("tovanlam.audioplayer");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.listMusic = new ListMusic();
		this.panelView = new PanelView(this);
		this.panelControl = new PanelControl();
		FrameListMusic frameListMusic = new FrameListMusic(this, panelView);
		this.buttonAdd = new ButtonAdd(listMusic, frameListMusic);
		this.buttonOpen = new ButtonOpen(panelView, this);
		this.buttonList = new ButtonList(frameListMusic);
		this.buttonChangInformation = new ButtonChangeInformation(frameChangeInformation);
		this.buttonPlay = new ButtonPlay(panelView, this);
		this.buttonCut = new ButtonCut(frameCutMp3);
		this.buttonLookAndFeel = new ButtonLookAndFeel(this);
		this.buttonInsert = new ButtonInsert(frameInsert);
	//	this.add(buttonInsert);
	//this.add(buttonLookAndFeel);
		this.add(panelView);
		this.add(buttonAdd);
		this.add(buttonOpen);
		this.add(buttonList);
		this.add(buttonChangInformation);
		this.add(buttonPlay);
		this.add(buttonCut);
		this.add(panelControl);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public ButtonPlay getButtonPlay() {
		return buttonPlay;
	}

	public MusicFile getCurrentMusicFile() {
		return currentMusicFile;
	}

	public void setCurrentMusicFile(MusicFile currentMusicFile) {
		this.currentMusicFile = currentMusicFile;
	}

	public ListMusic getListMusic() {
		return listMusic;
	}

	public void setListMusic(ListMusic listMusic) {
		this.listMusic = listMusic;
	}

	public SoundJLayer getSoundJLayer() {
		return soundJLayer;
	}

	public static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = AudioPlayer.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			//return null;
                        return new ImageIcon(System.getProperty("user.dir") + "\\" + path);
		}
	}

	public static String getCurrentDirectory() {
		String path = null;
		CodeSource codeSource = AudioPlayer.class.getProtectionDomain().getCodeSource();
		try {
			File jarFile = new File(codeSource.getLocation().toURI().getPath());
			path = jarFile.getParentFile().getPath();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void main(String[] args) {
		String type = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		AudioPlayer audioPlayer = new AudioPlayer();
		
	}
}
