/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTu
 */
//class này tạo Frame = tay cho khó hơn
public class PhongTroFrame extends JFrame implements ActionListener,ItemListener {
    private MyConnect myConnect = new MyConnect();
    private Connection conn = myConnect.connect();
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
    
    
    public PhongTroFrame() { //create a frame to display list phongtro
        add(panelChinhCuaFrame());
        showPhongTroSapXepTheoWhat(sapXepTheoWhat);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(100, 100);
        pack();
        setVisible(true);
    }
    
    public JPanel panelChinhCuaFrame() { //panel chính của frame, dùng để khai báo các thành phần của frame
        JPanel panel = new JPanel(new BorderLayout()); //cái panel chính
        
        //chú ý: muốn thêm 1 phần tử nào đó(button, textfield,...) ta phải tạo 1 panel để chứa nó, sau đó thêm cái panel này vào panel chính lúc đầu

        //thêm 1 cái tên cho table
        JPanel panelLabel = new JPanel();
        lbTenCuaTable = new JLabel("DANH SÁCH CÁC PHÒNG TRỌ CỦA KÝ TÚC XÁ");
        lbTenCuaTable.setFont(new java.awt.Font("Tahoma", 1, 18));
        panelLabel.add(lbTenCuaTable);
        panel.add(panelLabel, BorderLayout.PAGE_START);
        
        //Thêm 1 panel để chứa cái table
        JPanel panelTable = new JPanel();
        table = new JTable();
        panelTable.add(new JScrollPane(table)); //add cái table vào cái paneltable trên, ntn thì cái bảng mới cuộn lên xuống đc
        panel.add(panelTable, BorderLayout.CENTER); //cho cái tablePane vào giữa cái panel chính       
        
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
    
    public ResultSet getDataPhongTro() { //sau khi có hàm getDataPhongTroSapXepTheoWhat thì hàm này ko cần dùng nữa
        try {
            pst = conn.prepareStatement("SELECT * FROM phong");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getDataPhongTroSapXepTheoWhat(String what) {
        try {
            pst = conn.prepareStatement("SELECT * FROM phong ORDER BY "+what);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
    
    public void showPhongTro() { //làm giống hàm refresh() bên class sinhvienframe
        //sau khi có hàm showPhongTroSapXepTheoWhat() thì hàm này ko cần nữa
        DefaultTableModel model = new DefaultTableModel();
        
        rs = getDataPhongTro();
        try {
            ResultSetMetaData rsMD = rs.getMetaData();
            int columnNumber = rsMD.getColumnCount(); //lấy số cột
            String [] arr = new String[columnNumber];
            
            for (int i = 0; i < columnNumber; i++) {
                arr[i] = columnName[i]; //tiêu đề các cột
            }
            
            model.setColumnIdentifiers(arr); //sau đó add các tên vào 1 model
            
            //thêm tất cả các hàng vào model
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
    }
    
    public void showPhongTroSapXepTheoWhat(String what) {
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
    }
    
    public static void main(String[] args) {
        PhongTroFrame pt = new PhongTroFrame();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == cbSapXep) {
            
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        ///cách 1
//        if(ie.getStateChange()== ItemEvent.SELECTED) {
//            System.out.println("Sắp xếp theo "+ie.getItem());
//            
//            if(ie.getItem() == "Tên phòng") sapXepTheoWhat = "tenPhong";
//            if(ie.getItem() == "Loại phòng") sapXepTheoWhat = "loaiPhong";
//            if(ie.getItem() == "Số lượng chỗ") sapXepTheoWhat = "soLuongCho";
//            if(ie.getItem() == "Số lượng chỗ trống") sapXepTheoWhat = "soLuongChoTrong";
//            if(ie.getItem() == "Giá thuê") sapXepTheoWhat = "giaThue";
//            if(ie.getItem() == "Tòa nhà") sapXepTheoWhat = "ToaNha_tenToaNha";
//            
//            System.out.println("sapXepTheoWhat = "+sapXepTheoWhat);         
//        }
        
        /////cách 2:
        int choice = cbSapXep.getSelectedIndex();
        sapXepTheoWhat = sapXepTheo[choice];
        System.out.println("sapXepTheoWhat = "+sapXepTheoWhat);  
        showPhongTroSapXepTheoWhat(sapXepTheoWhat);
        
    }
}
