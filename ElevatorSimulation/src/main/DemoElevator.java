package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import display.AudioPlayer;
import display.PanelBuilding;
import display.PanelControl;
import display.PanelInfomation;
import display.PanelInstruction;
import display.PanelMenu;

public class DemoElevator {

	PanelControl panelControl;
	PanelBuilding panelBuilding;
	PanelInfomation panelInformation;
	PanelMenu panelMenu;
	JButton start;
	JPanel demo;
	JFrame frame;
	AudioPlayer sound;
	PanelInstruction instruction;

	public DemoElevator() throws IOException {
		panelBuilding = new PanelBuilding();
		panelControl = new PanelControl(panelBuilding);
		panelInformation = new PanelInfomation(panelBuilding);
		instruction = new PanelInstruction("/image/game.png");
		sound = new AudioPlayer("bgmusic.wav");
		panelMenu = new PanelMenu("/image/game.png");
		frame = new JFrame();
		frame.add(panelMenu);
		instruction.setVisible(false);
		demo = new JPanel();
		addPanel();
		panelMenu.getStart().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				panelMenu.setVisible(false);
				frame.add(demo);
				demo.setVisible(true);
				panelMenu.getSound().play();
			}
		});
		panelMenu.getInstruction().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				panelMenu.setVisible(false);
				frame.add(instruction);
				instruction.setVisible(true);
				panelMenu.getSound().play();
			}
		});
		panelControl.getBack().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				demo.setVisible(false);
				panelMenu.setVisible(true);
				panelMenu.getSound().play();
			}
		});

		instruction.getBtnBack().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				instruction.setVisible(false);
				panelMenu.setVisible(true);
				panelMenu.getSound().play();
			}
		});

		panelMenu.getSoundBtn().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (sound.isPlay()) {
					sound.stop();
				} else {
					sound.play();
					sound.loop();
				}
			}

		});
	}

	public void addPanel() {
		panelBuilding.setBounds(0, 0, 600, 660);
		panelControl.setBounds(610, 0, 450, 380);
		panelInformation.setBounds(600, 370, 463, 357);
		demo.setLayout(null);
		demo.add(panelBuilding);
		demo.add(panelControl);
		demo.add(panelInformation);
		demo.setVisible(false);
		frame.setSize(1088, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static String getCurrentDirectory() {
		String path = null;
		CodeSource codeSource = DemoElevator.class.getProtectionDomain().getCodeSource();
		try {
			File jarFile = new File(codeSource.getLocation().toURI().getPath());
			path = jarFile.getParentFile().getPath();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static void main(String[] args) throws IOException {

		new DemoElevator();
	}

}
