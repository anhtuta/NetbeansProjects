/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author AnhTu
 */
public class MagicWand extends Applet {

    private Polygon star;
    private Polygon stick;

    @Override
    public void init() {
        int xc = 200; // xc, yc define the centre of the star
        int yc = 100; // and the top of the stick
        int radius = 80; // radius of the star
        int width = 10; // width of the stick
        int length = 400; // length of the stick
// xs and ys below represent the coordinates of the 10 vertices
// of the stars whose centre is at (0, 0) and of radius 100
        int[] xs = {0, 20, 95, 35, 60, 0, -60, -35, -95, -20};
        int[] ys = {-100, -30, -30, 11, 80, 35, 80, 11, -30, -30};

// create the star of radius radius with centre at xc, yc
        for (int i = 0; i <= 9; i++) {
            xs[i] = xc + (int) (xs[i] * radius / 100.0);
            ys[i] = yc + (int) (ys[i] * radius / 100.0);
        }
        star = new Polygon(xs, ys, 10);
// create the stick (use the second method)
        stick = new Polygon();
        stick.addPoint(xc - width / 2, yc);
        stick.addPoint(xc + width / 2, yc);
        stick.addPoint(xc + width / 2, yc + length);
        stick.addPoint(xc - width / 2, yc + length);
        setBackground(Color.blue);
    } // init

    @Override
    public void paint(Graphics g) {
// display the stick
        g.setColor(Color.cyan);
        g.fillPolygon(stick);
// display the star
        g.setColor(Color.yellow);
        g.fillPolygon(star);
    }
}
