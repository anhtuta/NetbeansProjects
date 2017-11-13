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

//Chúng ta cần 2 class tham gia vào ví dụ này.
//HelloMain là một class thông thường có hàm main, nó là một luồng chính (main thread).
//HelloThread là một class mở rộng từ class Thread. Nó được tạo và chạy kích hoạt chạy bên trong luồng chính và sẽ chạy song song với luồng chính.

public class HelloMain {

    public static void main(String[] args) throws InterruptedException {

        int idx = 1;

        for (int i = 0; i < 2; i++) {

            System.out.println("Main thread running " + idx++);
            // Ngủ 2101 milli giây.
            Thread.sleep(2101);
        }

        HelloThread helloThread = new HelloThread();

        // Chạy thread
        helloThread.start();

        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread running " + idx++);
            // Ngủ 2101 milli giây.
            Thread.sleep(2101);
        }

        System.out.println("==> Main thread stopped");
    }
}
