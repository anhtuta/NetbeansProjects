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
public class PingPongThread extends Thread {
    String word;
    int delay;

    public PingPongThread(String word, int delay) {
        this.word = word;
        this.delay = delay;
    }
    
    //override nè
    @Override
    public void run() {
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
        
        PingPongThread r = new PingPongThread("anhtu", 200);
        r.start(); //nếu viết ntnay thì chạy nó báo nguy hiểm!
    }
}
