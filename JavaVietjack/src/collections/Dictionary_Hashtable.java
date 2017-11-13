/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class Dictionary_Hashtable {
    //ứng dụng từ điển dùng HashTable
    public static void main(String[] args) {
        Hashtable dic=new Hashtable();
        dic.put("Blue", "Màu xanh da trời");
        dic.put("Green", "Màu xanh lá cây");
        dic.put("Red", "Màu đỏ");
        dic.put("Black", "Màu đen");
        dic.put("White", "Màu trắng");
        dic.put("Yellow", "Màu vàng");
        System.out.println(dic);
        
        System.out.println("Ví dụ dùng enumeration:");
        Enumeration enu=dic.elements();
        System.out.println("enu=");
        while(enu.hasMoreElements()) System.out.print(enu.nextElement() + " ");
        
        
        Scanner kb=new Scanner(System.in);
        System.out.println("Nhập từ cần tra:");
        String w=kb.nextLine();
        
        ////cách 1:
        Set keys=dic.keySet();
        for(Object k:keys) {
            if(w.equalsIgnoreCase(k.toString())) {
                System.out.println("Nghĩa của từ: "+dic.get(k)); break;
            }
        }
        
        ///cách 2:
        System.out.println("Nhập từ cần tra:");
        w=kb.nextLine();
        String str=(String) dic.get(w);
        if(str==null) System.out.println("Ko tìm thấy từ");
        else System.out.println("Nghĩa của từ: "+str);
    }
}
