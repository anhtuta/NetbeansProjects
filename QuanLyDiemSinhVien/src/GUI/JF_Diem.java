package GUI;

import DBO.DBO_DIEM;
import DBO.DBO_SINH_VIEN;
import DBO.DBO_HOC_PHAN;
import DLL.DLL_Diem;
import DLL.DLL_SinhVien;
import DLL.DLL_HocPhan;
import MeThodShow.MyMethod;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JF_Diem extends javax.swing.JFrame {

    ArrayList<DBO_DIEM> lstDiem = null;
    ArrayList<DBO_SINH_VIEN> lstSinhVien = null;
    ArrayList<DBO_HOC_PHAN> lstHp = null;
    DLL_Diem dLL_Diem = new DLL_Diem();
    DLL_SinhVien dll_sv = new DLL_SinhVien();
    DLL_HocPhan dLL_HocPhan = new DLL_HocPhan();
    MeThodShow.MyMethod method = new MyMethod();
    private DefaultTableModel dtm;
    private int id_diem = 1;

    public JF_Diem() {
        initComponents();
        txtDiemC.requestFocus();
        //JScrollPane scroll = new JScrollPane(tblDiem, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //this.add(scroll);
        BidingDataDiem();
        finding();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        btnUpdateDiem = new javax.swing.JButton();
        btnDeleteDiem = new javax.swing.JButton();
        btnAddDiem = new javax.swing.JButton();
        btnResDiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtDiemC = new javax.swing.JTextField();
        jlb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiemB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDL2 = new javax.swing.JTextField();
        txtDL1 = new javax.swing.JTextField();
        txtDiemChu = new javax.swing.JTextField();
        txtDiemTB = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        checkBoxXoa = new javax.swing.JCheckBox();
        txtTenSinhVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenhocPhan = new javax.swing.JTextField();
        txtMaHocPhan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scrollpanen = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable(){
            private boolean inLayout;

            @Override
            public boolean getScrollableTracksViewportWidth() {
                return hasExcessWidth();

            }

            @Override
            public void doLayout() {
                if (hasExcessWidth()) {
                    // fool super
                    autoResizeMode = AUTO_RESIZE_SUBSEQUENT_COLUMNS;
                }
                inLayout = true;
                super.doLayout();
                inLayout = false;
                autoResizeMode = AUTO_RESIZE_OFF;
            }

            protected boolean hasExcessWidth() {
                return getPreferredSize().width < getParent().getWidth();
            }

            @Override
            public void columnMarginChanged(ChangeEvent e) {
                if (isEditing()) {
                    // JW: darn - cleanup to terminate editing ...
                    removeEditor();
                }
                TableColumn resizingColumn = getTableHeader().getResizingColumn();
                // Need to do this here, before the parent's
                // layout manager calls getPreferredSize().
                if (resizingColumn != null && autoResizeMode == AUTO_RESIZE_OFF
                    && !inLayout) {
                    resizingColumn.setPreferredWidth(resizingColumn.getWidth());
                }
                resizeAndRepaint();
            }

        };
        jPanel3 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mark Information");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnUpdateDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateDiem.setForeground(new java.awt.Color(255, 0, 0));
        btnUpdateDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnUpdateDiem.setText("Update");
        btnUpdateDiem.setEnabled(false);
        btnUpdateDiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUpdateDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDiemActionPerformed(evt);
            }
        });

        btnDeleteDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDeleteDiem.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnDeleteDiem.setText("Delete");
        btnDeleteDiem.setEnabled(false);
        btnDeleteDiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDeleteDiem.setIconTextGap(2);
        btnDeleteDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDiemActionPerformed(evt);
            }
        });

        btnAddDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddDiem.setForeground(new java.awt.Color(255, 0, 0));
        btnAddDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/new.png"))); // NOI18N
        btnAddDiem.setText("Add");
        btnAddDiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiemActionPerformed(evt);
            }
        });

        btnResDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResDiem.setForeground(new java.awt.Color(255, 0, 0));
        btnResDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reset.png"))); // NOI18N
        btnResDiem.setText("Reset");
        btnResDiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnResDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResDiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(btnAddDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteDiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResDiem)
                .addGap(12, 12, 12))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtDiemC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDiemC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemCKeyTyped(evt);
            }
        });

        jlb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlb.setForeground(new java.awt.Color(0, 0, 255));
        jlb.setText("Tên Học Sinh");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Tên Học Phần");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Điểm C");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Trạng Thái");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Điểm B");

        txtDiemB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiemBKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Điểm Thi lần 2");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Điểm Thi Lần 1");

        txtDL2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDL2KeyTyped(evt);
            }
        });

        txtDL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDL1KeyTyped(evt);
            }
        });

        txtDiemChu.setEditable(false);

        txtDiemTB.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));
        jLabel16.setText("Điểm Trung Bình");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("Điểm Chữ");

        checkBoxXoa.setText("Đã Xóa");

        txtTenSinhVien.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Mã Sinh Viên");

        txtTenhocPhan.setEditable(false);

        txtMaHocPhan.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Mã Học Phần");

        txtMaSinhVien.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlb)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDL2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtDL1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiemChu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkBoxXoa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenhocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb)
                    .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenhocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaHocPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiemC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtDL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(checkBoxXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtDiemChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MARK INFORMATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDiem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDiem);

        scrollpanen.setViewportView(jScrollPane3);

        txtFind.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nhập từ khóa cần tìm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollpanen, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpanen, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        JF_Manager jF_Manager = new JF_Manager();
        jF_Manager.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btnResDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResDiemActionPerformed
        res();
        BidingDataDiem();
    }//GEN-LAST:event_btnResDiemActionPerformed

    private void btnUpdateDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDiemActionPerformed

        if (txtDiemC.getText().isEmpty() || txtDiemB.getText().isEmpty() || txtDL1.getText().isEmpty() || txtDL2.getText().isEmpty()) {
            method.showMessegaNo("Have a textFiles is Empty");
        } else {
            String mssv = txtMaSinhVien.getText();
            String mahocphan = txtMaHocPhan.getText();
            Float diemc = Float.parseFloat(txtDiemC.getText());
            Float diemb = Float.parseFloat(txtDiemB.getText());
            Float dieml1 = Float.parseFloat(txtDL1.getText());
            Float dieml2 = Float.parseFloat(txtDL2.getText());
            boolean check = checkBoxXoa.isSelected();
            DBO_DIEM item = new DBO_DIEM();
            item.setMaSoSinhVien(mssv);
            item.setMaHocPhan(mahocphan);
            item.setDiem_C(diemc);
            item.setDiem_B(diemb);
            item.setDiem_TL1(dieml1);
            item.setDiem_TL2(dieml2);
            item.setXoa(check);
            if (dLL_Diem.Update(item)) {
                method.showMessegaNo("Update data success");
                res();
                BidingDataDiem();
            } else {
                method.showMessegaNo("Update data Fail");
            }
        }
    }//GEN-LAST:event_btnUpdateDiemActionPerformed

    private void btnDeleteDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDiemActionPerformed
        int yes = JOptionPane.showConfirmDialog(null, "Bạn Muốn xóa dữ liệu ?", "Nitification", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            String ma = txtMaSinhVien.getText();
            String mahp = txtMaHocPhan.getText();
            method.showMessegaNo("Mssv is Empty");
            if (dLL_Diem.Delete(ma, mahp)) {
                method.showMessegaNo("Delete data success");
                BidingDataDiem();
                res();
            } else {
                method.showMessegaNo("Delete data Fail");
            }
        }
    }//GEN-LAST:event_btnDeleteDiemActionPerformed

    private void btnAddDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiemActionPerformed
        JF_Add_Diem jf_add_diem = new JF_Add_Diem();
        jf_add_diem.setVisible(true);
        jf_add_diem.setLocation(200, 100);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddDiemActionPerformed

    private void tblDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDiemMouseClicked
        int row = tblDiem.getSelectedRow();
        String mssv = tblDiem.getValueAt(row, 0).toString();
        String mamon = tblDiem.getValueAt(row, 2).toString();
        // method.showMessegaNo(""+row);
