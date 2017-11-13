/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Map {   //map này cũng giống bg, nghĩa là gồm 20 ô vuông
    int [][] m;
    
    public Map() {
        m = new int[20][20];
    }
    
    public void setMap1() {
        clearMap();
        int i,j; //i,j tương ứng theo tọa độ x,y
        
        //j=0:
        for (i = 0; i < 20; i++) {
            m[i][0] = 1;
        }
        //j = 19:
        for (i = 0; i < 20; i++) {
            m[i][19] = 1;
        }
        
        //i=0:
        for (j = 0; j < 20; j++) {
            m[0][j] = 1;
        }
        //i=19:
        for (j = 0; j < 20; j++) {
            m[19][j] = 1;
        }
    }
    
    public void setMap2() {
        clearMap();
        int i,j; //i,j tương ứng theo tọa độ x,y
        
        for (j = 0; j < 20; j++) {
            for (i = 2; i < 18; i++) {
                if(j%3 == 0) m[i][j] = 1;
                else m[i][j]=0;
            }
        }
    }
    
    public void setRandomMap() {
        clearMap();
        int i,j;
        Random rd = new Random();
        int x;
        for (j = 0; j < 20; j++) {
            for (i = 0; i < 20; i++) {
                x = rd.nextInt(7);
                if(x>=1) m[i][j]=0;
                else m[i][j]=1;
            }
        }
    }
    
    public void setMapTu() {
        clearMap(); 
        int i;
        m[16][3] = m[15][4] = m[14][5] = 1;
        for (i = 0; i <= 8; i++) {
            m[i][6] = 1;
        }
        for (i = 6; i <= 15; i++) {
            m[4][i] = 1;
        }
        
        for (i = 6; i <= 15; i++) {
            m[11][i] = 1;
        }
        for (i = 6; i <= 15; i++) {
            m[17][i] = 1;
        }
        for (i = 11; i <= 17; i++) {
            m[i][15] = 1;
        }
    }
    
    public void clearMap() {
        int i,j; //i,j tương ứng theo tọa độ x,y
        
        for (j = 0; j < 20; j++) {
            for (i = 0; i < 20; i++) {
                m[i][j] = 0;
            }
        }
    }
    
    public int [][] getMap() {
        return m;
    }
}
