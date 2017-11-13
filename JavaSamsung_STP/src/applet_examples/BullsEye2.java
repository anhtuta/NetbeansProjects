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
public class BullsEye2 extends Applet {
    @Override
    public void init() {
        //CHÚ Ý THỬ VỚI TỪNG TRƯỜNG HỢP SẼ THẤY KQ KHÁC NHAU
        setSize(350, 350);
        setSize(250, 350);
        setSize(400, 200);
        
        setBackground(Color.GRAY);
    }
    @Override
    public void paint(Graphics g) {
        int n = 5;
        int width = getWidth();
        int height = getHeight();
        int minDimension = width < height ? width : height;
        int startXcoord = (width - minDimension) / 2;
        int startYcoord = (height - minDimension) / 2;
        int ringWidth = minDimension / (n * 2);
        setBackground(Color.orange);
        for (int i = n; i > 0; --i) {
            if (i % 2 == 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.white);
            }
            g.fillOval(startXcoord + (n - i) * ringWidth, startYcoord + (n - i) * ringWidth,
                    i * 2 * ringWidth, i * 2 * ringWidth);
        }
    }
}
