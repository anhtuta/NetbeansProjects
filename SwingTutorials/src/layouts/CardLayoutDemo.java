/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author AnhTu
 */
public class CardLayoutDemo extends Applet implements ActionListener {
    JPanel p1, p2;
    CardLayout c;
    
    JButton back, next;
    JLabel lb1,lb2,lb3,lb4;
    JTextField tf;
    
    @Override
    public void init() {
        //chú ý back và next là 2 button ở p1
        //p2 là panel ở dưới p1 và có dạng card
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        p1 = new JPanel();
        back = new JButton("back");
        back.addActionListener(this);
        next = new JButton("next");
        next.addActionListener(this);
        p1.add(back); p1.add(next);
        
        c = new CardLayout();
        p2 = new JPanel(c);
        //hoặc dùng cách sau:
        //JPanel p = new JPanel();
        //p.setLayout(new CardLayout());
        
        //tạo 4 panel con trong cardlayout của p
        JPanel first = new JPanel();
        lb1 = new JLabel("this is the first label");
        JButton btn = new JButton("first");
        first.add(btn);
        first.add(lb1);
        
        JPanel second = new JPanel();
        lb2 = new JLabel("this is the second label");
        second.add(lb2);
        
        JPanel third = new JPanel();
        lb3 = new JLabel("this is the third label");
        third.add(lb3);
        
        JPanel fourth = new JPanel();
        lb4 = new JLabel("this is the fourth label");
        fourth.add(lb4);
        ////////////////////////////////////////////
        
        //add them to p2:
        p2.add("1", first);
        p2.add("2", second);
        p2.add("3", third);
        p2.add("4", fourth);
        
        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.CENTER);
        
        add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            c.previous(p2);
        }
        if(ae.getSource() == next) {
            c.next(p2);
        }
    }
}
