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
public class ConfirmDialogDemo extends JFrame {
    private JLabel lb;
    private JButton btn, btn2, btn3;
    
    public ConfirmDialogDemo() {
        this.setSize(400, 250);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lb = new JLabel("confirm demo");
        add(lb);
        btn = new JButton("Ho ten");
        add(btn, "North", 1);
        //tạo action cho btn, nếu ko tạo thì khi click vào btn nó chả làm cái j cả
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int click = JOptionPane.showConfirmDialog(null, "May la Anhtu a?");
                switch(click) {
                    case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "Vậy mày chính là Anhtu rồi"); break;
                    case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "Mày đéo phải là Anhtu"); break; 
                    case JOptionPane.CANCEL_OPTION : JOptionPane.showMessageDialog(null, "Mày ko muốn trả lời câu hỏi này vì mày vừa click Cancel"); break;
                    case JOptionPane.CLOSED_OPTION : JOptionPane.showMessageDialog(null, "Mày vừa ấn nút thoát"); break;   
                } 
            }
        });
        
        btn2 = new JButton("Trường");
        add(btn2, "South", 1);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int click2 = JOptionPane.showConfirmDialog(null, "Mày học ở bkhn à?", "Trả lời câu hỏi sau:", JOptionPane.YES_NO_OPTION);
                switch(click2) {
                    case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "vậy mày học cùng trường với tao"); break;
                    case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "mày đéo phải sinh viên BK"); break; 
                    case JOptionPane.CLOSED_OPTION : JOptionPane.showMessageDialog(null, "Mày vừa ấn nút đóng"); break;   
                } 
            }
        });
        
        btn3 = new JButton("Địa chỉ");
        add(btn3,"West");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int click3 = JOptionPane.showConfirmDialog(null, "Mày ở Hà Nội à", "Trả lời mau!", JOptionPane.YES_OPTION);
                switch(click3) {
                    case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "vậy mày ở hanoi"); break;
                    case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "mày đéo phải người hanoi"); break; 
                    case JOptionPane.CLOSED_OPTION : JOptionPane.showMessageDialog(null, "Mày vừa ấn nút đóng"); break;   
                } 
            }
        });
    }
    
    public static void main(String[] args) {
        ConfirmDialogDemo cfd = new ConfirmDialogDemo();
        cfd.setVisible(true);
    }
}
