package logic;

import java.util.Random;

public class RngRegNr {
	private Random random = new Random();
	Integer tmp;
	String tmpRegNr;

	public String rngRegNr(){
		tmpRegNr = "";
		for(int i = 0; i < 5; i++){
			tmp = random.nextInt(9);
			tmpRegNr += tmp.toString();
		}
		return tmpRegNr;
	}
}
