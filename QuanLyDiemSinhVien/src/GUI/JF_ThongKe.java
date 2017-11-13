package GUI;

import DBO.DBO_VIEW_DIEM_SV_MON_HOC;
import DBO.DBO_VIEW_SV_LOP;
import DBO.DBO_VIEW_THONGKE_CANHCAO;
import DBO.DBO_VIEW_THONGKE_HOCBONG;
import DBO.DBO_HOC_PHAN;
import DBO.DBO_LOP;
import DBO.DBO_KHOA;
import DLL.DLL_HocPhan;
import DLL.DLL_Lop;
import DLL.DLL_Khoa;
import DLL.DLL_ViewDSVMH;
import DLL.DLL_ViewSVLop;
import DLL.DLL_ViewTKCC;
import DLL.DLL_ViewTKHB;
import ExCel.ExcelPorter;
import java.util.ArrayList;
import MeThodShow.MyMethod;
import com.sun.glass.events.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;

public class JF_ThongKe extends javax.swing.JFrame {

    // lst get data
    ArrayList<DBO_KHOA> lstCBKhoa = null;
    ArrayList<DBO_LOP> lstCBLop = null;
    ArrayList<DBO_HOC_PHAN> lstCBHP = null;
    ArrayList<DBO_VIEW_DIEM_SV_MON_HOC> lstViewDMHSV = null;
    ArrayList<DBO_VIEW_SV_LOP> lstViewLSV = null;
    ArrayList<DBO_VIEW_THONGKE_CANHCAO> lstViewTKCC = null;
    ArrayList<DBO_VIEW_THONGKE_HOCBONG> lstViewTKHB = null;
    ArrayList<Integer> lstInt = null;

    // DLL tr data
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    DLL_Khoa dLL_Khoa = new DLL_Khoa();
    DLL_Lop dLL_Lop = new DLL_Lop();
    DLL_ViewDSVMH dLL_ViewDSVMH = new DLL_ViewDSVMH();
    DLL_ViewSVLop dLL_ViewSVLop = new DLL_ViewSVLop();
    DLL_ViewTKCC dLL_ViewTKCC = new DLL_ViewTKCC();
    DLL_ViewTKHB dLL_ViewTKHB = new DLL_ViewTKHB();

    // method 
    MyMethod method = new MyMethod();
    private int choice = 1;
    private DefaultTableModel dtm;
    private boolean check = false;
    ExcelPorter ex = new ExcelPorter();
    String title = "";

    public JF_ThongKe() {
        initComponents();
        bidingLop();
        bidingHocPhan("");
        bidingKhoa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdSVLQL = new javax.swing.JRadioButton();
        rdSVLHP = new javax.swing.JRadioButton();
        rdSVHB = new javax.swing.JRadioButton();
        rdSVCC = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        cbLopQL = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        cbLopHP = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamhoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbHK = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtDK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataTk = new javax.swing.JTable();
        btnImport = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống Kê");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Thống Kê");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Lựa Chọn In Thống Kê");

