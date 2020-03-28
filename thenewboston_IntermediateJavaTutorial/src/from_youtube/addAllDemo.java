/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class addAllDemo {
    public static void main(String[] args) {
        String[] things = {"banana", "potato", "peanut", "grape"};
        List<String> list1 = Arrays.asList(things);
        
        //với ArrayList ta ko thể dùng Arrays.asList(things), nhưng ta có thể dùng hàm copy để sao chép things sang 1 ArrayList như sau:
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("google");
        list2.add("youtube");
        list2.add("java");
        for(String s: list2) System.out.println(s);
        
        Collections.addAll(list2, things); //thêm mảng things vào sau list2, nếu như list2 rỗng thì lệnh này tương đương với Arrays.asList(things);
        System.out.println(list2);
        
        System.out.println(Collections.frequency(list2, "google"));
        System.out.println(Collections.frequency(list2, "att"));
        
        boolean trueorfalse = Collections.disjoint(list1, list2);
        System.out.println(trueorfalse);
        if(trueorfalse) System.out.println("these list don't have anything in common");
        else System.out.println("these list must have something in common");
        
    }
}
