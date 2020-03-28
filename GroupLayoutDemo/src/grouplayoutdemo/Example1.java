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
import javax.swing.WindowConstants;

/**
 *
 * @author AnhTu
 */
public class Example1 extends JFrame {

    JPanel panel;
    JButton bt1,bt2,bt3,bt4;
    
    public Example1() {
        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        bt3 = new JButton("Button 3");
        bt4 = new JButton("Button 4");
        
        ///First, we create a new GroupLayout object and associate it with the panel:
        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        //specify automatic gap insertion:
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
//        Then, we define the groups and add the components. We establish a root group for each dimension using the
//        setHorizontalGroup and setVerticalGroup methods. Groups are created via
//        createSequentialGroup and createParallelGroup methods. Components are added to groups by using
//        the addComponent method:
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(bt1)
                .addComponent(bt2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
                    .addComponent(bt3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bt1)
                    .addComponent(bt2)
                    .addComponent(bt3))
                .addComponent(bt4)
        );
        
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        
    }
    
    public static void main(String[] args) {
        new Example1().setVisible(true);
    }
    
}
