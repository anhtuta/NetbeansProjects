/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintdemo2;

/**
 *
 * @author admin
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrameDemo extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    
    public Color c;
    public JButton btnRed;
    public JButton btnGreen;
    public JButton btnBlue;
    public JButton btnErase ;
    public JButton btnSin;
    public JPanel pDraw;
    public int x0,y0,x1,y1;
    public Graphics2D g;
    
    public PaintFrameDemo()
    {
        this.setLayout(null);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnRed=new JButton("Red");
        btnRed.setBounds(350, 50, 100, 30);
        btnRed.addActionListener(this);
        this.add(btnRed);
        
        btnGreen=new JButton("Green");
        btnGreen.setBounds(350, 100, 100, 30);
        btnGreen.addActionListener(this);
        this.add(btnGreen);
        
        btnBlue=new JButton("Blue");
        btnBlue.setBounds(350, 150, 100, 30);
        btnBlue.addActionListener(this);
        this.add(btnBlue);
        
        btnErase=new JButton("Erase");
        btnErase.setBounds(350, 200, 100, 30);
        btnErase.addActionListener(this);
        this.add(btnErase);
        
        btnSin=new JButton("y=sin(x)");
        btnSin.setBounds(350, 250, 100, 30);
        btnSin.addActionListener(this);
        this.add(btnSin);
        
        pDraw=new JPanel();
        pDraw.setBounds(10, 50, 300, 300);
        pDraw.setBackground(Color.white);
        pDraw.addMouseListener(this);
        pDraw.addMouseMotionListener(this);
        this.add(pDraw);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object o=e.getSource();
        if(o==btnRed)
            c=Color.red;
        if (o==btnGreen)
            c=Color.green;
        if (o==btnBlue)
            c=Color.blue;
        if (o==btnErase)
            c=Color.white;
        if(o==btnSin)
            drawSin();
    }
    public void drawSin()
    {
        double x,y,Xs=200/(2*Math.PI),Ys=200/2;
        int x11,y11,x21,y21;
        int X20=50,Y20=150;
        int x20=50,y20=150;
        g=(Graphics2D)pDraw.getGraphics();
        g.setColor(Color.ORANGE);
        g.drawLine(0, 150, 300, 150);
        g.drawString(">", 290, 153);
        g.drawLine(50, 0, 50, 300);
        g.drawString("^", 47, 10);
        g.setColor(Color.pink);
        g.drawString("y=sin(x)", 100, 100);
        g.setColor(c);
        for(int i=0;i<=100;i++)
        {
            x=Math.PI*2*i/100;
            y=Math.sin(x);
            x11=(int)(x*Xs);
            y11=(int)(y*Ys);
            x21=X20+x11;
            y21=Y20-y11;
            g.drawLine(x20, y20, x21, y21);
            x20=x21;
            y20=y21;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x0=e.getX();
        y0=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x1=e.getX();
        y1=e.getY();
        g=(Graphics2D)pDraw.getGraphics();
        if(c!=Color.white)
            g.setStroke(new BasicStroke(5.0f));
        else
            g.setStroke(new BasicStroke(30.0f));
        g.setColor(c);
        g.drawLine(x0, y0, x1, y1);
        x0=x1;
        y0=y1;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        new PaintFrameDemo().show();
    }
}
