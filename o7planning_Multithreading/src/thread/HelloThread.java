/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author AnhTu
 */
public class HelloThread extends Thread {

    // Code trong hàm run() sẽ được thực thi khi
    // thread được chạy (start)
    @Override
    public void run() {
        int index = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println("  - HelloThread running " + index++);

            try {
                // Ngủ 1030 milli giây.
                Thread.sleep(1030);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

        }
        System.out.println("  - ==> HelloThread stopped");
    }
}


