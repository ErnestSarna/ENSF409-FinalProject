package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class orderTest{

	@Test
	public void testConstructorNotNull(){
		Order testOrder = Order();
		assertNotNull("Order constructor did not create an object when provided a valid family one hamper", testOrder);
	}
	
	@Test
	public void testSetNameAndGetName(){
		int[] famArray = {1, 2};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		String excpectedName = "Test";
		testOrder.setName(expectedName);
		

		
		assertEquals("getName() did not return the name provided to setName()", expectedName, testOrder.getName());
	}
	
	@Test
	public void testGetHampersReturnsValidArrayList(){
		int[] famArray = {1, 2};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		ArrayList<Hamper> hampList = testOrder.getHampers();
		
		assertNotNull("getHampers() did not return a valid array list", hampList);
	}
	
	@Test
	public void testGetHamperSizeOneHamper(){
		int[] famArray = {1, 2};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		
		int hamperSize = testOrder.getHamperAmount();
		assertEquals("getHamperAmount() did not return 1 when one hamper added to order", 1, hamperSize);
	}
	
	@Test
	public void testAddMultipleHampersWithGetHamperSize(){
		int[] famArray = {1, 2};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		
		testOrder.add(testHamper);
		
		int[]famArrayTwo = {1, 3};
		Family testFamilyTwo = new Family(famArrayTwo);
		Hamper testHamperTwo = new Hamper(testFamilyTwo);
		testOrder.add(testHamperTwo);
		
		assertEquals("getHamperAmount() did not return 2 when two hampers were added to order", 2, testOrder.getHamperAmount());
	}
}
