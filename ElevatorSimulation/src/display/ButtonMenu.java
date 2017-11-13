
package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonMenu extends JPanel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JButton start;
	private JButton instruction;
	private JButton exit;

	public ButtonMenu() {
		Box bl = Box.createVerticalBox();
		Icon startIcon = new ImageIcon(this.getClass().getResource("/image/start.png"));
		start = new JButton(startIcon);
		start.setBorderPainted(false);
		start.setBackground(Color.WHITE);
		start.setBorder(null);

		Icon instructionIcon = new ImageIcon(this.getClass().getResource("/image/instruction.png"));
		instruction = new JButton(instructionIcon);
		instruction.setBorderPainted(false);
		instruction.setBackground(Color.WHITE);
		instruction.setBorder(null);

		Icon exitIcon = new ImageIcon(this.getClass().getResource("/image/exit.png"));
		exit = new JButton(exitIcon);
		exit.setBorderPainted(false);
		exit.setBorder(null);
		exit.setBackground(Color.WHITE);

		bl.add(start);
		bl.add(instruction);
		bl.add(exit);

		this.add(bl);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public JButton getStart() {
		return start;
	}

	public JButton getInstruction() {
		return instruction;
	}

	public JButton getExit() {
		return exit;
	}

}
