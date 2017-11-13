/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_handling;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author AnhTu
 */
public class MovingDot extends Applet implements MouseListener {

    private int x, y; // the dot's coordinates

    public void init() {
        setSize(300, 300);
        setBackground(Color.yellow);
        setForeground(Color.red);
        x = 150;
        y = 150;
        addMouseListener(this); // register itself as the mouse listener
    }

    public void paint(Graphics g) {
        //display the dot
        g.fillOval(x-5, y-5, 10, 10);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        x = me.getX();
        y = me.getY();
        
        repaint();
    }

    ///bọn ở dưới chả làm gì
    
    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("enter the applet");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}