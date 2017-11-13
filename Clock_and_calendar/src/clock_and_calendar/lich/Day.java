package tovanlam.lich;

public class Day {
	private Thu thu;
	private Ngay ngay;
	private boolean isFirstDayOfMonth;
	
	public Day(Thu thu, Ngay ngay) {
		this.thu = thu;
		this.ngay = ngay;
		if (this.ngay.isFirstDay()) {
			isFirstDayOfMonth = true;
		} else
			isFirstDayOfMonth = false;
	}

	public Day getNextDay() {
		Thu nextThu = thu.getNextThu();
		Ngay nextNgay = ngay.getNextDay();
		Day nextDay = new Day(nextThu, nextNgay);
		return nextDay;
	}

	public Day getPrevDay() {
		Thu prevThu = thu.getPrevThu();
		Ngay prevNgay = ngay.getPrevDay();
		Day prevDay = new Day(prevThu, prevNgay);
		return prevDay;
	}

	public Thu getThu() {
		return thu;
	}

	public Ngay getNgay() {
		return ngay;
	}

	public Thang getThang() {
		return ngay.getThang();
	}

	public Nam getNam() {
		return ngay.getThang().getYear();
	}

	public boolean isFirstDayOfMonth() {
		return isFirstDayOfMonth;
	}

}