//        String test = (String) tblDiem.getValueAt(row, 1);

        // method.showMessegaNo(test);
//        method.showMessegaNo(mssv);
//        method.showMessegaNo(mamon);
        lstDiem = dLL_Diem.getAllDiem_infor(mssv, mamon);

        lstSinhVien = dll_sv.getAllGV_dk(lstDiem.get(0).getMaSoSinhVien());
        lstHp = dLL_HocPhan.getAllHocPhan_dk(lstDiem.get(0).getMaHocPhan());
        //
        txtMaSinhVien.setText(lstDiem.get(0).getMaSoSinhVien());
        txtMaHocPhan.setText(lstDiem.get(0).getMaHocPhan());
        txtTenSinhVien.setText(lstSinhVien.get(0).getHoTen());
        txtTenhocPhan.setText(lstHp.get(0).getTenHocPhan());
        txtDiemC.setText(String.valueOf(lstDiem.get(0).getDiem_C()));
        txtDiemB.setText(String.valueOf(lstDiem.get(0).getDiem_B()));
        txtDL1.setText(String.valueOf(lstDiem.get(0).getDiem_TL1()));
        txtDL2.setText(String.valueOf(lstDiem.get(0).getDiem_TL2()));
        txtDiemTB.setText(String.valueOf(lstDiem.get(0).getDiem_Trung_Binh()));
        txtDiemChu.setText(lstDiem.get(0).getDiem_Chu());
        checkBoxXoa.setSelected(lstDiem.get(0).isXoa());
        //
        txtDiemC.requestFocus();
        btnDeleteDiem.setEnabled(true);
        btnUpdateDiem.setEnabled(true);
    }//GEN-LAST:event_tblDiemMouseClicked

    private void txtDiemCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemCKeyTyped
        onlynumber(evt, txtDiemC);
    }//GEN-LAST:event_txtDiemCKeyTyped

    private void txtDiemBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiemBKeyTyped
        onlynumber(evt, txtDiemB);
    }//GEN-LAST:event_txtDiemBKeyTyped

    private void txtDL1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDL1KeyTyped
        onlynumber(evt, txtDL1);
    }//GEN-LAST:event_txtDL1KeyTyped

    private void txtDL2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDL2KeyTyped
        onlynumber(evt, txtDL2);
    }//GEN-LAST:event_txtDL2KeyTyped

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(JF_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Diem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Diem().setVisible(true);
            }
        });
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

    private void BidingDataDiem() {
        lstDiem = dLL_Diem.getAllDiem();
        Vector Column = new Vector();
        Column.add("Mã Sinh Viên");
        Column.add("Tên Sinh Viên");
        Column.add("Mã Học Phần");
        Column.add("Tên Học Phần");
        Column.add("Điểm C");
        Column.add("Điểm B");
        Column.add("Điểm TL1");
        Column.add("Điểm TL2");
        Column.add("Điểm Trung Bình");
        Column.add("Điểm Chữ");
        Column.add("Xóa");
        Vector data = new Vector();
        try {
            for (DBO_DIEM item : lstDiem) {
                Vector row = new Vector();
                lstSinhVien = dll_sv.getAllGV_dk(item.getMaSoSinhVien());
                lstHp = dLL_HocPhan.getAllHocPhan_dk(item.getMaHocPhan());
                if (lstSinhVien.size() > 0) {
                    row.add(lstSinhVien.get(0).getMaSoSinhVien());
                } else {
                    row.add("Is Null");
                }
                if (lstSinhVien.size() > 0) {
                    row.add(lstSinhVien.get(0).getHoTen());
                } else {
                    row.add("Is Null");
                }
                if (lstHp.size() > 0) {
                    row.add(lstHp.get(0).getMaHocPhan());
                } else {
                    row.add("Is Null");
                }
                if (lstHp.size() > 0) {
                    row.add(lstHp.get(0).getTenHocPhan());
                } else {
                    row.add("Is Null");
                }
                row.add(item.getDiem_C());
                row.add(item.getDiem_B());
                row.add(item.getDiem_TL1());
                row.add(item.getDiem_TL2());
                row.add(item.getDiem_Trung_Binh());
                row.add(item.getDiem_Chu());
                boolean flag = item.isXoa();
                String Xoa = "Đã Xóa";
                if (!flag) {
                    Xoa = "Chưa Xóa";
                }
                row.add(Xoa);
                data.add(row);
            }
        } catch (Exception e) {
            method.showMessegaWa("Error for biding Diem : " + e.toString());
        }
        dtm = new DefaultTableModel(data, Column);
        tblDiem.setModel(dtm);
//        tblDiem.getColumnModel().getColumn(0).setPreferredWidth(100);
//        tblDiem.getColumnModel().getColumn(1).setPreferredWidth(200);
//        tblDiem.getColumnModel().getColumn(2).setPreferredWidth(200);
//        tblDiem.getColumnModel().getColumn(3).setPreferredWidth(200);
//        tblDiem.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void res() {
        txtDiemC.setText("");
        txtDiemB.setText("");
        txtDL1.setText("");
        txtDL2.setText("");
        txtDiemChu.setText("");
        txtDiemTB.setText("");
        txtMaSinhVien.setText("");
        txtTenSinhVien.setText("");
        txtMaHocPhan.setText("");
        txtTenhocPhan.setText("");
        checkBoxXoa.setSelected(false);
        btnUpdateDiem.setEnabled(false);
        btnDeleteDiem.setEnabled(false);
    }

    public void find(String querry) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDiem.getModel());
        tblDiem.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(querry));
    }

    public void finding() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDiem.getModel());
        tblDiem.setRowSorter(rowSorter);
        txtFind.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtFind.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtFind.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                method.showMessegaNo("thí is change");
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDiem;
    private javax.swing.JButton btnDeleteDiem;
    private javax.swing.JButton btnResDiem;
    private javax.swing.JButton btnUpdateDiem;
    private javax.swing.JCheckBox checkBoxXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlb;
    private javax.swing.JScrollPane scrollpanen;
    private javax.swing.JTable tblDiem;
    private javax.swing.JTextField txtDL1;
    private javax.swing.JTextField txtDL2;
    private javax.swing.JTextField txtDiemB;
    private javax.swing.JTextField txtDiemC;
    private javax.swing.JTextField txtDiemChu;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaHocPhan;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtTenSinhVien;
    private javax.swing.JTextField txtTenhocPhan;
    // End of variables declaration//GEN-END:variables
}
