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
public class Example5 extends Applet {

    @Override
    public void init() {
        setSize(300, 250);
    }
    @Override
    public void paint(Graphics g) {
        setBackground(Color.orange);
        int red, green, blue;
        g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
        for (int i = 0; i < 4; ++i) {
            red = (int) (Math.random() * 256);
            green = (int) (Math.random() * 256);
            blue = (int) (Math.random() * 256);
            Color c = new Color(red, green, blue);
            g.setColor(c);
            g.drawString("Hello", 10, 30 + 50 * i);
        }
    }
}
