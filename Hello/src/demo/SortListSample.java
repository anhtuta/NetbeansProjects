/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TQHuy
 */
public class SortListSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Double> list = new ArrayList<>();
        Double[] a = {1.0, 2.0, 4.0, 3.0, 6.9, 5.2, 3.2, 4.8};
        list.addAll(Arrays.asList(a));
        
        //Sắp xếp giảm dần
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 > o2) return -1;
                else if(o1 < o2) return 1;
                else return 0;
            }
        });
        System.out.println(list);
        
        //Sắp xếp tăng dần
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1 > o2) return 1;
                else if(o1 < o2) return -1;
                else return 0;
            }
        });
        System.out.println(list);
        
        //nếu dùng Collections.sort(list) thì là sắp xếp tăng dần
    }

}
