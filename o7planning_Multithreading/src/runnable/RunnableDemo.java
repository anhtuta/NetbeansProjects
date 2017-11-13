/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runnable;

/**
 *
 * @author AnhTu
 */

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        int idx = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from RunnableDemo " + idx++);
            // Ngủ 1 giây.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
