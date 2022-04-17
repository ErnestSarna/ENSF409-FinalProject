/**
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">

@version    1.2
@since      1.0
*/

package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/*
Test class for the Family class;  Tests constructor boundary conditions and each getter.
*/

public class FamilyTest{
	//Initialize client types for family to be made of
	AdultMale male = new AdultMale(16,28,26,30,2500);
	AdultFemale female = new AdultFemale(16, 28, 26, 30, 2000);
	ChildOver8 childOver = new ChildOver8(21, 33, 31, 15, 2200);
	ChildUnder8 childUnder = new ChildUnder8(21, 33, 31, 15, 1400);
	int[] clientTypes = {1,1,1,1};
	Family family = new Family(clientTypes);
	
	//Tests Family constructor when given good data
	@Test
	public void testFamilyConstructorGoodData(){
		Family family = new Family(clientTypes);
		assertNotNull("Family constructor failed to create a Family object when given valid data", family);
	}
		
	//Tests Family constructor action when given wrong amount of data
	@Test
	public void testFamilyConstructorWrongDataAmount(){
		boolean correctException = false;
		int[] clientTypes = {3,0,0};
		
		try {
			Family family = new Family(clientTypes);
		} catch (IllegalArgumentException e) {
			correctException = true;
		}
		
		assertTrue("Family constructor did not throw an IllegalArgumentException when given invalid amount of data", correctException);
	}
	
	//Tests Family constructor action when given invalid data
	@Test
	public void testFamilyConstructorInvalidDataValues(){
		boolean correctException = false;
		int array[] = {1, 2, -3, 4};
		
		try {
			Family family = new Family(array);
		} catch (IllegalArgumentException e) {
			correctException = true;
		}
		
		assertTrue("Family constructor did not throw an IllegalArgumentException when given invalid data values", correctException);
	}
	
	//Tests neededGrains getter within Family (family consists of 1 of each client type)
	@Test
	public void testGetNeededGrain(){
		double foundNeededGrains = family.getNeededGrains();
		double expectedNeededGrains = 1476.0 * 7;
		
		assertEquals("Method getNeededGrains() did not return the expected result: ", expectedNeededGrains, foundNeededGrains,0);
	}
	
	//Tests neededProtein getter within Family (family consists of 1 of each client type)
	@Test
	public void testGetNeededProtein(){
		double foundNeededProtein = family.getNeededProtein();
		double expectedNeededProtein = 2448.0 * 7;
		
		assertEquals("Method getNeededProtein() did not return the expected result: ", expectedNeededProtein, foundNeededProtein,0);
	}
	
	//Tests neededFV getter within Family (family consists of 1 of each client type)
	@Test
	public void testGetNeededFV(){
		double foundNeededFV = family.getNeededFV();
		double expectedNeededFV = 2286.0 * 7;
		
		assertEquals("Method getNeededFV() did not return the expected results: ", expectedNeededFV, foundNeededFV,0);
	}
	
	//Tests neededOther getter within Family (family consists of 1 of each client type)
	@Test
	public void testGetNeededOther(){
		double foundNeededOther = family.getNeededOther();
		double expectedNeededOther = 1890.0 * 7;
		
		assertEquals("Method getNeededOther() did not return the expected results: ", expectedNeededOther, foundNeededOther,0);
	}
	
	//Test neededCalories getter within Family (family consists of 1 of each client type)
	@Test
	public void testGetNeededCalories() {
		double foundNeededCalories = family.getNeededCalories();
		double expectedNeededCalories = 8100.0 * 7;
		
		assertEquals("Method getNeededCalories() did not return the expected results: ", expectedNeededCalories, foundNeededCalories, 0); 
	}
}
