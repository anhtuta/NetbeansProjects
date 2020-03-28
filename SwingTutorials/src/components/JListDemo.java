/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class JListDemo extends JFrame implements ActionListener {

    private String [] HDH = {"Android", "IOS", "Windows phone"};
    JButton btChangeJList;
    JList mylist;
    
    public JListDemo() {
        super("vi du JList"); //setTitle for this frame
        JPanel p = new JPanel(new FlowLayout());
        
        btChangeJList = new JButton("Change this list");
        btChangeJList.addActionListener(this);
        
        mylist = new JList(HDH);
        
        p.add(mylist);
        p.add(btChangeJList);
        
        add(p);
        
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btChangeJList) {
            //change mylist:
            DefaultListModel model = new DefaultListModel();
            model.addElement("Anh tu");
            model.addElement("K58 bkhn");
            
            mylist.setModel(model);
        }
    }
    
    public static void main(String[] args) {
        new JListDemo().setVisible(true);
    }
    
}
