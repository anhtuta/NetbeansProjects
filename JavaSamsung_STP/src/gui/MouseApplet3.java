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
//chú ý: chương trình này dùng mouseClicked(MouseEvent me), nên nó chậm hơn so với dùng mousePressed(MouseEvent me)
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* Let the user move a rectangle by clicking the mouse.*/
public class MouseApplet3 extends Applet implements MouseListener {

    private Rectangle box;
    private static final int BOX_X = 100;
    private static final int BOX_Y = 100;
    private static final int BOX_WIDTH = 20;
    private static final int BOX_HEIGHT = 30;

    @Override
    public void init() {
        box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        //vẽ box (tại tọa độ x,y, tọa độ này thiết lập trong phần mouselistener
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(box);
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        box.setLocation(x, y);
        repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {}
    @Override
    public void mouseReleased(MouseEvent me) {}
    @Override
    public void mouseEntered(MouseEvent me) {}
    @Override
    public void mouseExited(MouseEvent me) {}
    
    
}
