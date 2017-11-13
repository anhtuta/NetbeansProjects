/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class ExceptionDemo {
    public static float divide(int n1, int n2) throws ArithmeticException { //(1)
        //if(n2==0) throw new ArithmeticException("Ko the chia cho 0!"); //(2)
        return n1/n2;
    }
    
    public static void myMethod(String name, int age) throws NullPointerException, ArithmeticException { //(4)
        if(name==null) throw new NullPointerException("Thieu ten!");
        if(age<18) throw new ArithmeticException("Chua du tuoi!");
        System.out.println(name+" - "+age);
    }
    
    public static void myException() throws Exception {  //bắt buộc phải có throws vì cái này là lớp Exception
        throw new Exception("my new Exception");
    }
    
    public static void myException2()  {  //ko cần throws cũng ko sao
        throw new ArrayIndexOutOfBoundsException("Lỗi, khi gọi hàm này cần đặt nó trong khối try catch");
    }
    
    public static void main(String[] args) {
        //example 1:
        try { //(3)
            float a = divide(9,0);
            System.out.println("a = "+a);
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        
        //example 2:
        try {  //(5)
            myMethod("anhtu", 15);
        } catch (NullPointerException n){
            System.out.println("Thieu ten");
        } catch (ArithmeticException a) {
            System.out.println("Chua du tuoi");
        }
        
        try {
            myException();
        } catch (Exception ex) {
            System.out.println("lỗi");
        }
        
        myException2();
        
    }
}

//Throws là ném ra 1 ngoại lệ, và đặt ở phần khai báo tên phương thức
//hàm divide ném ra 1 ngoại lệ, khi đối tượng khác gọi nó thì phải dùng try catch để bắt ngoại lệ đó
//nếu ko có try catch khi gọi nó thì sẽ xảy ra ngoại lệ và chương trình ko thể chạy hết đc
//throws để thông báo rằng hàm divide có thể có ngoại lệ ArithmeticException, do đó có thể bỏ dòng  throws ArithmeticException đi vẫn đc

//Throw: để ném ra 1 ngoại lệ tự định nghĩa, tức là ngoại lệ mà người lập trình cho rằng đó là ngoại lệ
//nhưng máy thì ko cho đó là ngoại lệ
//throw đặt ở trong thân hàm

//ví dụ: ở (1) nếu ko có throws ArithmeticException thì ko sao, tác dụng của phần ý chỉ thông báo rằng
//hàm divide có thể xảy ra ngoại lệ ArithmeticException. do đó ở hàm main cần khối try catch (3) để bắt ngoại lệ đó
//nếu ko bắt thì chương trình lỗi và ko chạy tiếp đc
//tác dụng của (2): nếu ko có khối try catch (3) thì khi chạy máy sẽ in ra lỗi (chứ ko phải in ra ngoại lệ nhé!)
//in ra lỗi này: Exception in thread "main" java.lang.ArithmeticException: Ko the chia cho 0!
//và sau đó chương trình bị dừng
//nếu ko có cả (2) và (3) thì in ra LỖI này: Exception in thread "main" java.lang.ArithmeticException: / by zero, và chương trình bị dừng
//nếu có (3) thì chương trình in ra thông báo: java.lang.ArithmeticException: / by zero, và chương trình lại chạy tiếp như thường
//vậy nếu có (3) thì (2) chả có tác dụng. (2) chỉ có tác dụng khi (3) ko có, khi đó máy sẽ in ra lỗi như (2) yêu cầu


//ví dụ 2: dòng throws ở (4) chỉ để thông báo là hàm này có thể xảy ra các ngoại lệ đó, yêu cầu đứa nào gọi hàm này
//phải dùng try catch, với 2 khối catch để bắt 2 ngoại lệ đó, và ở (5) đã làm như vậy

//tóm lại: throws là thông báo có ngoại lệ và throw chỉ quăng ra lỗi thôi
//khi có throws thì yêu cầu cần có try catch để bắt các ngoại lệ đó, nếu ko chương trình xảy ra lỗi và ko chạy tiếp đc