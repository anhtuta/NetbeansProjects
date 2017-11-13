/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author AnhTu
 */
public class ClientPanel extends javax.swing.JPanel {

    JFileChooser chooser;
    String filePath;
    
    /**
     * Creates new form ClientPanel
     */
    public ClientPanel() {
        initComponents();
        chooser = new JFileChooser();
        
    }

    public JButton getBtClear() {
        return btClear;
    }

    public JButton getBtExit() {
        return btExit;
    }

    public JButton getBtSend() {
        return btSend;
    }

    public JTextArea getTaInput() {
        return taInput;
    }
    
    public JTextPane getTpMessage() {
        return tpMessage;
    }

    
    public JList<String> getOnlineList() {
        return onlineList;
    }

    //phương thức này ko hiệu quả lắm
    public void appendMessage2(String msg1, String msg2, Color c1, Color c2) {  //thiết lập 2 loại text khác màu nhau trên 1 dòng
        tpMessage.setEditable(true);
        //chèn msg1 trước:
        int len = tpMessage.getDocument().getLength();
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c1);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Impact"); //  FontFamily: thiết lập font, chú ý font này là kiểu đậm chứ ko phải ta thiết lập cho nó đậm nhé
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);    //vị trí cần chèn text
        tpMessage.setCharacterAttributes(aset, false);  //thiết lập thuộc tính cho text cần chèn
        tpMessage.replaceSelection(msg1);   //chèn text vào vị trí trên
        
        //chèn msg2 ngay sau msg1:
        len = len + msg1.length();
        
        sc = StyleContext.getDefaultStyleContext();
        
        aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c2); 
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Arial"); //  FontFamily: thiết lập font
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);
        tpMessage.setCharacterAttributes(aset, false);
        tpMessage.replaceSelection(msg2+"\n");   //nhớ xuống dòng
        
        len = len + msg2.length();
        tpMessage.setCaretPosition(len);
        tpMessage.setEditable(false);
    }
    
    //phương thức này ko hiệu quả lắm
    public void appendMessage2(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Comic Sans MS"); //  FontFamily: thiết lập font
        
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);     //cái này chưa biết tác dụng làm j
        aset = sc.addAttribute(aset, StyleConstants.FontSize, 14);      //kích thước font
        
        tpMessage.setCaretPosition(len);    //vị trí cần chèn text
        tpMessage.setCharacterAttributes(aset, false);  //thiết lập thuộc tính cho text cần chèn
        tpMessage.replaceSelection(message+"\n");   //chèn text vào vị trí trên
        
    }   
     
    
    public void appendMessage(String msg1, String msg2, Color c1, Color c2) {  //thiết lập 2 loại text khác màu nhau trên 1 dòng
        //chèn msg1 trước:
        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Serif");
        StyleConstants.setBold(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c1);
        
        try {
            doc.insertString(len, msg1, sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //sau đó chèn msg2 ngay sau msg1:
        doc = (StyledDocument) tpMessage.getDocument();
        len = len+msg1.length();
        
        sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Arial");
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, c2);
        
        try {
            doc.insertString(len, msg2+"\n", sas);      //phai xuong dong
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+msg2.length());
    }
    
    public void appendMessage(String message, Color color) {
        int len = tpMessage.getDocument().getLength();
        StyledDocument doc = (StyledDocument) tpMessage.getDocument();
        
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontFamily(sas, "Comic Sans MS");
        StyleConstants.setItalic(sas, true);
        StyleConstants.setFontSize(sas, 14);
        StyleConstants.setForeground(sas, color);
        
        try {
            doc.insertString(len, message+"\n", sas);
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tpMessage.setCaretPosition(len+message.length());
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btExit = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taInput = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpMessage = new javax.swing.JTextPane();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Online");

        btExit.setBackground(new java.awt.Color(255, 102, 102));
        btExit.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btExit.setForeground(new java.awt.Color(255, 102, 102));
        btExit.setText("Exit");

        btClear.setBackground(new java.awt.Color(102, 102, 255));
        btClear.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btClear.setForeground(new java.awt.Color(102, 102, 255));
        btClear.setText("Clear");

        btSend.setBackground(new java.awt.Color(102, 102, 255));
        btSend.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btSend.setForeground(new java.awt.Color(102, 102, 255));
        btSend.setText("Send");

        taInput.setColumns(20);
        taInput.setRows(5);
        jScrollPane3.setViewportView(taInput);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Messages' content");

        onlineList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        onlineList.setForeground(new java.awt.Color(51, 51, 255));
        jScrollPane4.setViewportView(onlineList);

        tpMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tpMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSend, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btSend, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(btExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> onlineList;
    private javax.swing.JTextArea taInput;
    private javax.swing.JTextPane tpMessage;
    // End of variables declaration//GEN-END:variables
}
