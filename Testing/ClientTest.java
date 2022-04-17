package edu.ucalgary.ensf409;

/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.3
@since      1.0
*/

/*
Test class for the Client class and all its subclasses.
*/

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ClientTest{
    AdultMale male = new AdultMale(16,28,26,30,2500);
    AdultFemale female = new AdultFemale(16, 28, 26, 30, 2000);
    ChildOver8 childOver = new ChildOver8(21, 33, 31, 15, 2200);
    ChildUnder8 childUnder = new ChildUnder8(21, 33, 31, 15, 1400);

    //Tests the client constructor with good data to check if it gets created properly
    @Test
    public void testClientConstructorGoodData(){
        Client client = new AdultMale(16,28,26,30,2500);
        assertNotNull("Client constructor did not create an object when given a valid set of data.", client);
    }

    //Tests the client constructor with invalid data to check if it throws an IllegalArgumentExcpetion correctly
    @Test
    public void testClientConstructorInvalidData(){
        boolean correctException = false;

        try{
            Client client = new AdultMale(-16,-28,-26,-30,-2500);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("Client constructor did not throw an IllegalArgumentException when given invalid data.", true, correctException);
    }

    //Test the getter for wholeGrains
    @Test
    public void testGetWholeGrains(){
        double foundWholeGrains = male.getWholeGrains();
        double expectedWholeGrains = 2800.0;
        assertEquals("Method getWholeGrains did not return the expected result: ",expectedWholeGrains, foundWholeGrains, 0.01);
    }

    //Test the getter for proteins
    @Test
    public void testGetProteins(){
        double foundProteins = female.getProteins();
        double expectedProteins = 3920.0;
        assertEquals("Method getProteins did not return the expected result: ", expectedProteins, foundProteins, 0.01);
    }

    //Test the getter for fruitsVeggies
    @Test
    public void testGetFruitsVeggies(){
        double foundFV = childOver.getFruitsVeggies();
        double expectedFV = 4774.0;
        assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedFV, foundFV,0.01);
    }

    //Test the getter for other
    @Test
    public void testGetOther(){
        double foundOther = childUnder.getOther();
        double expectedOther = 1470.0;
        assertEquals("Method getOther did not return the expected result: ", expectedOther, foundOther,0.01);
    }

    //Test the getter for calories
    @Test
    public void testGetCalories(){
        int foundCalories = male.getCalories();
        int expectedCalories = 17500;
        assertEquals("Method getCalories did not return the expected result: ", expectedCalories, foundCalories);
    }

    //Test the getter for CLIENT_ID within AdultMale
    @Test
    public void testGetClientIDAdultMale(){
        int foundID = male.getClientID();
        int expectedID = 1;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENT_ID within AdultFemale
    @Test
    public void testGetClientIDAdultFemale(){
        int foundID = female.getClientID();
        int expectedID = 2;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENT_ID within ChildOver8
    @Test
    public void testGetClientIDChildOver8(){
        int foundID = childOver.getClientID();
        int expectedID = 3;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENT_ID within ChildUnder8
    @Test
    public void testGetClientIDChildUnder8(){
        int foundID = childUnder.getClientID();
        int expectedID = 4;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }
}

