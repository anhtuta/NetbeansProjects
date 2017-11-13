/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTu
 */
//class này tạo Frame = tay cho khó hơn
public class PhongTroFrame extends JFrame implements ActionListener,ItemListener {
    private MyConnect myConnect;
    private Connection conn;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    private final String[] columnName = {"Tên phòng", "Loại phòng", "Số lượng chỗ", "Số lượng chỗ trống", "Giá thuê", "Tòa nhà"};
    private final String[] sapXepTheo = {"tenPhong","loaiPhong", "soLuongCho", "soLuongChoTrong", "giaThue", "ToaNha_tenToaNha"}; //tên các cột trên database
    private String sapXepTheoWhat = sapXepTheo[0]; //giá trị mặc định
    
    //các thành phần của java swing
    private JTable table;
    private JLabel lbTenCuaTable;
    private JLabel lbSapXep;
    private JComboBox cbSapXep;
    private JButton btTimPhong;
    private JTextField tfGia;
    private JTextField tfPhong;
    private JComboBox cbTimPhong;
    private boolean timPhongReNhat = true;
    
    int soSVTrong1Phong;
    
    public PhongTroFrame() { //create a frame to display list phongtro
        add(panelChinhCuaFrame());
        //showPhongTro(sapXepTheoWhat);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(100, 100);
        pack();
        setTitle("Danh sách phòng trọ trong KTX");
    }
    
