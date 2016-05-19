package com.PrimeChecker.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrimeTest {

	String tmp;
	String tmp2;
	String wrongFormat;
	Prime prime;
	
	@Before
	public void setUp() throws Exception {
		prime = new Prime();
		tmp = "5";
		tmp2 = "6";
		wrongFormat = "lol";
	}

	@Test
	public void testCheckIfPrime() {
		prime.checkIfPrime(tmp);
		assertTrue(prime.getIsPrime());
	}
	
	@Test
	public void testCheckIfPrime2() {
		prime.checkIfPrime(tmp2);
		assertFalse(prime.getIsPrime());
	}

	@Test
	public void testGetIsPrime() {
		prime.checkIfPrime(tmp2);
		assertFalse(prime.getIsPrime());
	}

	@Test(expected = NumberFormatException.class)
	public void testWrongNumberFormat(){
		prime.checkIfPrime(wrongFormat);
	}
}
