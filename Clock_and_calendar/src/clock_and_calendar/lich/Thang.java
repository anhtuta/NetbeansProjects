package tovanlam.lich;

public class Thang {
	private Nam year;
	private int numberOfMonth;
	private int numberDay;
	public static final Day FIRST_DAY_OF_JANUARY_2000 = new Day(new Thu(7), new Ngay(1, new Thang(1, new Nam(2000))));
	private Day firstDayOfMonth;

	public Thang(int numberOfMonth, Nam year) {
		this.numberOfMonth = numberOfMonth;
		this.year = year;
		setNumberDay();
		
		
	}
	public void setNumberDay() {
 
		if (this.numberOfMonth == 1 || this.numberOfMonth == 3 || this.numberOfMonth == 5 || this.numberOfMonth == 7
				|| this.numberOfMonth == 8 || this.numberOfMonth == 10 || this.numberOfMonth == 12) {
			this.numberDay = 31;
		}
		if (this.numberOfMonth == 4 || this.numberOfMonth == 6 || this.numberOfMonth == 9 || this.numberOfMonth == 11) {
			this.numberDay = 30;
		}
		if (this.numberOfMonth == 2) {
			if (this.year.isNhuan()) {
				this.numberDay = 29;
			} else {
				this.numberDay = 28;
			}
		}
	}
	public void setFirstDayOfMonth() {
		if (this.numberOfMonth == 1 && this.getYear().getNumberOfYear() == 2000) {
			this.firstDayOfMonth = Thang.FIRST_DAY_OF_JANUARY_2000;
		} else {
			if (this.year.getNumberOfYear() >= 2000) {
				this.firstDayOfMonth = this.getPrevMonth().getFirstDayOfNextMonth();
			} else {
				this.firstDayOfMonth = this.getNextMonth().getFirstDayOfPrevMonth();
			}
		}
	}


	public Day getFirstDayOfNextMonth() {
		Thang thang = this.getNextMonth();
		Ngay ngay = new Ngay(1, thang);
		Thu thu = this.getFirstDayOfMonth().getThu();
		for (int i = 1; i <= (this.numberDay % 7); i++) {
			thu = thu.getNextThu();
		}
		return new Day(thu, ngay);
	}

	public Day getFirstDayOfPrevMonth() {
		Thang thang = this.getPrevMonth();
		Ngay ngay = new Ngay(1, thang);
		Thu thu = this.firstDayOfMonth.getThu();
		for (int i = 1; i <= (this.getPrevMonth().getNumberDay() % 7); i++) {
			thu = thu.getPrevThu();
		}
		return new Day(thu, ngay);
	}

	public Thang getNextMonth() {
		Nam yearNextMonth;
		int numberOfNextMonth;
		if (numberOfMonth == 12) {
			yearNextMonth = year.getNextYear();
			numberOfNextMonth = 1;
		} else {
			yearNextMonth = year;
			numberOfNextMonth = numberOfMonth + 1;
		}
		Thang nextMonth = new Thang(numberOfNextMonth, yearNextMonth);
		return nextMonth;

	}

	public Thang getPrevMonth() {
		Nam yearPrevMonth;
		int numberOfPrevMonth;
		if (numberOfMonth == 1) {
			yearPrevMonth = year.getPrevYear();
			numberOfPrevMonth = 12;
		} else {
			yearPrevMonth = year;
			numberOfPrevMonth = numberOfMonth - 1;
		}
		Thang prevMonth = new Thang(numberOfPrevMonth, yearPrevMonth);
		return prevMonth;
	}

	

	public Nam getYear() {
		return year;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

	public int getNumberDay() {
		return numberDay;
	}
	public Day getFirstDayOfMonth() {
		this.setFirstDayOfMonth();
		return firstDayOfMonth;
	}

}
