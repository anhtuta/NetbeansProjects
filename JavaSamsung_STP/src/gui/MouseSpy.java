/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.applet.Applet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author AnhTu
 */
public class MouseSpy implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("mouse clicked at (x, y) = ("+me.getX()+", "+me.getY()+")");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("mouse pressed at (x, y) = ("+me.getX()+", "+me.getY()+")");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}

class MouseSpyApplet extends Applet {
        public MouseSpyApplet() {
            MouseSpy ms = new MouseSpy();
            addMouseListener(ms);
        }
        
        public static void main(String[] args) {
        new MouseSpyApplet();
    }
}
