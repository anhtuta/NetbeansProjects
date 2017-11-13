/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference_demo;

/**
 *
 * @author AnhTu
 */
public class PassByValue {
    public static void main(String[] args) {
        int a = 5;
        int b = a, c = a;
        System.out.println("before modify a:");
        System.out.println("a, b, c = "+a+b+c); //a, b, c = 555
        
        a = 7;
        System.out.println("after modify a:");
        System.out.println("a, b, c = "+a+b+c); //a, b, c = 755
        
        /////////////
        Student st1 = new Student("Anhtu", 23);
        Student st2 = st1;
        System.out.println("\nbefore modify st1:");
        st1.showInfo(); //Anhtu - 23
        st2.showInfo(); //Anhtu - 23
        
        st1.setName("Trung");
        st1.setAge(33);
        
        System.out.println("after modify st1:");
        st1.showInfo(); //Trung - 33
        st2.showInfo(); //Trung - 33
        //nghĩa là khi thay đổi st1 thì st2 cũng thay đôi theo vì cả 2 thằng đều tham chiếu tới 1 đối tượng
        
        st1 = new Student("Nguyen", 29);
        System.out.println("after create new st1:");
        st1.showInfo(); //Nguyen - 29
        st2.showInfo(); //Trung - 33
        //nghĩa là bây giờ thằng st1 tham chiếu tới 1 đối tượng mới, và st2 cũng tham chiếu tới 1 đối tượng khác
        
    }
}
