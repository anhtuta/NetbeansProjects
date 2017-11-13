/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.HashMap;

/**
 *
 * @author AnhTu
 */
public class Map {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        
        //cách thêm phần tử: map.put(Object key, Object value);
        //key để phân biệt các phần tử với nhau, giống như khóa trong database
        //value là giá trị cho key tương ứng
        //CHÚ Ý: key ko thể trùng nhau
        //tương tự: lấy phần tử cũng theo key: 
        //map.get(Object key);
        
        map.put("ho ten", "Ta Anh Tu");
        map.put("truong", "DHBK HN");
        map.put("tuoi", new Integer(21));
        map.put(1995, "nam sinh");
        map.put("ho ten", "Anh tu"); //cái này sẽ thay thế cái ho ten ở trên, do key ko thể trùng nhau
        
        System.out.println(map.get("ho ten"));
        System.out.println(map.get(1995));
        System.out.println(map.get("Ha noi")); //ko có key này nên kết quả in ra null
        System.out.println("size map: "+map.size());
        map.remove("truong");
        System.out.println(map.get("truong"));
        
        map.clear();
        System.out.println(map.get("ho ten"));
    }
}
