/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author AnhTu
 */
public class Ball implements Runnable {
    private int x, y;   //toa do cua qua bong
    private float vX, vY;  //vận tốc theo trục x, y
    boolean isCrashWall_X;
    boolean isCrashWall_Y;
    int radius;     //bán kính của quả bóng
    int left_limit, right_limit, up_limit, donw_limit;
    boolean isStop;
    boolean isShaking1;
    Color ballColor;
    
    Thread t;
    boolean isRunning;
    JFrame frame;

    public Ball(int x, int y, int radius, JFrame frame) {
        isShaking1 = true;
        isStop = false;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.frame = frame;
        
        //giới hạn bên trái của trục x
        left_limit = radius;
        
        //giới hạn bên phải của trục x
        right_limit = CatchBall.FRAME_WIDTH - radius;
        
        //giới hạn bên trên của trục y
        up_limit = radius;
        
        //giới hạn bên dưới của trục y
        donw_limit = CatchBall.FRAME_HEIGHT- 2*radius;
        
        isCrashWall_X = false;
        isCrashWall_Y = false;
        
        t = new Thread(this);
        isRunning = true;
    }
    
    public void startMovingBall() {
        t.start();
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }
    
    /**
     * Hàm này vẽ quả bóng tại tọa độ (x, y)
     * @param g = graphic để vẽ
     */
    public void paintBall(Graphics g) {
        g.drawOval(x, y, 1, 1);   //vẽ tâm quả bóng
        //g.drawOval(x - radius, y - radius, 2*radius, 2*radius);   //vẽ đường tròn bao quanh
        g.setColor(ballColor);
        g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
    }
    
    /**
     * hàm này cập nhật tọa độ của quả bóng
     */
    public void updateBall() {
        x += vX;
        y += vY;
        
        if(x >= right_limit || x <= left_limit) {
            //System.out.println("Dam vao tuong X");
            isCrashWall_X = true;
            //vX = -vX;
        } else {
            isCrashWall_X = false;
        }
        
        if(y >= donw_limit || y <= up_limit) {
            //System.out.println("    Dam vao tuong Y");
            isCrashWall_Y = true;
            //vY = - vY;
        } else {
            isCrashWall_Y = false;
        }
    }
    
    /**
     * Hàm này cập nhật vận tốc của quả bóng theo trục x và y
     * Giá trị vận tốc đc lấy random
     */
    public void updateVelocity() {
        if(isCrashWall_X) {
            vX = -vX;
        }
        if(isCrashWall_Y) {
            vY = -vY;
        }
    }
    
    public void shaekBall1() {
        x += 5;
        isShaking1 = false;
    }
    
    public void shaekBall2() {
        x -= 5;
        isShaking1 = true;
    }
    
    public void stopBall() {
        vX = 0;
        vY = 0;
    }

    @Override
    public void run() {
        while(isRunning) {
            if(!isStop) {
                updateBall();
                updateVelocity();
            }
            frame.repaint();
            
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(CatchBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
