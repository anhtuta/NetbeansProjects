/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemostp;

/**
 *
 * @author anhtu
 */
//cách viết khác so với class PingPongThread

public class PingPongThread2 extends Thread {
    String word;
    int delay;
    Thread t;

    public PingPongThread2(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }
    
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                System.out.println(word + "" + i );
                sleep(delay);
            }
        } catch(InterruptedException e) {
            System.out.println("Thread "+word + " interrupt.");
        }
    }
    
    public void start() {
        if(t==null) {
            t = new Thread(this);
            t.start();
        }
    }
    
    public static void main(String[] args) {
        new PingPongThread("ping", 500).start();
        new PingPongThread("pong", 1000).start();
    }
}
