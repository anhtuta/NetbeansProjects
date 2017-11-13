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

//NHƯỢC ĐIỂM CỦA synchronized: thời gian chạy lâu hơn vì mỗi thread chạy lần lượt
//nếu ko có synchronized thì các thread chạy chồng lên nhau nhưng thời gian sẽ giảm
public class ThreadDemo_2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        
        Thread td1 = new Thread(mt);
        Thread td2 = new Thread(mt);
        
        td1.setName("anhtu");
        td2.setName("songohan");
        
        td1.start();
        td2.start();
        
    }
}

class MyThread2 implements Runnable {

    int money = 1000;
    @Override
    public synchronized void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(20);
                System.out.println(Thread.currentThread().getName() + " " + i + " : " + money--);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}