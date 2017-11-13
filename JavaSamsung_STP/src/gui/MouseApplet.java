/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author AnhTu
 */

//There is an inner class MousePressListener defined inside the constructor of MouseApplet.
//This is a common practice in GUI programming – to implement the listener as an inner class.

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* Let the user move a rectangle by clicking the mouse.*/
public class MouseApplet extends Applet {

    private Rectangle box;
    private static final int BOX_X = 100;
    private static final int BOX_Y = 100;
    private static final int BOX_WIDTH = 20;
    private static final int BOX_HEIGHT = 30;

    public MouseApplet() { //hoặc có thể thay = phương thức: public void init()
        // the rectangle that the paint method draws
        box = new Rectangle(BOX_X, BOX_Y,
                BOX_WIDTH, BOX_HEIGHT);
        // add mouse press listener         
        class MousePressListener extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                box.setLocation(x, y);
                repaint();
            }
        }
        
        MouseAdapter listener = new MousePressListener();
        addMouseListener(listener);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(box);
    }
}
