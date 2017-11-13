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
public class Example4 extends Applet {

    @Override
    public void init() {
        setSize(300, 250);
    }
    @Override
    public void paint(Graphics g) {
        setBackground(Color.yellow);
        g.setColor(Color.red);
        g.drawString("Hello 1", 50, 50); // in red
        
        g.setColor(Color.blue);
        g.drawString("Hello 2", 50, 100); // in blue
        
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Hello 3", 50, 150); // in new font
        
        g.setColor(Color.pink);
        g.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 30));
        g.drawString("Hello 4", 50, 200); // new font and color
    }
}
