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
/*
Thread.join() là một method thông báo rằng hãy chờ thread này hoàn thành rồi thread CHA mới được tiếp tục chạy.

// Thread CHA cần phải đợi cho tới khi luồng này kết thúc mới được chạy tiếp.
// (Nó tương đương với gọi join(0) )
public final void join() throws InterruptedException;
 
// Thread CHA cần phải đợi 'millis' milli giây mới được tiếp tục chạy.
// kể từ lúc gọi join(millis).
// Nếu tham số millis = 0 nghĩa là đợi cho tới khi luồng này kết thúc.
public final synchronized void join(long millis) throws InterruptedException;
 
 
// Thread CHA cần phải đợi 'millis' milli giây và 'nanos' nano giây  mới được tiếp tục chạy.
// kể từ lúc gọi join(long,int).
// Nếu tham số millis = 0 & nanos = 0 nghĩa là đợi cho tới khi luồng này kết thúc.
// 1 giây = 1000000 nano giây.
public final synchronized void join(long millis, int nanos) throws InterruptedException;
*/
public class JoinThread extends Thread {

    private String threadName;
    private int count;

    public JoinThread(String threadName, int count) {
        this.threadName = threadName;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            System.out.println("Hello from " + this.threadName + " " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\n==> Thread " + threadName + " end!\n");
    }

}
