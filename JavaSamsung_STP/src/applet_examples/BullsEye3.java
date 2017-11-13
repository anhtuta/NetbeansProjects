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
//CHÚ Ý: WIDTH LÀ CHIỀU RỘNG, TÍNH THEO TRỤC X, HEIGHT LÀ CHIỀU DÀI, TÍNH THEO TRỤC Y
public class BullsEye3 extends Applet {
    int startx, starty, ringWidth;
    int cycle = 5;
    @Override
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        setBackground(Color.orange);
        
        int minDimension = width < height ? width : height;
        
        ringWidth = minDimension/(cycle*2);
        startx = (width - minDimension)/2;
        starty = (height - minDimension)/2; //1 trong 2 thằng sẽ = 0, hoặc cả 2 nếu 2 thằng = nhau
        
        for (int i = 1; i <= cycle; i++) {
            if(i%2 == 0) g.setColor(Color.white);
            else g.setColor(Color.red);
            g.fillOval(startx + (i-1)*ringWidth, starty + (i-1)*ringWidth, (10 - (i-1)*2)*ringWidth, (10 - (i-1)*2)*ringWidth);
        }
         
    }
}
