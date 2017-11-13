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
public class Phong extends javax.swing.JPanel {

    private BufferedImage image;
    PhongTroFrame ptf = new PhongTroFrame();

    /**
     * Creates new form Phong
     */
    public Phong() {
        initComponents();
        this.setSize(1100, 650);
        try {
            image = ImageIO.read(new File("src/res/room.png"));
        } catch (Exception e) {
            System.out.println("Can't find image");
        }
        reset();
    }

    void reset() {
        jLabel_name1.setText(" Click để thêm sinh viên ");
        jLabel_name2.setText(" Click để thêm sinh viên ");
        jLabel_name3.setText(" Click để thêm sinh viên ");
        jLabel_name4.setText(" Click để thêm sinh viên ");
        jLabel_name5.setText(" Click để thêm sinh viên ");
        jLabel_name6.setText(" Click để thêm sinh viên ");
        jLabel_name7.setText(" Click để thêm sinh viên ");
        jLabel_name8.setText(" Click để thêm sinh viên ");
        jLabel_image1.setIcon(null);
        jLabel_image2.setIcon(null);
        jLabel_image3.setIcon(null);
        jLabel_image4.setIcon(null);
        jLabel_image5.setIcon(null);
        jLabel_image6.setIcon(null);
        jLabel_image7.setIcon(null);
        jLabel_image8.setIcon(null);
    }
    
