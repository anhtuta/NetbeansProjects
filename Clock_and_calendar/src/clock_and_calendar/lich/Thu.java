package tovanlam.lich;

public class Thu {
	public static final int MAX_THU = 8;
	public static final int MIN_THU = 2;
	private int numberOfThu;

	public Thu(int numberOfThu) {
		this.numberOfThu = numberOfThu;
	}

	public Thu getNextThu() {
		if (this.numberOfThu == 8) {
			return new Thu(2);
		} else {
			return new Thu(this.numberOfThu + 1);
		}
	}
	public Thu getPrevThu() {
		if (this.numberOfThu == 2) {
			return new Thu(8);
		} else {
			return new Thu(this.numberOfThu - 1);
		}
	}
	 public int getNumberOfThu() {
		return numberOfThu;
	}

}
