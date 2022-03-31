package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class foodItemTest{
	
	public String name = "testFood";
	public double id = 2;
	public double grains = 5;
	public double protein = 10;
	public double fruitsVeg = 15;
	public double other = 20;
	public double calories = 30;
	public double invalid = -1;
	
	
	@Test
	public void testConstructorGoodData(){
		
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertNotNull("FoodItem constructor did not create an object when valid data was input", testFoodItem);
	}
	
	@Test
	public void testConstructorBadId(){
		boolean correctException = false;
		
		try{
			FoodItem testFoodItem = new FoodItem(name, invalid, grains, protein, fruitsVeg, other, calories);
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
		assertEquals("getTotalGrains did not return expected value.", testFoodItem.getTotalGrains(), grains);
	}
	
	@Test
	public void testGetTotalProtein(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getTotalProtein did not return expected value.", testFoodItem.getTotalProtein(), protein);
	}
	
	@Test
	public void testGetTotalFruitsVegs(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getTotalFruitsVegs did not return expected value.", testFoodItem.getTotalFruitsVegs(), fruitsVeg);
	}
	
	@Test
	public void testGetTotalOther(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getTotalOther did not return expected value.", testFoodItem.getTotalOther(), other);
	}
	
	@Test
	public void testGetTotalCalories(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertEquals("getTotalCalories did not return expected value.", testFoodItem.getTotalCalories(), calories);
	}
	
}
	
	
	
	
	
	
		
