/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy_birds;

import java.awt.Rectangle;
import java.io.File;
import pkg2dgamesframework.Objects;
import pkg2dgamesframework.SoundPlayer;

/**
 *
 * @author AnhTu
 */
public class Bird extends Objects {
    private float vt = 0; //tốc độ rơi hiện tại, chính là độ tăng tọa độ của con chim
    private boolean isFlying;
    private Rectangle rect;  //dùng để kiểm tra va chạm
    private boolean isAlive = true;
    public SoundPlayer flapSound, bupSound, scoreSound;

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setVt(float vt) {
        this.vt = vt;
    }

    public boolean getIsFlying() {
        return isFlying;
    }
    
    public Rectangle getRect() {
        return rect;
    }
    
    public Bird(int x,int y,int w,int h) {
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
        
        flapSound = new SoundPlayer(new File("Assets/flap.wav"));
        bupSound = new SoundPlayer(new File("Assets/bup.wav"));
        scoreSound = new SoundPlayer(new File("Assets/getmoney.wav"));
    }
    
    public void update(long deltaTime) {
        //update điểm rơi của con chim
        vt += FlappyBirds.g; //độ tăng tọa độ y của chim
        this.setPosY(this.getPosY()+vt); //tọa độ con chim theo trục y tăng 1 đoạn = vt do có gia tốc rơi tự do g
        if(vt<0) isFlying = true; //nếu chim đang bay lên thì = true
        else isFlying = false;
        rect.setLocation((int) this.getPosX(), (int) this.getPosY());
    }
    
    public void fly() {
        vt = -4;
        flapSound.play();
    }
}
