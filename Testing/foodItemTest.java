package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class foodItemTest{
	
	public String name = "testFood";
	public int id = 2;
	public int grains = 5;
	public int protein = 10;
	public int fruitsVeg = 15;
	public int other = 20;
	public int calories = 30;
	
	
	@Test
	public void testConstructorGoodData(){
		
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		assertNotNull("FoodItem constructor did not create an object when valid data was input", testFoodItem);
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
			FoodItem testFoodItem = new FoodItem(name, id, -1, protein, fruitsVeg, other, calories);
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
			FoodItem testFoodItem = new FoodItem(name, id, grains, -1, fruitsVeg, other, calories);
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
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, -1, other, calories);
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
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, -1, calories);
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
			FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, -1);
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
	
	@Test
	public void testPercentageToValue(){
		FoodItem testFoodItem = new FoodItem(name, id, grains, protein, fruitsVeg, other, calories);
		double ratio = 0.5;
		double value = 20;
		double expected = ratio * value;
		assertEquals("percentageToValue did not return expected value.", testFoodItem.percentageToValue(ratio, value), expected);
	}
	
	
	
	
	
	
		
