/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JList_custom_renderer;

/**
 *
 * @author AnhTu
 */
import java.awt.BorderLayout;
 
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
 
public class JListCustomRenderer extends JFrame {
    private int width = 350;
    private int height = 200;
    private JList<Book> listBook;
 
    public JListCustomRenderer() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JScrollPane(listBook = createListBooks()), BorderLayout.CENTER);        // create list book and set to scrollpane and add to panel
        
        
        add(panel);
        setTitle("JLIstCustomRenderer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }
 
    private JList<Book> createListBooks() {
        // create List model
        DefaultListModel<Book> model = new DefaultListModel<>();
        // add item to model
        model.addElement(new Book("C/C++ Programming", "A", "cpp"));
        model.addElement(new Book("Java Programming", "B", "java"));
        model.addElement(new Book("C# Programming", "C", "cs"));
        model.addElement(new Book("IOS Programming", "D", "ios"));
        model.addElement(new Book("Windows Phone Programming", "E", "wp"));
        model.addElement(new Book("Android Programming", "F", "android"));
        
        // create JList with model
        JList<Book> list = new JList<>(model);
        
        list.setCellRenderer(new BookRendererPanel());
        return list;
    }
 
    public static void main(String[] args) {
        new JListCustomRenderer().setVisible(true);
    }
}