        buttonGroup1.add(rdSVLQL);
        rdSVLQL.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdSVLQL.setSelected(true);
        rdSVLQL.setText("Sinh Viên Thuộc Lớp Quản Lý");
        rdSVLQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSVLQLActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdSVLHP);
        rdSVLHP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdSVLHP.setText("Sinh Viên Lớp Học Phần");
        rdSVLHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSVLHPActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdSVHB);
        rdSVHB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdSVHB.setText("Sinh Viên Nhận Học bổng");
        rdSVHB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSVHBActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdSVCC);
        rdSVCC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdSVCC.setText("Sinh Viên Bị Cảnh Cáo");
        rdSVCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSVCCActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Khoa");

        cbKhoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbKhoa.setEnabled(false);

        cbLopQL.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Lớp Quản Lý");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Filter");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Lớp HP");

        txtFilter.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtFilter.setEnabled(false);

        btnFilter.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.setEnabled(false);
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        cbLopHP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbLopHP.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Số Lượng HB");

        txtSL.setEnabled(false);
        txtSL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSLKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Học Kỳ");

        txtNamhoc.setEnabled(false);
        txtNamhoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamhocKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Năm Học");

        cbHK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học Kỳ 1", "Học Kỳ 2", "Học Kỳ Hè", "Học Kỳ Tết" }));
        cbHK.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Điều Kiện");

        txtDK.setEnabled(false);
        txtDK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDKKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbKhoa, 0, 250, Short.MAX_VALUE)
                    .addComponent(cbLopQL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFilter))
                    .addComponent(cbLopHP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSL)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamhoc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDK)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilter)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLopQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLopHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNamhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        tblDataTk.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblDataTk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDataTk);

        btnImport.setBackground(new java.awt.Color(255, 255, 204));
        btnImport.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Excel.png"))); // NOI18N
        btnImport.setText("Import Excel");
        btnImport.setEnabled(false);
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnShow.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myShow.png"))); // NOI18N
        btnShow.setText("Show Data");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(rdSVLQL)
                        .addGap(18, 18, 18)
                        .addComponent(rdSVLHP)
                        .addGap(18, 18, 18)
                        .addComponent(rdSVHB)
                        .addGap(18, 18, 18)
                        .addComponent(rdSVCC)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnShow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImport)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(423, 423, 423))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdSVLQL)
                        .addComponent(rdSVLHP)
                        .addComponent(rdSVHB)
                        .addComponent(rdSVCC))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(btnImport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        if (txtFilter.getText().isEmpty()) {
            method.showMessegaNo("Filter not is Empty");
        } else {
            cbLopHP.removeAllItems();
            bidingHocPhan(txtFilter.getText());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void rdSVLQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSVLQLActionPerformed
        cbLopQL.setEnabled(true);
        choice = 1;
        res();
        //
        cbKhoa.setEnabled(false);
        cbHK.setEnabled(false);
        cbLopHP.setEnabled(false);
        txtDK.setEnabled(false);
        txtFilter.setEnabled(false);
        txtNamhoc.setEnabled(false);
        txtSL.setEnabled(false);
        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdSVLQLActionPerformed

    private void rdSVLHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSVLHPActionPerformed
        cbLopHP.setEnabled(true);
        txtFilter.setEnabled(true);
        btnFilter.setEnabled(true);
        choice = 2;
        res();

        //
        cbLopQL.setEnabled(false);
        cbKhoa.setEnabled(false);
        cbHK.setEnabled(false);
        txtDK.setEnabled(false);
        txtNamhoc.setEnabled(false);
        txtSL.setEnabled(false);
    }//GEN-LAST:event_rdSVLHPActionPerformed

    private void rdSVHBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSVHBActionPerformed
        cbKhoa.setEnabled(true);
        txtNamhoc.setEnabled(true);
        res();

        cbHK.setEnabled(true);
        txtSL.setEnabled(true);
        txtDK.setEnabled(true);
        choice = 3;
        //
        cbLopQL.setEnabled(false);
        cbLopHP.setEnabled(false);
        txtFilter.setEnabled(false);
        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdSVHBActionPerformed

    private void rdSVCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSVCCActionPerformed
        txtNamhoc.setEnabled(true);
        cbHK.setEnabled(true);
        res();

        choice = 4;
        //
        cbLopQL.setEnabled(false);
        cbKhoa.setEnabled(false);
        cbLopHP.setEnabled(false);
        txtDK.setEnabled(false);
        txtFilter.setEnabled(false);
        txtSL.setEnabled(false);
        btnFilter.setEnabled(false);
    }//GEN-LAST:event_rdSVCCActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        if (choice == 1) {
            lstCBLop = dLL_Lop.getAllLop();
            int cbRow = cbLopQL.getSelectedIndex();
            String malop = lstCBLop.get(cbRow).getMaLop();
            BidingSVLQL(malop);
        } else if (choice == 2) {
            if (txtFilter.getText().isEmpty()) {
                txtFilter.setText("");
            }
            lstCBHP = dLL_HocPhan.getSearchHocPhan(txtFilter.getText());
            int cbRow = cbLopHP.getSelectedIndex();
            String malophocphan = lstCBHP.get(cbRow).getMaHocPhan();
            BidingSVLHP(malophocphan);
        } else if (choice == 3) {
            if (txtDK.getText().isEmpty() || txtNamhoc.getText().isEmpty() || txtSL.getText().isEmpty()) {
                method.showMessegaNo("Có 1 trường rỗng");
            } else {
                lstCBKhoa = dLL_Khoa.getAllKhoa();
                int cbRow = cbKhoa.getSelectedIndex();
                String makhoa = lstCBKhoa.get(cbRow).getMaKhoa();
                int hocky = cbHK.getSelectedIndex() + 1;
                Float dk = Float.parseFloat(txtDK.getText());
                int sl = Integer.parseInt(txtSL.getText());
                int namhoc = Integer.parseInt(txtNamhoc.getText());
                BidingTKHB(dk, sl, makhoa, namhoc, hocky);
            }
        } else if (choice == 4) {
            if (txtNamhoc.getText().isEmpty()) {
                method.showMessegaNo("Có 1 trường rỗng");
            } else {
                int hocky = cbHK.getSelectedIndex() + 1;
                BidingTKCC(Integer.parseInt(txtNamhoc.getText()), hocky);
            }
        }
        btnImport.setEnabled(true);
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtSLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSLKeyTyped
        InputNumber(evt, txtSL);
    }//GEN-LAST:event_txtSLKeyTyped

    private void txtDKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDKKeyTyped
        onlynumber(evt, txtDK);
    }//GEN-LAST:event_txtDKKeyTyped

    private void txtNamhocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamhocKeyTyped
        InputNumber(evt, txtNamhoc);
    }//GEN-LAST:event_txtNamhocKeyTyped

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        if (rdSVLQL.isSelected()) {
            title = "Danh Sách Sinh Viên Thuộc Lớp " + cbLopQL.getSelectedItem().toString();
        } else if (rdSVLHP.isSelected()) {
            title = "Danh Sách Sinh Viên Thuộc Lớp Học Phần " + cbLopHP.getSelectedItem().toString();
        } else if (rdSVHB.isSelected()) {
            title = "Danh Sách Sinh Viên Nhận học bổng khoa " + cbKhoa.getSelectedItem().toString() + "Học Kỳ " + cbHK.getSelectedItem().toString() + " - Năm Học " + txtNamhoc.getText();
        } else if (rdSVCC.isSelected()) {
            title = "Danh Sách Sinh Viên Bị Cảnh Cáo Học Kỳ " + cbHK.getSelectedItem().toString() + " - Năm Học " + txtNamhoc.getText();
        }
        if (check) {
            try {
                ex.writeExcel(tblDataTk, "test1", title);
            } catch (IOException ex) {
                Logger.getLogger(JF_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(JF_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            method.showMessegaNo("not data in table");
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(JF_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_ThongKe().setVisible(true);
            }
        });
    }

    public void bidingKhoa() {
        lstCBKhoa = dLL_Khoa.getAllKhoa();
        for (DBO_KHOA obj : lstCBKhoa) {
            cbKhoa.addItem(obj.getTenKhoa());
        }
    }

    public void bidingLop() {
        lstCBLop = dLL_Lop.getAllLop();
        for (DBO_LOP obj : lstCBLop) {
            cbLopQL.addItem(obj.getTenLop());
        }
    }

    public void bidingHocPhan(String chuoitimkiem) {
        lstCBHP = dLL_HocPhan.getSearchHocPhan(chuoitimkiem);
        for (DBO_HOC_PHAN obj : lstCBHP) {
            cbLopHP.addItem(obj.getTenHocPhan());
        }
    }

    public void BidingSVLQL(String malop) {
        lstViewLSV = dLL_ViewSVLop.getSVLop(malop);
        if (lstViewLSV.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Và Tên");
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_SV_LOP item : lstViewLSV) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaSoSinhVien());
                row.add(item.getHoTen());
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop SV : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    public void BidingSVLHP(String malophocphan) {
        lstViewDMHSV = dLL_ViewDSVMH.getDSVMH(malophocphan);
        if (lstViewDMHSV.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Trung Bình");
        Column.add("Điểm Chữ");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_DIEM_SV_MON_HOC item : lstViewDMHSV) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaHocPhan());
                row.add(item.getTenHocPhan());
                row.add(item.getMaSoSinhVien());
                row.add(item.getHoTen());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop HP : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    public void BidingTKHB(float dk, int sl, String makhoa, int namhoc, int hocky) {
        lstViewTKHB = dLL_ViewTKHB.getSVHB(dk, sl, makhoa, namhoc, hocky);
        if (lstViewTKHB.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Số");
        Column.add("Xếp Loại");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_THONGKE_HOCBONG item : lstViewTKHB) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaSoSinhVien());
                row.add(item.getHoTen());
                row.add(item.getDiemSo());
                row.add(item.getHinhThuc());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop HB : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    public void BidingTKCC(int namhoc, int hocky) {
        lstViewTKCC = dLL_ViewTKCC.getSVCC(namhoc, hocky);
        if (lstViewTKCC.size() > 0) {
            check = true;
        }
        Vector Column = new Vector();
        Column.add("STT");
        Column.add("Mã Lớp");
        Column.add("Tên Lớp");
        Column.add("Mã Số Sinh Viên");
        Column.add("Họ Tên");
        Column.add("Điểm Số");
        Column.add("Loại Cảnh Cáo");
        Vector data = new Vector();
        try {
            int i = 1;
            for (DBO_VIEW_THONGKE_CANHCAO item : lstViewTKCC) {
                Vector row = new Vector();
                row.add(i);
                row.add(item.getMaLop());
                row.add(item.getTenLop());
                row.add(item.getMaSoSinhVien());
                row.add(item.getHoTen());
                row.add(item.getDiemSo());
                row.add(item.getHinhThuc());
                data.add(row);
                i++;
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Lop CC : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDataTk.setModel(dtm);
    }

    private void onlynumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        if (vchar == KeyEvent.VK_PERIOD) {
            temp.setText(temp.getText() + ".");
        }
    }

    private void InputNumber(java.awt.event.KeyEvent evt, JTextField temp) {
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }

    public void res() {
        cbLopQL.setSelectedIndex(0);
        cbHK.setSelectedIndex(0);
        cbKhoa.setSelectedIndex(0);
        cbLopHP.setSelectedIndex(0);
        txtDK.setText("");
        txtFilter.setText("");
        txtNamhoc.setText("");
        txtSL.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnShow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbHK;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JComboBox<String> cbLopHP;
    private javax.swing.JComboBox<String> cbLopQL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdSVCC;
    private javax.swing.JRadioButton rdSVHB;
    private javax.swing.JRadioButton rdSVLHP;
    private javax.swing.JRadioButton rdSVLQL;
    private javax.swing.JTable tblDataTk;
    private javax.swing.JTextField txtDK;
    private javax.swing.JTextField txtFilter;
    private javax.swing.JTextField txtNamhoc;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
}
