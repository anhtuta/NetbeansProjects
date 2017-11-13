/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Image;

/**
 *
 * @author AnhTu
 */
public class Animation {
    public Image[] images;
    public int n;
    public int currImage;

    public Animation() {
        n=0;
        currImage = 0;
    }
    
    public void addImage(Image im) {
        Image[] arr = images;
        images = new Image[n+1];
        
        for (int i = 0; i < n; i++) {
            images[i] = arr[i];
            
        }
        images[n] = im;
        n++;
    }
    public void update() {
        currImage++;
        if(currImage >= 2) currImage = 0;
    }
    
    public Image getCurrImage() {
        return images[currImage];
    }
    
}
