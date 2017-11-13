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
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("before sleep");
                    Thread.sleep(1000);
                    System.out.println("after sleep");
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
//        t.run();
//        t.run(); //co the dung 2 lenh run()
//        t.start();
        //t.start(); //ko the dung 2 lenh start()
        
        MyThread mt = new MyThread();
        mt.start();
        
        YourThread yt = new YourThread();
        new Thread(yt).start();
        
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("(class MyThread)before sleep: "+i);
                Thread.sleep(500);
                System.out.println("(class MyThread)after sleep: "+i);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class YourThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("(class YourThread)before sleep: "+i);
                Thread.sleep(500);
                System.out.println("(class YourThread)after sleep: "+i);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}