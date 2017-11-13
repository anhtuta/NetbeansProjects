/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class Screen {
    private GraphicsDevice gd;

    public Screen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = env.getDefaultScreenDevice();
        
    }
    
    public void setFullScreen(DisplayMode dm, JFrame window) {
        window.setUndecorated(true);
        window.setResizable(false);
        gd.setFullScreenWindow(window);
        
        if(dm != null && gd.isDisplayChangeSupported()) {
            gd.setDisplayMode(dm);
        }
    }
    
    public Window getFullScreenWindow() {
        return gd.getFullScreenWindow();
    }
    
    public void restoreScreen() {
        Window w = gd.getFullScreenWindow();
        if(w != null) {
            w.dispose();
        }
        gd.setFullScreenWindow(null);
    }
    
    public static void main(String[] args) {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        JFrame frame = new JFrame();
        frame.setBackground(Color.PINK);
        frame.setForeground(Color.WHITE);
        frame.setFont(new Font("Tahoma", Font.PLAIN, 24));
        
        Screen s = new Screen();
        s.setFullScreen(dm, frame);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s.restoreScreen();
        
    }
}
