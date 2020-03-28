/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouplayoutdemo2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AnhTu
 */
public class Example2 extends JFrame {
    private JButton btAddr;
    private JButton btName;
    private JButton btAge;
    private JLabel lbInfo;
    private JTextField tfAddr;
    private JTextField tfName;
    private JTextField tfAge;
    
    private JPanel panel;
    
    public Example2() {
        btName = new javax.swing.JButton("Name");
        btAge = new javax.swing.JButton("Age");
        tfName = new javax.swing.JTextField();
        tfAge = new javax.swing.JTextField();
        btAddr = new javax.swing.JButton("Address");
        tfAddr = new javax.swing.JTextField();
        lbInfo = new javax.swing.JLabel("INFO SINH VIEN");
        
        btName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btNameActionPerformed(ae);
            }
        });
        
        lbInfo.setFont(new Font("Comic Sans MS", 0, 18));

        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup() //gồm gap và lbInfo
                .addGap(80, 80, 80)
                .addComponent(lbInfo)
            )
            .addGroup(layout.createSequentialGroup() //gồm gap, 3 button, và 3tf
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //gồm 3 button
                        // CHÚ Ý: addComponent(btName, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE) LÀ BỊ SAI, KÍCH THƯỚC BUTTON SẼ NHỎ VÀ KHÁC 75
                    .addComponent(btName, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE) 
                    .addComponent(btAge, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddr, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)    
                )
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //gồm 3 tf
                        //chú ý: addComponent(tfName, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE) LÀ BỊ SAI, KÍCH THƯỚC KO = 130
                    .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(tfAge, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(tfAddr, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //thử thay GroupLayout.DEFAULT_SIZE = số cụ thể cũng đc
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup() //gồm tất cả các thành phần, nghĩa là setVerticalGroup gồm 1 group lớn này. trong group lớn này có thể có các group nhỏ hơn
                .addGap(40, 40, 40)
                .addComponent(lbInfo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                //chú ý là phần setHorizontalGroup ta đã chọn 2 nhóm: 1 nhóm có 3 button và 1 nhóm có 3 tf. bây giờ ta sẽ chọn 3 nhóm: mỗi nhóm có 1 button và 1 tf
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE) //nếu dùng: addComponent(btName) có nghĩa là: theo trục dọc thì kích thước của các button để mặc định
                    .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btAge, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE) 
                    .addComponent(tfAge, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btAddr, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddr, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            )
        );
        
        
        add(panel);
        setSize(450, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void btNameActionPerformed(java.awt.event.ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "Name is: "+tfName.getText());
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Example2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Example2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Example2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Example2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //write main program here...
                new Example2().setVisible(true);
            }
        });
        
    }
}
