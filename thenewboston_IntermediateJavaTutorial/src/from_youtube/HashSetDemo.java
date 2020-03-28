/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class HashSetDemo {
    public static void main(String[] args) {
        String[] things = {"banana", "potato", "peanut", "grape", "banana"};
        List<String> list1 = Arrays.asList(things);
        System.out.println(list1);
        
        Set<String> set = new HashSet<String>(list1); //set sẽ lấy tất cả giá trị của list1, nhưng cái nào trùng nhau thì ko lấy nữa
        System.out.println(set);
        
        
    }
}
