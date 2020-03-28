/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import static java.awt.PageAttributes.MediaType.A;
import static javafx.scene.input.KeyCode.R;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static jdk.nashorn.internal.runtime.JSType.NULL;

/**
 *
 * @author AnhTu
 */
//1 project khác sử dụng nul layout là: PaintDemo2
//có thể mở xem. khá hay
//Null:
//*This indicates no Layout. Items must be manually positioned and arranged.
//This layout should only be used if the window will not and cannot be resized, as the item in the window will stay where they are placed, be that hidden or clumped in one corner of a window.
//
//This Layout is simple to use, but it is not all that professional, so be careful where you use it.

//CHÚ Ý: ko thể đặt 1 layout dạng null lên 1 layout khác. Đã thử và ko hiển thị đc!
public class NullLayoutDemo extends JFrame {

    public NullLayoutDemo(String name) {
        super(name);

        JTextField newItemField;
        JList itemsList;
        JButton addButton;
        JButton removeButton;

        getContentPane().setLayout(null);

//The text field
        newItemField = new JTextField();
        newItemField.setLocation(12, 12);
        newItemField.setSize(150, 30);
        getContentPane().add(newItemField);

//The Add button
        addButton = new JButton("Add");
        addButton.setMnemonic('A');
        addButton.setLocation(174, 12);
        addButton.setSize(100, 30);
        getContentPane().add(addButton);

//The List
        itemsList = new JList();
        JScrollPane scrollPane = new JScrollPane(itemsList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setLocation(12, 45);
        scrollPane.setSize(150, 150);
        getContentPane().add(scrollPane);

//The Remove button
        removeButton = new JButton("Remove");
        removeButton.setMnemonic('R');
        removeButton.setLocation(174, 45);
        removeButton.setSize(100, 30);
        getContentPane().add(removeButton);
    }

    public static void main(String[] args) {
        JFrame frame = new NullLayoutDemo("NULL Example");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(286, 230);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
