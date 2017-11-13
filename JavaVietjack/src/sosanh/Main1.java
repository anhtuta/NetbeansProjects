/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosanh;

import collections.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
//bài này dùng comparable
public class Main1 {
    public static void main(String[] args) {
        List<Student1> list=new ArrayList<>();
        list.add(new Student1(1, "Anhtu"));
        list.add(new Student1(3, "Nguyen"));
        list.add(new Student1(6, "nam"));
        list.add(new Student1(2, "trung"));
        list.add(new Student1(5, "Quan"));
        list.add(new Student1(7, "Linh"));
        list.add(new Student1(4, "Son"));
        
        System.out.println("\nBefort sort:");
        for (Student1 p:list) {
            System.out.println(p.id);
        }
        
        System.out.println("\nAfter sort:");
        Collections.sort(list);
        for (Student1 p:list) {
            System.out.println(p.id + " - " +p.name);
        }
    }
}
