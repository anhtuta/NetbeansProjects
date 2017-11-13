package object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import animation.SpriteHorizontal;

public class Building {
	private Elevator elevator;
	private ArrayList<Human> listHuman;
	private int height;
	private int width;
	private int numberFloors;
	private SpriteHorizontal spriteBuilding;
	private SpriteHorizontal spriteFloor;
	private ArrayList<SpriteHorizontal> listSpriteLamp;
	private boolean stopElevator;

	public boolean isStopElevator() {
		return stopElevator;
	}

	public void setStopElevator(boolean stopElevator) {
		this.stopElevator = stopElevator;
	}

	public Building() throws IOException {
		spriteBuilding = new SpriteHorizontal("building.png", 1, 5000);
		elevator = new Elevator(this);
		stopElevator = false;
		listHuman = new ArrayList<Human>();
		height = 660;
		width = 600;
		numberFloors = 6;

		spriteFloor = new SpriteHorizontal("phanchiatang.png", 1, 5000);
		listSpriteLamp = new ArrayList<>();
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
		listSpriteLamp.add(new SpriteHorizontal("lamp.png", 2, 5000));
	}

	private boolean turnOnLamp(int floor) {
		boolean turnOnLamp = false;
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).getCoordY() == listHuman.get(i).getCoordYStart()
					&& listHuman.get(i).getFloorStart() == floor) {
				turnOnLamp = true;
				return turnOnLamp;
			}
			if (listHuman.get(i).getCoordY() == listHuman.get(i).getCoorYFinish()
					&& listHuman.get(i).getFloorFinish() == floor) {
				turnOnLamp = true;
				return turnOnLamp;
			}
		}
		return turnOnLamp;

	}

	public Elevator getElevator() {
		return elevator;
	}

	public ArrayList<Human> getListHuman() {
		return listHuman;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public void setListHuman(ArrayList<Human> listHuman) {
		this.listHuman = listHuman;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getNumberFloors() {
		return numberFloors;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spriteBuilding.getListFrame().get(spriteBuilding.getCurrentFrame()).getImageFrame(), 0, 0, null);
		if (!stopElevator) {
			elevator.setCoord();
		}

		elevator.draw(g);
		for (int i = 0; i < listHuman.size(); i++) {
			listHuman.get(i).setHasNextHuman();
			if (!listHuman.get(i).isHasNextHuman()) {
				listHuman.get(i).setCoord();
			}
			listHuman.get(i).draw(g);
			if (!listHuman.get(i).isShow()) {
				listHuman.remove(i);
			}
		}
		for (int i = 0; i < 6; i++) {
			if (turnOnLamp(i + 1)) {
				listSpriteLamp.get(i).setCurrentFrame(1);
			} else {
				listSpriteLamp.get(i).setCurrentFrame(0);
			}
			g2d.drawImage(
					listSpriteLamp.get(i).getListFrame().get(listSpriteLamp.get(i).getCurrentFrame()).getImageFrame(),
					0, 560 - i * 110 - 4, null);
		}
		elevator.drawDoor(g);
		g2d.drawImage(spriteFloor.getListFrame().get(spriteFloor.getCurrentFrame()).getImageFrame(), 0, 0, null);

	}

}
