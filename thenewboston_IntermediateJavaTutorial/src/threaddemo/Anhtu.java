/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

/**
 *
 * @author AnhTu
 */
public class Anhtu {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tuna("one"));
        Thread t2 = new Thread(new Tuna("two"));
        Thread t3 = new Thread(new Tuna("three"));
        Thread t4 = new Thread(new Tuna("four"));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }
}
