import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class FamilyTest{
	int[] clientTypes = {3,0,0,0};
	Family family = new Family(clientTypes);
	
	//Tests Family constructor when given good data
	@Test
	public void testFamilyConstructorGoodData(){
		int[] clients = {1,1,1,1};
		Family family = new Family(clients);
		assertNotNull("Family constructor failed to create a Family object when given valid data", family);
	}
		
	//Tests Family constructor action when given wrong amount of data
	@Test
	public void testFamilyConstructorWrongDataAmount(){
		boolean correctException = false;
		
		try {
			Family family = new Family();
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
	
	//Tests neededGrains getter within Family (family consists of 3 "AdultMales")
	@Test
	public void testGetNeededGrain(){
		int foundNeededGrains = family.getNeededGrains();
		int expectedNeededGrains = 300;
		
		assertEquals("Method getNeededGrains() did not return the expected result: ", expectedNeededGrains, foundNeededGrains);
	}
	
	//Tests neededProtein getter within Family
	@Test
	public void testGetNeededProtein(){
		int foundNeededProtein = family.getNeededProtein();
		int expectedNeededProtein = 360;
		
		assertEquals("Method getNeededProtein() did not return the expected result: ", expectedNeededProtein, foundNeededProtein);
	}
	
	//Tests neededFV getter within Family
	@Test
	public void testGetNeededFV(){
		int foundNeededFV = family.getNeededFV();
		int expectedNeededFV = 140*3;
		
		assertEquals("Method getNeededFV() did not return the expected results: ", expectedNeededFV, foundNeededFV);
	}
	
	//Tests neededOther getter within Family
	@Test
	public void testGetNeededOther(){
		int foundNeededOther = family.getNeededOther();
		int expectedNeededOther = 160*3;
		
		assertEquals("Method getNeededOther() did not return the expected results: ", expectedNeededOther, foundNeededOther);
	}
	
	//Test neededCalories getter within Family
	@Test
	public void testGetNeededCalories() {
		int foundNeededCaloires = family.getNeedOther();
		int expectedNeededCalories = 180*3;
		
		assertEquals("Method getNeededCalories() did not return the expected results: ", expectedNeededCalories, foundNeededCaloires); 
	}
	
