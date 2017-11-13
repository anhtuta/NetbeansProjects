/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author AnhTu
 */
import java.util.Random;

public class ThreadExceptionDemo {

    public static class RunnableTest implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread running ..");

            while (true) {
                Random r = new Random();
                // Một số ngẫu nhiên từ 0 - 99
                int i = r.nextInt(100);
                System.out.println("Next value " + i);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

                if (i > 70) {
                    // Mô phỏng một ngoại lệ đã không được sử lý trong luồng.
                    throw new RuntimeException("Have a problem...");
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("==> Main thread running...");

        Thread thread1 = new Thread(new RunnableTest());
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("#Thread: " + t);
                System.err.println("#Thread exception message: " + e.getMessage());
            }
        });

        thread1.start();
        System.out.println("==> Main thread end.... Note that main thread ends WHILE our thread1 is still alive");
    }

}
