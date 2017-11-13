package button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import main.AudioPlayer;

public class ButtonLookAndFeel extends JButton {
	private String type;

	public ButtonLookAndFeel(AudioPlayer audioPlayer) {
		this.setText("Metal");
		this.setBounds(510, 1, 100, 30);
		this.setBackground(Color.YELLOW);
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (getText()) {
				case "Metal":
					setText("Window");
					type = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					break;

				case "Window":
					setText("Moti");
					type = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
					break;

				case "Moti":
					setText("System");
					type = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
					break;

				case "System":
					setText("Metal");
					type = "javax.swing.plaf.metal.MetalLookAndFeel";
					break;
				}
				try {
					UIManager.setLookAndFeel(type);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI((JFrame) audioPlayer);
			}
		});
		this.setMnemonic(KeyEvent.VK_L);
		
	}

}