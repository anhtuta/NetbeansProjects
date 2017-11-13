/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */
public class Example7 extends Applet {

    @Override
    public void init() {
        setSize(350, 250);
        setBackground(Color.GRAY);
    }
    @Override
    public void paint(Graphics g) {
        //g.fillArc(0, 0, 100, 100, 0, 290);
        g.setColor(Color.PINK);
        g.fillArc(50, 50, 200, 200, 0, 90);
        g.setColor(Color.GREEN);
        g.fillArc(50, 50, 200, 200, 90, 90);
        g.setColor(Color.BLUE);
        g.fillArc(50, 50, 200, 200, 180, 90);
        g.setColor(Color.YELLOW);
        g.fillArc(50, 50, 200, 200, 270, 90);
        
    }
}
