/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

/**
 *
 * @author AnhTu
 */
public class CompareObject_Person {
    String name;
    int id;

    @Override
    public boolean equals(Object ob) {
        boolean b=false;
        if(ob instanceof CompareObject_Person) {
            CompareObject_Person p1 = (CompareObject_Person)ob;
            if((this.id == p1.id) && (this.name.equals(p1.name))) b= true;
        }
        
        return b;
    }
    
    public CompareObject_Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Main {
    
    public static void main(String[] args) {
        CompareObject_Person p1 = new CompareObject_Person("A", 1);
        CompareObject_Person p2 = new CompareObject_Person("A", 1);
        //2 đối tượng p1 và p2 trỏ đến 2 vùng nhớ khác nhau trong bộ nhớ Heap
        //do đó địa chỉ bộ nhớ của chúng khác nhau, do đó 2 đối tượng đó độc lập với nhau
        //nghĩa là p1==p2: false

        System.out.println(p1.equals(p2)); //nếu ko override hàm equals thì cái này luôn trả về false
        System.out.println(p1==p2);
        
        String s1=new String("anhtu");
        String s2=new String("anhtu");
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        
        Object o1="anhtu";
        Object o2="anhtu";
        System.out.println(o1.equals(o2));
        System.out.println(o1==o2);
        
        int a=6;
        int b=6;
        System.out.println(a==b);
    }
}