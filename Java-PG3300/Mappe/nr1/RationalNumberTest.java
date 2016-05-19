package nr1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RationalNumberTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void rationalNumber_testEmptyConstructor() {
		
		RationalNumber rn = new RationalNumber();
		
		assertEquals("0", rn.toString());
		
	}

	@Test
	public void RationalNumber_testConstructorWithPositiveNumbers() {

		RationalNumber rn = new RationalNumber(1, 2);

		assertEquals("1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_testConstructorWithNegativeNumbers() {

		RationalNumber rn = new RationalNumber(-1, -2);

		assertEquals("1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_testConstructorWithNegativeDenominator() {

		RationalNumber rn = new RationalNumber(1, -2);

		assertEquals("-1/2", rn.toString());
	}
	
	@Test
	public void RationalNumber_testConstructorWithNegativeNominator() {

		RationalNumber rn = new RationalNumber(-1, 2);

		assertEquals("-1/2", rn.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void RationalNumber_testConstructorWithInValidNumbers() {

		@SuppressWarnings("unused")
		RationalNumber rn = new RationalNumber(3, 0);
	}

	@Test
	public void toString_testExpectedOutput() {

		RationalNumber rn = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(2, 1);

		assertEquals("1/2", rn.toString());
		assertEquals("2", rn2.toString());
	}
	
	@Test
	public void getNumerator_testExpectedGet() {

		RationalNumber rn = new RationalNumber(1, 2);
		
		assertEquals(1, rn.getNumerator());
	}
	
	@Test
	public void getDenominator_testExpectedGet() {

		RationalNumber rn = new RationalNumber(1, 2);
		
		assertEquals(2, rn.getDenominator());
	}
	
	@Test
	public void Equals_testWithDifferentObjects() {

		RationalNumber rn1 = new RationalNumber(3, 8);
		RationalNumber rn2 = new RationalNumber(3, 8);
		
		assertNotSame(rn1, rn2);
	}
	
	@Test
	public void Equals_testWithTheSameObject() {
		
		RationalNumber rn1 = new RationalNumber(3, 8);
		
		assertSame(rn1, rn1);
	}
	
	@Test
	public void Equals_testWithSimilarObjects() {

		RationalNumber rn1 = new RationalNumber(3, 8);
		RationalNumber rn2 = new RationalNumber(3, 8);
		
		assertEquals(rn1, rn2);
	}

	@Test
	public void Add_testWithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.add(rn2);
		
		assertEquals("1", rn3.toString());
	}
	
	@Test
	public void Add_testWithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.add(rn2);
		
		assertEquals("2", rn3.toString());
	}

	@Test
	public void Subtract_testWithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.subtract(rn2);
		
		assertEquals("0", rn3.toString());
	}
	
	@Test
	public void Subtract_testWithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.subtract(rn2);
		
		assertEquals("0", rn3.toString());
	}

	@Test
	public void Multiply_testWithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.multiply(rn2);
		
		assertEquals("1/4", rn3.toString());
	}
	
	@Test
	public void Multiply_testWithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(2, 2);
		RationalNumber rn2 = new RationalNumber(2, 2);
				
		RationalNumber rn3 = rn1.multiply(rn2);
		
		assertEquals("1", rn3.toString());
	}

	@Test
	public void Divide_testWithFractions() {

		RationalNumber rn1 = new RationalNumber(1, 2);
		RationalNumber rn2 = new RationalNumber(1, 2);
				
		RationalNumber rn3 = rn1.divide(rn2);
		
		assertEquals("1", rn3.toString());
	}
	
	@Test
	public void Divide_testWithWholeNumbers() {

		RationalNumber rn1 = new RationalNumber(6, 2);
		RationalNumber rn2 = new RationalNumber(6, 2);
				
		RationalNumber rn3 = rn1.divide(rn2);
		
		assertEquals("1", rn3.toString());
	}

	@Test
	public void Reduce_test() {
		
		RationalNumber rn1 = new RationalNumber(4, 8);
		
		RationalNumber rn2 = rn1.reduce();
		
		assertEquals("1/2", rn2.toString());
	}
	
	@Test
	public void GCD_testOfReturn() {
		
		RationalNumber rn1 = new RationalNumber(5, 10);
		
		int returnOutput = rn1.gcd(10, 5);
		
		assertEquals(5, returnOutput);
	}
}
