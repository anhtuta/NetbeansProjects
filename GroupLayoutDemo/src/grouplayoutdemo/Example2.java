/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouplayoutdemo;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author AnhTu
 */
public class Example2 extends JFrame {
    JButton bt1,bt2,bt3,bt4;
    JPanel panel, panel2;
    
    public Example2() {
        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        bt3 = new JButton("Button 3");
        bt4 = new JButton("Button 4");
        
        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setHorizontalGroup( //cần 2 group theo chiều ngang:
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(bt1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED) //nếu ko related thì có thể dùng .addGap(23, 23, 23), với 23 là 1 khoảng hở giữa bt1 và bt3
                    .addComponent(bt3)
                    .addContainerGap(268, Short.MAX_VALUE)) //nếu ko biết chính xác khoảng hở bên phải = 268 thì thay số đó = GroupLayout.DEFAULT_SIZE
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt2)
                    .addGap(148, 148, 148)
                )
        );
        
        layout.setVerticalGroup( //cần 1 group theo chiều dọc:
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(bt1)
                            .addComponent(bt3))
                        .addGap(55, 55, 55)
                        .addComponent(bt2)
                        .addContainerGap(286, Short.MAX_VALUE))
        );
        
        
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
    }
    
    public static void main(String[] args) {
        new Example2().setVisible(true);
    }
}
