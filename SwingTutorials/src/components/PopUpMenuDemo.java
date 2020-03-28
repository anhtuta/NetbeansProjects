/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

/**
 *
 * @author AnhTu
 */
public class PopUpMenuDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pop up Demo");
        frame.setSize(300, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPopupMenu popup = new JPopupMenu("Option"); //tên của pop up menu ko quan trọng vì ko hiển thị
        JMenuItem itcopy = new JMenuItem("Copy"); //itcopy = menuitem copy
        JMenuItem itpaste = new JMenuItem("Paste"); //itcopy = menuitem copy
        JMenuItem itdelete = new JMenuItem("Delete"); //itcopy = menuitem copy
        popup.add(itcopy);        
        popup.add(itpaste);   
        popup.addSeparator();
        popup.add(itdelete);        
                
        JTextArea area = new JTextArea();
        frame.add(area);
        area.setComponentPopupMenu(popup);
        
    }
}
