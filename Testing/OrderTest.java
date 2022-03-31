package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class OrderTest{
	
	
	
	@Test
	public void testConstructorOneHamper(){
		int[] memberTypes = {1, 2};
		Family testFamily = new Family(memberTypes, 1);
		Order testOrder = new Order(1, testFamily);
		assertNotNull("Order constructor did not create an object when provided a valid family one hamper", testOrder);
	}
	
	@Test
	public void testConstructorMultipleHamper(){
		int[] memberTypes = {1, 2};
		Family testFamily = new Family(memberTypes, 3);
		Order testOrder = new Order(3, testFamily);
		assertNotNull("Order constructor did not create an object when provided with a valid family and three hampers", testOrder);
	}
	
	@Test
	public void testConstructorZeroHampers(){
		boolean correctException = false;
		
		try{
			int[] memberTypes = {1, 2};
			Family testFamily = new Family(memberTypes, 0);
			Order testOrder = new Order(0, testFamily);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("Order constructor did not throw an IllegalArgumentException when requesting zero hampers", true, correctException);
	}
	
	@Test
	public void testConstructorBadData(){
		boolean correctException = false;
		
		try{
			int[] memberTypes = {1, 2};
			Family testFamily = new Family(memberTypes, 1);
			Order testOrder = new Order(-1, testFamily);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("Order constructor did not throw an IllegalArgumentException when invalid hamper number was provided", true, correctException);
	}
	
	@Test
	public void testGetHamperAmountOneHamper(){
		int[] memberTypes = {1, 2};
		Family testFamily = new Family(memberTypes, 1);
		Order testOrder = new Order(1, testFamily);
		assertEquals("getHamperAmount did not return 1 when one hamper was specified", 1, testOrder.getHamperAmount());
	}
	
	@Test
	public void testGetHamperAmountMultipleHamper(){
		int[] memerTypes = {1, 2};
		Family testFamily = new Family(memberTypes, 3);
		Order testOrder = new Order(3, testFamily);
		assertEquals("getHamperAmount did not return 3 when three hampers were specified", 3, testOrder.getHamperAmount());
	}
}
			
	
	
		
