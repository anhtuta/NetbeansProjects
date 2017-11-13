/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font_and_font_metrics;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */

//Display the message “The Truth is Out There” (in
//a fixed font of your choice) so that the message is
//always in the middle of the applet, vertically and
//horizontally

public class TruthIsOutThere extends Applet {
    private String msg;
    
    public void init() {
        setSize(520, 300);
        setBackground(Color.pink);
        setForeground(Color.blue);
        msg = "The Truth is Out There";
    
    }
    
    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.BOLD, 50));
        FontMetrics fm = g.getFontMetrics();
        
        g.drawString(msg, (getWidth() - fm.stringWidth(msg))/2, (getHeight() + fm.getHeight())/2);
    }
}
