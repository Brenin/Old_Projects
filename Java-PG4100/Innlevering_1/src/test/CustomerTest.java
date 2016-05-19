package test;

import static org.junit.Assert.*;

import org.junit.Test;

import customer.Customer;

public class CustomerTest {

	@Test
	public void testCustomer() {
		String tmp = "Eirikur";
		Customer cu1 = new Customer(tmp);
		Customer cu2 = new Customer(tmp);
		
		assertNotSame(cu1, cu2);
	}
	
	@Test
	public void testCustomer2() {
		String tmp = "Eirikur";
		Customer cu1 = new Customer(tmp);
		
		assertSame(cu1, cu1);
	}

	@Test
	public void testGetName() {
		String tmp = "Eirikur";
		Customer cu = new Customer(tmp);
		assertSame(tmp, cu.getName());
	}

	@Test
	public void testSetName() {
		String tmp = "";
		Customer cu = new Customer(tmp);
		cu.setName("Eirikur");
		assertSame("Eirikur", cu.getName());
	}

	@Test
	public void testToString() {
		String tmp = "Eirikur";
		Customer cu = new Customer(tmp);
		
		assertEquals("Kundens namn är: Eirikur\n", cu.toString());
	}
}
