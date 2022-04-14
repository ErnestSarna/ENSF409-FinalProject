package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ClientTest{
    Client client = new AdultMale(100,120,140,160,180);

    //Tests the client constructor with good data to check if it gets created properly
    @Test
    public void testClientConstructorGoodData(){
        Client client = new AdultMale(197,200,155,142,102);
        assertNotNull("Client constructor did not create an object when given a valid set of data.", client);
    }

    //Tests the client constructor with not enough data provided to check if it throws an IllegalArgumentExcpetion correctly
    @Test
    public void testClientConstructorInvalidData(){
        boolean correctException = false;

        try{
            Client client = new AdultMale(120,145,68,204);
        }
        catch(IllegalArgumentException e){
            correctException = true;
        }

        assertEquals("Client constructor did not throw an IllegalArgumentException when given invalid data.", true, correctException);
    }

    //Test the getter for WHOLE_GRAINS within Client
    @Test
    public void testGetWholeGrains(){
        int foundWholeGrains = client.getWholeGrains();
        int expectedWholeGrains = 100;
        assertEquals("Method getWholeGrains did not return the expected result: ", expectedWholeGrains, foundWholeGrains);
    }

    //Test the getter for PROTEINS within Client
    @Test
    public void testGetProteins(){
        int foundProteins = client.getProteins();
        int expectedProteins = 120;
        assertEquals("Method getProteins did not return the expected result: ", expectedProteins, foundProteins);
    }

    //Test the getter for FRUITS_VEGGIES within Client
    @Test
    public void testGetFruitsVeggies(){
        int foundFV = client.getFruitsVeggies();
        int expectedFV = 140;
        assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedFV, foundFV);
    }

    //Test the getter for OTHER within Client
    @Test
    public void testGetOther(){
        int foundOther = client.getOther();
        int expectedOther = 160;
        assertEquals("Method getOther did not return the expected result: ", expectedOther, foundOther);
    }

    //Test the getter for CALORIES within Client
    @Test
    public void testGetCalories(){
        int foundCalories = client.getCalories();
        int expectedCalories = 180;
        assertEquals("Method getCalories did not return the expected result: ", expectedCalories, foundCalories);
    }

    //Test the getter for CLIENTID within AdultMale
    @Test
    public void testGetClientIDAdultMale(){
        int foundID = AdultMale.getClientID();
        int expectedID = 1;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENTID within AdultFemale
    @Test
    public void testGetClientIDAdultFemale(){
        int foundID = AdultFemale.getClientID();
        int expectedID = 2;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENTID within ChildOver8
    @Test
    public void testGetClientIDChildOver8(){
        int foundID = ChildOver8.getClientID();
        int expectedID = 3;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }

    //Test the getter for CLIENTID within ChildUnder8
    @Test
    public void testGetClientIDChildUnder8(){
        int foundID = ChildUnder8.getClientID();
        int expectedID = 4;
        assertEquals("Method getClientID did not return the expected result: ",expectedID, foundID);
    }
}
