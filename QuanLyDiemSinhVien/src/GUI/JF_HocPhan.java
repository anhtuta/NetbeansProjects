package GUI;

import DBO.DBO_HOC_PHAN;
import DBO.DBO_GIANG_VIEN;
import DLL.DLL_HocPhan;
import DLL.DLL_GiangVien;
import MeThodShow.MyMethod;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JF_HocPhan extends javax.swing.JFrame {

    ArrayList<DBO_HOC_PHAN> lstHocPhan = null;
    ArrayList<DBO_GIANG_VIEN> lstGV = null;
    DLL_HocPhan dLL_hp = new DLL_HocPhan();
    DLL_GiangVien dLL_gv = new DLL_GiangVien();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private String dk = "";

    public JF_HocPhan() {
        initComponents();
        BiddingcbGiangVien();
        BidingDataHocPhan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHocPhan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHocPhan = new javax.swing.JTextField();
        txtPhonghoc = new javax.swing.JTextField();
        txtSoTinChi = new javax.swing.JTextField();
        txtTenHocPhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHocKy = new javax.swing.JTextField();
        cbGiangVien = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNamHoc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAddHP = new javax.swing.JButton();
        btnupdateHP = new javax.swing.JButton();
        btnDeleteHP = new javax.swing.JButton();
        btnResHP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Subject Ìnormation");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUBJECT INFORMATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        tblHocPhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblHocPhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
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
        tblHocPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocPhanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHocPhan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Tên Học Phần");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Mã Học Phần");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Số Tín Chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Học Kỳ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Phòng Học");

        cbGiangVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Giảng Viên");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Năm Học");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(cbGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtPhonghoc)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhonghoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        btnAddHP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddHP.setForeground(new java.awt.Color(255, 0, 0));
        btnAddHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddHP.setText("New");
        btnAddHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHPActionPerformed(evt);
            }
        });

        btnupdateHP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnupdateHP.setForeground(new java.awt.Color(255, 0, 0));
        btnupdateHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Update.png"))); // NOI18N
        btnupdateHP.setText("Update");
        btnupdateHP.setEnabled(false);
        btnupdateHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateHPActionPerformed(evt);
            }
        });

        btnDeleteHP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteHP.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Remove.png"))); // NOI18N
        btnDeleteHP.setText("Delete");
        btnDeleteHP.setEnabled(false);
        btnDeleteHP.setIconTextGap(2);
        btnDeleteHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHPActionPerformed(evt);
            }
        });

        btnResHP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResHP.setForeground(new java.awt.Color(255, 0, 0));
        btnResHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResHP.setText("Reset");
        btnResHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResHPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteHP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnAddHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnupdateHP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddHP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnupdateHP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteHP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResHP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 380, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnResHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResHPActionPerformed
        res();
    }//GEN-LAST:event_btnResHPActionPerformed

    private void tblHocPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocPhanMouseClicked
        lstHocPhan = dLL_hp.getAllHocPhan();
        int rowtbl = tblHocPhan.getSelectedRow();
        txtMaHocPhan.setText(lstHocPhan.get(rowtbl).getMaHocPhan());
        txtTenHocPhan.setText(lstHocPhan.get(rowtbl).getTenHocPhan());
        txtPhonghoc.setText(lstHocPhan.get(rowtbl).getPhongHoc());
        txtHocKy.setText(String.valueOf(lstHocPhan.get(rowtbl).getHocKy()));
        txtSoTinChi.setText(String.valueOf(lstHocPhan.get(rowtbl).getSoTinChi()));
        txtNamHoc.setText(String.valueOf(lstHocPhan.get(rowtbl).getNamHoc()));
        lstGV = dLL_gv.getAllGV_dk(lstHocPhan.get(rowtbl).getMaGiangVien());
        // method.showMessegaNo(lstKhoa.get(0).getMaKhoa());
        if (lstGV.size() > 0) {
            cbGiangVien.setSelectedItem(lstGV.get(0).getHoTenGiangVien());
        } else {
            cbGiangVien.setSelectedIndex(0);
        }
        btnDeleteHP.setEnabled(true);
        btnupdateHP.setEnabled(true);
        dk = txtMaHocPhan.getText();
    }//GEN-LAST:event_tblHocPhanMouseClicked

    private void btnAddHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHPActionPerformed
        lstGV = dLL_gv.getAllGV();
        String mahp = txtMaHocPhan.getText();
        String tenhp = txtTenHocPhan.getText();
        String phonghoc = txtPhonghoc.getText();
        int tc = Integer.parseInt(txtSoTinChi.getText());
        int hocky = Integer.parseInt(txtHocKy.getText());
        int namhoc = Integer.parseInt(txtNamHoc.getText());
        int cbRow = cbGiangVien.getSelectedIndex();
        String magv = lstGV.get(cbRow).getMaGiangVien();
        DBO_HOC_PHAN item = new DBO_HOC_PHAN();
        item.setMaHocPhan(mahp);
        item.setTenHocPhan(tenhp);
        item.setPhongHoc(phonghoc);
        item.setSoTinChi(tc);
        item.setHocKy(hocky);
        item.setMaGiangVien(magv);
        item.setNamHoc(namhoc);
        if (mahp.isEmpty() || tenhp.isEmpty() || phonghoc.isEmpty() || txtSoTinChi.getText().isEmpty() || txtHocKy.getText().isEmpty()) {
            method.showMessegaNo("Have a textFiles is Empty");
        } else {
            lstHocPhan = dLL_hp.Check_Lop(mahp);
            if (lstHocPhan.size() < 1) {
                if (dLL_hp.Insert(item)) {
                    method.showMessegaNo("insert data success");
                    res();
                    BidingDataHocPhan();
                } else {
                    method.showMessegaNo("insert data Fail");
                }
            } else {
                method.showMessegaNo("Đã tồn tại dữ liệu trong cơ sở dữ liệu, Xin kiểm tra lại");
            }
        }
    }//GEN-LAST:event_btnAddHPActionPerformed

    private void btnupdateHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateHPActionPerformed
        lstGV = dLL_gv.getAllGV();
        String mahp = txtMaHocPhan.getText();
        String tenhp = txtTenHocPhan.getText();
        String phonghoc = txtPhonghoc.getText();
        int tc = Integer.parseInt(txtSoTinChi.getText());
        int hocky = Integer.parseInt(txtHocKy.getText());
        int namhoc = Integer.parseInt(txtNamHoc.getText());
        int cbRow = cbGiangVien.getSelectedIndex();
        String magv = lstGV.get(cbRow).getMaGiangVien();
        DBO_HOC_PHAN item = new DBO_HOC_PHAN();
        item.setMaHocPhan(mahp);
        item.setTenHocPhan(tenhp);
        item.setPhongHoc(phonghoc);
        item.setSoTinChi(tc);
        item.setHocKy(hocky);
        item.setMaGiangVien(magv);
        item.setNamHoc(namhoc);
        if (mahp.isEmpty() || tenhp.isEmpty() || phonghoc.isEmpty() || txtSoTinChi.getText().isEmpty() || txtHocKy.getText().isEmpty()) {
            method.showMessegaNo("Have a textFiles is Empty");
        } else if (dLL_hp.Update(item, dk)) {
            method.showMessegaNo("update data success");
            res();
            BidingDataHocPhan();
        } else {
            method.showMessegaNo("update data fail");
        }
    }//GEN-LAST:event_btnupdateHPActionPerformed

    private void btnDeleteHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHPActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String mahp = txtMaHocPhan.getText();
            if (mahp.isEmpty()) {
                method.showMessegaNo("This malop is Empty");
            } else if (dLL_hp.Delete(mahp)) {
                method.showMessegaNo("Delete data success");
                res();
                // Show data from database to Jtable
                BidingDataHocPhan();
            } else {
                method.showMessegaNo("Delete data fail");
            }
        }
    }//GEN-LAST:event_btnDeleteHPActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JF_HocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_HocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_HocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_HocPhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_HocPhan().setVisible(true);
            }
        });
    }

    public void BidingDataHocPhan() {
        lstHocPhan = dLL_hp.getAllHocPhan();
        Vector Column = new Vector();
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Tên Giảng Viên");
        Column.add("Phòng Học");
        Column.add("Số Tín Chí");
        Column.add("Học Kì");
        Column.add("Năm Học");
        Vector data = new Vector();
        try {
            for (DBO_HOC_PHAN item : lstHocPhan) {
                Vector row = new Vector();
                row.add(item.getMaHocPhan());
                row.add(item.getTenHocPhan());
                lstGV = dLL_gv.getAllGV_dk(item.getMaGiangVien());
                if (lstGV.size() > 0) {
                    row.add(lstGV.get(0).getHoTenGiangVien());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getPhongHoc());
                row.add(item.getSoTinChi());
                row.add(item.getHocKy());
                row.add(item.getNamHoc());
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding hoc Phan : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblHocPhan.setModel(dtm);
    }

    public void BiddingcbGiangVien() {
        lstGV = dLL_gv.getAllGV();
        for (DBO_GIANG_VIEN obj : lstGV) {
            cbGiangVien.addItem(obj.getHoTenGiangVien());
        }
    }

    public void res() {
        txtHocKy.setText("");
        txtMaHocPhan.setText("");
        txtPhonghoc.setText("");
        txtTenHocPhan.setText("");
        txtNamHoc.setText("");
        txtSoTinChi.setText("");
        cbGiangVien.setSelectedIndex(0);
        btnDeleteHP.setEnabled(false);
        btnupdateHP.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHP;
    private javax.swing.JButton btnDeleteHP;
    private javax.swing.JButton btnResHP;
    private javax.swing.JButton btnupdateHP;
    private javax.swing.JComboBox cbGiangVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHocPhan;
    private javax.swing.JTextField txtHocKy;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JTextField txtNamHoc;
    private javax.swing.JTextField txtPhonghoc;
    private javax.swing.JTextField txtSoTinChi;
    private javax.swing.JTextField txtTenHocPhan;
    // End of variables declaration//GEN-END:variables
}
