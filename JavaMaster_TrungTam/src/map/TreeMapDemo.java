/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author AnhTu
 */
//TreeMap khác HashMap ở chỗ: các phần tử thêm vào đc sắp xếp theo thứ tự tăng dần của key, giống như khi thêm phần tử vào BinarySearchTree, AVL,...

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, Person> treeMap = new TreeMap<>();     //TreeMap: các phần tử sắp xếp theo chiều tăng của key
        
        treeMap.put(3, new Person(1, "anhtu"));
        treeMap.put(1, new Person(10, "nam"));
        treeMap.put(7, new Person(5, "trung"));
        treeMap.put(2, new Person(9, "nguyen"));
        treeMap.put(6, new Person(12, "toan"));
        treeMap.put(2, new Person(3, "att"));
        treeMap.put(4, new Person(6, "huy"));
        treeMap.put(4, new Person(11, "nam"));  //thêm phần tử có key=4 sẽ thay thế value trước đó
        treeMap.put(4, new Person(16, "huy"));  //thêm phần tử có key=4 sẽ thay thế value trước đó
        
        for(Map.Entry<Integer, Person> entrySet : treeMap.entrySet()) {
            System.out.println(entrySet.getKey()+": "+entrySet.getValue().getInfo());
        }
    }
}
/*
1: 10 - nam
2: 3 - att
3: 1 - anhtu
4: 16 - huy
6: 12 - toan
7: 5 - trung
*/