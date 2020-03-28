/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTu
 */
public class ButtonDemo2 extends JFrame implements ActionListener {

    private JButton btn1, btn2, btn3; 
    private JTable table;
    private String [] titleColumn = {"STT", "Họ Tên", "Địa chỉ", "Số điện thoại"};
    
    public ButtonDemo2() {
        JPanel panel = new JPanel(new BorderLayout());
        
        /////////panel1//////////////////////////////////////////
        JPanel panel1 = new JPanel();
        btn1 = new JButton("Halloween");
        btn1.addActionListener(this);
        panel1.add(btn1);
        
        btn2 = new JButton("anhtu");
        btn2.addActionListener(this);
        panel1.add(btn2); //btn1 và btn2 lần lượt đc xếp vào panel1
        
        panel.add(panel1, BorderLayout.PAGE_START);
        /////////panel1//////////////////////////////////////////
        
        /////////panel2//////////////////////////////////////////
        JPanel panel2 = new JPanel();
        btn3 = new JButton("That's shit!");
        btn3.addActionListener(this);
        panel2.add(btn3);
        panel.add(panel2, BorderLayout.PAGE_END);
        /////////panel2//////////////////////////////////////////
        
        JPanel panel3 = new JPanel();
        table = new JTable();
        panel3.add(new JScrollPane(table));
        
        
        panel.add(panel3, BorderLayout.CENTER);
        
        add(panel);
        
        showDataInTable();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }
    
    public void showDataInTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(titleColumn);
        
        Object [] column = new Object[4];
        
        for (int i = 0; i < 10; i++) {
            column[0] = i+1;
            column[1] = "Tạ Văn "+(i+1);
            column[2] = "Hà nội "+(i+1);
            column[3] = "0123456780"+(i+1);
            
            model.addRow(column);
        }
        
        table.setModel(model);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn1) JOptionPane.showMessageDialog(null, "Happy Halloween");
        if(ae.getSource() == btn2) JOptionPane.showMessageDialog(null, "Hello anhtu");
        if(ae.getSource() == btn3) JOptionPane.showMessageDialog(null, "That's shit. I woke up at 3:30 in the morning");
    }
    
    public static void main(String[] args) {
        ButtonDemo2 bd2 = new ButtonDemo2();
        bd2.setVisible(true);
    }
}
