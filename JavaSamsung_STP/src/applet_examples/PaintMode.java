/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */
public class PaintMode extends Applet {
    
    @Override
    public void init() {
        setSize (300, 300);
    }
    
    @Override
    public void paint (Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(50, 50, 40, 30);
        g.setColor(Color.pink);
        g.fillOval(70, 65, 30, 60);
        g.setColor(Color.cyan);
        g.fillRoundRect(90, 80, 70, 50, 20, 30);
        
        g.setColor(Color.blue);
        g.fillRect(50, 150, 40, 30);
        g.setXORMode(Color.green);
        g.fillOval(70, 165, 30, 60);
        g.setXORMode(Color.black);
        g.fillRoundRect(90, 180, 60, 40, 50, 20);
    }
}
