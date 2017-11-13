/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font_and_font_metrics;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */
public class BasepointExample extends Applet {

    @Override
    public void paint(Graphics g) {
        setBackground(Color.yellow);
        g.setColor(Color.red);
        g.drawLine(30, 30, 180, 30);
        g.setColor(Color.blue);
        g.drawString("Trust No One", 30, 30);
    }
}
