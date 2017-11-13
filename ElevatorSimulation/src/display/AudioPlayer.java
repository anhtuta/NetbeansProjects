
package display;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import main.DemoElevator;

public class AudioPlayer {
	private Clip clip;
	private boolean isPlay;

	public AudioPlayer(String nameAudio) {
		File file = new File(DemoElevator.getCurrentDirectory() + "//music//" + nameAudio);
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.start();
		isPlay = true;
	}

	public AudioPlayer clone() {
		return this.clone();
	}

	public void stop() {
		if (clip.isRunning())
			clip.stop();
		isPlay = false;
	}

	public void close() {
		stop();
		clip.close();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public boolean isPlay() {
		return isPlay;
	}
}
