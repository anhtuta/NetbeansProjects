/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemostp;

//import static java.time.Clock.system;

/**
 *
 * @author anhtu
 */
public class NonSynchronizedCounter {
    static int count = 0;
    public static void increament() {
        ++count;
        System.out.println("count is: "+count+ " - "+System.nanoTime());
    }
    
    public static void decreament() {
        --count;
        System.out.println("count is: "+count+ " - "+System.nanoTime());
    }
    
    public static void main(String[] args) {
        Thread threadIncrement = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    increament();
                }
            }
        };
        
        Thread threadDecrement = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    decreament();
                }
            }
        };
        
        threadIncrement.start();
        threadDecrement.start();
        
    }
        
}
