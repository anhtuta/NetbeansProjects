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
import javax.swing.JApplet;

/**
 *
 * @author AnhTu
 */
//NÊN DÙNG APPLET HƠN LÀ JAPPLET
public class Example2 extends Applet {//CHÚ Ý LÀ APPLET VÀ JAPPLET CHO 2 KẾT QUẢ KHÁC NHAU, CỨ THỬ MÀ XEM!
    @Override
    public void init() {
        setFont(new Font("SansSerif", Font.BOLD, 30));
        setBackground(Color.yellow);
        setForeground(Color.BLUE);  //lệnh này chả có tác dụng gì!???
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawArc(20, 30, 170, 170, -10, 135);
        g.drawString("Hello world!", 20, 160);
    }
}
