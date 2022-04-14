/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.1.4
@since      1.0
*/

/*
This Program tests the functionality of the FoodItem class.
*/
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class FoodItemTest{
	
	//Variables used in each test to instantiate FoodItem object
	public String name = "testFood";
	public int id = 2;
	public int grains = 5;
	public int protein = 10;
	public int fruitsVeg = 15;
	public int other = 20;
	public int calories = 30;
	public int invalid = -1;
	
	//Tests the constructor with valid data
	@Test
	public void testConstructorGoodData(){
		
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertNotNull("FoodItem constructor did not create an object when valid data was input", testFoodItem);
	}
	
	//Tests the constructor with various bad inputs
	
	@Test
	public void testConstructorBadName(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(null, id, invalid, protein, fruitsVeg, other, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when a null name was provided", true, correctException);
	}
	
	@Test
	public void testConstructorBadId(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, -1, grains, protein, fruitsVeg, other, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when an invalid ID was provided", true, correctException);
	}
	
	@Test
	public void testConstructorBadGrains(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, id, invalid, protein, fruitsVeg, other, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when invalid grains was provided", true, correctException);
	}
	
	@Test
	public void testConstructorBadProtein(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, id, grains, invalid, fruitsVeg, other, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when an invalid protein was provided", true, correctException);
	}
	
	@Test
	public void testConstructorBadFruitsVeg(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, invalid, other, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when invalid grains was provided", true, correctException);
	}
			
			
	@Test
	public void testConstructorBadOther(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, invalid, calories);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when invalid other was provided", true, correctException);
	}
	
	@Test
	public void testConstructorBadCalories(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, invalid);
		}
		catch(IllegalArgumentException e){
			correctException = true;
		}
		
		assertEquals("FoodItem Constructor did not throw an IllegalArgumentException when invalid calories was provided", true, correctException);
	}
	
	//Tests all the getters for the FoodItem class
	
	@Test
	public void testGetName(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getName did not return expected value.", testFoodItem.getName(), name);
	}
	
	@Test
	public void testGetId(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getId did not return expected value.", testFoodItem.getID(), id);
	}
	
	@Test
	public void testGetTotalGrains(){
		
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		double expectedValue = (double) grains / 100 * calories;
		assertEquals("getTotalGrains did not return expected value.", expectedValue, testFoodItem.getTotalGrains(), 0.01);
	}
	
	@Test
	public void testGetTotalProtein(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		double expectedValue = (double) protein / 100 * calories;
		assertEquals("getTotalProtein did not return expected value.", expectedValue, testFoodItem.getTotalProtein(), 0.01);
	}
	
	@Test
	public void testGetTotalFruitsVeg(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		double expectedValue = (double) fruitsVeg / 100 * calories;
		assertEquals("getTotalFruitsVegs did not return expected value.", expectedValue, testFoodItem.getTotalFruitsVeg(), 0.01);
	}	
	
	@Test
	public void testGetTotalOther(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		double expectedValue =  ((double)other / 100) * calories;
		assertEquals("getTotalOther did not return expected value.", expectedValue, testFoodItem.getTotalOther(), 0.01);
	}
	
	@Test
	public void testGetTotalCalories(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getTotalCalories did not return expected value.", testFoodItem.getTotalCalories(), calories, 0.01);
	}	
}		
