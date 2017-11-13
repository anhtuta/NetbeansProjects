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
public class DrawPolyLine extends Applet implements MouseListener {

    private int [] xCoords;
    private int [] yCoords;
    private int numPoints;
    
    @Override
    public void init() {
        setSize(300, 300);
        xCoords = new int[1000];
        yCoords = new int[1000];
        numPoints = 0;
        setBackground(Color.orange);
        setForeground(Color.blue);
        
        addMouseListener(this); //CHÚ Ý CÁI NÀY KHÁC JAVA SWING NHA!
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawPolyline(xCoords, yCoords, numPoints);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        xCoords[numPoints] = me.getX();
        yCoords[numPoints] = me.getY();
        numPoints++;
        
        repaint();
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
