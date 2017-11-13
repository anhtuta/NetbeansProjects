/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author AnhTu
 */
public class Printer {
    private static Printer instance;
    
    private Printer() {
        System.out.println("Bạn vừa khởi tạo 1 đối tượng Printer");
    }

    public static Printer getInstance() {
        if(instance == null) {
            instance = new Printer();
        }
        //nếu instance != null, nghĩa là đã có 1 lần dùng hàm này rồi,
        //nghĩa là ở đâu đó đã khởi tạo 1 đối tượng thuộc lớp Printer này rồi
        //thì sẽ ko đc tạo thêm 1 đối tượng nào thuộc kiểu Printer này nữa
        //Nghĩa là class này chỉ cho tạo 1 đối tượng duy nhất thôi
        return instance;
    }
    
    public void connect() {
        System.out.println("connected");
    }
}

class Employee {
    public void print() {
        
    }
    public static void main(String[] args) {
        Printer p = Printer.getInstance();
        p.connect();
        
        Printer p2 = Printer.getInstance();
        p2.connect();
    }
}
