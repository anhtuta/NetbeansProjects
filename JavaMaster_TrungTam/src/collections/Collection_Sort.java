/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Collection_Sort {
    public static void main(String[] args) {
        ///////example1:
        List<String> list1 = new ArrayList<String>();
        list1.add("anhtu");
        list1.add("toan");
        list1.add("trung");
        list1.add("huy");
        list1.add("att");
        list1.add("nguyen");
        
        System.out.println("Before sorting:");
        for(String s: list1) {
            System.out.print(s+" ");
        }
        
        Collections.sort(list1);    //dùng đc hàm này vì lớp String là có sẵn, 
        //và hàm này sắp xếp theo chiều tăng dần theo bảng chữ cái
        //nếu muốn sắp xếp giảm dần thì phải override hàm compareTo
        System.out.println("\nAfter sorting:");
        for(String s: list1) {
            System.out.print(s+" ");
        }
        
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                if(t1.compareTo(t2) > 0) return -1;
                else if(t1.compareTo(t2) < 0) return 1;
                else return 0;
            }
        });
        System.out.println("\nSau khi sắp xếp theo chiều giảm dần của bảng chữ cái:");
        for (String s : list1) {
            System.out.print(s + " ");
        }
        
        ///////example2:
        List<Integer> list2 = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            list2.add(rd.nextInt(50));
        }
        
        System.out.println("\n\nBefore sorting:");
        for(int a : list2) {
            System.out.print(a+" ");
        }
        
        Collections.sort(list2);
        System.out.println("\nSau khi sắp xếp tăng dần:");
        for(int a : list2) {
            System.out.print(a+" ");
        }
        
        Collections.shuffle(list2);
        System.out.println("\nAfter shuffling:");
        for(int a : list2) {
            System.out.print(a+" ");
        }
        
        //Tương tự, muốn sắp xếp giảm dần ta làm như sau:
        Collections.sort(list2, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                if(t1 > t2) return -1;
                else if(t1 < t2) return 1;
                else return 0;
            }
        });
        System.out.println("\nSau khi sắp xếp giảm dần:");
        for(int a : list2) {
            System.out.print(a+" ");
        }
    }
}
/*
    
    Before sorting:
    anhtu toan trung huy att nguyen 
    After sorting:
    anhtu att huy nguyen toan trung 
    Sau khi sắp xếp theo chiều giảm dần của bảng chữ cái:
    trung toan nguyen huy att anhtu 

    Before sorting:
    35 9 5 15 10 38 46 18 33 30 28 13 6 33 28 30 18 33 21 42 
    Sau khi sắp xếp tăng dần:
    5 6 9 10 13 15 18 18 21 28 28 30 30 33 33 33 35 38 42 46 
    After shuffling:
    28 35 46 13 5 15 30 18 42 10 33 38 18 30 33 33 21 6 9 28 
    Sau khi sắp xếp giảm dần:
    46 42 38 35 33 33 33 30 30 28 28 21 18 18 15 13 10 9 6 5
*/