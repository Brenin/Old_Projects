package test;

import static org.junit.Assert.*;

import org.junit.Test;

import car.Car;

public class CarTest {

	@Test
	public void testSetIsRented_trueBool_true() {
		Car c = new Car();
		c.setIsRented(true);
		assertTrue(c.getIsRented());
	}
	
	@Test
	public void testSetIsRented_falseBool_false() {
		Car c = new Car();
		c.setIsRented(false);
		assertFalse(c.getIsRented());
	}

	@Test
	public void testSetRegNr_passingString_equals() throws Exception {
		Car c = new Car();
		c.setRegNr("12345");
		assertEquals("XX12345", c.toString());
	}
	
	@Test
	public void testGetRegNr_passingString_equals() throws Exception {
		Car c = new Car();
		c.setRegNr("12345");
		assertEquals(c.getRegNr(), "12345");
	}

	@Test
	public void testToString_passingRightString_equals() throws Exception {
		Car c = new Car();
		c.setRegNr("12345");
		assertEquals("XX12345", c.toString());
	}
	
	@Test (expected = Exception.class)
	public void testToString_passingWrongString_throwQException() throws Exception {
		Car c = new Car();
		c.setRegNr("1234567");
	}
}
