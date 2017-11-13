package nguyenvanquan7826;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

public class CaroGraphics extends JPanel {
	private static final long serialVersionUID = 1L;
	public final static int sizeCell = 30;
	public final static int row = 18;
	public final static int col = 18;
	public final static int width = sizeCell * col + 1;
	public final static int height = sizeCell * row + 1;

	private int sizeImg = sizeCell - 2;
	public boolean player, playerRoot;
	private Process process;

	private MyImage myImage = new MyImage();
	private Icon iconActive;
	private UndoManager undoManager = new UndoManager();
	protected Vector<Point> pointVector;

	private int winer = 0;

	public int getWiner() {
		return winer;
	}

	public void setWiner(int winer) {
		this.winer = winer;
	}

	public CaroGraphics() {
		makeIcon();
		setPreferredSize(new Dimension(width, height));
		init();
	}

	public void init() {
		winer = 0;
		process = new Process();
		player = playerRoot;
		pointVector = new Vector<Point>();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(238, 238, 238));
		for (int i = 0; i <= row; i++) {
			g.drawLine(i * sizeCell, 0, i * sizeCell, height - 1);
			g.drawLine(0, i * sizeCell, width - 1, i * sizeCell);
		}
		drawImg(g);
		System.out.println("a");
	}

	private void drawImg(Graphics g) {
		boolean player = playerRoot;
		for (int i = 0; i < pointVector.size(); i++) {
			Image image = player ? myImage.imgCross : myImage.imgNought;
			Point point = convertPointToCaro(convertPoint(pointVector.get(i)));
			g.drawImage(image, point.x, point.y, null);
			player = !player;
		}
	}

	private Point convertPoint(Point point) {
		int x, y;
		int deviation = 1;
		x = (point.x % sizeCell > deviation) ? (point.x / sizeCell * sizeCell + sizeCell / 2)
				: (point.x / sizeCell * sizeCell - sizeCell / 2);
		y = (point.y % sizeCell > deviation) ? (point.y / sizeCell * sizeCell + sizeCell / 2)
				: (point.y / sizeCell * sizeCell - sizeCell / 2);
		return new Point(x, y);
	}

	private Point convertPointToMaxtrix(Point point) {
		return new Point(point.y / sizeCell, point.x / sizeCell);
	}

	private Point convertPointToCaro(Point point) {
		return new Point(point.x - sizeImg / 2, point.y - sizeImg / 2);
	}

	public void setStatus() {
		CaroFrame.lbStatusO.setIcon(iconActive);
		CaroFrame.lbStatusX.setIcon(iconActive);
		if (player) {
			CaroFrame.lbStatusX.setEnabled(true);
			CaroFrame.lbStatusO.setEnabled(false);
		} else {
			CaroFrame.lbStatusX.setEnabled(false);
			CaroFrame.lbStatusO.setEnabled(true);
		}
	}

	private void makeIcon() {
		iconActive = new ImageIcon(myImage.reSizeImage(
				myImage.getMyImageIcon("active.png"), 20, 20));
	}

	void actionClick(Point point) {
		// repaint();

		Point pointTemp = convertPoint(point);
		if (process.updateMatrix(player, convertPointToMaxtrix(pointTemp))) {
			pointVector.addElement(point);
			undoManager.undoableEditHappened(new UndoableEditEvent(this,
					new UndoablePaintSquare(point, pointVector)));

			repaint();
			// drawImg(player, convertPointToCaro(point));
			player = !player;
			setStatus();
			if (process.getWin() > 0) {
				winer = process.getWin();
			}
		}
	}

	public void undo() {
		player = !player;
		Point point = pointVector.get(pointVector.size() - 1);
		point = convertPointToMaxtrix(convertPoint(point));
		process.undoMatrix(point);
		undoManager.undo();
		setStatus();
		repaint();
	}

	public boolean canUndo() {
		return undoManager.canUndo();
	}
}
