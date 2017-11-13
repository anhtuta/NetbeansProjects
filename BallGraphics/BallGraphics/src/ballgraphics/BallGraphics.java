/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballgraphics;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author phamn
 */
class Ball {

    public double vY;

    public double vX;

    public double x, y;

    private int timeLoopAfterColY = 0;
    private int timeLoopAfterColX = 0;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        vY = 0;
        vX = 0;
    }

    public void setVY(double v) {
        this.vY = v;
    }

    public void setVX(double v) {
        this.vX = v;
    }

    public void paintBall(Graphics g) {
        g.drawRect((int) x - 5, (int) y - 5, 10, 10);
        g.drawOval((int) (x) - 30, (int) y - 30, 60, 60);
    }

    public void setPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void Update() {
//        if(timeLoopAfterColX != 0) System.out.println("timeLoopAfterColX = " + timeLoopAfterColX);
//        else System.out.println("\ttimeLoopAfterColX = " + timeLoopAfterColX);
//        if(timeLoopAfterColY != 0) System.out.println("timeLoopAfterColY = " + timeLoopAfterColY);
//        else System.out.println("\ttimeLoopAfterColY = " + timeLoopAfterColY);

        if (timeLoopAfterColY <= 0) {
            vY += BallGraphics.Gravity;
        }

        y += vY;

        if (timeLoopAfterColY <= 0) {
            if (y + 30 >= 600) {
                vY = -(vY) / 1.5;
                timeLoopAfterColY = 5;
            }
        } else {
            timeLoopAfterColY--;
        }

        if (timeLoopAfterColX <= 0 && vX > 0) {
            vX += BallGraphics.Fc;
        }

        x += vX;

        if (timeLoopAfterColX <= 0) {
            if (x + 30 >= 600 || x - 30 <= 0) {
                vX = -(vX) / 1.5;
                timeLoopAfterColX = 5;
            }
        } else {
            timeLoopAfterColX--;
        }

    }

}

public class BallGraphics extends JFrame implements Runnable, MouseMotionListener, MouseListener {
    double x1, x2, y1, y2;      //coordinates of mouse
    Thread thread;
    Ball ball;
    public static double Gravity = 0.2;
    public static double Fc = -0.02;

    public BallGraphics() {
        setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ball = new Ball(100, 100);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        thread = new Thread(this);
        thread.start();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.paintBall(g);
    }

    public static void main(String[] args) {
        new BallGraphics();
    }

    public void Update() {
        ball.Update();
        repaint();
    }

    @Override
    public void run() {
        while (true) {
            Update();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ball.setPoint(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        ball.setVX((x2 - x1) / 10);
        ball.setVY((y2 - y1) / 10);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }
}
