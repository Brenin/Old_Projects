package rental;

import logic.Logger;
import printing.MainPrinting;

public class RentCar {
	private static Utleie utleie = new Utleie();
	private Logger logger = new Logger();
	private MainPrinting pr = new MainPrinting();
	
	public void rentCar(int carToRent, String name) {
		utleie.getLock().lock();
		try {
			if (utleie.getCarList()[carToRent].getIsRented() == true) {
				System.out.println("Car not available");
				utleie.getWaitForCar().await();
			} else {
				System.out.println(utleie.getCarList()
						[carToRent].toString() + " Rented by: " + name);
				utleie.getCarList()[carToRent].setIsRented(true);
			}
		} catch (Exception e) {
			logger.logError(e);
		} finally {
			pr.statusPrint(utleie.getCarList());
			utleie.getLock().unlock();
		}
	}
}
