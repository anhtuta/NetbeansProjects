/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class RanSanMoi extends JFrame {
    
    GameScreen gs;
    private static ArrayList<User> users;
    
    public RanSanMoi() {
        gs = new GameScreen();
        
        users = new ArrayList<User>();
        readData();
        add(gs);
        addKeyListener(new Handle());
    }
    
    public static void main(String[] args) {
        RanSanMoi f = new RanSanMoi();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(650, 500);
        
    }
    
    class Handle implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_SPACE) {
                GameScreen.isPlaying = !GameScreen.isPlaying;
                if(GameScreen.isGameOver == true) {
                    GameScreen.isGameOver = false;
                    gs.cr.resetGame();
                }
            }
            
            if (ke.getKeyCode() == KeyEvent.VK_UP) gs.cr.setVector(1);
            if (ke.getKeyCode() == KeyEvent.VK_DOWN) gs.cr.setVector(-1);
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) gs.cr.setVector(2);
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) gs.cr.setVector(-2);
            
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }

    }
    
    public static void updateData() {
        
    }
    
    public static void readData() {
        try {
            FileReader fr = new FileReader("data/data.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line = null;
            while((line = br.readLine()) != null) {
                String [] str = line.split(" "); //chia line thành các mảng cách nhau bởi dấu cách
                users.add(new User(str[0], str[1]));
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RanSanMoi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RanSanMoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}


