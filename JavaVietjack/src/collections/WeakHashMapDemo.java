/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Map;
import java.util.WeakHashMap;

/**
 *
 * @author AnhTu
 */
public class WeakHashMapDemo {

    private static Map map;

    public static void main(String args[]) {
        map = new WeakHashMap();
        map.put("Maine", "Augusta");
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.gc();
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}
