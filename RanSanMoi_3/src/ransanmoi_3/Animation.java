/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.awt.Image;

/**
 *
 * @author AnhTu
 */
public class Animation {
    public Image[] images;
    public int n;
    public int currImage; //chú ý biến này là chỉ số của hình ảnh hiện tại

    public Animation() {
        n=0;
        currImage = 0;
        images = new Image[4];  //tối đa ta sử dụng 4 ảnh cho 1 animation: con sâu thì 4 ảnh, đầu con rắn chỉ cần 2 thôi
    }
    
    public void addImage(Image im) {
        images[n] = im;
        n++;
    }
    public void update() {
        currImage++;
        if(currImage >= n) currImage = 0;
    }
    
    public Image getCurrImage() {
        return images[currImage];
    }
    
}
