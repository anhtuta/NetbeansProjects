package tovanlam.lich;

public class Ngay {
	private int numberOfDay;
	private boolean isFirstDay;
	private Thang thang;

	public Ngay(int numberOfNgay, Thang thang) {
		this.numberOfDay = numberOfNgay;
		if (this.numberOfDay == 1) {
			isFirstDay = true;
		} else {
			isFirstDay = false;
		}
		this.thang = thang;
	}

	public Ngay getNextDay() {
		int numberOfNextDay;
		Thang thangOfNextDay;
		if (this.numberOfDay == this.thang.getNumberDay()) {
			numberOfNextDay = 1;
			thangOfNextDay = this.thang.getNextMonth();
		} else {
			numberOfNextDay = this.numberOfDay + 1;
			thangOfNextDay = this.thang;
		}
		Ngay nextDay = new Ngay(numberOfNextDay, thangOfNextDay);
		return nextDay;
	}

	public Ngay getPrevDay() {
		int numberOfPrevDay;
		Thang thangOfPrevDay;
		if (this.numberOfDay == 1) {
			numberOfPrevDay = this.thang.getPrevMonth().getNumberDay();
			thangOfPrevDay = this.thang.getPrevMonth();
		} else {
			numberOfPrevDay = this.numberOfDay - 1;
			thangOfPrevDay = this.thang;
		}
		Ngay prevDay = new Ngay(numberOfPrevDay, thangOfPrevDay);
		return prevDay;
	}

	public int getNumberOfDay() {
		return numberOfDay;
	}

	public boolean isFirstDay() {
		return isFirstDay;
	}

	public Thang getThang() {
		return thang;
	}

}
