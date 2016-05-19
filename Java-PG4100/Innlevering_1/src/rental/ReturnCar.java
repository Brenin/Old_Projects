package rental;

import logic.Logger;
import printing.Indention;

public class ReturnCar {
	private static Utleie utleie = new Utleie();
	private Logger logger = new Logger();
	private Indention tab = new Indention();
	
	public void returnCar(int carToRent, String name) {
		utleie.getLock().lock();
		try {
			if (utleie.getCarList()[carToRent].getIsRented() == true) {
				System.out.println(tab.tabs() + name + " returned car: " + 
								utleie.getCarList()[carToRent].toString());
				utleie.getCarList()[carToRent].setIsRented(false);
				utleie.getWaitForCar().signal();
			} else {

			}
		} catch (Exception e) {
			logger.logError(e);
		} finally {
			utleie.getLock().unlock();
		}
	}
}
