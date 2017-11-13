/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author AnhTu
 */
public class ArrayAndVector {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("Anhtu");
        al.add(new String("bkhn"));
        al.add(new Integer(7));
        al.add(new Long(1000));
        for(int i=4; i<12; i++) al.add(new Integer(i*i));

        System.out.println(al.get(11));
        
        al.remove(3);
        try {
            System.out.println(al.get(3));  //phan tu thu 3 da bi remove roi!
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        Object [] array = al.toArray();
        System.out.println(array.length + " "+ al.size());
        
        ///in tat ca ca phan tu
        System.out.println("cac phan tu cua mang al la:");
        for(int i=0; i<al.size(); i++) System.out.println(al.get(i)); //ko thể dùng al[i]
        
        System.out.println("cac phan tu cua object array la:");
        for(int i=0; i<array.length; i++) System.out.println(array[i]);
        //vậy ArrayList thì dùng al.get(i), còn Object dùng chỉ số như mảng bình thường: array[i]
        
        Vector vt = new Vector();
        vt.add("Att2");
        vt.add(new Integer(8));
        for(int i=2; i<10; i++) vt.add(new Long(i*i*i*i));
        
        System.out.println("cac phan tu cua Vector:");
        for(int i =0; i<vt.size(); i++) System.out.println(vt.get(i));
        
    }

}
