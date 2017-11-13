package object;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import animation.SpriteHorizontal;
import animation.SpriteVertical;

public class Elevator {
	private int coordX;
	private int coordY;
	private boolean stop;
	private boolean isOpenning;
	private boolean isClosing;
	private boolean isMovingUp;
	private boolean isMovingDown;
	private int floor;
	private Human nextHumanGoIn;
	private Building building;
	private SpriteHorizontal elevatorSprite;
	private SpriteVertical elevatorOpenSprite;
	private SpriteVertical elevatorCloseSprite;
	private SpriteVertical elevatorDoor;

	public Elevator(Building building) throws IOException {
		coordX = 490;
		coordY = 660;
		this.building = building;
		this.floor = 0;
		this.isMovingDown = true;
		this.isMovingUp = true;
		this.stop = true;
		this.isClosing = true;
		this.isOpenning = false;
		elevatorSprite = new SpriteHorizontal("elevator.png", 1, 5000);
		elevatorOpenSprite = new SpriteVertical("elevatoropne.png", 5, 200);
		elevatorCloseSprite = new SpriteVertical("elevatorclose.png", 5, 200);
		elevatorDoor = elevatorOpenSprite;
	}

	public void setCoord() {
		ArrayList<Human> listHuman = building.getListHuman();
		Human randomHumanInElevator = null;
		int humanInElevator = numberHumanIn();
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				randomHumanInElevator = listHuman.get(i);
			}
		}
		int humanOutElevator = 0;
		for (int i = 0; i < listHuman.size(); i++) {
			if (!listHuman.get(i).isInElevator() && listHuman.get(i).getCoordX() >= 500) {
				humanOutElevator++;
			}
		}

		this.setFloor(
				(int) ((building.getHeight() - coordY) / (building.getHeight() / building.getNumberFloors())) + 1);
		this.stop = false;
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				if (listHuman.get(i).getCoorYFinish() == coordY) {
					this.stop = true;
				}
			}
			if (!listHuman.get(i).isInElevator()) {
				if (listHuman.get(i).getCoordYStart() == coordY && listHuman.get(i).getCoordX() >= 500
						&& ((listHuman.get(i).getCoorYFinish() < coordY && this.isMovingUp == true)
								|| (listHuman.get(i).getCoorYFinish() > coordY && this.isMovingDown == true))) {
					if (humanInElevator > 0) {
						if (!isFull()) {
							this.stop = true;
						}
					} else {
						if (nextHumanGoIn == null || nextHumanGoIn == listHuman.get(i)) {
							this.stop = true;
						}
					}
				}
			}
		}

		if (this.stop == false) {
			if (humanInElevator > 0) {
				if (randomHumanInElevator.getCoorYFinish() < coordY) {
					moveUp();
					this.isMovingUp = true;
					this.isMovingDown = false;
				}
				if (randomHumanInElevator.getCoorYFinish() > coordY) {
					moveDown();
					this.isMovingUp = false;
					this.isMovingDown = true;
				}
			} else if (humanOutElevator > 0) {

				if (nextHumanGoIn == null) {
					nextHumanGoIn = humanMakeMinDistance();
				}
				if (nextHumanGoIn != null) {
					Human humanMakeMinDistance = humanMakeMinDistance();
					if (coordY >= humanMakeMinDistance.getCoordYStart() && this.isMovingUp
							&& (humanMakeMinDistance.getFloorStart() > humanMakeMinDistance.getFloorFinish())) {
						nextHumanGoIn = humanMakeMinDistance;
					}
					if (coordY <= humanMakeMinDistance.getCoordYStart() && this.isMovingDown
							&& (humanMakeMinDistance.getFloorStart() < humanMakeMinDistance.getFloorFinish())) {
						nextHumanGoIn = humanMakeMinDistance;
					}

				}

				if (nextHumanGoIn.getCoordYStart() < coordY) {
					moveUp();
					this.isMovingUp = true;
					this.isMovingDown = false;
				}
				if (nextHumanGoIn.getCoordYStart() > coordY) {
					moveDown();
					this.isMovingUp = false;
					this.isMovingDown = true;
				}
				if (nextHumanGoIn.getCoordYStart() == coordY) {
					this.stop = true;
					if (nextHumanGoIn.getFloorFinish() > nextHumanGoIn.getFloorStart()) {
						this.isMovingUp = true;
						this.isMovingDown = false;
					}
					if (nextHumanGoIn.getFloorFinish() < nextHumanGoIn.getFloorStart()) {
						this.isMovingUp = false;
						this.isMovingDown = true;
					}
					nextHumanGoIn = null;

				}

			}
		}
	}

	public int numberHumanIn() {
		ArrayList<Human> listHuman = building.getListHuman();
		int count = 0;
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				count++;
			}
		}
		return count;
	}

	public boolean isFull() {
		boolean full = false;
		int count = 0;
		ArrayList<Human> listHuman = building.getListHuman();
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).isInElevator()) {
				count++;
			}
		}
		if (count == 8) {
			full = true;
		}
		return full;
	}

	public boolean isOpenning() {
		return isOpenning;
	}

	public void setOpenning(boolean isOpenning) {
		this.isOpenning = isOpenning;
	}

	public boolean isClosing() {
		return isClosing;
	}

	public void setClosing(boolean isClosing) {
		this.isClosing = isClosing;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public void moveUp() {
		if (isClosing) {
			coordY--;
		}
	}

	public void moveDown() {
		if (isClosing) {
			coordY++;
		}
	}

	public boolean isStop() {
		return stop;
	}

	public boolean isMovingUp() {
		return isMovingUp;
	}

	public boolean isMovingDown() {
		return isMovingDown;
	}

	public int getCoordY() {
		return coordY;
	}

	private Human humanMakeMinDistance() {
		Human humanMakeMinDistance = null;
		int distanceForUp;
		int distanceForDown;
		int minFloorStartGoUp = 0;
		int maxFloorFinishGoUp = 0;
		int maxFloorStartGoDown = 0;
		int minFloorFinishGoDown = 0;
		Human nextHumanGoUp = null;
		Human nextHumanGoDown = null;

		Building building = this.building;
		ArrayList<Human> listHuman = building.getListHuman();
		ArrayList<Human> listHumanGoUp = new ArrayList<>();
		ArrayList<Human> listHumanGoDown = new ArrayList<>();
		for (int i = 0; i < listHuman.size(); i++) {
			if (listHuman.get(i).getFloorStart() < listHuman.get(i).getFloorFinish()
					&& listHuman.get(i).getCoordYStart() == listHuman.get(i).getCoordY()
					&& listHuman.get(i).getCoordX() == 500) {
				listHumanGoUp.add(listHuman.get(i));
			} else if (listHuman.get(i).getFloorStart() > listHuman.get(i).getFloorFinish()
					&& listHuman.get(i).getCoordYStart() == listHuman.get(i).getCoordY()
					&& listHuman.get(i).getCoordX() == 500) {
				listHumanGoDown.add(listHuman.get(i));
			}
		}
		if (listHumanGoUp.size() > 0) {
			minFloorStartGoUp = listHumanGoUp.get(0).getFloorStart();
			maxFloorFinishGoUp = listHumanGoUp.get(0).getFloorFinish();
			nextHumanGoUp = listHumanGoUp.get(0);
			for (int i = 0; i < listHumanGoUp.size(); i++) {
				if (listHumanGoUp.get(i).getFloorStart() < minFloorStartGoUp) {
					minFloorStartGoUp = listHumanGoUp.get(i).getFloorStart();
					nextHumanGoUp = listHumanGoUp.get(i);
				}
				if (listHumanGoUp.get(i).getFloorFinish() > maxFloorFinishGoUp) {
					maxFloorFinishGoUp = listHumanGoUp.get(i).getFloorFinish();
				}
			}

		}
		if (listHumanGoDown.size() > 0) {
			maxFloorStartGoDown = listHumanGoDown.get(0).getFloorStart();
			minFloorFinishGoDown = listHumanGoDown.get(0).getFloorFinish();
			nextHumanGoDown = listHumanGoDown.get(0);
			for (int i = 0; i < listHumanGoDown.size(); i++) {
				if (listHumanGoDown.get(i).getFloorStart() > maxFloorStartGoDown) {
					maxFloorStartGoDown = listHumanGoDown.get(i).getFloorStart();
					nextHumanGoDown = listHumanGoDown.get(i);
				}
				if (listHumanGoDown.get(i).getFloorFinish() < minFloorFinishGoDown) {
					minFloorFinishGoDown = listHumanGoDown.get(i).getFloorFinish();
				}
			}
		}
		if (listHumanGoUp.size() > 0 && listHumanGoDown.size() == 0) {
			humanMakeMinDistance = nextHumanGoUp;
		}
		if (listHumanGoDown.size() > 0 && listHumanGoUp.size() == 0) {
			humanMakeMinDistance = nextHumanGoDown;
		}
		if (listHumanGoDown.size() > 0 && listHumanGoUp.size() > 0) {

			distanceForUp = Math.abs(floor - minFloorStartGoUp) + (maxFloorFinishGoUp - minFloorStartGoUp)
					+ Math.abs(maxFloorFinishGoUp - maxFloorStartGoDown) + (maxFloorStartGoDown - minFloorFinishGoDown);
			distanceForDown = Math.abs(floor - maxFloorStartGoDown) + (maxFloorStartGoDown - minFloorFinishGoDown)
					+ Math.abs(minFloorFinishGoDown - minFloorStartGoUp) + (maxFloorFinishGoUp - minFloorStartGoUp);
			if (distanceForDown < distanceForUp) {
				humanMakeMinDistance = nextHumanGoDown;
			} else if (distanceForDown > distanceForUp) {
				humanMakeMinDistance = nextHumanGoUp;
			} else if (distanceForDown == distanceForUp) {
				if (Math.abs(maxFloorStartGoDown - floor) > Math.abs(minFloorStartGoUp - floor)) {
					humanMakeMinDistance = nextHumanGoUp;
				} else {
					humanMakeMinDistance = nextHumanGoDown;
				}
			}
		}

		return humanMakeMinDistance;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(elevatorSprite.getListFrame().get(elevatorSprite.getCurrentFrame()).getImageFrame(), coordX,
				coordY - elevatorSprite.getHeight(), null);
	}

	public void drawDoor(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (stop == true && isClosing) {
			elevatorDoor = elevatorOpenSprite;
			if (elevatorDoor.getCurrentFrame() != (elevatorDoor.getSize() - 1)) {
				elevatorDoor.nextFrame();
			}
			if (elevatorDoor.getCurrentFrame() == (elevatorDoor.getSize() - 1)) {
				isClosing = false;
				elevatorCloseSprite.setCurrentFrame(0);
				isOpenning = true;
			}
		}
		if (stop == false && isOpenning) {
			elevatorDoor = elevatorCloseSprite;
			if (elevatorDoor.getCurrentFrame() != (elevatorDoor.getSize() - 1)) {
				elevatorDoor.nextFrame();
			}
			if (elevatorDoor.getCurrentFrame() == (elevatorDoor.getSize() - 1)) {
				isOpenning = false;
				elevatorOpenSprite.setCurrentFrame(0);
				isClosing = true;
			}
		}
		g2d.drawImage(elevatorDoor.getListFrame().get(elevatorDoor.getCurrentFrame()).getImageFrame(), coordX,
				coordY - elevatorDoor.getHeight(), null);
	}
}
