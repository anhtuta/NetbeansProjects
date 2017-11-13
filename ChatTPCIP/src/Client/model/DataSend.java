package Client.model;

import java.io.Serializable;
import java.util.Objects;


public class DataSend implements Serializable{
	private String command;
	private String yourUserName;
	private String password;
	private String yourFriendUserName;
	private String message;
	private String fileName;
	private byte[] data;
	
	public DataSend() {
		// TODO Auto-generated constructor stub
		
	}
	
	public DataSend(String command, String username, String password, String userSend, String message, String fileName, byte[] data){
		this.command = command;
		this.yourUserName = username;
		this.password = password;
		this.yourFriendUserName = userSend;
		this.message = message;
		this.fileName= fileName;
		this.data = data;
	}
	
	public void setCommand(String command){
		this.command = command;
	}
	
	public String getInfo(){
		return command+"|"+yourUserName+"|"+password+"|"+yourFriendUserName+"|"+message+"|"+fileName;
	}
	
	public String getYourUserName(){
		return this.yourUserName;
	}
	
	public String getYourFriendUserName(){
		return this.yourFriendUserName;
	}
	
	public String getTimelist(){
		return this.password;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public String getFileName(){
		return this.fileName;
	}
	
	public byte[] getData(){
		return data;
	}
	
	public String getCommand(){
		return command;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (!(arg0 instanceof DataSend)) {
	        return false;
	    }else if (this.getInfo().equals(((DataSend)arg0).getInfo())){
	    	return true;
	    } else return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(command, yourUserName, password, yourFriendUserName, message, fileName);
	}

}
