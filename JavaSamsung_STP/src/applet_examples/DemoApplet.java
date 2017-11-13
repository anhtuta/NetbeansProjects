/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author AnhTu
 */
public class DemoApplet extends Applet {

    public void paint(Graphics g) {
        setBackground(Color.yellow);
        g.setColor(Color.blue);
        Rectangle box = new Rectangle(50, 50, 80, 80);
        Graphics2D g2D = (Graphics2D) g;
        g2D.draw(box);
        
        // move the object 100 pixels to the right and 100 pixels down
        box.translate(100, 100);
        g2D.fill(box);
        
        for (int i = 0; i < 10; i++) {
            box.translate(i*20, 0);
            g2D.fill(box);
        }
    }
}
