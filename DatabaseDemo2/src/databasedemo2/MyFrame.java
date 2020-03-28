import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame implements ActionListener  {
//	private String [] titleColumn = {"ID", "Name", "Point"};
	
	MyConnect myConnect = new MyConnect();
	private JTable table; 
	private JTextField tfID, tfName, tfPoint;
	private JButton btnOK, btnCancel;
	private boolean isUpdate = false; //vì btnOK dùng cho cả update và add nên dùng biến này để phân biệt. nếu isUpdate =  true thì là update(); nếu = false thì là add()
	
	public MyFrame() {
		add(createMainPanel());
		setDisplayInput(false, false); //ẩn panel input
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack(); //Jframe có kích thước vừa đủ với nội dung bên trong nó
		setLocation(300, 200);
		setLocationRelativeTo(null); //jframe hiển thị giữa màn hình chính
		setVisible(true);
		
		//connect database
		myConnect.connect();
	}
	
	private JPanel createMainPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		/////////bây giờ tạo các panel con để add vào cái panel trên://///////////
		//gồm 3 panel chính:
		//1.
		JPanel connectDBPanel = new JPanel(); 					//taoj 1 cais panel moiws
		JLabel lbConnectDB = new JLabel("Connect Database"); 	//tạo 1 cái label hiển thị tên của connectDBPanel
		connectDBPanel.add(lbConnectDB);	 						//add tên vào cái connectDBPanel
		panel.add(connectDBPanel, BorderLayout.PAGE_START );		//add connectDBPane vào cái panel ban đầu
		
		//2.
		JPanel tablePanel = new JPanel();
//		DefaultTableModel model = new DefaultTableModel();		//ví dụ: tạo 1 mẫu bảng mới
//		model.setColumnIdentifiers(titleColumn); 				//mẫu bảng này gồm 3 cột có tên như trong mảng titleColumn
		table = new JTable(); 						
		tablePanel.add(new JScrollPane(table)); 					//add cái bảng trên vào cái tablePanel
		panel.add(tablePanel, BorderLayout.CENTER ); 			//add tablePane vào cái panel ban đầu
		
		//3.
		JPanel BottomPanel = new JPanel(new GridLayout(1, 3, 5, 6));
		BottomPanel.add(createBottomPanel());
		panel.add(BottomPanel, BorderLayout.PAGE_END ); //sau đó add cái BottomPane này vào cái panel ban đầu
		////////tạo xong các panel con/////////////////////////////////////////////
		
		
//		JPanel ButtonPanel = new JPanel(new GridLayout(1, 3, 5, 6)); 	//1 hàng 3 cột, các thành phần cách nhau 5 đơn vị theo hàng ngang và 6 đơn vị theo hàng dọc. mục đích làm cho kích thước các button = nhau và đẹp hơn				
//		panel.setBorder(new EmptyBorder(5, 50, 10, 50)); //khoảng cách của các nút bấm so với các lề trên, trái, dưới, phải = 5, 50, 10, 50
		
		return panel;
	}
	
	private JPanel createBottomPanel() {
		//tạo 1 cái bottom pane trống:
		JPanel BottomPanel = new JPanel(new BorderLayout(10, 10)); //kich thước ...
		BottomPanel.setBorder(new EmptyBorder(5, 70, 10, 70));
		//bottom pane này có 2 phần chính sau:
		
		////1. thêm panel input vào BottomPanel
		JPanel inputPanel = new JPanel(new BorderLayout());
		
		///1.1. thêm panel left vào inputPanel
		JPanel panelLeft = new JPanel(new GridLayout(3, 1, 5, 5)); //3 hàng 1 cột, khoảng hởn theo hàng ngang và dọc là 5 và 5
		//// thêm các jlabel vào panelLeft
		panelLeft.add(new JLabel("ID")); 
		panelLeft.add(new JLabel("Name")); 
		panelLeft.add(new JLabel("Point")); 
		inputPanel.add(panelLeft, BorderLayout.WEST);
		
		///1.2. thêm panel right vào inputPanel
		JPanel panelRight = new JPanel(new GridLayout(3, 1, 5, 5));
		//1.2.1. thêm các textfield vào panelRight
		panelRight.add(tfID = new JTextField());
		panelRight.add(tfName = new JTextField());
		panelRight.add(tfPoint = new JTextField());
		inputPanel.add(panelRight, BorderLayout.CENTER);
		
		///1.3. thêm panel ok vào inputPanel
		JPanel panelOK = new JPanel(new GridLayout(1, 2, 5, 5)); //1 hàng 2 cột
		panelOK.setBorder(new EmptyBorder(0, 50, 0, 50)); //căn lề trên trái dưới phải
		panelOK.add(btnOK = createButton("OK"));
		panelOK.add(btnCancel = createButton("Cancel"));
		inputPanel.add(panelOK, BorderLayout.PAGE_END);
		BottomPanel.add(inputPanel, BorderLayout.CENTER);
		
		///2. thêm panel button  vào BottomPanel
		//cần 3 button cho cái ButtonPane này
		JPanel ButtonPanel = new JPanel(new GridLayout(1, 3, 5, 6)); 	//1 hàng 3 cột, các thành phần cách nhau 5 hàng ngang và 6 hàng dọc. mục đích làm cho kích thước các button = nhau và đẹp hơn				
		ButtonPanel.add(createButton("Add"));
		ButtonPanel.add(createButton("Update"));
		ButtonPanel.add(createButton("Delete"));
		ButtonPanel.setBorder(new EmptyBorder(5, 50, 10, 50)); //khoảng cách của các nút bấm so với các lề trên, trái, dưới, phải = 5, 50, 10, 50
		BottomPanel.add(ButtonPanel, BorderLayout.PAGE_END); 
		//nghĩa là trong BottomPanel có 2 cái: 1 cái inputPanel ở giữa và 1 cái ButtonPanel ở dưới cùng
		
		return BottomPanel;
	}
	
	private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.addActionListener(this);
        return btn;
	}
	
	private boolean setDisplayInput(boolean display, boolean update) {
		 if (update && (table.getSelectedRow() < 0)) { //nếu ấn nút update mà chưa chọn hàng nào để update thì return false
             return false;
		 } else if (update) { // nếu update =true thì cho phép update và hiển thị inputPanel và đưa dữ liệu vào cái inputPanel
			int row = table.getSelectedRow();
			tfID.setText((String) table.getValueAt(row, 0));
			tfName.setText((String) table.getValueAt(row, 1));
			tfPoint.setText((String) table.getValueAt(row, 2));
		}
		tfID.setEnabled(display);
		tfName.setEnabled(display);
		tfPoint.setEnabled(display);
		btnOK.setEnabled(display);
		btnCancel.setEnabled(display);

		return true;
		//chú ý hàm này chỉ return false khi cho phép update trong khi chưa chọn 1 hàng nào, còn các trường hợp khác đều true 
		//setDisplayInput(false, false) nghĩa là ẩn inputpanel và ko cho update
		//setDisplayInput(true, fasle) nghĩa là hiện inputpanel và ko cho update
		//setDisplayInput(true, true) nghĩa là hiện inputpanel và cho update
		//khi ko có hàng nào đc chọn thì setDisplayInput(true, true) = false
		//khi có 1 hàng nào đc chọn thì setDisplayInput(true, true) = true : cho phép update
		//setDisplayInput(true, fasle) = true : cho phép add
	}
	
	private void loadData() {
		
		//1. đầu tiên cần tạo 1 cái table model để thay đổi dữ liệu
		DefaultTableModel model = new DefaultTableModel();
		
		//2. sau đó lấy dữ liệu từ database
		ResultSet rs = myConnect.getData();
		try {
			
			//2.1. load tiêu đề các cột
			ResultSetMetaData rsMD = rs.getMetaData(); //lấy số cột và tiêu đề các cột trong bảng
			int columnNumber = rsMD.getColumnCount(); 	//lấy tiêu đề, số lượng các cột
			String[] arr = new String[columnNumber];  //mảng chứa tiêu đề cột, cũng dùng để lấy dữ liệu từ các bản ghi
			//lấy tên của các cột
			for(int i = 0; i<columnNumber; i++) {
				arr[i] = rsMD.getColumnName(i+1);
			}
			
			//sau đó add các tên vào 1 model
			model.setColumnIdentifiers(arr);
			
			//2.2. load dữ liệu lên từ database lên cái table
			while(rs.next()) { //trong khi các bản ghi vẫn còn thì làm gì đó...
				for(int i=0; i<columnNumber; i++) arr[i] = rs.getString(i+1); //lấy dữ liệu từ bản ghi ra 1 mảng
				model.addRow(arr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(model); //add cái model vào cái bảng, dữ liệu trong model chính là dữ liệu trên database
	}

	private void delete() {
		int row = table.getSelectedRow();
		if(row<0) { //nếu chưa có hàng nào đc chọn
			JOptionPane.showMessageDialog(null, "Bạn phải chọn 1 hàng muốn xóa", "Couldn't delete", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			int select = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa ko?", "Thông báo", JOptionPane.YES_NO_OPTION); //select = 0 là chọn yes, =1 nếu chọn No 
			if(select == 0) myConnect.deleteID((String) table.getValueAt(row, 0)); //nếu chọn yes thì xóa cái hàng = row
			loadData(); //tải lại dữ liệu
		}
	}
	
	private Student getStudent() { 
		//hàm này thực chất là lấy dữ liệu 1 sv từ inputPanel, rồi return 1 biến st có kiểu Student, biến st có dữ liệu như dữ liệu trong inputPanel
		//chú ý là việc hiển thị dữ liệu 1 sv lên inputPanel là do hàm setDisplayInput() phụ trách
		
		String id = tfID.getText().trim().toUpperCase(); //trim(): cắt đầu và đuôi nếu có dấu cách
		String name = tfName.getText().trim();
		if(id.equals("") || name.equals("")) return null;
		double point;
		try {
			point = Double.parseDouble(tfPoint.getText().trim()); //chuyển chuỗi thành số
		}
		catch (Exception e)  {
			System.out.println("Ko đổi được sang số!");
			return null;
		}
		Student st = new Student(id, name, point);
		
		//hiển thị dữ liệu và return 1 sinh viên st
		return st;
	}
	
	private void update() {
		if(setDisplayInput(true, true)) { //nếu cái inputPanel đã đc hiện lên và cho phép update và có 1 hàng đã đc chọn : setDisplayInput(true, true)==true
			isUpdate = true;
		} else {
			JOptionPane.showMessageDialog(null, "Ko update đc vì bạn chưa chọn sinh viên nào!", "Error update", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void add() {
		setDisplayInput(true, false); //hiển thị và ko cho update
	}
	
	//giải thích: ta chọn 1 sv(1 hàng),sv đó lưu vào s, khi này s != null,
	//chú ý rằng khi chọn bất kì 1 hàng thì setDisplayInput() = true
	//khi ấn Update thì set isUpdate = true, sau đó thực hiện như hàm bên dưới
	private void addOrUpdate() {
		Student s = getStudent(); //lấy dữ liệu trong inputPanel
		if(s != null) {
			if(isUpdate) { //nếu như người dùng đang muốn update thì...
				myConnect.updateID(s.getId(), s); //update sinh viên theo id của sinh viên, sửa sinh viên đó thành sinhvien s. ////hàm này bên class MyConnect
				loadData();
				isUpdate = false; //update xong phải cho = false
			}
			else {
				myConnect.insert(s); //nếu người dùng muốn insert thì ta cứ chèn sinhvien s vào thôi //hàm này bên class MyConnect
				loadData();
			}
			clear(); //sau đó xóa dữ liệu phần inputPanel đi
			setDisplayInput(false, false); //và cho ẩn cái inputPane
		} else { //nếu s = null
			JOptionPane.showMessageDialog(null, "Infomation is error", "Error info", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private void clear() { //xóa 3 textfield
		tfID.setText("");
		tfName.setText("");
		tfPoint.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Delete") {
			delete(); 
			return;
		}
		if(e.getActionCommand() == "Update") {
			update(); //nếu ấn nút update: thì sẽ gọi hàm update(), hàm update() chỉ cho hiển thị cái inputPanel lên và cho isUpdate = true thôi. khi nào ấn nút btnOK thì mới update và gọi hàm addOrUpdate()
			return;
		}
		if(e.getActionCommand() == "Add") {
			add(); 
			return;
		}
		if(e.getSource() == btnOK) {
			addOrUpdate();
		}
		if(e.getSource() == btnCancel) {
			clear(); 
			setDisplayInput(false, false); // cho ẩn cái inputPane
		}
	}
	
	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();
		mf.loadData();
//	
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
