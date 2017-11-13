/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author AnhTu
 */
///class này cho thấy lỗi sai khi tạo frame. xem class PhongTro để hiểu cách tạo đúng

public class PhongTroFrame_CreateFrameInAWrongWay extends JFrame {
    
    private JTable table;
    private JLabel lbTenCuaTable;
    private JComboBox cbSapXep;
    
    public PhongTroFrame_CreateFrameInAWrongWay() { //create a frame to display list phongtro
        initComponents(); //sai ở chỗ này, hàm này trả về kiểu void nên cái frame sẽ chả có cái j
        this.setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    public void initComponents() { //panel chính của frame, dùng để khai báo các thành phần của frame
        JPanel panel = new JPanel(new BorderLayout()); //cái panel chính
        
        //Thêm 1 panel để chứa cái table
        JPanel tablePane = new JPanel();
        table = new JTable();
        tablePane.add(new JScrollPane(table)); //add cái table vào cái paneltable trên, ntn thì cái bảng mới cuộn lên xuống đc
        panel.add(tablePane, BorderLayout.CENTER); //cho cái tablePane vào giữa cái panel chính
        
        //thêm 1 cái tên cho table
        JPanel lbPanel = new JPanel();
        lbTenCuaTable = new JLabel("DANH SÁCH CÁC PHÒNG TRỌ CỦA KÝ TÚC XÁ");
        lbTenCuaTable.setFont(new java.awt.Font("Tahoma", 2, 18));
        lbPanel.add(lbTenCuaTable);
        panel.add(lbPanel, BorderLayout.PAGE_START);
        
    }
    
    public static void main(String[] args) {
        PhongTroFrame_CreateFrameInAWrongWay pt = new PhongTroFrame_CreateFrameInAWrongWay();
    }
}
