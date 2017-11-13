package tovanlam.dongho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateAndTime {
	private static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	private Date today = calendar.getTime();
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Date date = new Date();
	private static String dateAndTime = dateFormat.format(date);
	private static int year = Integer.valueOf(dateAndTime.substring(0, 4));
	private static int month = Integer.valueOf(dateAndTime.substring(5, 7));
	private static int day = Integer.valueOf(dateAndTime.substring(8, 10));
	private static int hour = Integer.valueOf(dateAndTime.substring(11, 13));
	private static int minute = Integer.valueOf(dateAndTime.substring(14, 16));
	private static int second = Integer.valueOf(dateAndTime.substring(17, 19));

	public static String getDateAndTime() {
		return dateAndTime;
	}

	public static int getYear() {
		return year;
	}

	public static int getMonth() {
		return month;
	}

	public static int getDay() {
		return day;
	}

	public static int getHour() {
		return hour;
	}

	public static int getMinute() {
		return minute;
	}

	public static int getSecond() {
		return second;
	}
}
