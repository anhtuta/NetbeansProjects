/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Apple implements Runnable {

    String name;
    int time;
    Random rd = new Random();

    public Apple(String name) {
        this.name = name;
        time = rd.nextInt(999);
    }
    
    
    @Override
    public void run() {
        System.out.printf("%s is sleeping for %d\n", name, time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Apple.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("%s is done\n", name);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Apple("one"));
        Thread t2 = new Thread(new Apple("two"));
        Thread t3 = new Thread(new Apple("three"));
        
        t1.start();
        t2.start();
        t3.start();
    }
}
