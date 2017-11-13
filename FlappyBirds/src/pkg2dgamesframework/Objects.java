/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgamesframework;

/**
 *
 * @author phamn
 */
public class Objects {
    
    private float posX, posY; //tọa độ của object
    private float w, h; //kích thước của object
    
    public Objects(){
         posX = posY = w = h = 0;
    }
    
    public Objects(float x, float y, float w, float h){
        this.posX = x;
        this.posY = y;
        this.w = w;
        this.h = h;
    }
    
    public boolean isCollisionHappenWith(float x, float y){
        return x > posX && x < posX + w && y > posY && y < posY + h;
    }
    public boolean isCollisionHappenWith(float x, float y, float w, float h){
        return x < posX + this.w && x + w > posX && y < posY + this.h && h + y > posY;
    }
    public void setPos(float x, float y){
        posX = x;
        posY = y;
    }
    public void setPosX(float x){
        posX = x;
    }
    public void setPosY(float y){
        posY = y;
    }
    public float getPosX(){
        return posX;
    }
    public float getPosY(){
        return posY;
    }
    public float getW(){
        return w;
    }
    public float getH(){
        return h;
    }
    public void increasePosX(float m){
        posX+=m;
    }
    public void increasePosY(float m){
        posY+=m;
    }
}
