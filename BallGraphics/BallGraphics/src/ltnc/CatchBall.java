/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltnc;   //Lap trinh nang cao 20171

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class CatchBall extends JFrame {
    GameScreen panel;
    Thread t;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    
    
    public CatchBall() {
        panel = new GameScreen();
        t = new Thread(panel);

        this.add(panel);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        CatchBall cb = new CatchBall();
        cb.setVisible(true);
        cb.t.start();
    }
}
