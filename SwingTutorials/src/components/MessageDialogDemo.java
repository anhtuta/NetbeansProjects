/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class MessageDialogDemo extends JFrame {
    private JLabel lb;
    private JButton btn;
    
    public MessageDialogDemo() {
        this.setSize(400, 250); //đặt kích thước của frame
        setLocation(500, 300); //đặt vị trí của frame
        setResizable(false); //ko kéo thả để thay đổi kích thước của frame đc
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lb = new JLabel("Message Demo");
        add(lb);
        
        btn = new JButton("Hit me!");
        add(btn, "North", 1);
        btn.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent ae) {
                String name = "Anhtu";
                JOptionPane.showMessageDialog(null, "Ho ten: "+name, "Chú ý nè", JOptionPane.QUESTION_MESSAGE);
                System.out.println("Ho ten: "+name);
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        MessageDialogDemo messagedemo = new MessageDialogDemo(); //khởi tạo 1 đối tượng có kiểu dữ liệu MessageDialogDemo
        messagedemo.setVisible(true); //cho phép hiển thị cái frame
    }
    
}
