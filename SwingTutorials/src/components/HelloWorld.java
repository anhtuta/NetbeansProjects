/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author AnhTu
 */
public class HelloWorld extends JFrame {
    public HelloWorld() {
        
        ////////////////////////////////////////////////////////
        this.setSize(200, 150); //chieu dai = 200, chieu rong = 150
        setVisible(true); //hiển thị cái frame lên
        setLocation(500, 300);
        /////3 phương thức này rất quan trọng khi làm việc với frame//////
        
        setResizable(true);   //nếu setResizable(false);  thì ko thể thay đổi kích thước của frame
        JLabel lb = new JLabel("Hello World");   //lb = label
        add(lb); //add lb vào frame và cho hiển thị
    }
    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        //hello.setVisible(true);    //có hàm setVisible ở trên nên ko cần nữa
        
    }
}