    public JPanel panelChinhCuaFrame() { //panel chính của frame, dùng để khai báo các thành phần của frame
        JPanel panel = new JPanel(new BorderLayout()); //cái panel chính
        
        //chú ý: muốn thêm 1 phần tử nào đó(button, textfield,...) ta phải tạo 1 panel để chứa nó, sau đó thêm cái panel này vào panel chính lúc đầu

        //thêm 1 cái panel ở đầu frame để chứa tên cho table
        JPanel panelLabel = new JPanel();
        lbTenCuaTable = new JLabel("DANH SÁCH CÁC PHÒNG TRỌ CỦA KÝ TÚC XÁ");
        lbTenCuaTable.setFont(new java.awt.Font("Tahoma", 1, 18));
        panelLabel.add(lbTenCuaTable);
        panel.add(panelLabel, BorderLayout.PAGE_START);
        
        //Thêm 1 panel ở giữa để chứa cái table
        JPanel panelMiddle = new JPanel(new BorderLayout());
        
        JPanel panelTable = new JPanel();
        table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(  //cái này ví dụ thôi, chứ chả có tác dụng gì!
            new Object [][] {},
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8" 
            }
        ));
        table.getTableHeader().setReorderingAllowed(false);  //lệnh này ko cho phép thay đổi vị trí các cột, chứ ko phải lệnh này: table.setDragEnabled(false);
        table.setAutoCreateRowSorter(true); //tự động sắp xếp khi click vào tiêu đề 1 cột
        table.setFillsViewportHeight(true); //kéo frame thì cái table cũng di chuyển theo nhưng ko thay đổi kích thước table
        JScrollPane scpn = new JScrollPane();
        scpn.setViewportView(table); //nếu dùng scpn.add(table) thì ko đc
        scpn.setPreferredSize(new Dimension(500, 300));
        panelTable.add(scpn); //add cái table vào cái paneltable trên, ntn thì cái bảng mới cuộn lên xuống đc
        
        JPanel panelUnderTable = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        btTimPhong = new JButton("Tìm phòng");
        btTimPhong.addActionListener(this);
        p1.add(btTimPhong);
        cbTimPhong = new JComboBox();
        cbTimPhong.addItem("Rẻ nhất");
        cbTimPhong.addItem("Đắt nhất");
        cbTimPhong.addItemListener(this);
        p1.add(cbTimPhong);
        
        
        JPanel p2 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel p3 = new JPanel(new GridLayout(2, 1, 10, 10));
        JLabel lbPhong = new JLabel("Tên Phòng");
        //lbPhong.setPreferredSize(new Dimension(60, 20)); lệnh này ko có tác dụng vì cái tfPhong sẽ thiết lập kích thước sau đó
        tfPhong = new JTextField();
        tfPhong.setPreferredSize(new Dimension(150, 20)); //kích thước của mỗi phần tử trong Grid, mọi phần tử đều có kích thước như nhau và =  ntnay
        tfPhong.setEditable(false);
        JLabel lbGia = new JLabel("Giá thuê");
        tfGia = new JTextField();
        tfGia.setEditable(false);
        //tfPhong.setPreferredSize(new Dimension(200, 20)); ko cần lệnh này nữa vì cái tfPhong đã thiết lập kích thước rồi
        p2.add(lbPhong);
        p2.add(lbGia);
        p3.add(tfPhong);
        p3.add(tfGia);
        
        panelUnderTable.add(p1);
        panelUnderTable.add(p2);
        panelUnderTable.add(p3);
        
        panelMiddle.add(panelTable, BorderLayout.PAGE_START);
        panelMiddle.add(panelUnderTable, BorderLayout.CENTER);
        
        panel.add(panelMiddle, BorderLayout.CENTER); //cho cái tablePane vào giữa cái panel chính       
        
        //thêm 1 cái panel con ở dưới cùng để sắp xếp
        JPanel panelEnd = new JPanel();
        panelEnd.setLayout(new FlowLayout());
        //thêm 1 label:
        lbSapXep = new JLabel("Sắp xếp theo: ");
        panelEnd.add(lbSapXep);
        //thêm 1 cái combobox
        cbSapXep = new JComboBox();
        cbSapXep.addItem("Tên phòng");
        cbSapXep.addItem("Loại phòng");
        cbSapXep.addItem("Số lượng chỗ");
        cbSapXep.addItem("Số lượng chỗ trống");
        cbSapXep.addItem("Giá thuê");
        cbSapXep.addItem("Tòa nhà");
        //cbSapXep.addActionListener(this); //ko cần cái này
        //chú ý: phải có cái sau:
        cbSapXep.addItemListener(this);
        panelEnd.add(cbSapXep);
        panel.add(panelEnd, BorderLayout.PAGE_END);
        
        //xong cái panel chính rồi
        
        return panel;
    }
    
    public ResultSet getDataPhongTroSapXepTheoWhat(String what) {
        myConnect = new MyConnect();
        conn = myConnect.connect();
        try {
            pst = conn.prepareStatement("SELECT * FROM phong ORDER BY "+what);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
    
    public void showPhongTro(String what) {
        DefaultTableModel model = new DefaultTableModel();
        
        rs = getDataPhongTroSapXepTheoWhat(what);
        try {
            ResultSetMetaData rsMD = rs.getMetaData();
            int columnNumber = rsMD.getColumnCount(); //lấy số cột
            String [] arr = new String[columnNumber];
            
            for (int i = 0; i < columnNumber; i++) {
                arr[i] = columnName[i]; //tiêu đề các cột
            }
            
            model.setColumnIdentifiers(arr); //sau đó add các tên vào 1 model
            
            while(rs.next()) {
                for (int i = 0; i < columnNumber; i++) {
                    arr[i] = rs.getString(i+1);
                }
                model.addRow(arr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table.setModel(model);
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public int getSoSVTrong1Phong(String phong) throws SQLException {
//        conn = myConnect.connect();
//        pst = conn.prepareStatement("SELECT * FROM quan_ly_sv_ktx.phong WHERE tenPhong LIKE '"+phong+"';");
//        rs = pst.executeQuery();
//        
//        int soSV = 0;
//        while(rs.next()) {
//            soSV = rs.getInt(3) - rs.getInt(4);
//        }
//        conn.close();
//        return soSV;
//    }
    
    public int getSoLuongCho(String phong) throws SQLException {
        conn = myConnect.connect();
        pst = conn.prepareStatement("SELECT * FROM quan_ly_sv_ktx.phong WHERE tenPhong LIKE '"+phong+"';");
        rs = pst.executeQuery();
        
        int kt = 0;
        while(rs.next()) {
            kt =  rs.getInt(3);
        }
        conn.close();
        return kt;
    }
    
    public int getSoLuongChoTrong(String phong) throws SQLException {
        conn = myConnect.connect();
        pst = conn.prepareStatement("SELECT * FROM quan_ly_sv_ktx.phong WHERE tenPhong LIKE '"+phong+"';");
        rs = pst.executeQuery();
        
        int sl = 0;
        while(rs.next()) {
            sl =  rs.getInt(4);
        }
        System.out.println("sl chỗ trống = "+sl);
        conn.close();
        return sl;
    }
    
    public void updateSoLuongChoTrong(String phong, int soLuongChoTrongMoi) throws SQLException {
        conn = myConnect.connect();
        pst = conn.prepareStatement("UPDATE `quan_ly_sv_ktx`.`phong` SET `soLuongChoTrong`='"+ soLuongChoTrongMoi +"' WHERE `tenPhong`='"+phong+"';");
        pst.executeUpdate();
        conn.close();
    }
    
    public static void main(String[] args) throws SQLException {
        PhongTroFrame ptf = new PhongTroFrame();
        ptf.setVisible(true);
    }
    

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource() == cbSapXep) {
            int choice = cbSapXep.getSelectedIndex();
            sapXepTheoWhat = sapXepTheo[choice];
            System.out.println("sapXepTheoWhat = " + sapXepTheoWhat);
            showPhongTro(sapXepTheoWhat);
        }
        else if(ie.getSource() == cbTimPhong) {
            int choice = cbTimPhong.getSelectedIndex();
            if(choice == 0) timPhongReNhat = true;
            else if(choice == 1) timPhongReNhat = false;
            //System.out.println("Dòng 222:" +timPhongReNhat); TẠI SAO dòng này lại in ra 2 lần?
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btTimPhong) {
            if (timPhongReNhat == true) {
                myConnect = new MyConnect();
                conn = myConnect.connect();
                String str1 = null;
                StringBuilder str2 = new StringBuilder(); //CHÚ Ý PHẢI CÓ LỆNH new StringBuilder(); để tạo mới, nếu ko sẽ có lỗi java.lang.NullPointerException
                try {
                    pst = conn.prepareStatement("SELECT MIN(giaThue) FROM phong"); //kết quả là 1 bản ghi với 1 cột duy nhất có giá thuê nhỏ nhất. cột đó tên là MIN(giaThue)
                    rs = pst.executeQuery();
                    rs.first();
                    str1 = rs.getString("MIN(giaThue)");
                    tfGia.setText(str1);
                } catch (SQLException ex) {
                    Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(str1);
                try {
                    pst = conn.prepareStatement("SELECT * FROM phong WHERE giaThue LIKE " + str1);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        str2.append(String.valueOf(rs.getString("tenPhong")) + " ");
                    }
                    tfPhong.setText(String.valueOf(str2));
                } catch (SQLException ex) {
                    Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(timPhongReNhat == false) {
                myConnect = new MyConnect();
                conn = myConnect.connect();
                String str1 = null;
                StringBuilder str2 = new StringBuilder(); //CHÚ Ý PHẢI CÓ LỆNH new StringBuilder(); để tạo mới, nếu ko sẽ có lỗi java.lang.NullPointerException
                try {
                    pst = conn.prepareStatement("SELECT MAX(giaThue) FROM phong"); //kết quả là 1 bản ghi với 1 cột duy nhất có giá thuê nhỏ nhất. cột đó tên là MIN(giaThue)
                    rs = pst.executeQuery();
                    rs.first();
                    str1 = rs.getString("MAX(giaThue)");
                    tfGia.setText(str1);
                } catch (SQLException ex) {
                    Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(str1);
                try {
                    pst = conn.prepareStatement("SELECT * FROM phong WHERE giaThue LIKE " + str1);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        str2.append(String.valueOf(rs.getString("tenPhong")) + " ");
                    }
                    tfPhong.setText(String.valueOf(str2));
                } catch (SQLException ex) {
                    Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
