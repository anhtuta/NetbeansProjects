package display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controlMenu.BtnAdd;
import controlMenu.BtnPause;
import controlMenu.BtnRandom;
import controlMenu.BtnStart;
import controlMenu.FloorFinish;
import controlMenu.FloorStart;
import object.Building;
import object.Human;

public class PanelControl extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private FloorStart floorStart;
	private FloorFinish floorFinish;
	private BtnAdd btn1;
	private BtnStart btn2;
	private BtnPause btn3;
	private BtnRandom btn4;
	private JLabel back;
	private PanelBuilding panelBuilding;
	private JLabel add;
	private JLabel subtract;
	private int numberHuman = 1;
	private JTextField textNumberHuman;
	private AudioPlayer footSteps;
	private AudioPlayer openDoor;
	private AudioPlayer bell;
	private AudioPlayer closeDoor;
	private AudioPlayer moving;
	private Timer timerFootstep;
	private Timer timerOpenDoor;

	public PanelControl(PanelBuilding panelBuilding) {
		icon = new ImageIcon(this.getClass().getResource("/image/pane.jpg"));
		footSteps = new AudioPlayer("footsteps.wav");
		openDoor = new AudioPlayer("open.wav");
		bell = new AudioPlayer("bell.wav");
		closeDoor = new AudioPlayer("close.wav");
		moving = new AudioPlayer("moving.wav");
		createButton();
		this.panelBuilding = panelBuilding;
		addButton();

		timerFootstep.start();
		timerOpenDoor.start();
	}

	public void createButton() {
		floorStart = new FloorStart();
		floorFinish = new FloorFinish();

		back = new JLabel(new ImageIcon(this.getClass().getResource("/image/back1.png")));

		add = new JLabel(new ImageIcon(this.getClass().getResource("/image/+.png")));
		subtract = new JLabel(new ImageIcon(this.getClass().getResource("/image/-.png")));
		textNumberHuman = new JTextField("1");
		textNumberHuman.setEditable(false);

		add.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				numberHuman++;
				textNumberHuman.setText(numberHuman + "");
			}
		});

		subtract.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (numberHuman > 1) {
					numberHuman--;
					textNumberHuman.setText(numberHuman + "");
				}
			}
		});

		btn1 = new BtnAdd();
		btn1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				for (int i = 0; i < getNumberHuman(); i++) {
					Building building = panelBuilding.getBuilding();
					ArrayList<Human> listHuman = building.getListHuman();

					if (getFloorStart().getSelectedIndex() != getFloorFinish().getSelectedIndex()) {
						Human human = null;
						try {
							human = new Human(getFloorStart().getSelectedIndex() + 1,
									getFloorFinish().getSelectedIndex() + 1, building);
						} catch (IOException ex) {
							Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
						}
						listHuman.add(human);
					}

					building.setListHuman(listHuman);
					panelBuilding.setBuilding(building);
					setPanelBuilding(panelBuilding);
				}
			}
		});
		btn2 = new BtnStart();
		btn2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Building building = panelBuilding.getBuilding();
				building.setStopElevator(false);
				panelBuilding.setBuilding(building);
			}

		});
		btn3 = new BtnPause();
		btn3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				Building building = panelBuilding.getBuilding();
				building.setStopElevator(true);
				panelBuilding.setBuilding(building);
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("Da release");
			}

		});

		btn4 = new BtnRandom();
		btn4.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				for (int i = 0; i < getNumberHuman(); i++) {
					Building building = panelBuilding.getBuilding();
					ArrayList<Human> listHuman = building.getListHuman();
					Random random = new Random();
					int floorStartIndex = 1 + random.nextInt(5);
					int floorFinishIndex = 1 + random.nextInt(5);

					while (floorStartIndex == floorFinishIndex) {
						floorFinishIndex = 1 + random.nextInt(5);
					}

					getFloorStart().setSelectedIndex(floorStartIndex);
					getFloorFinish().setSelectedIndex(floorFinishIndex);

					Human human = null;
					try {
						human = new Human(getFloorStart().getSelectedIndex() + 1,
								getFloorFinish().getSelectedIndex() + 1, building);
					} catch (IOException ex) {
						Logger.getLogger(PanelControl.class.getName()).log(Level.SEVERE, null, ex);
					}
					listHuman.add(human);

					building.setListHuman(listHuman);
					panelBuilding.setBuilding(building);
					setPanelBuilding(panelBuilding);
				}
			}
		});
		timerFootstep = new Timer(1200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Building building = panelBuilding.getBuilding();
				ArrayList<Human> listHuman = building.getListHuman();

				for (int i = 0; i < listHuman.size(); i++) {
					if (listHuman.get(i).isInElevator() || listHuman.get(i).getCoordX() == 500) {
						footSteps.stop();
					} else {
						footSteps.play();
					}
				}
			}
		});

		timerOpenDoor = new Timer(300, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelBuilding.getBuilding().getElevator().isOpenning()) {
					bell.play();
					openDoor.play();
				}
				if (panelBuilding.getBuilding().getElevator().isClosing()
						&& panelBuilding.getBuilding().getElevator().isStop()
						&& !panelBuilding.getBuilding().getListHuman().isEmpty()) {
					closeDoor.play();
				}

				if (!panelBuilding.getBuilding().getListHuman().isEmpty()) {
					boolean isHas = false;
					for (int i = 0; i < panelBuilding.getBuilding().getListHuman().size(); i++) {
						if (panelBuilding.getBuilding().getListHuman().get(i).getCoordX() >= 500) {
							isHas = true;
							break;
						}
					}
					if (isHas && !panelBuilding.getBuilding().isStopElevator()) {
						moving.play();
					}
				}

			}
		});
	}

	public PanelBuilding getPanelBuilding() {
		return panelBuilding;
	}

	public void setPanelBuilding(PanelBuilding panelBuilding) {
		this.panelBuilding = panelBuilding;
	}

	public void addButton() {
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel(new ImageIcon(this.getClass().getResource("/image/startFloor.png"))));
		box4.add(floorStart);
		this.add(box4);

		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel(new ImageIcon(this.getClass().getResource("/image/endFloor.png"))));
		box5.add(floorFinish);
		this.add(box5);

		Box box1 = Box.createHorizontalBox();
		box1.add(btn4);

		box1.add(btn1);
		this.add(box1);

		Box box2 = Box.createHorizontalBox();
		box2.add(btn2);

		box2.add(btn3);
		this.add(box2);

		Box box3 = Box.createHorizontalBox();
		box3.add(back);
		box3.add(add);
		box3.add(textNumberHuman);
		box3.add(subtract);
		this.add(box3);

	}

	public FloorStart getFloorStart() {
		return floorStart;
	}

	public FloorFinish getFloorFinish() {
		return floorFinish;
	}

	public BtnAdd getBtn1() {
		return btn1;
	}

	public BtnStart getBtn2() {
		return btn2;
	}

	public BtnPause getBtn3() {
		return btn3;
	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public JLabel getBack() {
		return back;
	}

	public int getNumberHuman() {
		return numberHuman;
	}
}
