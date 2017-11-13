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
public class Example3 extends Applet {

    @Override
    public void paint(Graphics g) { //The web browser or applet viewer calls the paint method
//        The paint method takes a Graphics object as a parameter
//        Graphics objects store the current graphics state(colours, fonts, etc.) for drawing operations
        setBackground(Color.blue);
        g.setColor(Color.orange);
        g.fillRect(50, 50, 200, 200);
        g.setColor(Color.blue);
        g.fillOval(52, 52, 196, 196);
        g.setColor(Color.yellow);
        g.drawString("Hello World!", 100, 150);
    }
}
