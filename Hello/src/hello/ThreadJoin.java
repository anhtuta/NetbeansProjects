/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class ThreadJoin extends Thread {
    private String ten;

    public ThreadJoin(String name) {
        this.ten = name;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String name) {
        this.ten = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getTen() + " - " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadJoin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        ThreadJoin t1=new ThreadJoin("thread1");
        ThreadJoin t2=new ThreadJoin("thread2");
        ThreadJoin t3=new ThreadJoin("thread3");
        
        t1.start();
        try {
            t1.join(300);  //các thread2,3 phải đợt thread1 hoàn thành mới đc bắt đầu
            //vậy ý nghĩa join: các thread khác phải đợi 300ms sau đó bọn chúng mới hoạt động đc
            //số 300 nghĩa là thời gian đợi của các thread, nghĩa là sau 300ms thì các thread khác sẽ hoạt động,
            //bất chấp thread1 đã hoàn thành hay chưa.
            //Nếu chỉ viết t1.join(); nghĩa là các thread khác phải đợi thread này hoàn thành sau đó bọn chúng mới hoạt động đc
            //chú ý rằng các thread còn lại vẫn chạy song song với nhau
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadJoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.start();
        t3.start();
    }
}
