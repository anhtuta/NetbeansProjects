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
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class BookRendererPanel extends JPanel implements ListCellRenderer<Book> {

    private JLabel lbIcon = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbAuthor = new JLabel();

    public BookRendererPanel() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbName);
        panelText.add(lbAuthor);
        add(lbIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book book, int index, boolean isSelected, boolean cellHasFocus) {
        lbIcon.setIcon(new ImageIcon(getClass().getResource("/images/" + book.getIconName() + ".png")));
        lbName.setText(book.getName());
        lbAuthor.setText(book.getAuthor());
        lbAuthor.setForeground(Color.blue);

        // set Opaque to change background color of JLabel
        lbName.setOpaque(true);
        lbAuthor.setOpaque(true);
        lbIcon.setOpaque(true);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbAuthor.setBackground(list.getSelectionBackground());
            lbIcon.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbAuthor.setBackground(list.getBackground());
            lbIcon.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }
        return this;
    }
}
