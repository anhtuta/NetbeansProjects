package tovanlam.lich;

import java.util.ArrayList;

import tovanlam.dongho.DateAndTime;

public class CalendarMonth {
	private Thang month;
	private Day firstDayOfMonth;
	private ArrayList<Day> listDay;
	private Day firstListDay;
	

	public CalendarMonth(Thang month) {
		this.listDay =new ArrayList<>();
		this.month = month;
		this.firstDayOfMonth = month.getFirstDayOfMonth();
		setFirstListDay();
		setListDay();
	}

	public void setFirstListDay() {
		firstListDay = firstDayOfMonth;
		
		while (firstListDay.getThu().getNumberOfThu() != 8) {
			firstListDay = firstListDay.getPrevDay();
		}
		
	}

	public void setListDay() {
		Day currentAddDay = firstListDay;
		System.out.println(firstListDay.getThu().getNumberOfThu());
		System.out.println(currentAddDay.getThu().getNumberOfThu());
		for (int i = 1; i <= 42; i++) {
			listDay.add(currentAddDay);
			currentAddDay = currentAddDay.getNextDay();
		}
	}

	public CalendarMonth getNextCalendarMonth() {
		return new CalendarMonth(month.getNextMonth());
	}

	public CalendarMonth getPrevCalendarMonth() {
		return new CalendarMonth(month.getPrevMonth());
	}

	public Thang getMonth() {
		return month;
	}

	public Day getFirstDayOfMonth() {
		return firstDayOfMonth;
	}

	public ArrayList<Day> getListDay() {
		return listDay;
	}
}
