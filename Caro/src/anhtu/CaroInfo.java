package anhtu;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CaroInfo extends JFrame {
	private String direction = File.separator + "nguyenvanquan7826"
			+ File.separator + "textInfo" + File.separator;
	private String[] fileName = { "caroHelp", "caroAbout" };
	private String[] title = { "Hướng dẫn", "Giới thiệu" };

	public CaroInfo() {
	}

	public CaroInfo(int type) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setTitle("Caro - " + title[type]);

		// add content
		add(createJTextArea(type));

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JTextArea createJTextArea(int type) {
		InputStream in = getClass().getResourceAsStream(
				direction + fileName[type]);
		System.out.println(direction + fileName[type]);
		JTextArea ta = new JTextArea();
		ta.setWrapStyleWord(true);
		ta.setLineWrap(true);
		ta.setEditable(false);
		ta.setBackground(null);
		try {
			ta.read(new InputStreamReader(in), null);
		} catch (IOException e) {
			System.out.println("Error read file");
		}
		return ta;
	}
}
