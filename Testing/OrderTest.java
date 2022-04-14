/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.2.2
@since      1.0
*/

/*
This Program tests the functionality of the Order class.
*/
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.util.*;


public class OrderTest{

	//Test constructor generates on object when called
	@Test
	public void testConstructorNotNull(){
		Order testOrder = new Order();
		assertNotNull("Order constructor did not create an object when provided a valid family one hamper", testOrder);
	}
	
	//Test private member "name" setter and getter return expected values
	@Test
	public void testSetNameAndGetName(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		String expectedName = "Test";
		testOrder.setName(expectedName);
		

		
		assertEquals("getName() did not return the name provided to setName()", expectedName, testOrder.getName());
	}

	//Test getHampers method returns expected ArrayList
	@Test
	public void testGetHampersReturnsValidArrayList(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		ArrayList<Hamper> hampList = testOrder.getHampers();
		
		assertNotNull("getHampers() did not return a valid array list", hampList);
	}
	
	//Test getHamperAmount returns expected value with a single hamper
	@Test
	public void testGetHamperSizeOneHamper(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		
		int hamperSize = testOrder.getHamperAmount();
		assertEquals("getHamperAmount() did not return 1 when one hamper added to order", 1, hamperSize);
	}
	
	//Test getHamperAmount returns expected value with multiple hampers
	@Test
	public void testAddMultipleHampersWithGetHamperSize(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		
		testOrder.add(testHamper);
		
		int[]famArrayTwo = {1, 1, 0, 0};
		Family testFamilyTwo = new Family(famArrayTwo);
		Hamper testHamperTwo = new Hamper(testFamilyTwo);
		testOrder.add(testHamperTwo);
		
		assertEquals("getHamperAmount() returned " + testOrder.getHamperAmount() + " when two hampers were added to order", 2, testOrder.getHamperAmount());
	}
	
	//Test that hamper Array List is empty after calling clear
	@Test
	public void testClear(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		
		testOrder.add(testHamper);
		testOrder.clear();
		assertTrue("clearHamper() was called and Order contained a non-empty array list", testOrder.getHampers().isEmpty());
	}
		
}
