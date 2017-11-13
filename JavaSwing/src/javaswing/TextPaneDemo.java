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
import java.awt.Color;
/*from w  w w .  j a  v  a 2  s .  co m*/
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TextPaneDemo {
  public static void main(String[] args) {
    JFrame f = new JFrame();
    StyleContext sc = new StyleContext();
    final DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane pane = new JTextPane(doc);

    final Style heading2Style = sc.addStyle("Heading2", null);
    heading2Style.addAttribute(StyleConstants.Foreground, Color.red);
    heading2Style.addAttribute(StyleConstants.FontSize, new Integer(16));
    heading2Style.addAttribute(StyleConstants.FontFamily, "serif");
    heading2Style.addAttribute(StyleConstants.Bold, new Boolean(true));

    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          try {
            doc.insertString(0, text, null);

            doc.setParagraphAttributes(0, 1, heading2Style, false);
          } catch (BadLocationException e) {
          }
        }
      });
    } catch (Exception e) {
      System.out.println("Exception when constructing document: " + e);
      System.exit(1);
    }

    f.getContentPane().add(new JScrollPane(pane));
    f.setSize(400, 300);
    f.setVisible(true);
  }

  public static final String text = "Attributes, Styles and Style Contexts\n"
      + "this is a test.\n";

}