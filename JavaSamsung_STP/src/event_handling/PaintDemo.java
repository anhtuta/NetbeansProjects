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
import java.awt.event.MouseMotionListener;

/**
 *
 * @author AnhTu
 */
public class PaintDemo extends Applet implements MouseListener, MouseMotionListener {
    private int x1,y1,x2,y2;
    
    @Override
    public void init() {
        setSize(300, 300);
        setBackground(Color.yellow);
        setForeground(Color.blue);
        
        addMouseListener(this);
        addMouseMotionListener(this); //CHÚ Ý CÁI NÀY KHÁC JAVA SWING NHA!
    }
    
    //chú ý: class này vẽ ko dùng hàm paint() của Applet, chỉ đơn giản như vẽ trên 1 frame
    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.red);
//        g.drawLine(x1, y1, x2, y2);
//        x1 = x2; y1 = y2;
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        x2 = me.getX();
        y2 = me.getY();
        Graphics g = null;
        g = this.getGraphics();
        g.drawLine(x1, y1, x2, y2);
        x1 = x2; y1 = y2;
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        x1 = me.getX();
        y1 = me.getY();
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
