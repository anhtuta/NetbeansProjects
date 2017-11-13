package GUI;

import DBO.DBO_LOP;
import DBO.DBO_KHOA;
import DLL.DLL_Khoa;
import DLL.DLL_Lop;
import MeThodShow.MyMethod;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JF_Lop extends javax.swing.JFrame {

    public JF_Lop() {
        initComponents();
        BiddingcbKhoa();
        BidingDataLop();
    }

    ArrayList<DBO_KHOA> lstKhoa = null;
    ArrayList<DBO_LOP> lstLop = null;
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dLL_Lop = new DLL_Lop();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtKhoaHoc = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        txtMaLop = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbMaKhoa = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnUpdateLop = new javax.swing.JButton();
        btnDeletelop = new javax.swing.JButton();
        btnAddLop = new javax.swing.JButton();
        btnResLop = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Class Ìnormation");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLASS INFORMATION");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Khóa Học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Mã Khoa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Mã Lớp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Tên Lớp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKhoaHoc)
                    .addComponent(cbMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        btnUpdateLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateLop.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdateLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateLop.setText("Update");
        btnUpdateLop.setEnabled(false);
        btnUpdateLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdateLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLopActionPerformed(evt);
            }
        });

        btnDeletelop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeletelop.setForeground(new java.awt.Color(255, 0, 0));
        btnDeletelop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnDeletelop.setText("Delete");
        btnDeletelop.setEnabled(false);
        btnDeletelop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeletelop.setIconTextGap(2);
        btnDeletelop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletelopActionPerformed(evt);
            }
        });

        btnAddLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddLop.setForeground(new java.awt.Color(255, 0, 0));
        btnAddLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddLop.setText("Add");
        btnAddLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLopActionPerformed(evt);
            }
        });

        btnResLop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResLop.setForeground(new java.awt.Color(255, 0, 0));
        btnResLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResLop.setText("Reset");
        btnResLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnResLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResLopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateLop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletelop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddLop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateLop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeletelop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResLop, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLop);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnAddLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLopActionPerformed
        lstKhoa = dLL_Khoa.getAllKhoa();
        String malop = txtMaLop.getText();
        String tenlop = txtTenLop.getText();
        String khoahoc = txtKhoaHoc.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String makhoa = lstKhoa.get(cbRow).getMaKhoa();
        DBO_LOP item = new DBO_LOP();
        item.setMaLop(malop);
        item.setTenLop(tenlop);
        item.setMaKhoa(makhoa);
        item.setKhoaHoc(khoahoc);
        if (malop.isEmpty() || tenlop.isEmpty() || khoahoc.isEmpty()) {
            method.showMessegaNo("This malop or tenlop or khoahoc is Empty");
        } else {
            lstLop = dLL_Lop.Check_Lop(malop);
            if (lstLop.size() < 1) {
                if (dLL_Lop.Insert(item)) {
                    method.showMessegaNo("insert data success");
                    res();
                    BidingDataLop();
                } else {
                    method.showMessegaNo("insert data Fail");
                }
            } else {
                method.showMessegaNo("Đã tồn tại dữ liệu trong cơ sở dữ liệu, Xin kiểm tra lại");
            }
        }
    }//GEN-LAST:event_btnAddLopActionPerformed

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        lstLop = dLL_Lop.getAllLop();
        int rowtbl = tblLop.getSelectedRow();
        txtMaLop.setText(lstLop.get(rowtbl).getMaLop());
        txtTenLop.setText(lstLop.get(rowtbl).getTenLop());
        txtKhoaHoc.setText(lstLop.get(rowtbl).getKhoaHoc());
        lstKhoa = dLL_Khoa.getAllKhoa_dk(lstLop.get(rowtbl).getMaKhoa());
        // method.showMessegaNo(lstKhoa.get(0).getMaKhoa());
        if (lstKhoa.size() > 0) {
            cbMaKhoa.setSelectedItem(lstKhoa.get(0).getTenKhoa());
        } else {
            cbMaKhoa.setSelectedIndex(0);
        }
        btnUpdateLop.setEnabled(true);
        btnDeletelop.setEnabled(true);
        dk = txtMaLop.getText();
//        method.showMessegaNo(dk);
    }//GEN-LAST:event_tblLopMouseClicked

    private void btnResLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResLopActionPerformed
        res();
    }//GEN-LAST:event_btnResLopActionPerformed

    private void btnUpdateLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLopActionPerformed
        lstKhoa = dLL_Khoa.getAllKhoa();
        String malop = txtMaLop.getText();
        String tenlop = txtTenLop.getText();
        String khoahoc = txtKhoaHoc.getText();
        int cbRow = cbMaKhoa.getSelectedIndex();
        String makhoa = lstKhoa.get(cbRow).getMaKhoa();
        DBO_LOP item = new DBO_LOP();
        item.setMaLop(malop);
        item.setTenLop(tenlop);
        item.setMaKhoa(makhoa);
        item.setKhoaHoc(khoahoc);
        if (malop.isEmpty() || tenlop.isEmpty() || khoahoc.isEmpty()) {
            method.showMessegaNo("This malop or tenlop or khoahoc is Empty");
        } else if (dLL_Lop.Update(item, dk)) {
            method.showMessegaNo("update data success");
            res();
            BidingDataLop();
        } else {
            method.showMessegaNo("update data fail");
        }
    }//GEN-LAST:event_btnUpdateLopActionPerformed

    private void btnDeletelopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletelopActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String malop = txtMaLop.getText();
            if (malop.isEmpty()) {
                method.showMessegaNo("This malop is Empty");
            } else if (dLL_Lop.Delete(malop)) {
                method.showMessegaNo("Delete data success");
                res();
                // Show data from database to Jtable
                BidingDataLop();
            } else {
                method.showMessegaNo("Delete data fail");
            }
        }
    }//GEN-LAST:event_btnDeletelopActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Lop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Lop().setVisible(true);
            }
        });
    }

    public void BidingDataLop() {
        lstLop = dLL_Lop.getAllLop();
        Vector Column = new Vector();
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Column.add("Tên Khoa");
        Column.add("Khóa");
        Vector data = new Vector();
        try {
            for (DBO_LOP item : lstLop) {
                Vector row = new Vector();
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                lstKhoa = dLL_Khoa.getAllKhoa_dk(item.getMaKhoa());
                if (lstKhoa.size() > 0) {
                    row.add(lstKhoa.get(0).getTenKhoa());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getKhoaHoc());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblLop.setModel(dtm);
    }

    public void BiddingcbKhoa() {
        lstKhoa = dLL_Khoa.getAllKhoa();
        for (DBO_KHOA obj : lstKhoa) {
            cbMaKhoa.addItem(obj.getTenKhoa());
        }
    }

    public void res() {
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtKhoaHoc.setText("");
        cbMaKhoa.setSelectedIndex(0);
        btnUpdateLop.setEnabled(false);
        btnDeletelop.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLop;
    private javax.swing.JButton btnDeletelop;
    private javax.swing.JButton btnResLop;
    private javax.swing.JButton btnUpdateLop;
    private javax.swing.JComboBox cbMaKhoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLop;
    private javax.swing.JTextField txtKhoaHoc;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtTenLop;
    // End of variables declaration//GEN-END:variables
}
