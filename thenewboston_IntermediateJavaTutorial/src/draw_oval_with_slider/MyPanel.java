/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw_oval_with_slider;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class MyPanel extends JPanel {
    private int d = 10;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(10, 10, d, d);
    }
    
    public void setD(int newd) {
        d = (newd >= 0 ? newd : 10);
        repaint(); //call the paintComponent from the same class, so we don't have to call the method paintComponent over and over again
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
    
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
