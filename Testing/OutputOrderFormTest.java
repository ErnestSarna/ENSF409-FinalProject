package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class OutputOrderFormTest{
	
	
	@Test
	public void testConstructorGoodData(){
		
		int[] famArray = {1, 2};
		Family testFamily = new Family(famArray);
		Order testOrder = new Order(1, tesstFamily);
		
		OutputOrderForm testForm = new OutputOrderForm(testOrder);
		
		assertNotNull("OutputOrderForm constructor did not create an object when valid data was input", testForm);
	}
	
	@Test
	public void testPrintForm(){
		boolean noException = true;
		
		try{
			int[] famArray = {1, 2};
			Family testFamily = new Family(famArray);
			Order testOrder = new Order(1, tesstFamily);
			OutputOrderForm testForm = new OutputOrderForm(testOrder);
			
			testForm.printForm();
		}
		catch(IOException e){
			noException = false;
		}	
		assertEquals("printForm did not successfully create a file.", true, noException);
	}
	
	
	@Test
	public void testConstructorGoodData(){

	boolean correctException = false;
	try{
		OutputOrderForm testForm = new OutputOrderForm(null);
	}
	catch(IllegalArgumentException e){
		correctException = true;
	}
	
	assertEquals("OutputOrderForm constructor did not throw an IllegalArgumentException when a null was used in constructor.", true, correctException);
	}
}
	
