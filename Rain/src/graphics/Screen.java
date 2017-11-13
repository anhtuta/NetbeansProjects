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
    
    public int[] tiles = new int[64*64];
    private Random rd = new Random();
    
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width*height];
        
        for (int i = 0; i < 64*64; i++) {
            tiles[i] = rd.nextInt(0xffffff);
        }
        
    }
    
    public void render() {
        for (int y = 0; y < height; y++) {
            if(y >= height) break;
            for (int x = 0; x < width; x++) {
                if(x >= width) break;
                int tileIndex = (x >> 4) + (y >> 4) * 64;
                pixels[x+y*width] = tiles[tileIndex];
            }
        }
    }
    
    public void clear() {   //set every pixels to Black
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
