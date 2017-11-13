/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class Ball extends Thread {
    private JPanel box;
    static final int XSIZE = 10;
    static final int YSIZE = 10;
    int x = 0; int y = 0; //coords of the ball
    int dx=2; int dy=2;
    Color color;
    
    public Ball(JPanel b, Color c) {
        box = b;
        color = c;
    }
    
    public void draw() {
        Graphics g = box.getGraphics();
        g.setColor(color);
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose();
    }
    
    public void move() {
        if(!box.isVisible()) return;
        Graphics g = box.getGraphics();
        g.setXORMode(box.getBackground());
        g.setColor(color);
        g.fillOval(x, y, XSIZE, YSIZE);
        x += dx; y += dy;
        
        Dimension d = box.getSize();
        
        if(x<0) {
            x=0; dx = -dx;
        }
        if(y<0) {
            y=0; dy = -dy;
        }
        if(x+XSIZE >= d.width) {
            x = d.width - XSIZE; dx=-dx;
        }
        if(y+YSIZE >= d.height) {
            y = d.height - YSIZE; dy=-dy;
        }
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose();
        
    }
    
    @Override
    public void run() {
        int i;
        for(i=1; i<=1000; i++) {
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
