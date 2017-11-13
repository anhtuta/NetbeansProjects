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
public class Example6 extends Applet {

    @Override
    public void init() {
        setSize(300, 250);
        setBackground(Color.yellow);
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(30, 30, 200, 150);
        g.drawOval(30, 30, 200, 150);
        g.drawLine(30, 30, 170, 90);
    }
}
