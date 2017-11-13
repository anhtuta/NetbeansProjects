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
public class FontMetricsExample_Note_This_Mistake extends Applet {
    public void init() {
        setSize(500, 400);
    }
    
    public void paint(Graphics g) {
        Font f2 = new Font("Niagara Solid", Font.BOLD, 18);
        Font f3 = new Font("Arial", Font.PLAIN, 14);
        
        int x = 30; int y = 80;
        String msg1 = "Java language ";
        String msg2 = "A new approach to program";
        
        FontMetrics fm2 = g.getFontMetrics(f2); //dòng này và dòng dưới phải cùng kiểu f2 hoặc f3, nếu ko bị lỗi
        g.setFont(f3);
        g.drawString(msg1, x, y);
        g.setFont(f3);
        g.drawString(msg2, x + fm2.stringWidth(msg1), y);
        
        y = y + 30;
        g.setFont(f2);
        g.drawString(msg1, x, y);
        g.setFont(f3);
        g.drawString(msg2, x, y + fm2.getHeight());
        
    }
}
