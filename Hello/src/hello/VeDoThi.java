/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public class VeDoThi extends JFrame {
    JPanel drawPanel;
    JButton btDraw, btSin;
    Graphics2D g;
    
    public VeDoThi() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel btnPanel = new JPanel();
        
        drawPanel = new JPanel();
        drawPanel.setPreferredSize(new Dimension(0, 420));
        drawPanel.setBorder(new LineBorder(new Color(51, 102, 255), 3, false));
        
        btDraw = new JButton("Vẽ y=3x^3+10");
        btDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                drawSomething();
            }
        });
        btnPanel.add(btDraw);
        
        btSin = new JButton("Vẽ y=x^2-100");
        btSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                drawX2();
            }
        });
        btnPanel.add(btSin);
        
        mainPanel.add(drawPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
        
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Ve do thi y = 3x^3 + 10");
    }
    
    private void drawSomething() {
        g = (Graphics2D) drawPanel.getGraphics();
        g.setColor(Color.BLACK);
        g.drawLine(0, 200, 540, 200);   //Ox
        g.drawString(">", 540, 205);    //Ox's arrow
        g.drawLine(250, 13, 250, 400);     //Oy
        g.drawString("^", 248, 18);        //Oy's arrow
        //Tâm của đồ thị O ở tọa độ (250, 200)
        
        g.setColor(Color.BLUE);
        int x1, y1, x2, y2;
        x1 = 250 + (-5);
        y1 = 200 - (int) fx(-5);
        
        //g.drawLine(250, 200, 100, 100);
            
        for (int i = -4; i < 7; i++) {
            x2 = 250 + i;
            y2 = 200 - (int) fx(i);
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
        //System.out.println("Toàn noob! Toàn gà vl :v");
        //JOptionPane.showMessageDialog(this, "Toàn noob! Toàn gà vl :v", "Cảnh báo nguy hiểm", JOptionPane.WARNING_MESSAGE);
    }
    
    private void drawSin() {
        g = (Graphics2D) drawPanel.getGraphics();
        g.setColor(Color.BLUE);
        int x1, y1, x2, y2;
        x1 = 250 + (-5);
        y1 = 200 - (int) fx(-5);
        
        for (int i = 0; i < 100; i++) {
            
        }
    }
    
    private void drawX2() {
        g = (Graphics2D) drawPanel.getGraphics();
        g.setColor(Color.BLUE);
        int x1, y1, x2, y2;
        x1 = 250 + (-5);
        y1 = 200 - (int) fx(-5);
        
        for (int i = 0; i < 100; i++) {
            x2 = 250 + i;
            y2 = (int) (200 - fx2(i));
            g.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }
     
    float fx(int x) {
        return (3*x*x*x + 10);
    }
    
    double sinx(int x) {
        return Math.sin(x);
    }
    
    float fx2(int x) {
        return x*x - 100;
    }
    
    public static void main(String[] args) {
        new VeDoThi().setVisible(true);
    }
}
