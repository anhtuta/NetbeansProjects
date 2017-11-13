/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;

/**
 *
 * @author AnhTu
 */
class DeamonThread extends Thread {

    @Override
    public void run() {
        int count = 0;

        // Vòng lặp vô tận.
        while (true) {
            System.out.println("+ Hello from Deamon Thread " + count++);
            try {
                // Ngủ 2 giây.
                sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
