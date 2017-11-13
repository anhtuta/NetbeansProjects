/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author AnhTu
 */
public class Dictionary_TreeMap {
    //ứng dụng từ điển dùng HashTable
    public static void main(String[] args) {
        TreeMap dic=new TreeMap();
        dic.put("blue", "Màu xanh da trời");
        dic.put("green", "Màu xanh lá cây");
        dic.put("red", "Màu đỏ");
        dic.put("black", "Màu đen");
        dic.put("white", "Màu trắng");
        dic.put("yellow", "Màu vàng");
        System.out.println(dic);
        System.out.println("Ta nhận thấy các entry đc in ra sắp xếp theo thứ tự tăng dần của key\n");
        
        Scanner kb=new Scanner(System.in);
        System.out.println("Nhập từ cần tra:");
        String w=kb.nextLine();
        
        ////cách 1:
        Set keys=dic.keySet();
        for(Object k:keys) {
            if((w.trim()).equalsIgnoreCase(k.toString())) {
                System.out.println("Nghĩa của từ: "+dic.get(k)); break;
            }
        }
        
        ///cách 2:
        System.out.println("Nhập từ cần tra:");
        w=kb.nextLine();
        String str=(String) dic.get(w.toLowerCase().trim());
        if(str==null) System.out.println("Ko tìm thấy từ");
        else System.out.println("Nghĩa của từ: "+str);
    }
}
