/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_awt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class CanvasDemo extends Canvas {
    private JFrame frame;

    public CanvasDemo() {
        frame = new JFrame();
        this.setPreferredSize(new Dimension(500, 400));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(3, 3, 50, 50);
        g.drawRect(70, 3, 70, 40);
        g.setColor(Color.cyan);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Today is 21/06/2017", 0, 70);
        
        Image java = new ImageIcon(getClass().getResource("/images/java.png")).getImage();
        g.drawImage(java, 100, 100, this);
    }
    
    
    
    public static void main(String[] args) {
        CanvasDemo cd = new CanvasDemo();
        cd.frame.add(cd);
        cd.frame.pack();    //thử ko có lệnh này xem, thì lệnh setPreferredSize(new Dimension(300, 200)); ở trên ko có tác dụng
        cd.frame.setTitle("Canvas demo");
        cd.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.frame.setLocationRelativeTo(null);
        cd.frame.setVisible(true);
    }
}
