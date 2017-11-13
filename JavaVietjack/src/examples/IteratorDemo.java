/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class IteratorDemo {
    public static void main(String[] args) {
        //nếu dùng for(...) thì khi remove 1 phần tử sẽ bất tiện hơn iterator:
        List l=new ArrayList();
        l.add("A");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("e");
        
//        
//        String s;
//        int leng=l.size();
//        for (int i = 0; i < leng; i++) {
//            s=l.get(i);
//            if(s.equals("b")) {
//                l.remove(s);
//                leng--; //phải giới hạn giảm độ tăng của i
//            }
//            //else System.out.println(s+" "); in ra màn hình lúc này là sai
//        }
        
        for (Object st:l) {
            System.out.println(st+" ");
        }
        
        ///dùng iterator:
        Iterator iter=l.iterator();
        while(iter.hasNext()) {
            Object s2=  iter.next();
            //if(s2.equals("c")) l.remove(s2);
        }
        
        ////////////
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(a1);
        Iterator it=a1.iterator();
        while(it.hasNext()) {
            String s=(String) it.next();
            if(s.equals("Mahnaz")) a1.remove(s);
        }
        System.out.println(a1);
    }
}
