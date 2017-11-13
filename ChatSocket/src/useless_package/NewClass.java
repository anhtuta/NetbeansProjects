/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useless_package;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author AnhTu
 */
public class NewClass extends JFrame {
    JTextArea ta;
    
    public NewClass() {
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane();
        ta = new JTextArea();
        ta.setPreferredSize(new Dimension(200, 200));
        scroll.setViewportView(ta);
        
        panel.add(scroll, BorderLayout.NORTH);

        add(scroll);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ta.append("\nthis is a demo");
        ta.append("\nthis is a demo");
        ta.append("\nthis is a demo");
        ta.append("\nthis is a demo");
        ta.append("\nthis is a demo");
        
    }
    
    public static void main(String[] args) {
        new NewClass();
        String str = "dai hoc bach khoa";
        String str2 = str.substring(4, str.length());
        System.out.println(str2);
        str2 = str2.substring(1, str2.length());
        System.out.println(str2);
        
        String str3 = "CMD_PRIVATECHAT|Anh tu|huy|hom nay khoe ko?";
        StringTokenizer tokenizer = new StringTokenizer(str3, "|");
        String cmd = tokenizer.nextToken();
        String sender = tokenizer.nextToken();
        String receiver = tokenizer.nextToken();
        String message = str3.substring(cmd.length()+sender.length()+receiver.length()+3, str3.length());
        System.out.println("message = "+message);
        
        System.out.println(System.getProperty("user.dir"));
    }
}
