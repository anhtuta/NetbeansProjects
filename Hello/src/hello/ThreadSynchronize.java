/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class ThreadSynchronize implements Runnable {

    int tien;

    public ThreadSynchronize() {
        this.tien = 1000;
    }
    
    public synchronized void rutTien(int t) {
        if(tien>0) {
            System.out.println("thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSynchronize.class.getName()).log(Level.SEVERE, null, ex);
            }
            tien -= t;
            System.out.println("so tien con lai = "+tien);
        }
        else System.out.println("Het tien!");
    }
    
    @Override
    public void run() {
        rutTien(1000);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSynchronize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        ThreadSynchronize t=new ThreadSynchronize();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        
        t1.start();
        t2.start();
        
    }
    
}
//nếu ko có synchronized thì 2 thằng t1 và t2 đều start cùng 1 lúc, khi bọ nó start thì 1000ms sau bọn nó mới trừ tiền
//do đó lúc cả 2 start thì tien vẫn = 1000, nhưng sau 1000ms thì tien=0, nhưng lúc này thì cả 2 thread đều đang chạy, 
//do đó tiền vẫn bị trừ!