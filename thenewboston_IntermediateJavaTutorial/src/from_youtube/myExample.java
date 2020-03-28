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
public class myExample {
    public static void main(String[] args) {
        String [] stuff = {"apple", "lemon", "geese", "bacon", "anhtu"};
        ArrayList<String> l1 = new ArrayList<String>();
        for(String s: stuff) {
            l1.add(s);
        }
        l1.add("dtvt");
        Collections.sort(l1);
        System.out.println(l1);
        
        insertToList(l1, "bkhn");
        System.out.println(l1);
    }
    
    private static void insertToList(ArrayList<String> list, String str) {
        list.add(str);
    }
}
