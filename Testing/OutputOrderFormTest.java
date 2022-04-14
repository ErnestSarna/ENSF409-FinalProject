/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.2.3
@since      1.0
*/

/*
This Program tests the functionality of the OutputOrderForm class.
*/
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;
import java.io.*;

public class OutputOrderFormTest{
	
	
	//Tests constructor produces valid object when given valid data
	@Test
	public void testConstructorGoodData(){
		
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		testOrder.setName("Test Name");
		
		
		OutputOrderForm testForm = new OutputOrderForm(testOrder);
		
		assertNotNull("OutputOrderForm constructor did not create an object when valid data was input", testForm);
	}
	
	//Test that file gets made when printForm is called
	@Test
	public void testPrintFormCreatesFile(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		testOrder.setName("TestName");
		
		OutputOrderForm testForm = new OutputOrderForm(testOrder);
		testForm.printForm();
		
		File testFile = new File("TestName's_Order.txt");

		assertTrue("printForm did not successfully create a file.", testFile.exists());
	}
	
	//Tests that IllegalArgumentException si thrown when a null Order is passed in to constructor
	@Test
	public void testConstructorBadData(){

		boolean correctException = false;
		try{
			OutputOrderForm testForm = new OutputOrderForm(null);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertTrue("OutputOrderForm constructor did not throw an IllegalArgumentException when a null was used in constructor.", correctException);
		}
		
	
	//Tests that checkOrderForm returns a valid string
	@Test
	public void testcheckOrderFormReturnsValidString(){
		int[] famArray = {1, 0, 0, 1};
		Family testFamily = new Family(famArray);
		Hamper testHamper = new Hamper(testFamily);
		Order testOrder = new Order();
		testOrder.add(testHamper);
		testOrder.setName("Test Name");
		
		
		OutputOrderForm testForm = new OutputOrderForm(testOrder);
			
		assertNotNull("checkOrderForm returned a null string", testForm.checkOrderForm());
	}
	
		
}
	
