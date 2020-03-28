/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class PaintDemoWindow extends JFrame implements ActionListener {
    private JPanel mainPanel, pDraw, pButtons;
    private JButton btBlack, btRed, btBlue, btGreen, btYellow, btErase;
    private Graphics2D g;
    Color c;
    int x0,y0, x1,y1;
    
    private PaintDemoWindow() {
        mainPanel = new JPanel(new BorderLayout());
        
        JPanel pDrawOutside = new JPanel(new BorderLayout(15, 15));
        pDraw = new JPanel();
        pDraw.setPreferredSize(new Dimension(400, 400));
        pDraw.setBackground(Color.WHITE);
        
        pDraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x0 = evt.getX();
                y0 = evt.getY();
                System.out.println(x0+", "+y0);
            }
        });
        pDraw.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                //vẽ 1 đường thẳng nối 2 điểm (x0,y0) và (x1y1):
                x1 = evt.getX();
                y1 = evt.getY();
                g = (Graphics2D) pDraw.getGraphics();
                g.setColor(c);
                if(g.getColor() == Color.WHITE) g.setStroke(new BasicStroke(20.0f));
                else g.setStroke(new BasicStroke(5.0f));
                g.drawLine(x0, y0, x1, y1);
                
                x0 = x1;
                y0 = y1;
            }
        });
        
        pDrawOutside.add(pDraw, BorderLayout.NORTH);
        
        
        pButtons = new JPanel(new BorderLayout(5, 5));
        GridLayout gl = new GridLayout(6, 1, 15, 15);
        JPanel pButtonInside = new JPanel(gl);
        
        btRed = new JButton("Red");
        btRed.setPreferredSize(new Dimension(70, 30));
        pButtonInside.add(btRed);
        btBlack = new JButton("Black");
        pButtonInside.add(btBlack);
        btBlue = new JButton("Blue");
        pButtonInside.add(btBlue);
        btGreen = new JButton("Green");
        pButtonInside.add(btGreen);
        btYellow = new JButton("Yellow");
        pButtonInside.add(btYellow);
        btErase = new JButton("Erase");
        pButtonInside.add(btErase);
        pButtons.add(pButtonInside, BorderLayout.NORTH);
        
        btRed.addActionListener(this);
        btBlack.addActionListener(this);
        btBlue.addActionListener(this);
        btGreen.addActionListener(this);
        btYellow.addActionListener(this);
        btErase.addActionListener(this);
        
        
        mainPanel.add(pDrawOutside, BorderLayout.WEST);
        mainPanel.add(pButtons, BorderLayout.EAST);
        
        
        
        add(mainPanel);
        
        this.setSize(530, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new PaintDemoWindow().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == btRed) c = Color.RED;
        if(o == btBlue) c = Color.BLUE;
        if(o == btGreen) c = Color.GREEN;
        if(o == btYellow) c = Color.YELLOW;
        if(o == btErase) c = Color.WHITE;
        if(o == btBlack) c = Color.BLACK;
    }
}
