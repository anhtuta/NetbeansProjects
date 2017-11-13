package panel;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelControl extends JPanel{
	public PanelControl(){
		this.setBounds(0, 150, 620, 60);
		this.setBackground(Color.CYAN);
		this.setBorder(new LineBorder(Color.BLACK));
		this.setFocusable(true);
	}
	
}
