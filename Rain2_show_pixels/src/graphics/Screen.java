/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Screen {
    private int width, height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width*height];
    }
    
    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(x%(1+new Random().nextInt(100)) == 0) pixels[x+y*width] = 0xff00ff;
            }
        }
    }
}
