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
public class BullsEye extends Applet {

    private int ringWidth; //bán kính hình tròn, do đó muốn vẽ hình tròn bán kính = ringWidth thì phải vẽ đường kính = 2*ringWidth. CHÚ Ý KO THỂ DÙNG KIỂU double
    private int startx, starty; //tọa độ bắt đầu để vẽ. CHÚ Ý KO THỂ DÙNG KIỂU double
    
    @Override
    public void init() {
        setSize(450, 450);
        setBackground(Color.GRAY);
        ringWidth = 30;
        startx = 50; starty = 50;
    }
    @Override
    public void paint(Graphics g) {
        setBackground(Color.yellow);
//        g.setColor(Color.magenta);
//        int xc = getWidth();
//        int yc = getHeight();
//        int radius = 100;
//        g.fillOval( xc/2 - radius, yc/2 - radius, 2 * radius, 2 * radius );

        for (int i = 1; i <= 5; i++) {
            if(i%2 == 0) g.setColor(Color.white);
            else g.setColor(Color.red);
            g.fillOval(startx + (i-1)*ringWidth, starty + (i-1)*ringWidth, (10 - (i-1)*2)*ringWidth, (10 - (i-1)*2)*ringWidth);
        }
        
    }
}
