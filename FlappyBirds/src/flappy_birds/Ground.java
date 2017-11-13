/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy_birds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author AnhTu
 */
public class Ground {
    private BufferedImage groundImage;
    private int x1 ,y1, x2, y2; //cần 2 ảnh ground để tạo hiệu ứng ground xuất hiện liên tục
    
    public int getYGround() {
        return y1;
    }
    public Ground() {
        try {
            groundImage = ImageIO.read(new File("Assets/ground.png"));
        } catch (IOException ex) {
            Logger.getLogger(Ground.class.getName()).log(Level.SEVERE, null, ex);
        }
        x1=0;
        y1=500; //tọa độ của ground thứ 1 tại (0,500)
        x2 = 830; //830 = độ dài của ảnh ground.png
        y2 = 500; //tọa độ ground thứ 2 tại (830, 500) nghĩa là nó nối tiếp ground1 theo trục x
        
    }
    
    public void update() {
        x1-=2;
        x2-=2;
        if(x2 < 0) x1 = x2+830;
        if(x1 < 0) x2 = x1+830;
    }
    
    public void paint2D(Graphics2D g) {
       g.drawImage(groundImage, x1, y1, null);  //vẽ 2 hình ground
       g.drawImage(groundImage, x2, y2, null);
    }
}
