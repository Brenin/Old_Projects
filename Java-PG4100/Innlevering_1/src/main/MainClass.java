package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import car.CreateCar;
import rental.RentalTask;

public class MainClass {
	private static CreateCar cc = new CreateCar();
	final static CountDownLatch latch = new CountDownLatch(5);

	public static void main(String[] args) {
		cc.create();

		ExecutorService executor = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 10; i++) {
			executor.execute(new RentalTask(latch));
		}
		executor.shutdown();
	}	
}
