/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_handling;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.lang.String;

/**
 *
 * @author AnhTu
 */
public class MovingBall extends Applet implements ActionListener {

    private int xc;
    private int yc;
    private int size;
    private Timer timer;
    private int xDirection = 3;
    private int yDirection = 3;
    private int delay = 50;

    @Override
    public void init() {
        xc = 10;
        yc = 10;
        size = 20;
        setBackground(Color.blue);
        setForeground(Color.orange);
        timer = new Timer(String.valueOf(delay), true);
    }

    @Override
    public void start() {
        //timer.start();
    }

    @Override
    public void stop() {
        //timer.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(xc, yc, size, size);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        xc = xc + xDirection;
        yc = yc + yDirection;
        if (xc <= 0 || xc >= getWidth() - size) {
            xDirection = -xDirection;
        }
        if (yc <= 0 || yc >= getHeight() - size) {
            yDirection = -yDirection;
        }
        repaint();
    }
}
