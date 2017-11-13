package GUI;

import DBO.DBO_LOP;
import java.util.ArrayList;
import DBO.DBO_SINH_VIEN;
import DLL.DLL_Lop;
import java.util.Vector;
import DLL.DLL_SinhVien;
import DBO.DBO_DANG_NHAP;
import DLL.DLL_DangNhap;
import MeThodShow.MyMethod;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import MeThodShow.MyMethod;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JF_Manager extends javax.swing.JFrame {

    MyMethod method = new MyMethod();
    public String flag_Login = JF_Login.flag;
    public String name = JF_Login.name;
    public boolean flag_TaiKhoan = false;// JF_Login.flag_TaiKhoan;
    DBO_DANG_NHAP User = new DBO_DANG_NHAP();
    DLL_DangNhap dLL_DangNhap = new DLL_DangNhap();

    public JF_Manager() {
        initComponents();
        this.setLocation(250, 100);
        postData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        pcAdmin = new javax.swing.JPanel();
        btnKhoa = new javax.swing.JButton();
        btnClass = new javax.swing.JButton();
        btnSinhVien = new javax.swing.JButton();
        btnGiangVien = new javax.swing.JButton();
        btnMonHoc = new javax.swing.JButton();
        btnDiem = new javax.swing.JButton();
        pcUser = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnImportDB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuSystem = new javax.swing.JMenu();
        mnuiLogin = new javax.swing.JMenuItem();
        mnuiRegister = new javax.swing.JMenuItem();
        mnuiLogOut = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuiExit = new javax.swing.JMenuItem();
        mnuUpdate = new javax.swing.JMenu();
        mnuSearch = new javax.swing.JMenu();
        mniSearch = new javax.swing.JMenuItem();
        mnuPort = new javax.swing.JMenu();
        mnuBaoCao = new javax.swing.JMenu();
        mnuAboutUs = new javax.swing.JMenu();
        mniabout = new javax.swing.JMenuItem();
        jmnuHelp = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Application");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Studient Scores Manager");

        btnKhoa.setBackground(new java.awt.Color(204, 255, 204));
        btnKhoa.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnKhoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myKhoa.png"))); // NOI18N
        btnKhoa.setText("Khoa");
        btnKhoa.setToolTipText("");
        btnKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaActionPerformed(evt);
            }
        });

        btnClass.setBackground(new java.awt.Color(204, 255, 204));
        btnClass.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myClass.png"))); // NOI18N
        btnClass.setText("Lớp");
        btnClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassActionPerformed(evt);
            }
        });

        btnSinhVien.setBackground(new java.awt.Color(255, 204, 204));
        btnSinhVien.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myStu.png"))); // NOI18N
        btnSinhVien.setText("Sinh Viên");
        btnSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinhVienActionPerformed(evt);
            }
        });

        btnGiangVien.setBackground(new java.awt.Color(204, 255, 255));
        btnGiangVien.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myTea.png"))); // NOI18N
        btnGiangVien.setText("Giảng Viên");
        btnGiangVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiangVienActionPerformed(evt);
            }
        });

        btnMonHoc.setBackground(new java.awt.Color(204, 255, 204));
        btnMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mySub.png"))); // NOI18N
        btnMonHoc.setText("Học Phần");
        btnMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonHocActionPerformed(evt);
            }
        });

        btnDiem.setBackground(new java.awt.Color(204, 204, 255));
        btnDiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myScor.png"))); // NOI18N
        btnDiem.setText("Điểm");
        btnDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pcAdminLayout = new javax.swing.GroupLayout(pcAdmin);
        pcAdmin.setLayout(pcAdminLayout);
        pcAdminLayout.setHorizontalGroup(
            pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKhoa)
                    .addComponent(btnClass)
                    .addComponent(btnSinhVien))
                .addGap(18, 18, 18)
                .addGroup(pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGiangVien)
                    .addComponent(btnMonHoc)
                    .addComponent(btnDiem))
                .addContainerGap())
        );

        pcAdminLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClass, btnDiem, btnGiangVien, btnKhoa, btnMonHoc, btnSinhVien});

        pcAdminLayout.setVerticalGroup(
            pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGiangVien)
                    .addComponent(btnKhoa))
                .addGap(18, 18, 18)
                .addGroup(pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMonHoc)
                    .addComponent(btnClass))
                .addGap(18, 18, 18)
                .addGroup(pcAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDiem)
                    .addComponent(btnSinhVien))
                .addContainerGap())
        );

        pcAdminLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClass, btnDiem, btnGiangVien, btnKhoa, btnMonHoc, btnSinhVien});

        pcUser.setPreferredSize(new java.awt.Dimension(292, 157));

        btnSearch.setBackground(new java.awt.Color(204, 204, 255));
        btnSearch.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 153, 153));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search2.png"))); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.setPreferredSize(new java.awt.Dimension(127, 33));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnTaiKhoan.setBackground(new java.awt.Color(204, 204, 255));
        btnTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnTaiKhoan.setForeground(new java.awt.Color(0, 153, 153));
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/User-32x32.png"))); // NOI18N
        btnTaiKhoan.setText("Tài Khoản");
        btnTaiKhoan.setEnabled(false);
        btnTaiKhoan.setPreferredSize(new java.awt.Dimension(127, 33));
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(204, 204, 255));
        btnThongKe.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(0, 153, 153));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myThongKe.png"))); // NOI18N
        btnThongKe.setText("Thống Kê");
        btnThongKe.setPreferredSize(new java.awt.Dimension(127, 33));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnImportDB.setBackground(new java.awt.Color(204, 204, 255));
        btnImportDB.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnImportDB.setForeground(new java.awt.Color(0, 153, 153));
        btnImportDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myExcel.png"))); // NOI18N
        btnImportDB.setText("Import DB");
        btnImportDB.setPreferredSize(new java.awt.Dimension(127, 33));
        btnImportDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pcUserLayout = new javax.swing.GroupLayout(pcUser);
        pcUser.setLayout(pcUserLayout);
        pcUserLayout.setHorizontalGroup(
            pcUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pcUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pcUserLayout.createSequentialGroup()
                        .addComponent(btnImportDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pcUserLayout.setVerticalGroup(
            pcUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pcUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Hello :");

        txtLogin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        mnuSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mySystem.png"))); // NOI18N
        mnuSystem.setText("Hệ Thống");

        mnuiLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Customer.png"))); // NOI18N
        mnuiLogin.setText("Đăng Nhập");
        mnuiLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiLoginActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuiLogin);

        mnuiRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sign-up-icon (1).png"))); // NOI18N
        mnuiRegister.setText("Đăng Ký");
        mnuiRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiRegisterActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuiRegister);

        mnuiLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/001_02.png"))); // NOI18N
        mnuiLogOut.setText("Đăng Xuất");
        mnuiLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiLogOutActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuiLogOut);
        mnuSystem.add(jSeparator1);

        mnuiExit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        mnuiExit.setText("Thoát");
        mnuiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiExitActionPerformed(evt);
            }
        });
        mnuSystem.add(mnuiExit);

        jMenuBar1.add(mnuSystem);

        mnuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myUpdate.png"))); // NOI18N
        mnuUpdate.setText("Cập Nhật");
        jMenuBar1.add(mnuUpdate);

        mnuSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mySearch.png"))); // NOI18N
        mnuSearch.setText("Tìm Kiếm");

        mniSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search-icon.png"))); // NOI18N
        mniSearch.setText("Tìm Kiếm");
        mniSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSearchActionPerformed(evt);
            }
        });
        mnuSearch.add(mniSearch);

        jMenuBar1.add(mnuSearch);

        mnuPort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myThongKe.png"))); // NOI18N
        mnuPort.setText("Thống Kê");
        jMenuBar1.add(mnuPort);

        mnuBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myRe.png"))); // NOI18N
        mnuBaoCao.setText("Import DB");
        jMenuBar1.add(mnuBaoCao);

        mnuAboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/about.png"))); // NOI18N
        mnuAboutUs.setText("About Us");

        mniabout.setText("About Us");
        mniabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniaboutActionPerformed(evt);
            }
        });
        mnuAboutUs.add(mniabout);

        jMenuBar1.add(mnuAboutUs);

        jmnuHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/myHelp.png"))); // NOI18N
        jmnuHelp.setText("Help");
        jMenuBar1.add(jmnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pcAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pcUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pcAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pcUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinhVienActionPerformed
        JF_SinhVien jf_sv = new JF_SinhVien();
        jf_sv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSinhVienActionPerformed

    private void mnuiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuiExitActionPerformed

    private void btnKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaActionPerformed
        JF_Khoa jf_kh = new JF_Khoa();
        jf_kh.setVisible(true);
        jf_kh.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnKhoaActionPerformed

    private void btnClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassActionPerformed
        JF_Lop jf_lp = new JF_Lop();
        jf_lp.setVisible(true);
        jf_lp.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnClassActionPerformed

    private void btnGiangVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiangVienActionPerformed
        JF_GiangVien jf_gv = new JF_GiangVien();
        jf_gv.setVisible(true);
        jf_gv.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnGiangVienActionPerformed

    private void btnMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonHocActionPerformed
        JF_HocPhan jf_hp = new JF_HocPhan();
        jf_hp.setVisible(true);
        jf_hp.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnMonHocActionPerformed

    private void btnDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemActionPerformed
        JF_Diem jf_d = new JF_Diem();
        jf_d.setVisible(true);
        jf_d.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnDiemActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        JF_Search_SV jf_s = new JF_Search_SV();
        jf_s.setVisible(true);
        jf_s.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void mniSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSearchActionPerformed
        JF_Search_SV jf_s = new JF_Search_SV();
        jf_s.setVisible(true);
        jf_s.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_mniSearchActionPerformed

    private void mnuiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiLoginActionPerformed
        JF_Login jf_log = new JF_Login(this);
        jf_log.setVisible(true);
    }//GEN-LAST:event_mnuiLoginActionPerformed

    private void mnuiRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiRegisterActionPerformed
        
    }//GEN-LAST:event_mnuiRegisterActionPerformed

    private void mnuiLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiLogOutActionPerformed
        int flag = JOptionPane.showConfirmDialog(null, "Bạn Muốn thoát phải không ?", "Thông Báo", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (flag == JOptionPane.YES_OPTION) {
            method.showMessegaNo("Good bye : " + txtLogin.getText());
            flag_Login = JF_Login.flag = "user";
            flag_TaiKhoan = JF_Login.flag_TaiKhoan = false;
            User = null;
            txtLogin.setText("");
            btnTaiKhoan.setEnabled(false);
            AdminChoise(flag_Login);
        }
    }//GEN-LAST:event_mnuiLogOutActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        JF_TaiKhoan jf_tk = new JF_TaiKhoan(this);
        jf_tk.setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        JF_ThongKe jf_tk = new JF_ThongKe();
        jf_tk.setVisible(true);
        jf_tk.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnImportDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportDBActionPerformed
        JF_Import jf_i = new JF_Import();
        jf_i.setVisible(true);
        jf_i.setLocation(200, 100);
        this.dispose();
    }//GEN-LAST:event_btnImportDBActionPerformed

    private void mniaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniaboutActionPerformed
        JF_AboutUs jf_au = new JF_AboutUs();
        jf_au.setVisible(true);
        jf_au.setLocation(500, 200);
        this.dispose();
    }//GEN-LAST:event_mniaboutActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Manager().setVisible(true);
            }
        });
    }

    public void postData() {
        flag_Login = "user";
        flag_Login = JF_Login.flag;
        flag_TaiKhoan = JF_Login.flag_TaiKhoan;
        if (name.isEmpty()) {
            txtLogin.setText(User.getHoTen());
        } else {
            txtLogin.setText(name);
        }
        btnTaiKhoan.setEnabled(flag_TaiKhoan);
        AdminChoise(flag_Login);
    }

    public void postDataFromTK() {
//        txtLogin.setText(User.getHoTen());
        method.showMessegaNo("ok");
    }

    private void AdminChoise(String flag) {
        boolean check = false;
        if (flag.equals("admin")) {
            check = true;
        }
        if (check) {
            mnuiLogin.setEnabled(false);
            mnuiLogOut.setEnabled(true);
        } else {
            mnuiLogin.setEnabled(true);
            mnuiLogOut.setEnabled(false);
        }
        btnClass.setEnabled(check);
        btnDiem.setEnabled(check);
        btnGiangVien.setEnabled(check);
        btnKhoa.setEnabled(check);
        btnMonHoc.setEnabled(check);
        btnSinhVien.setEnabled(check);
        btnThongKe.setEnabled(check);
        btnImportDB.setEnabled(check);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClass;
    private javax.swing.JButton btnDiem;
    private javax.swing.JButton btnGiangVien;
    private javax.swing.JButton btnImportDB;
    private javax.swing.JButton btnKhoa;
    private javax.swing.JButton btnMonHoc;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSinhVien;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThongKe;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmnuHelp;
    private javax.swing.JMenuItem mniSearch;
    private javax.swing.JMenuItem mniabout;
    private javax.swing.JMenu mnuAboutUs;
    private javax.swing.JMenu mnuBaoCao;
    private javax.swing.JMenu mnuPort;
    private javax.swing.JMenu mnuSearch;
    private javax.swing.JMenu mnuSystem;
    private javax.swing.JMenu mnuUpdate;
    private javax.swing.JMenuItem mnuiExit;
    private javax.swing.JMenuItem mnuiLogOut;
    private javax.swing.JMenuItem mnuiLogin;
    private javax.swing.JMenuItem mnuiRegister;
    private javax.swing.JPanel pcAdmin;
    private javax.swing.JPanel pcUser;
    public final javax.swing.JLabel txtLogin = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
