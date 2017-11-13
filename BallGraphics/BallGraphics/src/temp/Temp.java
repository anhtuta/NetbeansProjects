/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Temp {
    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println((float) rd.nextInt(100)/10);
        }
    }
}
