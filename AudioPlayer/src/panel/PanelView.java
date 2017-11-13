package panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalSliderUI;

import listmusic.MusicFile;
import main.AudioPlayer;

public class PanelView extends JPanel {
	private Timer timer;
	private MusicFile musicFile;
	private JSlider slider;
	private JPanel panelInformation;
	private JLabel labelCurrentTime;
	private JLabel labelEndTime;
	private JLabel labelSong;
	private JLabel labelArtist;
	private AudioPlayer audioPlayer;
	private int currentValue;

	public PanelView(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
		this.slider = new JSlider();
		this.currentValue = 0;
		this.labelSong = new JLabel("Song :");
		this.labelArtist = new JLabel("Artist : ");
		this.slider.setValue(0);
		slider.setForeground(Color.red);
		slider.setBackground(Color.GREEN);

		slider.setUI(new MetalSliderUI() {
			protected void scrollDueToClickInTrack(int direction) {
				int value = slider.getValue();
				if (slider.getOrientation() == JSlider.HORIZONTAL) {
					value = this.valueForXPosition(slider.getMousePosition().x);
				} else if (slider.getOrientation() == JSlider.VERTICAL) {
					value = this.valueForYPosition(slider.getMousePosition().y);
				}
				slider.setValue(value);
			}
		});
		this.setBounds(0, 0, 620, 150);
		this.setBackground(Color.YELLOW);
		this.setBorder(new LineBorder(Color.BLACK));
		this.setLayout(new GridLayout(5, 1));
		this.setFocusable(true);
		this.add(new JLabel("AudioPlayer - ToVanLam"));
		this.add(labelSong);
		this.add(labelArtist);
		this.add(slider);
		timer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		slider.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (Math.abs(slider.getValue() - currentValue) > 10) {
					audioPlayer.getSoundJLayer().play(slider.getValue());
					audioPlayer.getCurrentMusicFile().setCurrentFrame(slider.getValue());
				}

			}
		});
		addPanelInformation();
	}

	public void addPanelInformation() {

		panelInformation = new JPanel();
		panelInformation.setLayout(new GridLayout(1, 10));
		labelCurrentTime = new JLabel("0:0:0");
		labelEndTime = new JLabel("0:0:0");
		panelInformation.add(labelCurrentTime);
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(new JLabel("|"));
		panelInformation.add(labelEndTime);
		this.add(panelInformation);
	}

	private void refresh() {

		labelSong.setText("Song : " + audioPlayer.getCurrentMusicFile().getBitrate() + "kbs - Ten bai hat : "
				+ audioPlayer.getCurrentMusicFile().getName());
		labelArtist.setText("Artist : " + audioPlayer.getCurrentMusicFile().getArtist());
		audioPlayer.getCurrentMusicFile().increaseCurrentFrame();

		slider.setMinimum(0);
		slider.setMaximum((int) audioPlayer.getCurrentMusicFile().getTimeEnd());
		slider.setValue(audioPlayer.getCurrentMusicFile().getCurrentTimeSecond());
		this.currentValue = slider.getValue();
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(false);
		slider.setPaintLabels(false);
		slider.setPaintTrack(true);
		labelCurrentTime.setText(audioPlayer.getCurrentMusicFile().getCurrentTime());
		labelEndTime.setText(audioPlayer.getCurrentMusicFile().getTotalTime());
	}

	public void run() {
		timer.start();
	}

	public void pause() {
		timer.stop();
	}

}