    public void setEnableLabel(int soLuong) {
        switch(soLuong) {
            case 1: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(false);
                    jLabel_name3.setVisible(false);
                    jLabel_name4.setVisible(false);
                    jLabel_name5.setVisible(false);
                    jLabel_name6.setVisible(false);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(false);
                    jLabel_image3.setVisible(false);
                    jLabel_image4.setVisible(false);
                    jLabel_image5.setVisible(false);
                    jLabel_image6.setVisible(false);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 2: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(false);
                    jLabel_name4.setVisible(false);
                    jLabel_name5.setVisible(false);
                    jLabel_name6.setVisible(false);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(false);
                    jLabel_image4.setVisible(false);
                    jLabel_image5.setVisible(false);
                    jLabel_image6.setVisible(false);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 3: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(false);
                    jLabel_name5.setVisible(false);
                    jLabel_name6.setVisible(false);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(false);
                    jLabel_image5.setVisible(false);
                    jLabel_image6.setVisible(false);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 4: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(true);
                    jLabel_name5.setVisible(false);
                    jLabel_name6.setVisible(false);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(true);
                    jLabel_image5.setVisible(false);
                    jLabel_image6.setVisible(false);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 5: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(true);
                    jLabel_name5.setVisible(true);
                    jLabel_name6.setVisible(false);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(true);
                    jLabel_image5.setVisible(true);
                    jLabel_image6.setVisible(false);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 6: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(true);
                    jLabel_name5.setVisible(true);
                    jLabel_name6.setVisible(true);
                    jLabel_name7.setVisible(false);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(true);
                    jLabel_image5.setVisible(true);
                    jLabel_image6.setVisible(true);
                    jLabel_image7.setVisible(false);
                    jLabel_image8.setVisible(false);
                    break;
            case 7: jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(true);
                    jLabel_name5.setVisible(true);
                    jLabel_name6.setVisible(true);
                    jLabel_name7.setVisible(true);
                    jLabel_name8.setVisible(false);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(true);
                    jLabel_image5.setVisible(true);
                    jLabel_image6.setVisible(true);
                    jLabel_image7.setVisible(true);
                    jLabel_image8.setVisible(false);
                    break;
            case 8: 
            default:jLabel_name1.setVisible(true);
                    jLabel_name2.setVisible(true);
                    jLabel_name3.setVisible(true);
                    jLabel_name4.setVisible(true);
                    jLabel_name5.setVisible(true);
                    jLabel_name6.setVisible(true);
                    jLabel_name7.setVisible(true);
                    jLabel_name8.setVisible(true);
                    
                    jLabel_image1.setVisible(true);
                    jLabel_image2.setVisible(true);
                    jLabel_image3.setVisible(true);
                    jLabel_image4.setVisible(true);
                    jLabel_image5.setVisible(true);
                    jLabel_image6.setVisible(true);
                    jLabel_image7.setVisible(true);
                    jLabel_image8.setVisible(true);
                    break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 1100, 650, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_name1 = new javax.swing.JLabel();
        jLabel_image1 = new javax.swing.JLabel();
        jLabel_name2 = new javax.swing.JLabel();
        jLabel_image2 = new javax.swing.JLabel();
        jLabel_name3 = new javax.swing.JLabel();
        jLabel_image3 = new javax.swing.JLabel();
        jLabel_name4 = new javax.swing.JLabel();
        jLabel_image4 = new javax.swing.JLabel();
        jLabel_image5 = new javax.swing.JLabel();
        jLabel_name5 = new javax.swing.JLabel();
        jLabel_image6 = new javax.swing.JLabel();
        jLabel_name6 = new javax.swing.JLabel();
        jLabel_image7 = new javax.swing.JLabel();
        jLabel_name7 = new javax.swing.JLabel();
        jLabel_image8 = new javax.swing.JLabel();
        jLabel_name8 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        lbTenKhuNha = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1100, 650));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel_name1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_name1.setOpaque(true);
        jLabel_name1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name1MouseMoved(evt);
            }
        });

        jLabel_image1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image1.setOpaque(true);

        jLabel_name2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_name2.setOpaque(true);
        jLabel_name2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name2MouseMoved(evt);
            }
        });

        jLabel_image2.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image2.setOpaque(true);

        jLabel_name3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_name3.setOpaque(true);
        jLabel_name3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name3MouseMoved(evt);
            }
        });

        jLabel_image3.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image3.setOpaque(true);

        jLabel_name4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_name4.setOpaque(true);
        jLabel_name4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name4MouseMoved(evt);
            }
        });

        jLabel_image4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image4.setOpaque(true);

        jLabel_image5.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image5.setOpaque(true);

        jLabel_name5.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name5.setOpaque(true);
        jLabel_name5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name5MouseMoved(evt);
            }
        });

        jLabel_image6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image6.setOpaque(true);

        jLabel_name6.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name6.setOpaque(true);
        jLabel_name6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name6MouseMoved(evt);
            }
        });

        jLabel_image7.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image7.setOpaque(true);

        jLabel_name7.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name7.setOpaque(true);
        jLabel_name7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name7MouseMoved(evt);
            }
        });

        jLabel_image8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_image8.setOpaque(true);

        jLabel_name8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_name8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_name8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name8.setOpaque(true);
        jLabel_name8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel_name8MouseMoved(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/back.png"))); // NOI18N

        lbTenKhuNha.setBackground(new java.awt.Color(51, 51, 255));
        lbTenKhuNha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTenKhuNha.setForeground(new java.awt.Color(255, 255, 255));
        lbTenKhuNha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTenKhuNha.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_name4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel_image4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel_image3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel_image2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_image5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_name5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_image6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_name6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_image7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_name7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_image8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_name8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(lbTenKhuNha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel_name1, jLabel_name2, jLabel_name3, jLabel_name4, jLabel_name5, jLabel_name6, jLabel_name7, jLabel_name8});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel_image1, jLabel_image2, jLabel_image3, jLabel_image4, jLabel_image5, jLabel_image6, jLabel_image7, jLabel_image8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_name5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_image1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel_image5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(back)
                    .addComponent(lbTenKhuNha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_image2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel_image6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_name7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_image3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jLabel_image7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_name8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_image4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel_name4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_image8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_name1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name1MouseMoved
        jLabel_name1.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name1MouseMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged
    void resetBackGround() {
        jLabel_name1.setBackground(new java.awt.Color(51,51,255));
        jLabel_name2.setBackground(new java.awt.Color(51,51,255));
        jLabel_name3.setBackground(new java.awt.Color(51,51,255));
        jLabel_name4.setBackground(new java.awt.Color(51,51,255));
        jLabel_name5.setBackground(new java.awt.Color(51,51,255));
        jLabel_name6.setBackground(new java.awt.Color(51,51,255));
        jLabel_name7.setBackground(new java.awt.Color(51,51,255));
        jLabel_name8.setBackground(new java.awt.Color(51,51,255));
    }
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        resetBackGround();
    }//GEN-LAST:event_formMouseMoved

    private void jLabel_name2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name2MouseMoved
        jLabel_name2.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name2MouseMoved

    private void jLabel_name3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name3MouseMoved
        jLabel_name3.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name3MouseMoved

    private void jLabel_name4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name4MouseMoved
        jLabel_name4.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name4MouseMoved

    private void jLabel_name5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name5MouseMoved
        jLabel_name5.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name5MouseMoved

    private void jLabel_name6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name6MouseMoved
        jLabel_name6.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name6MouseMoved

    private void jLabel_name8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name8MouseMoved
        jLabel_name8.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name8MouseMoved

    private void jLabel_name7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_name7MouseMoved
        jLabel_name7.setBackground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_jLabel_name7MouseMoved
    
    /////////////getters and setters:
    public JLabel getBack() {
        return back;
    }

    public JLabel getLbName1() {
        return jLabel_name1;
    }

    public JLabel getLbName2() {
        return jLabel_name2;
    }

    public JLabel getLbName3() {
        return jLabel_name3;
    }

    public JLabel getLbName4() {
        return jLabel_name4;
    }

    public JLabel getLbName5() {
        return jLabel_name5;
    }

    public JLabel getLbName6() {
        return jLabel_name6;
    }

    public JLabel getLbName7() {
        return jLabel_name7;
    }

    public JLabel getLbName8() {
        return jLabel_name8;
    }
    
    public JLabel getLbImage1() {
        return jLabel_image1;
    }
    
    public JLabel getLbImage2() {
        return jLabel_image2;
    }
    
    public JLabel getLbImage3() {
        return jLabel_image3;
    }
    
    public JLabel getLbImage4() {
        return jLabel_image4;
    }
    
    public JLabel getLbImage5() {
        return jLabel_image5;
    }
    
    public JLabel getLbImage6() {
        return jLabel_image6;
    }
    
    public JLabel getLbImage7() {
        return jLabel_image7;
    }
    
    public JLabel getLbImage8() {
        return jLabel_image8;
    }

    public void setjLabel_name1(String name) {
        this.jLabel_name1.setText(name + " ");
    }

    public void setjLabel_name2(String name) {
        this.jLabel_name2.setText(name + " ");
    }

    public void setjLabel_name3(String name) {
        this.jLabel_name3.setText(name + " ");
    }

    public void setjLabel_name4(String name) {
        this.jLabel_name4.setText(name + " ");
    }

    public void setjLabel_name5(String name) {
        this.jLabel_name5.setText(" " + name);
    }

    public void setjLabel_name6(String name) {
        this.jLabel_name6.setText(" " + name);
    }

    public void setjLabel_name7(String name) {
        this.jLabel_name7.setText(" " + name);
    }

    public void setjLabel_name8(String name) {
        this.jLabel_name8.setText(" " + name);
    }
    
    void setLbTenKhuNha(String name){
        this.lbTenKhuNha.setText(name);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel jLabel_image1;
    private javax.swing.JLabel jLabel_image2;
    private javax.swing.JLabel jLabel_image3;
    private javax.swing.JLabel jLabel_image4;
    private javax.swing.JLabel jLabel_image5;
    private javax.swing.JLabel jLabel_image6;
    private javax.swing.JLabel jLabel_image7;
    private javax.swing.JLabel jLabel_image8;
    private javax.swing.JLabel jLabel_name1;
    private javax.swing.JLabel jLabel_name2;
    private javax.swing.JLabel jLabel_name3;
    private javax.swing.JLabel jLabel_name4;
    private javax.swing.JLabel jLabel_name5;
    private javax.swing.JLabel jLabel_name6;
    private javax.swing.JLabel jLabel_name7;
    private javax.swing.JLabel jLabel_name8;
    private javax.swing.JLabel lbTenKhuNha;
    // End of variables declaration//GEN-END:variables
    
}
