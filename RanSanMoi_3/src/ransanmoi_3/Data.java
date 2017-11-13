/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.awt.Image;
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
public class Data {
    public static BufferedImage sprite;
    
    public static Image imageHead;
    public static Image imageHead_GoLeft;
    public static Image imageHead_GoRight;
    public static Image imageHead_GoUp;
    public static Image imageHead_GoDown;
    
    public static Image imageBody;
    
    public static Image imageWorm;
    public static Image imageWorm2;
    public static Image imageWorm3;
    
    public static Image imageWall;
    
    public static Animation headGoUp;
    public static Animation headGoDown;
    public static Animation headGoLeft;
    public static Animation headGoRight;
    public static Animation wormAnim;
    
    
    public static void loadImage() {
        try {
            sprite = ImageIO.read(new File("res/sprite1.png"));
            
            imageHead = sprite.getSubimage(2, 3, 30, 30);
            imageHead_GoLeft = sprite.getSubimage(75, 3, 30, 30);
            imageHead_GoRight = sprite.getSubimage(110, 3, 30, 30);
            imageHead_GoUp = sprite.getSubimage(145, 3, 30, 30);
            imageHead_GoDown = sprite.getSubimage(39, 3, 30, 30);
            
            imageBody = sprite.getSubimage(6, 79, 20, 20);
            
            imageWorm = sprite.getSubimage(2, 40, 30, 32);
            imageWorm2 = sprite.getSubimage(31, 40, 30, 32);
            imageWorm3 = sprite.getSubimage(59, 40, 30, 32);
            
            imageWall = ImageIO.read(new File("res/wall.png"));
        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void loadAllAnim() {
        headGoUp = new Animation();
        headGoUp.addImage(imageHead);
        headGoUp.addImage(imageHead_GoUp);
        
        headGoDown = new Animation();
        headGoDown.addImage(imageHead);
        headGoDown.addImage(imageHead_GoDown);
        
        headGoLeft = new Animation();
        headGoLeft.addImage(imageHead);
        headGoLeft.addImage(imageHead_GoLeft);
        
        headGoRight = new Animation();
        headGoRight.addImage(imageHead);
        headGoRight.addImage(imageHead_GoRight);
        
        wormAnim = new Animation();
        wormAnim.addImage(imageWorm);
        wormAnim.addImage(imageWorm2);
        wormAnim.addImage(imageWorm3);
        wormAnim.addImage(imageWorm2);
        
    }
}
