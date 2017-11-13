/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AnhTu
 */
//Generics
//Nói cho bộ dịch biết kiểu dữ liệu của tập hợp
//Bộ dịch sẽ biết cần phải ép kiểu thế nào
//Tránh trong quá trình chạy (runtime) Java ném ra điều không mong đợi vì sai xót trong việc ép kiểu (ClassCastException).


//Iterator - biến lặp
//Khái niệm: Cung cấp một cách để truy xuất các thành phần của một đối tượng hợp nhất một cách tuần tự 
//Khái niệm: Cung cấp một cách để truy xuất các thành phần của một đối tượng hợp nhất một cách tuần tự
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<A> al = new ArrayList<A>(); //ép kiểu cho al chỉ thuộc loại A
        al.add(new A());
        al.add(new A());
        for (int i = 0; i < al.size(); i++) {
            al.get(i).show(); //nếu dùng ArrayList<A> al = new ArrayList<A>(); thì ko thể xài lệnh này đc
            //vì al.get(i) ko thuộc kiểu A
        }
        
        HashMap<String, B> map = new HashMap<String, B>(); //haspmap quản lí theo key và value nên cần 2 đối tượng
        map.put("anhtu", new B());
        map.put("key2", new B());
        map.get("anhtu").go();
        //map.put(new Integer(3), new B()); ;lỗi
        
    }
}

class A {
    void show() {
        System.out.println("call show() in class A");
    }
}

class B {
    void go() {
        System.out.println("call go() in class B");
    }
}
