package nguyenvanquan7826;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PlayerName extends JDialog implements ActionListener {
	private String playerName1 = "Người chơi 1", playerName2 = "Người chơi 2";
	private JTextField tfPlayer1, tfPlayer2;
	private JRadioButton radPlayer1, radPlayer2;
	private int start = 1;
	private CaroFrame caroFrame;

	public CaroFrame getCaroFrame() {
		return caroFrame;
	}

	public void setCaroFrame(CaroFrame caroFrame) {
		this.caroFrame = caroFrame;
	}

	public String getPlayerName1() {
		return playerName1;
	}

	public void setPlayerName1(String playerName1) {
		this.playerName1 = playerName1;
	}

	public String getPlayerName2() {
		return playerName2;
	}

	public void setPlayerName2(String playerName2) {
		this.playerName2 = playerName2;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public PlayerName(CaroFrame caroFrame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);

		this.caroFrame = caroFrame;
		init();
		add(createPanel());

		pack();
		setLocationRelativeTo(null);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(titlePanel(), BorderLayout.PAGE_START);
		panel.add(mainPanel(), BorderLayout.CENTER);
		panel.add(buttonPanel(), BorderLayout.PAGE_END);
		return panel;
	}

	private JPanel titlePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Chọn người chơi"));
		return panel;
	}

	private JPanel mainPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1, 2, 2));
		panel.add(playerPanel(true));
		panel.add(playerPanel(false));
		return panel;
	}

	private JPanel buttonPanel() {
		JPanel panel = new JPanel();
		panel.add(createJButton("Xong"));
		return panel;
	}

	private JPanel playerPanel(boolean player) {
		JTextField tf;
		JLabel lb;
		JRadioButton rad;
		if (player) {
			tf = tfPlayer1;
			lb = new JLabel("Nguời chơi 1: ");
			rad = radPlayer1;
		} else {
			tf = tfPlayer2;
			lb = new JLabel("Nguời chơi 2: ");
			rad = radPlayer2;
		}

		JPanel panel = new JPanel();

		panel.add(lb);
		panel.add(tf);
		panel.add(rad);

		return panel;
	}

	private void init() {
		tfPlayer1 = createJTextField(true);
		tfPlayer2 = createJTextField(false);
		createpalyerStart();
	}

	private JTextField createJTextField(boolean player) {
		String playerName = player ? playerName1 : playerName2;
		JTextField tf = new JTextField(15);
		tf.setText(playerName);
		return tf;
	}

	private JButton createJButton(String btnName) {
		JButton btn = new JButton(btnName);
		btn.addActionListener(this);
		return btn;
	}

	private void createpalyerStart() {
		ButtonGroup btnG = new ButtonGroup();
		radPlayer1 = new JRadioButton();
		radPlayer1.setSelected(true);
		radPlayer1.addActionListener(this);

		radPlayer2 = new JRadioButton();
		radPlayer2.addActionListener(this);

		btnG.add(radPlayer1);
		btnG.add(radPlayer2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == radPlayer1) {
			start = 1;
		}
		if (e.getSource() == radPlayer2) {
			start = 2;
		}
		if (e.getActionCommand() == "Xong") {
			if (checkEmpty(tfPlayer1)) {
				return;
			}
			if (checkEmpty(tfPlayer2)) {
				return;
			}
			playerName1 = tfPlayer1.getText();
			playerName2 = tfPlayer2.getText();
			caroFrame.updateStatus();
			System.out.println(playerName1 + ", " + playerName2 + ", " + start);
			setVisible(false);
		}
	}

	private boolean checkEmpty(JTextField tf) {
		if (tf.getText().trim().equals("")) {
			tf.requestFocus();
			return true;
		}
		return false;
	}
}
