/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author tungt
 */
public class MoveTo extends javax.swing.JPanel {

    private BufferedImage image;

    /**
     * Creates new form MoveTo
     */
    public MoveTo() {
        initComponents();
        this.setSize(1100, 650);
        try {
            image = ImageIO.read(new File("src/res/sd.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1100, 650, this);
    }

    void resetColor() {
        jLabel107.setBackground(new java.awt.Color(0, 0, 153));
        jLabel109.setBackground(new java.awt.Color(0, 0, 153));
        jLabel108.setBackground(new java.awt.Color(0, 0, 153));
    }

    public JLabel get109() {
        return r109;
    }

    public JLabel get107() {
        return r107;
    }

    public JLabel get108() {
        return r108;
    }

    public JLabel getBack() {
        return back;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        r109 = new javax.swing.JLabel();
        r108 = new javax.swing.JLabel();
        r107 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        r109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/door.png"))); // NOI18N
        r109.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                r109MouseMoved(evt);
            }
        });

        r108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/door.png"))); // NOI18N
        r108.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                r108MouseMoved(evt);
            }
        });

        r107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/door.png"))); // NOI18N
        r107.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                r107MouseMoved(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/back.png"))); // NOI18N

        jLabel107.setBackground(new java.awt.Color(0, 0, 153));
        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("107");
        jLabel107.setOpaque(true);

        jLabel108.setBackground(new java.awt.Color(0, 0, 153));
        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("108");
        jLabel108.setOpaque(true);

        jLabel109.setBackground(new java.awt.Color(0, 0, 153));
        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("109");
        jLabel109.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(r109)
                                .addGap(18, 18, 18)
                                .addComponent(r108)
                                .addGap(18, 18, 18)
                                .addComponent(r107))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel109)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel108)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel107)))))
                .addContainerGap(681, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel107, jLabel108, jLabel109});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel108)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r108)
                    .addComponent(r109)
                    .addComponent(r107))
                .addGap(53, 53, 53))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel107, jLabel108, jLabel109});

    }// </editor-fold>//GEN-END:initComponents

    private void r109MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r109MouseMoved
        // TODO add your handling code here:
        jLabel109.setBackground(new java.awt.Color(0, 0, 51));
    }//GEN-LAST:event_r109MouseMoved

    private void r108MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r108MouseMoved
        // TODO add your handling code here:
        jLabel108.setBackground(new java.awt.Color(0, 0, 51));
    }//GEN-LAST:event_r108MouseMoved

    private void r107MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r107MouseMoved
        // TODO add your handling code here:
        jLabel107.setBackground(new java.awt.Color(0, 0, 51));
    }//GEN-LAST:event_r107MouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        resetColor();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel r107;
    private javax.swing.JLabel r108;
    private javax.swing.JLabel r109;
    // End of variables declaration//GEN-END:variables

}
