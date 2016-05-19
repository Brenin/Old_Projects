package com.PrimeChecker.logic;

import org.apache.commons.math3.primes.Primes;

public class Prime {

	private boolean isAPrime;
	
	public void checkIfPrime(String nrToTest){
		int tmp = Integer.parseInt(nrToTest);
		setIsPrime(Primes.isPrime(tmp));
	}

	public boolean getIsPrime() {
		return isAPrime;
	}

	private void setIsPrime(boolean isAPrime) {
		this.isAPrime = isAPrime;
	}
}