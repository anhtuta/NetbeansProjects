package nguyenvanquan7826;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 * ----------------- @author nguyenvanquan7826 -----------------
 * ---------------nguyenvanquan7826.wordpress.com --------------
 */
class MyLine implements Serializable {
	private static final long serialVersionUID = 1L;
	private Line2D.Double l = new Line2D.Double();
	private int indexPointA, indexPointB;
	private int cost;

	final int barb = 10;
	final int r = 15;
	final double phi = Math.PI / 6;

	public MyLine(Line2D.Double l, int indexPointA, int indexPointB, int cost) {
		this.cost = cost;
		this.indexPointA = indexPointA;
		this.indexPointB = indexPointB;
		this.l = l;
	}

	private void drawArrow(Graphics2D g, double theta, double x0, double y0,
			Color colorLine, int size) {
		double x = x0 - barb * Math.cos(theta + phi);
		double y = y0 - barb * Math.sin(theta + phi);
		g.setStroke(new BasicStroke(size));
		g.draw(new Line2D.Double(x0, y0, x, y));
		x = x0 - barb * Math.cos(theta - phi);
		y = y0 - barb * Math.sin(theta - phi);
		g.draw(new Line2D.Double(x0, y0, x, y));
	}

	public void drawLine(Graphics2D g, Point p1, Point p2, Color colorCost,
			Color colorLine, int size, boolean type) {
		String c = "";
		if (cost < 0) {
			c = "";
		} else
			c = String.valueOf(cost);
		g.setColor(colorLine);
		g.setStroke(new BasicStroke(size));
		double theta = Math.atan2(p2.y - p1.y, p2.x - p1.x);
		g.draw(l);
		if (type && cost >= 0) {
			double x = p2.x - r * Math.cos(theta);
			double y = p2.y - r * Math.sin(theta);
			drawArrow(g, theta, x, y, colorLine, size);
		}

		g.setColor(colorCost);
		g.drawString(c, (int) (Math.abs(p1.x + p2.x) / 2),
				(int) (p1.y + p2.y) / 2);
	}

	public boolean containerPoint(Point p) {
		Polygon poly = createPolygon(l);
		for (int i = 0; i < poly.npoints; i++) {
			double temp = (p.x - poly.xpoints[i])
					* (poly.ypoints[(i + 1) % poly.npoints] - poly.ypoints[i])
					- (p.y - poly.ypoints[i])
					* (poly.xpoints[(i + 1) % poly.npoints] - poly.xpoints[i]);
			if (temp < 0)
				return false;
		}
		return true;
	}

	private Polygon createPolygon(Line2D line) {
		int barb = 5;
		double phi = Math.PI / 2;
		double theta = Math.atan2(line.getY2() - line.getY1(), line.getX2()
				- line.getX1());
		int x[] = new int[4];
		int y[] = new int[4];
		x[0] = (int) (line.getX1() - barb * Math.cos(theta + phi));
		y[0] = (int) (line.getY1() - barb * Math.sin(theta + phi));
		x[1] = (int) (line.getX1() - barb * Math.cos(theta - phi));
		y[1] = (int) (line.getY1() - barb * Math.sin(theta - phi));

		x[2] = (int) (line.getX2() - barb * Math.cos(theta - phi));
		y[2] = (int) (line.getY2() - barb * Math.sin(theta - phi));
		x[3] = (int) (line.getX2() - barb * Math.cos(theta + phi));
		y[3] = (int) (line.getY2() - barb * Math.sin(theta + phi));
		Polygon poly = new Polygon(x, y, 4);
		return poly;
	}

	public Line2D.Double getL() {
		return l;
	}

	public void setL(Line2D.Double l) {
		this.l = l;
	}

	public int getIndexPointA() {
		return indexPointA;
	}

	public void setIndexPointA(int indexPointA) {
		this.indexPointA = indexPointA;
	}

	public int getIndexPointB() {
		return indexPointB;
	}

	public void setIndexPointB(int indexPointB) {
		this.indexPointB = indexPointB;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}