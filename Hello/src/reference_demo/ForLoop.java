/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference_demo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class ForLoop {
    public static void main(String[] args) {
        List<Student> stList = new ArrayList<>();
        
        Student st = new Student();
        for (int i = 0; i < 5; i++) {
            st.setName("Anhtu"+i);
            st.setAge(20+i);
            stList.add(st);
        }
        System.out.println("stList = ");
        for(Student stInList : stList) {
            stInList.showInfo();
        }
        //Nhận xét: trong cả 5 vòng lặp, stList đều thêm biến st, mà st vẫn chỉ tham chiếu tới 1 đối tượng duy nhất, 
        //nên sau mỗi vòng lặp đối tượng đó đều thay đổi, dẫn tới st cũng thay đổi theo
        //mà stList chỉ chứa 5 thằng st giống hệt nhau nên 5 phần tử trong stList có giá trị = giá trị cuối
        //cùng mà st đc thay đổi
        
        //ta làm cách khác:
        List<Student> stList2 = new ArrayList<>();
        
        Student st2;
        for (int i = 0; i < 5; i++) {
            st2 = new Student();
            st2.setName("Anhtu"+i);
            st2.setAge(20+i);
            //st2 = new Student("Anhtu"+i, (20+i));
            stList2.add(st2);
        }
        System.out.println("stList2 = ");
        for(Student stInList : stList2) {
            stInList.showInfo();
        }
        //Trường hợp trên, stList2 chứa 5 thằng st2, mỗi thằng st2 tham chiếu tới 1 đối tượng khác nhau
        //do đó stList2 chứa 5 thằng st2 tham chiếu đến 5 đối tượng khác nhau
        
        //KẾT LUẬN: Nếu muốn thêm các giá trị khác nhau cho list trong vòng for thì mỗi vòng cần khởi tạo 
        //đối tượng mới rồi mới đc add vào list
    }
}
