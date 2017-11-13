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
public class ThreadDeadlock implements Runnable {

    public synchronized void test1() {
        System.out.println("test1");
        test2();
    }
    
    public synchronized void test2() {
        System.out.println("test2");
        test1();
    }
    
    @Override
    public void run() {
        test1();
    }
    
    public static void main(String[] args) {
        ThreadDeadlock t=new ThreadDeadlock();
        
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        
        t1.start();
        t2.start();
    }
}
