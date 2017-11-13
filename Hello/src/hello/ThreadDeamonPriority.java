/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author AnhTu
 */
public class ThreadDeamonPriority extends Thread {

    public ThreadDeamonPriority(String name) {
        this.setName(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }
    //Deamon là thread chạy ngầm(chạy ở background)
    //priority là độ ưu tiên, từ 1-10. Nó ko có ý nghĩa nhiều lắm, ví dụ: thread1 có độ ưu tiên = 1,
    //thread2 có độ ưu tiên = 10, khi chạy thì có thể thằng thread1 vẫn đc chạy trước
    
    public static void main(String[] args) {
        ThreadDeamonPriority t1=new ThreadDeamonPriority("thread1");
        ThreadDeamonPriority t2=new ThreadDeamonPriority("thread2");
        ThreadDeamonPriority t3=new ThreadDeamonPriority("thread3");
        
        t1.setPriority(1);
        t2.setPriority(10);
        t3.setPriority(5);
        
//        t1.start();
//        t2.start();
//        t3.start();
        
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        System.out.println(t1.isDaemon());
        
    }
}
