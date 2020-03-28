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

//cái này thực hành lại cho nhớ thôi

public class ConfirmDialog2_Demo extends JFrame {
    private JLabel lb;
    private JButton btn1, btn2;
    
    public ConfirmDialog2_Demo() {
        this.setSize(400, 300);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lb = new JLabel("Thông tin của mày");
        add(lb);
        btn1 = new JButton("Chiều cao");
        add(btn1, "North", 1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int click = JOptionPane.showConfirmDialog(null, "Mày cao trên 1m65 à?", "trả lời đi", JOptionPane.YES_NO_OPTION);
                switch(click) {
                    case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "mày cao vậy. đéo tin", "Nói đối!", JOptionPane.YES_OPTION); break;
                    case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "mày thấp quá. Ha ha!", "Ngu!", JOptionPane.ERROR_MESSAGE); break;
                    case JOptionPane.CLOSED_OPTION : JOptionPane.showMessageDialog(null, "mày muốn thoát", "Bye mày", JOptionPane.NO_OPTION); break;
                }
                
            }
        });
        
        btn2 = new JButton("Cân nặng");
        add(btn2, "South");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int click2 = JOptionPane.showConfirmDialog(null, "Mày nặng 55kg à?", "trả lời đi", JOptionPane.YES_NO_CANCEL_OPTION);
                switch(click2) {
                    case JOptionPane.YES_OPTION : JOptionPane.showMessageDialog(null, "mày quá nhẹ", "Yếu thế", JOptionPane.WARNING_MESSAGE); break;
                    case JOptionPane.NO_OPTION : JOptionPane.showMessageDialog(null, "mày nói dối", "cút", JOptionPane.INFORMATION_MESSAGE); break;
                    case JOptionPane.CANCEL_OPTION : JOptionPane.showMessageDialog(null, "mày vừa ấn cancel", "OK", JOptionPane.WARNING_MESSAGE); break;
                    case JOptionPane.CLOSED_OPTION : JOptionPane.showMessageDialog(null, "mày ẤN close", "đóng lại đi", JOptionPane.INFORMATION_MESSAGE); break;
                    
                }
                    
            }
        });
    }
    
    public static void main(String[] args) {
        ConfirmDialog2_Demo att = new ConfirmDialog2_Demo();
        att.setVisible(true);
    }
}
