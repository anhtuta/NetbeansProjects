/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemostp;

import static java.lang.Thread.sleep;

/**
 *
 * @author anhtu
 */
public class PingPongRunnable implements Runnable {

    String word;
    int delay;

    public PingPongRunnable(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }
    @Override
    public void run() {
        //override giống như class PingPongThread
        try {
            for (int i = 1; i < 10; i++) {
                System.out.println(word + "" + i);
                sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread "+word + " interrupt.");
        }
    }
    
    public static void main(String[] args) {
        new PingPongThread("ping", 500).start();
        new PingPongThread("pong", 1000).start();
        
        PingPongRunnable r = new PingPongRunnable("anhtu", 200);
        r.start();
    }

    private void start() { //hàm này chỉ dành cho lệnh r.start()
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
