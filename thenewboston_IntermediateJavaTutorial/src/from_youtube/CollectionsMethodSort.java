/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class CollectionsMethodSort {
    public static void main(String[] args) {
        String [] stuff = {"apple", "lemon", "geese", "bacon", "anhtu"};
        List<String> l1 = Arrays.asList(stuff);
        l1.add("dtvt");
        Collections.sort(l1);
        System.out.println(l1);
        
        insertToList(l1, "bkhn");
        System.out.println(l1);
    }
    
    private static void insertToList(List<String> list, String str) {
        list.add(str);
    }
}
