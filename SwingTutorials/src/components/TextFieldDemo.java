/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author AnhTu
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldDemo extends JFrame implements ActionListener{
    
    private JTextField tf;
    private JButton btn, btn2;
        
    public TextFieldDemo() {
        this.setSize(400, 300);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tf = new JTextField();
        add(tf, "North");
        
        btn = new JButton("Show dòng chữ ở trên");
        add(btn, "South");
        btn.addActionListener(this);
        
        btn2 = new JButton("Nhấn để hiện dòng chữ: Anhtu quá gầy");
        add(btn2, "West");
        btn2.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if((JButton)ae.getSource() == btn) JOptionPane.showMessageDialog(null,tf.getText());
        else if((JButton)ae.getSource() == btn2) tf.setText("Anhtu quá gầy");
        
    }
    
    public static void main(String[] args) {
        TextFieldDemo tfdemo = new TextFieldDemo();
        tfdemo.setVisible(true); 
    }

}
