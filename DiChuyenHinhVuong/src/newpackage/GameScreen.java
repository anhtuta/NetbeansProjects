/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */

public class GameScreen extends JPanel implements Runnable {
    
    Thread thread;
    int a = 0;
    public GameScreen() {
        thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        g.fillRect(a, 10, 100, 100);
    }

    @Override
    public void run() {
        while(true) {
            a++;
            repaint();
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
