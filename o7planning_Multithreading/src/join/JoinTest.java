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
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n==> Main thread starting..\n");

        Thread joinThreadA = new JoinThread("A*", 2);
        Thread joinThreadB = new JoinThread("B*", 3);

        // Thread thông thường, sẽ không sử dụng join().
        Thread noJoinThreadC = new JoinThread("C", 5);

        joinThreadA.start();
        joinThreadB.start();
        noJoinThreadC.start();
        // Sử dụng join()
        joinThreadA.join();
        joinThreadB.join();

        // Đoạn code dưới đây sẽ phải chờ cho tới khi 2
        // joinThread A,B hoàn thành, mới được chạy tiếp.
        // Chú ý rằng chỉ main thread mới là thread cha của thread A,B
        // Do đó chỉ main thread chờ A, B kết thúc mới chạy tiếp, còn thread C ko phải chờ
        System.out.println("Hello from main thread...");

        System.out.println("Thread A isLive? " + joinThreadA.isAlive());
        System.out.println("Thread B isLive? " + joinThreadB.isAlive());
        System.out.println("Thread C isLive? " + noJoinThreadC.isAlive());

        System.out.println("\n==> Main Thread end!\n");
    }
}
