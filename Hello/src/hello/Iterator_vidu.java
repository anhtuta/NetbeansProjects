/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author AnhTu
 */

//1 cách để duyệt các phần tử của ArrayList
public class Iterator_vidu {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("anhtu");
        al.add("dhbk");
        al.add(new Long(7));
        al.add('a');
        
        Iterator iter = al.iterator();
        while(iter.hasNext()) System.out.println(iter.next());
        
    }
}
