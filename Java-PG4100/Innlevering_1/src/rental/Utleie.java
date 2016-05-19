package rental;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import car.Car;
import rental.RentCar;
import rental.ReturnCar;

public class Utleie {
	private static Lock lock = new ReentrantLock();
	private static Condition waitForCar = lock.newCondition();
	private static Car[] carList = new Car[5];
	private RentCar rentC = new RentCar();
	private ReturnCar returnC = new ReturnCar();

	public void rentCar(int carToRent, String name){
		rentC.rentCar(carToRent, name);
	}
	
	public void returnCar(int carToRent, String name){
		returnC.returnCar(carToRent, name);
	}

	public Car[] getCarList() {
		return carList;
	}

	public static void setCarList(Car[] carList) {
		Utleie.carList = carList;
	}

	public Lock getLock() {
		return lock;
	}

	public static void setLock(Lock lock) {
		Utleie.lock = lock;
	}

	public Condition getWaitForCar() {
		return waitForCar;
	}

	public static void setWaitForCar(Condition waitForCar) {
		Utleie.waitForCar = waitForCar;
	}
}