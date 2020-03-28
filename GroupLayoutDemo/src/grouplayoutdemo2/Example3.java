/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouplayoutdemo2;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author AnhTu
 */
public class Example3 extends JFrame {
    JPanel panel;
                    
    private JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    
    public Example3() {
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();

        bt1.setText("jButton1");
        bt2.setText("jButton2");
        bt3.setText("jButton3");
        bt4.setText("jButton4");
        bt5.setText("jButton5");
        bt6.setText("jButton6");
        
        panel = new JPanel();
        GroupLayout glo = new GroupLayout(panel);
        panel.setLayout(glo);
        
        glo.setHorizontalGroup(
            glo.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(glo.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bt1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap(260, Short.MAX_VALUE)
            )
            .addGroup(glo.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(bt2, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt3, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap(45, Short.MAX_VALUE)
            )
            .addGroup(glo.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(bt4, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt5, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)    
                .addComponent(bt6, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap(45, Short.MAX_VALUE)
            )
        );
        
        glo.setVerticalGroup(
            glo.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(glo.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bt1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(glo.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bt2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(3, 3, 3)
                .addGroup(glo.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bt4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
            .addContainerGap(100, Short.MAX_VALUE)
            )
        );
        
        setSize(400, 300);
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Example3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Example3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Example3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Example3.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                new Example3().setVisible(true);
            }
        });
        
    }
}
