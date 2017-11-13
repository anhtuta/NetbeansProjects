package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import object.Human;

public class PanelInfomation extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private Timer timer;
	public PanelBuilding panelBuilding;
	private ImageIcon icon;

	public PanelInfomation(PanelBuilding panelBuilding) {
		icon = new ImageIcon(this.getClass().getResource("/image/information.png"));
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(44));
		box.add(Box.createHorizontalStrut(250));
		this.panelBuilding = panelBuilding;
		textArea = new JTextArea(12, 28);
		textArea.setFont(new Font("JSL Ancient", Font.BOLD, 14));
		textArea.setForeground(Color.red);
		textArea.setBackground(new Color(23, 23, 20));
		textArea.setEditable(false);
		box.add(textArea);
		this.add(box);
		timer = new Timer(5, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextArea();
			}
		});
		timer.start();
	}

	public String setNumberHumanText() {
		ArrayList<Human> listHuman = panelBuilding.getBuilding().getListHuman();

		int count = 0;
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				count++;
			}
		}

		return "\nThe elevator have " + count + " people";
	}

	public String setTextAddOutPeople() {
		StringBuilder text = new StringBuilder();
		ArrayList<Human> listHuman = panelBuilding.getBuilding().getListHuman();
		ArrayList<Human> listHumanOut = new ArrayList<>();
		ArrayList<Human> listHumanIn = new ArrayList<>();
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				listHumanIn.add(listHuman.get(i));
			}
		}
		if (listHumanIn.size() != 0) {
			text.append("Add a person go to ");
			for (int i = 0; i < listHumanIn.size(); i++) {
				if (i == listHumanIn.size() - 1) {
					text.append(listHumanIn.get(i).getFloorFinish() + " ");
				} else {
					text.append(listHumanIn.get(i).getFloorFinish() + ", ");
				}
			}
			text.append(" floor \n");
		}

		for (int i = 0; i < listHuman.size(); i++) {
			if (!listHuman.get(i).isInElevator() && listHuman.get(i).getCoordY() == listHuman.get(i).getCoorYFinish()) {
				listHumanOut.add(listHuman.get(i));
			}
		}

		if (listHumanOut.size() != 0) {
			text.append("A person from ");
			for (int i = 0; i < listHumanOut.size(); i++) {
				if (i == listHumanOut.size() - 1) {
					text.append(listHumanOut.get(i).getFloorStart() + " ");
				} else {
					text.append(listHumanOut.get(i).getFloorStart() + ", ");
				}
			}
			text.append(" floor out \n");
		}

		return text.toString();
	}

	public String setNumberFloorText() {
		return "\nThe elevator is in " + panelBuilding.getBuilding().getElevator().getFloor() + " floor";
	}

	public void setTextArea() {
		StringBuilder text = new StringBuilder();
		text.append(setTextAddOutPeople() + " " + setNumberHumanText() + " " + setNumberFloorText());
		textArea.setText(text.toString());
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public PanelBuilding getPanelBuilding() {
		return panelBuilding;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void setPanelBuilding(PanelBuilding panelBuilding) {
		this.panelBuilding = panelBuilding;
	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}