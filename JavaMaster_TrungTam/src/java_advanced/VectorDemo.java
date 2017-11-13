/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author AnhTu
 */
//giống hệt Arraylist, linkedlist, chỉ khác là các phương thức của Vector là đồng bộ
public class VectorDemo {
    public static void main(String[] args) {
        Random rd = new Random();
        List<Student> vectorSt = new Vector<>();
        for (int i = 1; i <= 10; i++) {
            vectorSt.add(new Student(rd.nextInt(20), "vector_student"+i));
        }
        for (int i = 0; i < vectorSt.size(); i++) {
            System.out.println(vectorSt.get(i).printStudent());
        }
    }
}
/*
2 - vector_student1
5 - vector_student2
6 - vector_student3
13 - vector_student4
0 - vector_student5
19 - vector_student6
8 - vector_student7
19 - vector_student8
15 - vector_student9
19 - vector_student10

//Nhận xét: các phần tử đc sắp xếp theo thứ tự thêm vào
*/