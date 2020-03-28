/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author AnhTu
 */
public class ImageDemo extends JFrame {
    public ImageDemo() {      //hàm khởi tạo 
        this.setSize(400, 250); //chieu dai = 200, chieu rong = 150
        setLocation(500, 300);    
        setResizable(true);   //nếu setResizable(false);  thì ko thể thay đổi kích thước của frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //kết thúc chương trình, ko cho chạy mãi mãi
        JLabel lb = new JLabel();   //lb = label
        add(lb); //add lb vào frame và cho hiển thị
        lb.setSize(350, 200);
        //System.out.println("x: "+lb.getSize().width+" y: "+lb.getSize().height);
        
        setPicture(lb,"Italy.jpg");
    }
       
    public void setPicture(JLabel lb, String filename) {
         try {
            BufferedImage image = ImageIO.read(new File("Italy.jpg"));
            int x = lb.getSize().width;
            int y = lb.getSize().height;
            int ix = image.getWidth();
            int iy = image.getHeight(); 
            int dx,dy = 0;
            
            if(x/y > ix/iy) {
                dy = y;
                dx = dy*ix/iy;
            } else {
                dx = x;
                dy = dx*iy/ix;
            }
            
            ImageIcon icon = new ImageIcon(image.getScaledInstance(250, 150, image.SCALE_SMOOTH)); //tên file ảnh trong thư mục project
            lb.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ImageDemo.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
                
    public static void main(String[] args) {
        ImageDemo imagedemo = new ImageDemo();
        imagedemo.setVisible(true);
    }
}

    