/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author AnhTu
 */
public class LabelDemo extends JFrame {
    public LabelDemo() {
       
        this.setSize(200, 150); //chieu dai = 200, chieu rong = 150
        setVisible(true); //hiển thị cái frame lên
        setLocation(500, 300);
        
        setResizable(true);   //nếu setResizable(false);  thì ko thể thay đổi kích thước của frame
        JLabel lb = new JLabel("demo label");   //lb = label
        add(lb); //add lb vào frame và cho hiển thị
        
        lb.setText("viet nam"); //thay thế demo label = viet nam
        lb.setToolTipText("Day la text hien thi khi de chuot len chu");
        lb.setForeground(Color.BLUE);
        
    }
    public static void main(String[] args) {
        LabelDemo lbdemo = new LabelDemo();
    }
}
