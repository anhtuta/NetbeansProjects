import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

//CHÚ Ý: PHẢI VIẾT ĐÚNG CÚ PHÁP CÁC LỆNH MYSQL, VÍ DU: update student_info set name = ?, point = ? where id = ?"

public class MyConnect {
	private final String className = "com.mysql.jdbc.Driver"; //giá trị mặc định 
	
	private Connection connection; //connect đến dữ liệu
	
	public void connect() { //dùng để kết nối từ Java đến csdl trong sql
		try {
			Class.forName(className); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "5555"); //trong ngoặc lần lượt laf: đường dẫn đến csdl student, user, password
			//hoặc connection = DriverManager.getConnection("jdbc:mysql://localhost/student?" + "user=root&password=5555");
			System.out.println("Connect thành công nhé!");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found! hehe!");
		} catch (SQLException e) {
			System.out.println("Error connection! Lỗi kết nối nhé mày!");
		}
	}
	
	public ResultSet getData() { //lấy dữ liệu của bảng student_info
		ResultSet rs = null;
		java.sql.Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select * from student_info");
		} catch (SQLException e) {
			System.out.println("select errot \n" + e.toString());
		}
		return rs;
	}
	
	public ResultSet getDataID(String id) { //lấy dữ liệu sinh vien có ID = id
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("select * from student_info where id = ?"); //chú ý student_info là tên bảng trong csdl của chúng ta
			pst.setString(1, id);    // ví dụ nếu id = 20134509 thì setString = 20134509 cho dấu ? thử nhất trong chuỗi "select * from student_info where `id` = ?"
			//hoặc gộp làm 1 câu:
			//pst = connection.prepareStatement("select * from student_info where id = "+id); 
			
			rs = pst.executeQuery(); 
//			if(pst.executeQuery() != null){
//				System.out.println("Ko có sinh viên nào ");
//			}
		} catch (SQLException e) {
			System.out.println("select error \n ko tồn tại sinh viên này" + e.toString());
		}
		return rs;
	}
	
	public void deleteID(String id) {
		
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("delete from student_info where id = ?");
			pst.setString(1, id);
			if(pst.executeUpdate() > 0) //delete hoặc insert, update đều thực hiện thông qua lệnh executeUpdate()
				System.out.println("deleted successfully");
			else System.out.println("Couldn't delete: ID ko tồn tại!");
		} catch (SQLException e) {
			System.out.println("Delete error: "+e.toString());
		}
	}
	
	public void insert(Student s) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("insert into student_info value(?,?,?)");
			pst.setString(1, s.getId());
			pst.setString(2, s.getName());
			pst.setDouble(3, s.getPoint());
			if(pst.executeUpdate() > 0) 
				System.out.println("insert successfully");
			else System.out.println("insert failed!"); //chú ý rằng lệnh pst.executeUpdate() đã được thực hiện trong câu lệnh if
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateID(String id, Student s) { //update sv có ID = id thành sinh viên mới = s
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement("update student_info set name = ?, point = ? where id = ?");
			pst.setString(1, s.getName());
			pst.setDouble(2, s.getPoint());
			pst.setString(3, s.getId());
			if(pst.executeUpdate() > 0) 
				System.out.println("update successfully");
			else System.out.println("update failed!"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showData(ResultSet rs) { //in kq: hiển thị các bản ghi ra
		try {
			while(rs.next()) {
				System.out.printf("%-10s %-20s %-2.2f\n", rs.getString(1), rs.getString(2), rs.getDouble(3)); 
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MyConnect myConnect = new MyConnect();	
		myConnect.connect();
		
		myConnect.showData(myConnect.getData()); //lay data va in toan bo cai data ra
//		
		System.out.println("Hiển thị sinh viên có id = 20134509 ");
		myConnect.showData(myConnect.getDataID("20134509"));
//		
		myConnect.deleteID("20130008");
		System.out.println("dữ liệu của bảng sau khi xóa 1 sinh vien");
		myConnect.showData(myConnect.getData());
//		
		myConnect.insert(new Student("20130008", "krilin", 2.21));
		System.out.println("dữ liệu của bảng sau khi chèn 1 sinh viên");
		myConnect.showData(myConnect.getData());
		
		myConnect.updateID("20130003", new Student("20130003", "Go Ten", 3.42));
		System.out.println("sau khi update 1 sinh vien: ");
		myConnect.showData(myConnect.getData());
		
		
	}
}
