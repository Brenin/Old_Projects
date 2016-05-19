package printing;

import car.Car;

public class MainPrinting {
	private static LineBreak lb = new LineBreak();
	private static PrintTopLine ptl = new PrintTopLine();
	private static PrintBottomLine pbl = new PrintBottomLine();
	
	public void statusPrint(Car[] carList){
		ptl.topStatusLine();
		for(Car car : carList){
			if(car.getIsRented() == false){
				System.out.print(car.toString() + " - Available  ");
			} else{
				System.out.print(car.toString() + " - Rented  ");
			}
		}
		lb.lineBreak();
		pbl.bottomStatusLine();
	}
}
