/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball2;   //Lap trinh nang cao 20171

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class CatchBall extends JFrame implements Runnable {
    Thread t;
    final int NUM_0F_BALLS = 40;
    final int MAX_SPEED = 20;
    
    Ball balls[] = new Ball[NUM_0F_BALLS];
    boolean isRunning;
    ShowMessageThread t2;
    Color colors[] = {Color.RED, Color.BLUE, Color.CYAN, Color.yellow, Color.GREEN};
    
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    
    public CatchBall() {
        Random rd = new Random();
        for (int i = 0; i < NUM_0F_BALLS; i++) {
            balls[i] = new Ball(100+2*i, 100+5*i, 20);
            balls[i].setvX(rd.nextInt(MAX_SPEED) + 1);
            balls[i].setvY(rd.nextInt(MAX_SPEED) + 1);
            balls[i].setBallColor(colors[rd.nextInt(5)]);
        }
        t = new Thread(this);
        isRunning = true;
        
        this.addMouseListener(new MouseAdapter() {
            //Hình như mouseClicked phải click 2 lần mới đc
            @Override
            public void mousePressed(MouseEvent me) {
                ////kiem tra xem co bat dc qua bong ko
                int mouseX = me.getX();
                int mouseY = me.getY();
                System.out.println("mouse: " + mouseX + " - " + mouseY);
                
                for (int i = 0; i < NUM_0F_BALLS; i++) {
                    int ballCentreX = balls[i].getX();
                    int ballCentreY = balls[i].getY();
                    System.out.println("ball: "+ ballCentreX + " - " + ballCentreY);
                    if(mouseX >= ballCentreX - balls[i].radius && mouseX <= ballCentreX + balls[i].radius &&
                            mouseY >= ballCentreY - balls[i].radius && mouseY <= ballCentreY + balls[i].radius) {
                        new ShowMessageThread().start();
                        //isRunning = false;
                        balls[i].stopBall();
                        balls[i].isStop = true;
                    }
                }
            }
        });
        

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < NUM_0F_BALLS; i++) {
            balls[i].paintBall(g);
        }

    }

    @Override
    public void run() {
        while(isRunning) {
            for (int i = 0; i < NUM_0F_BALLS; i++) {
                if(!balls[i].isStop) {
                    balls[i].updateBall();
                    balls[i].updateVelocity();
                } 
//                else {
//                    if(balls[i].isShaking1) balls[i].shaekBall1();
//                    else balls[i].shaekBall2();
//                }
                repaint();
            }
            //update the whole screen
            
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
