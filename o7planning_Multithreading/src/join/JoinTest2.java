/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package join;

/**
 *
 * @author AnhTu
 */
public class JoinTest2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n==> Main thread starting..\n");

        Thread joinThreadA = new JoinThread("A*", 5);

        joinThreadA.start();
        // Luồng cha (main) phải chờ 5000 milli giây
        // mới được tiếp tục chạy. (Không nhất thiết phải A kết thúc)
        joinThreadA.join(5000);

        System.out.println("Main thread after 5000 milli second:");
        System.out.println("Hello from main thread...");

        System.out.println("Thread A isLive? " + joinThreadA.isAlive());

        System.out.println("\n==> Main Thread end!\n");
    }
}
