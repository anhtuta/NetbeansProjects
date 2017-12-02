/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

/**
 *
 * @author AnhTu
 */
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MessageWithLink extends JEditorPane {
    private static final long serialVersionUID = 1L;

    public MessageWithLink(String htmlBody) {
        super("text/html", "<html><body style=\"" + getStyle() + "\">" + htmlBody + "</body></html>");
        addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                    // Process the click event on the link (for example with java.awt.Desktop.getDesktop().browse())
                    System.out.println(e.getURL()+" was clicked");
                    try {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    } catch (URISyntaxException | IOException ex) {
                        Logger.getLogger(MessageWithLink.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        setEditable(false);
        setBorder(null);
    }

    static StringBuffer getStyle() {
        // for copying style
        JLabel label = new JLabel();
        Font font = label.getFont();
        Color color = label.getBackground();

        // create some css from the label's font
        StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
        style.append("font-weight:").append(font.isBold() ? "bold" : "normal").append(";");
        style.append("font-size:").append(font.getSize()).append("px;");
        style.append("background-color: rgb(").append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue()).append(");");
        return style;
    }
}
