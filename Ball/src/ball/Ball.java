/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball;

import java.awt.Graphics;


/**
 *
 * @author AnhTu
 */
public class Ball {
    private int x, y;   //toa do cua qua bong
    private float vX, vY;  //vận tốc theo trục x, y
    boolean isCrashWall_X;
    boolean isCrashWall_Y;
    int radius;     //bán kính của quả bóng

    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        isCrashWall_X = false;
        isCrashWall_Y = false;
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
    
    /**
     * Hàm này vẽ quả bóng tại tọa độ (x, y)
     * @param g = graphic để vẽ
     */
    public void paintBall(Graphics g) {
        g.drawOval(x, y, 1, 1);   //vẽ tâm quả bóng
        g.drawOval(x - radius, y - radius, 2*radius, 2*radius);   //vẽ đường tròn bao quanh
    }
    
    /**
     * hàm này cập nhật tọa độ của quả bóng
     */
    public void updateBall() {
        x += vX;
        y += vY;
        
        if(x >= 600 || x <= 0) {
            System.out.println("Dam vao tuong X");
            isCrashWall_X = true;
        } else {
            isCrashWall_X = false;
        }
        
        if(y >= 600 || y <= 0) {
            System.out.println("    Dam vao tuong Y");
            isCrashWall_Y = true;
        } else {
            isCrashWall_Y = false;
        }
    }
    
    //đổi chiểu chuyển động khi đâm vào tường
    public void updateVelocity() {
        if(isCrashWall_X) {
            vX = -vX;
        }
        if(isCrashWall_Y) {
            vY = -vY;
        }
    }
}
