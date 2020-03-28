/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced_swing;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author AnhTu
 */
public class SimpleTree {
    public static void main(String[] args) {
        JFrame fr = new SimpleTreeFrame();
        fr.setDefaultCloseOperation(3);
        fr.setVisible(true);
    }
}

class SimpleTreeFrame extends JFrame {
    public SimpleTreeFrame() {
        setTitle("Content of advanced Java Programming");
        setSize(300, 300);
        setDefaultCloseOperation(3);
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Java programming");
        
        DefaultMutableTreeNode chapter1 = new DefaultMutableTreeNode("Multithreading");
        root.add(chapter1);
        
        DefaultMutableTreeNode title1 = new DefaultMutableTreeNode("What are threads?");
        chapter1.add(title1);
        DefaultMutableTreeNode title2 = new DefaultMutableTreeNode("Thread properties");
        chapter1.add(title2);
        
        DefaultMutableTreeNode ch2 = new DefaultMutableTreeNode("networking");
        root.add(ch2);
        
        DefaultMutableTreeNode title3 = new DefaultMutableTreeNode("connect to server");
        ch2.add(title3);
        DefaultMutableTreeNode title4 = new DefaultMutableTreeNode("sending email");
        ch2.add(title4);
        
        //tạo 1 cây và cho nó vào thanh trượt:
        JTree tree = new JTree(root);
        Container c = getContentPane();
        c.add(new JScrollPane(tree));
        
    }
}
