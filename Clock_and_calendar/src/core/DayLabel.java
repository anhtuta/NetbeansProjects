package core;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DayLabel extends JLabel{
	private String day;
	private String month;
	private String year;
	public DayLabel(String day, String month, String year, Integer st){
		this.day= day;
		this.month = month;
		this.year= year;
		setText();
		setColor(st);
	}
	public void setText(){
		
	}
	public void setColor(Integer st){
		
	}
	class FrameDay extends JFrame{
		
	}
}
