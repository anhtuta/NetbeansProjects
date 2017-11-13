/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catch_ball;   //Lap trinh nang cao 20171

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class CatchBall extends JFrame implements Runnable {
    Thread t;
    Ball b;
    boolean isRunning;
    ShowMessageThread t2;
    
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    
    public CatchBall() {
        b = new Ball(100, 100, 20);
        b.setvX(2);
        b.setvY(7);
        t = new Thread(this);
        isRunning = true;
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                ////kiem tra xem co bat dc qua bong ko
                int mouseX = me.getX();
                int mouseY = me.getY();
                System.out.println("mouse: " + mouseX + " - " + mouseY);
                
                int ballCentreX = b.getX();
                int ballCentreY = b.getY();
                System.out.println("ball: "+ ballCentreX + " - " + ballCentreY);
                if(mouseX >= ballCentreX - b.radius && mouseX <= ballCentreX + b.radius &&
                        mouseY >= ballCentreY - b.radius && mouseY <= ballCentreY + b.radius) {
                    new ShowMessageThread().start();
                    isRunning = false;
                }
            }
        });

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(b != null) b.paintBall(g);
    }

    @Override
    public void run() {
        while(isRunning) {
            //update the whole screen
            b.updateBall();
            b.updateVelocity();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatchBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CatchBall cb = new CatchBall();
                cb.setVisible(true);
                cb.t.start();
            }
        });
        
    }
}
