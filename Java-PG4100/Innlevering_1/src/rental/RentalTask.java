package rental;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import customer.Customer;
import logic.Logger;
import logic.RngWaitTime;
import logic.RngSleepTime;

public class RentalTask implements Runnable {
	private final CountDownLatch latch;
	private RngWaitTime rngWait = new RngWaitTime();
	private RngSleepTime rngSleep = new RngSleepTime();
	private Utleie utleie = new Utleie();
	private Logger logger = new Logger();
	private Random random = new Random();
	
	private int carToRent;
	private int tmp;

	public RentalTask(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		Customer cu = new Customer();
		System.out.print(cu.toString());
		
		latch.countDown();
		try {
			latch.await();
		} catch (Exception e) {
			logger.logError(e);
		}

		try {
			while (true) {
				tmp = rngWait.waitTime();
				Thread.sleep(tmp);

				carToRent = random.nextInt(5);
				utleie.rentCar(carToRent, cu.getName());

				tmp = rngSleep.sleepTime();
				Thread.sleep(tmp);
				utleie.returnCar(carToRent, cu.getName());
			}
		} catch (Exception e) {
			logger.logError(e);
		}
	}
}
