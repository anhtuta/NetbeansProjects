/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class Anhtu extends JFrame {

    @Override
    public void paint(Graphics g) {
        g.drawString("This is gonna be awesome!", 100, 100);
    }
    
    public void run(DisplayMode dm) {
        setBackground(Color.PINK);
        setForeground(Color.WHITE);
        setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        Screen s = new Screen();
        try {
            s.setFullScreen(dm, this);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.restoreScreen();
        }
    }
    
    public static void main(String[] args) {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        Anhtu at = new Anhtu();
        at.run(dm);
        
    }
}
