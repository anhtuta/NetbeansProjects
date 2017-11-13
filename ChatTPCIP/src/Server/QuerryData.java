package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuerryData {
	public DataSend data = new DataSend();
	public QuerryData() {
		// TODO Auto-generated constructor stub
	}
	
	public QuerryData(DataSend dataReceive) {
		String command = dataReceive.getCommand();
	}
	
	public void QuerrySignIn(DataSend dataReceive) throws SQLException{
		String userName = dataReceive.getInfo().split("\\|")[1];
		String password = dataReceive.getInfo().split("\\|")[2];
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "SELECT * FROM tbl_user WHERE (userName = '"+userName+"');";
		ResultSet rs = stmt.executeQuery(queryStr);
		if(!rs.first())
			data.setCommand("SignInNotOK");
		else{
			if (rs.getString("password").equals(password))
				data.setCommand("SignInOK");
			else
				data.setCommand("SignInNotOK");
		}
	}
	
	//////////////////////
	
	public void QuerrySignUp(DataSend dataReceive) throws SQLException{
		String userName = dataReceive.getInfo().split("\\|")[1];
		//String password = dataReceive.getInfo().split("|")[2];
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "SELECT * FROM tbl_user WHERE (userName = '"+userName+"');";
		ResultSet rs = stmt.executeQuery(queryStr);
		if(!rs.first())
			data.setCommand("SignUpOK");
		else
			data.setCommand("SignUpNotOK");
	}
	
	///////////////////////////////
	
	public void AddUser(DataSend dataReceive) throws SQLException{
		String userName = dataReceive.getInfo().split("\\|")[1];
		String password = dataReceive.getInfo().split("\\|")[2];
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "INSERT IGNORE INTO tbl_user VALUES(?,?);";
		PreparedStatement addStmt = conn.prepareStatement(queryStr);
		addStmt.setString(1, userName);
		addStmt.setString(2, password);
		addStmt.addBatch();
		addStmt.executeBatch();
	}
	
	///////////////////////////////
	public void QuerryListChat (DataSend dataReceive)throws SQLException{
		String yourUser = dataReceive.getInfo().split("\\|")[1];
		String yourFriendUserList = "";
		String messageList = "";
		String timeList = "";
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "SELECT userSend, userReceive, message, time FROM (SELECT * from tbl_conversation ORDER BY time DESC limit 50)t WHERE (userSend = '"+yourUser+"') OR (userReceive LIKE '% "+yourUser+" %') GROUP BY userReceive ORDER BY time DESC;";
		ResultSet rs = stmt.executeQuery(queryStr);
		if(!rs.first())System.out.println("Have no record!");
		else{
		//display result if not empty
			do{
				String yourFriendUser = rs.getString(2).replaceAll("\\|", "").trim();
				String message = rs.getString(3).replaceAll("\\|", "").trim();
				Timestamp dt = rs.getTimestamp(4);
				Long time = dt.getTime();
				yourFriendUserList = yourFriendUserList+yourFriendUser+"_";
				messageList = messageList + message + "_";
				timeList = timeList+ time.toString() + "_";
			}while(rs.next());
		}
		data = new DataSend("updateListChat", null, timeList, yourFriendUserList, messageList, null, null);
	}
	///////////////////////////
	
	public void QuerryChatWindow (DataSend dataReceive) throws SQLException{
		String yourUser = dataReceive.getInfo().split("\\|")[1];
		String yourFriendUser = dataReceive.getYourFriendUserName();
		Connection conn;
		String messageList = "";
		String userSendList = "";
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "SELECT message, time, userSend, userReceive, seen FROM tbl_conversation WHERE (userReceive = '"+yourFriendUser+"');";
		ResultSet rs = stmt.executeQuery(queryStr);
		if(!rs.first())
			data = new DataSend("updateChatWindow", " ", " ", " ", " ", " ", new byte[2]);
		else{
		//display result if not empty
			do{
				String message = rs.getString(1).replaceAll("\\|", "").trim();
				String userSend = rs.getString(3).replaceAll("\\|", "").trim(); 
				messageList = messageList + message + "_";
				userSendList = userSendList + userSend + "_";
			} while(rs.next());
		}
		data = new DataSend("updateChatWindow", yourUser, userSendList, yourFriendUser, messageList, null, null);
	}
	
	/////////////////////////////
	
	public void AddMessage(DataSend dataReceive) throws SQLException{
		String yourUser = dataReceive.getInfo().split("\\|")[1];
		String yourFriendUser = dataReceive.getYourFriendUserName();
		String message = dataReceive.getMessage();
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "INSERT IGNORE INTO tbl_conversation VALUES(NULL,?,?,?,?,?);";
		PreparedStatement addStmt = conn.prepareStatement(queryStr);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        addStmt.setString(1, yourUser);
		addStmt.setString(2, yourFriendUser);
		addStmt.setString(3, message);
		addStmt.setString(4, time);
		addStmt.setInt(5, 0);
		addStmt.addBatch();
		addStmt.executeBatch();
	}
	
	public void SendFile (DataSend dataReceive) throws SQLException{
		String yourUser = dataReceive.getYourUserName();
		String yourFriendUser = dataReceive.getYourFriendUserName();
		String fileName = dataReceive.getFileName();
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "INSERT IGNORE INTO tbl_conversation VALUES(NULL,?,?,?,?,?);";
		PreparedStatement addStmt = conn.prepareStatement(queryStr);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        addStmt.setString(1, yourUser);
		addStmt.setString(2, yourFriendUser);
		addStmt.setString(3, "<file>"+fileName);
		addStmt.setString(4, time);
		addStmt.setInt(5, 0);
		addStmt.addBatch();
		addStmt.executeBatch();
	}
	
	public void AddConversation(DataSend dataReceive) throws SQLException {
		String yourUser = dataReceive.getYourUserName();
		String yourFriendUser = dataReceive.getYourFriendUserName();
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		String queryStr = "INSERT IGNORE INTO tbl_conversation VALUES(NULL,?,?,?,?,?);";
		PreparedStatement addStmt = conn.prepareStatement(queryStr);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        addStmt.setString(1, yourUser);
		addStmt.setString(2, yourFriendUser);
		addStmt.setString(3, "|null|");
		addStmt.setString(4, time);
		addStmt.setInt(5, 0);
		addStmt.addBatch();
		addStmt.executeBatch();
	}
	
	public void QuerryUser (DataSend dataReceive) throws SQLException {
		String yourFriendUser = dataReceive.getYourFriendUserName();
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		int i = 1;
		boolean check = true;
		try{
			while (yourFriendUser.split("\\s+")[i] != null){
				String queryStr = "SELECT * from tbl_user WHERE (userName = '"+yourFriendUser.split("\\s+")[i]+"');";
				ResultSet rs = stmt.executeQuery(queryStr);
				if(!rs.first()){
					check = false;
					break;
				}
				i++;
			}
		}
		catch (ArrayIndexOutOfBoundsException e ) {
	        System.out.println("Split done");
	    }
		if (check)
			data.setCommand("AddConversationOK");
		else data.setCommand("AddConversationNotOK");
	} 
	
	public void SetSeen(DataSend dataReceive) throws SQLException{
		String yourFriendUser = dataReceive.getYourFriendUserName();
		String queryStr = "UPDATE tbl_conversation SET seen = 1 WHERE (userReceive = '"+yourFriendUser+"') AND (message<>'|');";
		Connection conn;
		Statement stmt = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:6688/chat", "root", "");
		stmt = conn.createStatement();
		stmt.executeUpdate(queryStr);
	}
	
}
