package tovanlam.lich;

public class Nam {
	private final int soThang = 12;
	private int numberOfYear;
	private boolean isNhuan;

	public Nam(int numberOfYear) {
		this.numberOfYear = numberOfYear;
		if (this.numberOfYear % 4 == 0) {
			isNhuan = true;
		} else {
			isNhuan = false;
		}
	}

	public Nam getNextYear() {
		Nam nam = new Nam(numberOfYear + 1);
		return nam;
	}

	public Nam getPrevYear() {
		Nam nam = new Nam(numberOfYear - 1);
		return nam;
	}

	public int getSoThang() {
		return soThang;
	}

	public int getNumberOfYear() {
		return numberOfYear;
	}

	public boolean isNhuan() {
		return isNhuan;
	}
}
