package car;

import rental.Utleie;
import printing.MainPrinting;
import logic.RngRegNr;

public class CreateCar {
	private Utleie utleie = new Utleie();
	private MainPrinting pr = new MainPrinting();
	private RngRegNr rng = new RngRegNr();
	
	public void create() {
		for (int i = 0; i < 5; i++) {
			Car car = new Car();
			try {
				car.setRegNr(rng.rngRegNr());
			} catch (Exception e) {
				System.out.println("Wrong format on RegNr");
			}
			utleie.getCarList()[i] = car;
		}
		pr.statusPrint(utleie.getCarList());
	}
}
