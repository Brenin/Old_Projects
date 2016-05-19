package logic;

import java.util.Random;

public class RngWaitTime {
	private Random random = new Random();
	
	public int waitTime() {
		int tmp = random.nextInt(9000) + 1000;
		return tmp;
	}
}
