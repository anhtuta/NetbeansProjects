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
public class FlashGordon extends Applet {

    private String message1, message2;

    @Override
    public void init() {
        setSize(520, 300);
        setBackground(Color.yellow);
        setForeground(Color.blue);
        message1 = "Nguyễn ";
        message2 = "Gordon";
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("SansSerif", Font.BOLD, 40));
        int xBase = 100;
        int yBase = 150;
        FontMetrics metrics = g.getFontMetrics();
        int widthOfMessage1 = metrics.stringWidth(message1);
        
        g.setColor(Color.blue);
        g.drawString(message1, xBase, yBase);
        g.setColor(Color.red);
        g.drawString(message2, xBase + widthOfMessage1, yBase);
    }
}
