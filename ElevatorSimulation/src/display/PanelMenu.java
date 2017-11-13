
package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private JLabel start;
	private JLabel instruction;
	private JLabel exit;
	private AudioPlayer sound;
	private JLabel soundBgBtn;
	private JLabel load;

	public PanelMenu(String link) throws IOException {
		soundBgBtn = new JLabel(new ImageIcon(this.getClass().getResource("/image/bgsound.png")));
		sound = new AudioPlayer("soundClick.wav");
		icon = new ImageIcon(this.getClass().getResource(link));
		Box box = Box.createVerticalBox();
		Icon startIcon = new ImageIcon(this.getClass().getResource("/image/start.png"));
		start = new JLabel(startIcon);
		Icon instructionIcon = new ImageIcon(this.getClass().getResource("/image/instruction.png"));
		instruction = new JLabel(instructionIcon);
		Icon exitIcon = new ImageIcon(this.getClass().getResource("/image/exit.png"));
		exit = new JLabel(exitIcon);
		
		box.setPreferredSize(new Dimension(375, 500));
		box.add(Box.createVerticalStrut(20));
		box.add(start);
		box.add(instruction);
		box.add(soundBgBtn);
		box.add(exit);
		this.add(box);
		exit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				System.exit(1);
				sound.play();
			}
		});

	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public JLabel getStart() {
		return start;
	}

	public JLabel getInstruction() {
		return instruction;
	}

	public JLabel getExit() {
		return exit;
	}

	public AudioPlayer getSound() {
		return sound;
	}

	public JLabel getSoundBtn() {
		return soundBgBtn;
	}

}
