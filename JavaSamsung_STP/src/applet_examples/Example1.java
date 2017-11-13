/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author AnhTu
 */
public class Example1 extends JApplet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Today is December 21th, 2016. Noel is comming very soon!", 20, 100);
        showStatus("Applet is running");
        g.drawString("Context: "+getAppletContext(), 20, 120);
    }
}
