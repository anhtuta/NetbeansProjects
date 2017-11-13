/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltnc;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class GameScreen extends JPanel implements Runnable {
    ShowMessageThread t2;
    Ball b;
    boolean isRunning;

    public GameScreen() {
        b = new Ball(100, 100, 20);
        b.setvX(1);
        b.setvY(4);
        isRunning = true;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                System.out.println("click!");
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
    }
    
    @Override
    public void paint(Graphics g) {
        //System.out.println("paint!");
        super.paint(g);
        b.paintBall(g);
    }
    
    @Override
    public void run() {
        while(isRunning) {
            //update the whole screem
            b.updateBall();
            b.updateVelocity();
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
