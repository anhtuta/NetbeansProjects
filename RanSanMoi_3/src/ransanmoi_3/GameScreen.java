/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class GameScreen extends JPanel implements Runnable {
    public static int [][] bg = new int[20][20]; //background
    ConRan cr;
    Thread t;
    public static int padding = 10; //khoảng hở giữa phần chơi và frame
    
    private final int kichThuocOVuongChuaOLuoi = 20; //kích thước ô vuông chứa ô lưới nhỏ bên trong
    private final int kichThuocOLuoi = 18; //kích thước 1 ô lưới trong 1 ô vuông, do đó mỗi ô cách nhau 2 pixel
    private final int soOLuoi = 20; //số ô lưới trên màn hình
    
    static boolean isPlaying; //tại sao cần static: vì biến này sẽ thay đổi khi đối tượng thuộc lớp ConRan thay đổi,
                              //nhưng lớp ConRan ko có đối tượng nào thuộc lớp GameScreen, do đó muốn thay đổi thuộc tính isPlaying thì phải để nó là static,
                              //khi đó có thể thay đổi mà ko cần đối tượng nào thuộc lớp này
    boolean enableTextStartGame = true;
    static boolean isGameOver = false;
    static boolean isReadyForNewGameAfterGameOver = true;
    
    static int currLevel = 1;
    static int diem = 0;
    static final int WALL = 1;
    static final int LURE = 2;  //khi tọa độ của background b[i][j] = 2 thì con mồi ở vị trí (i,j), số 2 chả có ý nghĩa gì cả!
    //nếu bg[i][j] = 0 thì tọa độ (i,j) ko có gì
    //nếu bg[i][j] = 1 thì tọa độ (i,j) có tường, rắn đâm vào sẽ chết
    //nếu bg[i][j] = 2 thì tọa độ (i,j) có con mồi
    static Map map = new Map();
    
    public GameScreen() {
        cr = new ConRan();
        Data.loadImage();
        Data.loadAllAnim();
        t = new Thread(this);
        t.start();
        
        bg[10][10] = LURE; //con mồi ban đầu ở vị trí (10, 10)
    }

    public void paintGrid(Graphics g) {
        int i,j;
        g.setColor(Color.LIGHT_GRAY);
        for (i = 0; i < soOLuoi; i++) {
            for (j = 0; j < soOLuoi; j++) {
                g.fillRect(i*kichThuocOVuongChuaOLuoi+padding, j*kichThuocOVuongChuaOLuoi+padding, kichThuocOLuoi, kichThuocOLuoi);
            }
        }
    }
    
    public void paintGroundUnderGrid(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400 + padding*2, 400 + padding*2);
    }
    
    public void paintDisplayScoreLevelBg(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(400 + padding*2, 0, 200, 400 + padding*2);
        g.setColor(Color.BLACK);
        g.drawRect(400 + padding*2, 0, 200, 400 + padding*2);
    }
    
    public void paintBottomBg(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 400 + padding*2, 600 + padding*2, 100);
        g.setColor(Color.BLACK);
        g.drawRect(0, 400 + padding*2, 600 + padding*2, 100);
    }
    
    public void paintBg(Graphics g) {
        paintGroundUnderGrid(g);
        paintDisplayScoreLevelBg(g);
        paintBottomBg(g);
        paintGrid(g);
        
        int i,j;
        
        for (i = 0; i < soOLuoi; i++) {
            for (j = 0; j < soOLuoi; j++) {
                //vẽ tường:
                if(bg[i][j] == 1)  g.drawImage(Data.imageWall, i*20 + padding, j*20 + padding, null);
                
                //vẽ con mồi:
                if(bg[i][j] == 2)  g.drawImage(Data.wormAnim.getCurrImage(), i*20-7 + padding, j*20-7 + padding, null);
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        paintBg(g);
        cr.veRan(g);
        
        g.setColor(Color.black);
        g.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 25));
        g.drawString("Level: "+currLevel, 450, 100);
        g.drawString("Score: "+diem, 450, 150);
        
        if(!GameScreen.isPlaying) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString("PRESS SPACE TO PLAY", 50, 450);
        }
        
        if(GameScreen.isGameOver && !GameScreen.isReadyForNewGameAfterGameOver) {
            paintBg(g);
            cr.veRan(g);
            
            //display score after died:
            g.setColor(Color.black);
            g.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 25));
            g.drawString("Level: " + currLevel, 450, 100);
            g.drawString("Score: " + diem, 450, 150);
            
            //display these things after died:
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game over!", 50, 450);
            
            g.setColor(Color.GREEN);
            g.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 25));
            g.drawString("PRESS SPACE TO START A NEW GAME", 50, 480);
        }
    }
    
    @Override
    public void run() {
        long t1 = 0;
        while(true) {
            if(isPlaying) {
                if (System.currentTimeMillis() - t1 > 200) {
                    Data.wormAnim.update();
                    t1 = System.currentTimeMillis();
                }
                cr.update();
            }
            
            repaint(); //nếu cho hàm này vào trong lệnh if ở trên thì khi đang pause game thì nó ko hiển thị dòng PRESS SPACE TO PLAY nữa,
                       //nghĩa là lúc isPlaying = false thì vẽ cái gì lên panel cũng ko đc
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
