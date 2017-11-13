package Client.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversation implements IConversation {
	private String name;
	private String displayName;
	private String mess;
	private long date;
	public Conversation(String initName, String displayName, String initMess, long initTime){
		this.displayName = displayName;
		this.name = initName;
		this.mess = initMess;
		this.date = initTime;
	}
	@Override
	public long getMinAgo() {
		// TODO Auto-generated method stub
		Date date = new Date();
		long time = date.getTime();
		time = time - this.date;
		long min = time/1000/60;
		return min;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public String getMess() {
		// TODO Auto-generated method stub
		return this.mess;
	}
	
	
	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Date date = new Date(this.date);
		
		return dateFormat.format(date);
	}
	@Override
	public String toString(){
		return this.displayName + " - " + this.mess + " - " + this.getDate();
	}
	
	public String getDisplayName(){
		return this.displayName;
	}
}
