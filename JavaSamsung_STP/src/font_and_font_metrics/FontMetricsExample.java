/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font_and_font_metrics;

import java.applet.Applet;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */
public class FontMetricsExample extends Applet {
    public void init() {
        setSize(500, 400);
    }
    
    public void paint(Graphics g) {
        //example 1:
        Font f1 = new Font("Times Roman", Font.PLAIN, 22);
        FontMetrics fm = g.getFontMetrics(f1);
        String name = fm.getFont().getName();
        g.drawString("font1 name is: " + name, 30, 50);
        
        
        //example 2:
        Font f2 = new Font("Niagara Solid", Font.BOLD, 18);
        Font f3 = new Font("Arial", Font.PLAIN, 14);
        
        int x = 30; int y = 80;
        String msg1 = "Java language ";
        String msg2 = "A new approach to program";
        
        FontMetrics fm2 = g.getFontMetrics(f2);
        g.setFont(f2);
        g.drawString(msg1, x, y);
        g.setFont(f3);
        g.drawString(msg2, x + fm2.stringWidth(msg1), y);
        
        y = y + 30;
        g.setFont(f2);
        g.drawString(msg1, x, y);
        g.setFont(f3);
        g.drawString(msg2, x, y + fm2.getHeight());
        
        Font f4 = new Font("Blackoak Std", Font.PLAIN, 20);
        y = y + 60;
        g.setFont(f4);
        g.drawString(msg1, x, y);
        g.setFont(f4);
        g.drawString(msg2, x, y + g.getFontMetrics(f4).getHeight());
        
        
    }
}
