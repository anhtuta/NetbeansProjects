/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author AnhTu
 */
public class GenericClass<T> {
    private T t;
    
    public void add(T t) {
        this.t=t;
    }

    public T getT() {
        return t;
    }
    
    public static void main(String[] args) {
        GenericClass<Integer> intNum=new GenericClass();
        GenericClass<Float> floatNum=new GenericClass();
        GenericClass<String> str=new GenericClass();
        GenericClass<Student> dssv=new GenericClass(); //dssv này chỉ chứa đc 1 sinh viên thôi, vì do class GenericClass định nghĩa phương thức add thì khi add sẽ xóa cái cũ và thay thế = cái mới
        
        intNum.add(7);  //thằng này ko thể add số thực đc, vi dụ: intNum.add(7.3); là sai
        floatNum.add(9.3f);
        str.add("Anhtu");
        dssv.add(new Student(1001, "anhtu"));
        dssv.add(new Student(1002, "att"));
        
        System.out.println(intNum.getT());
        System.out.println(floatNum.getT());
        System.out.println(str.getT());
        System.out.println(dssv.getT().id + " - " + dssv.getT().name);
    }
}
