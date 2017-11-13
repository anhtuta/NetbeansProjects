/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy_birds;

import java.awt.Rectangle;
import pkg2dgamesframework.Objects;

/**
 *
 * @author AnhTu
 */
public class Chimney extends Objects {
    
    private Rectangle rect;
    private boolean isBehindBird = false;

    public boolean getIsBehindBird() {
        return isBehindBird;
    }

    public void setIsBehindBird(boolean isBehindBird) {
        this.isBehindBird = isBehindBird;
    }
    
    public Chimney(int x,int y,int w,int h) {
        super(x, y, w, h);
        rect = new Rectangle(x, y, w, h);
    }
    public void update() {
        setPosX(getPosX() - 2); //thay đổi tọa độ ống khói giống với ground
        rect.setLocation((int) this.getPosX(), (int) this.getPosY());
    }
    
    public Rectangle getRect() {
        return rect;
    }
}
