package listmusic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ListRender extends JPanel implements ListCellRenderer<MusicFile> {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JLabel musicLb;

	public ListRender() {
		musicLb = new JLabel();
		add(musicLb);
	}

	public Component getListCellRendererComponent(JList<? extends MusicFile> list, MusicFile music, int index,
			boolean isSelected, boolean cellHasFocus) {
		musicLb.setText(music.getName());
		musicLb.setFont(new Font("Arial", 3, 10));
		if (isSelected) {
			musicLb.setForeground(Color.BLACK);
			setBackground(list.getSelectionBackground());
		} else {

			setBackground(list.getBackground());
		}
		return this;
	}
}
