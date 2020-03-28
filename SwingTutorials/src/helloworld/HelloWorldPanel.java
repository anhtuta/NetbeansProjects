/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class HelloWorldPanel extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Hello world", 75, 100);
    }
    
    @Override
    public Dimension getPreferredSize() { //override to return the preferfed size of this component
        return new Dimension(900, 200);   //thiết lập kích thước cho JPanel
    }
}
