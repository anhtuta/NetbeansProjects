/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Tuna implements Runnable {
    String name;
    int time;

    public Tuna(String name) {
        this.name = name;
        time = new Random().nextInt(10000);
    }
    
    
    @Override
    public void run() {
        System.out.printf("%s is sleeping for %d\n", name, time);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tuna.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("%s is done\n", name);
    }
    
}
