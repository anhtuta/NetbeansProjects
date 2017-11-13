/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class FrameScreen extends JFrame {
    
    private GameScreen gameScreen;
    public FrameScreen() {
        gameScreen = new GameScreen();
        add(gameScreen);
    }
    
    public static void main(String[] args) {
        FrameScreen f = new FrameScreen();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(500, 500);
    }
}