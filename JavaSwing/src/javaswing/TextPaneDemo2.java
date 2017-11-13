/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

/**
 *
 * @author AnhTu
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
/*from  w ww.j  a va2s  .c om*/
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TextPaneDemo2 {
  public static void main(String args[]) throws BadLocationException {
    JFrame jf = new JFrame("StyledText");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = jf.getContentPane();

    JTextPane pane = new JTextPane();
    SimpleAttributeSet set = new SimpleAttributeSet();
    StyleConstants.setBold(set, true);

    // Set the attributes before adding text
    pane.setCharacterAttributes(set, true);
    pane.setText("java2s.com ");

    set = new SimpleAttributeSet();
    StyleConstants.setItalic(set, true);
    StyleConstants.setForeground(set, Color.red);
    StyleConstants.setBackground(set, Color.blue);

    Document doc = pane.getStyledDocument();
    doc.insertString(doc.getLength(), "Swing ", set);

    set = new SimpleAttributeSet();
    StyleConstants.setFontSize(set, 24);

    doc.insertString(doc.getLength(), "Tutorial", set);

    JScrollPane scrollPane = new JScrollPane(pane);
    cp.add(scrollPane, BorderLayout.CENTER);

    jf.setSize(400, 300);
    jf.setVisible(true);
  }
}