package logic;

import java.util.Random;

public class RngSleepTime {
	private Random random = new Random();

	public int sleepTime() {
		int tmp = random.nextInt(2000) + 1000;
		return tmp;
	}
}
