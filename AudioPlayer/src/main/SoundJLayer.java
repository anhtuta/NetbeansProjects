package main;

import java.io.File;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import listmusic.MusicFile;

public class SoundJLayer extends PlaybackListener implements Runnable {
	private String filePath;
	private AdvancedPlayer player;
	private Thread playerThread;
	private int number;
	private int startFrame;
	private int endFrame;
	private boolean isPlay;
	private MusicFile musicFile;

	public SoundJLayer(String filePath) {
		number = 1;
		this.filePath = filePath;
		isPlay = false;

	}

	public SoundJLayer() {

	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void play() {
		musicFile = new MusicFile(new File(filePath));
		number = 1;
		if (isPlay) {
			this.player.close();
		}
		isPlay = true;
		try {
			String urlAsString = "file:///" + "/" + this.filePath;

			this.player = new AdvancedPlayer(new java.net.URL(urlAsString).openStream(),
					javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this, "AudioPlayerThread");
			this.playerThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void play(int startTime) {
		System.out.println(filePath);
		musicFile = new MusicFile(new File(filePath));
		musicFile.setCurrentFrame(startTime);
		number = 2;
		this.startFrame = (int) (startTime * musicFile.getNumberFrames() / musicFile.getTimeEnd());
		if (isPlay) {
			this.player.close();
		}
		isPlay = true;
		try {
			String urlAsString = "file:///" + "/" + this.filePath;

			this.player = new AdvancedPlayer(new java.net.URL(urlAsString).openStream(),
					javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this, "AudioPlayerThread");
			this.playerThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void play(int startTime, int endTime) {
		musicFile = new MusicFile(new File(filePath));
		musicFile.setCurrentFrame(startTime);
		number = 3;
		this.startFrame = (int) (startTime * musicFile.getNumberFrames() / musicFile.getTimeEnd());
		this.endFrame = (int) (endTime * musicFile.getNumberFrames() / musicFile.getTimeEnd());
		if (isPlay) {
			this.player.close();
		}
		isPlay = true;
		try {
			String urlAsString = "file:///" + "/" + this.filePath;

			this.player = new AdvancedPlayer(new java.net.URL(urlAsString).openStream(),
					javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
			this.player.setPlayBackListener(this);
			this.playerThread = new Thread(this, "AudioPlayerThread");
			this.playerThread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void playbackStarted(PlaybackEvent playbackEvent) {
		System.out.println("playbackStarted");
	}

	public void playbackFinished(PlaybackEvent playbackEvent) {
		System.out.println("playbackEnded");
	}

	public void stop() {
		this.player.stop();
	}

	public void close() {
		this.player.close();
		isPlay = false;
	}

	public void run() {
		try {
			switch (number) {
			case 1:
				this.player.play();
				break;
			case 2:

				this.player.play(startFrame, musicFile.getNumberFrames());

				break;
			case 3:
				this.player.play(startFrame, endFrame);
				break;
			}
		} catch (javazoom.jl.decoder.JavaLayerException ex) {
			ex.printStackTrace();
		}
	}

	public boolean isPlay() {
		return isPlay;
	}

}
