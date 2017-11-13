/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class GameScreen extends JPanel implements Runnable {
    Thread t;
    static int [][] bg = new int[20][20]; //background
    ConRan cr;
    static int padding = 10; //khoảng hở giữa phần chơi và frame
    static int width = 400;
    static int height = 400;
    static boolean isPlaying;
    static boolean enableTextStartGame = true;
    static boolean isGameOver = false;
    static int currLevel = 1;
    static int diem = 0;
    
    public GameScreen() {
        cr = new ConRan();
        Data.loadImage();
        Data.loadAllAnim();
        
        t = new Thread(this);
        t.start();
        
        bg[10][10] = 2;
    }
    
    public void veLuoi(Graphics h) {
        for (int m = 0; m < 20; m++) {
            for (int n = 0; n < 20; n++) {
                h.fillRect(m*20+5, n*20+5, 18, 18); //vẽ lưới
            }
        }
    }
    
    public void paintBg(Graphics g1) {
        g1.setColor(Color.gray);
        g1.fillRect(0, 0, width + padding*2 + 200, height + padding*2); //vẽ nền chơi game
        //veLuoi(g1);
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                //g1.fillRect(i*20+5, j*20+5, 18, 18);
                if(bg[i][j] == 2) {
//                    g1.setColor(Color.red);
//                    g1.fillRect(i*20+5, j*20+5, 18, 18);
//                    g1.setColor(Color.gray);
                    
                    //vẽ con mồi
                    g1.drawImage(Data.wormAnim.getCurrImage(), i*20+5-4 + padding, j*20+5-4 + padding, null);
                    
                }
            }
        }
        
    }
    
//    private void paintFrame2d() {
//        Graphics2D g2d = (Graphics2D) this.getGraphics();
//        g2d.setColor(Color.yellow);
//        g2d.setStroke(new BasicStroke(20.0f));
//        g2d.drawRect(0, 0, width+padding*2, height+padding*2);
//    }
    
    private void paintFrame(Graphics g) {
        g.setColor(Color.yellow);
        g.drawRect(0, 0, width+padding*2 + 200, height+padding*2);
        g.drawRect(2, 2, width+padding*2-2, height+padding*2-2);
        g.drawRect(2, 2, width+padding*2-4 + 200, height+padding*2-4);
        
    }
    
    @Override
    public void paint(Graphics g) {
        paintBg(g);
        cr.veRan(g);
//        
//        Image im = null;
//        try {
//            im = ImageIO.read(new File("res/snake_head.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        paintFrame(g);
        
        if(!isPlaying) {
            if (enableTextStartGame) {
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("PRESS SPACE TO PLAY", 60, 220);
            }
        }
        
        if(isGameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game over", 60, 190);
            
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("LEVEL: "+currLevel, 450, 150);
        
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString("Điểm: "+diem, 450, 200);
    }

    @Override
    public void run() {
        long t1 = 0;
        long t2 = 0;
        while(true) {
            if(System.currentTimeMillis()-t2>500) {  //làm cho dòng chữ nhấp nháy, cứ 500ms thì lại nhấp nháy
                enableTextStartGame = !enableTextStartGame;
                t2 = System.currentTimeMillis();
            }
            
            if(isPlaying) {
                if (System.currentTimeMillis() - t1 > 200) {
                    Data.wormAnim.update();
                    t1 = System.currentTimeMillis();
                }
                
                cr.update();
                
            }
            
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
