/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class Temp extends JFrame implements Runnable {

    Node node;
    public Temp() {
        setSize(400, 400);
        setDefaultCloseOperation(3);
        node = new Node(5, 100, 100, this);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                
            }
            
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                
                node.setX(x);
                node.setY(y);
                repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.drawLine(50, 50, 100, 200);
        node.drawNode(g);
    }

//    @Override
//    public void repaint() {
//        //super.repaint(); //To change body of generated methods, choose Tools | Templates.
//        Graphics g = this.getGraphics();
//        removeAll();
//        validate();
//        node.drawNode(g);
//    }
//    
    

    @Override
    public void run() {
        
    }
    
    public static void main(String[] args) {
        new Temp().setVisible(true);
        //int []a = {};
        int []a = new int[9];
        //a[0]= 1;
        System.out.println(a.length);
        //a[10] = 99;
    }
}
