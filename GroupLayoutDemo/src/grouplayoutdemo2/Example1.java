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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author anhtu
 */
public class Example1 extends JFrame {
    private JPanel panel;
    private JButton btCancel;
    private JButton btOK;
    private JLabel lbLogin;
    private JLabel lbName;
    private JLabel lbPW;
    private JTextField tfName;
    private JPasswordField tfPW;
    
    public Example1() {
        panel = new javax.swing.JPanel();
        lbLogin = new javax.swing.JLabel("Login");
        lbName = new javax.swing.JLabel("username");
        lbPW = new javax.swing.JLabel("password");
        tfName = new javax.swing.JTextField();
        tfPW = new javax.swing.JPasswordField();
        btOK = new javax.swing.JButton("OK");
        btOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btOKActionPerformed(ae);
            }
        });
        btCancel = new javax.swing.JButton("Cancel");
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btCancelActionPerformed(ae);
            }
        });
        
        lbLogin.setFont(new Font("Comic Sans MS", 0, 18));
        
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING) //do tạo group song song nên thêm các phần tử sẽ song song với nhau và ko phải thêm gap giữa các phần tử
            //vì xếp song song 3 phần tử dưới đây theo chiều ngang    
            .addGroup(layout.createSequentialGroup() //contains: a gap and lbLogin
                .addGap(87, 87, 87)
                .addComponent(lbLogin)
            )
            .addGroup(layout.createSequentialGroup() //contains: a gap and 2 lb, 2 tf
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //this group contains: 2 lb and 2 tf
                    .addGroup(layout.createSequentialGroup() //contains: lbName and tfName
                        .addComponent(lbName, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE) //73 is the the lbName's length, because we are setting HorizontalGroup, so 73 is the length: 73 là chiều dài theo chiều ngang, nghĩa là chiều dài
                        .addGap(5, 5, 5)
                        .addComponent(tfName, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPW, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(tfPW, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    )
                )
                .addContainerGap(99, Short.MAX_VALUE)
            )
            .addGroup(layout.createSequentialGroup() //contains: a gap and 2 buttons
                .addGap(105, 105, 105)
                .addComponent(btOK, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING) //dưới đây chỉ có 1 phần tử xếp song song, đó là 1 group chứa tất cả các thành phần
                //trong group này các thành phần đc xếp 1 cách lần lượt, do đó phải có khoảng gap
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lbLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE) //35 is the width, because we are setting VerticalGroup, do đó 35 là chiều dài theo chiều dọc, nghĩa là chiều rộng
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE) //2 cái này kích thước như nhau nếu chiếu lên trục Oy, là trục vertical
                )
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbPW, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPW, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btOK)
                    .addComponent(btCancel)
                )
            .addContainerGap(43, Short.MAX_VALUE)
            )
            
        );
        
        
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 350);
    }
    
    private void btOKActionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "Wrong username or password");
    }
    
    private void btCancelActionPerformed(ActionEvent ae) {
        
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Example1.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Example1().setVisible(true);
            }
        });
        
    }
    
}
