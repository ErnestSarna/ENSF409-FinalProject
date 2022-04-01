
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class FoodEfficiencyAlgorithmTest{


    @Test 
    public void testGetHamper(){
        int[] members = {1, 1,1,1};
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        FoodEfficiencyAlgorithm eff = new FoodEfficiencyAlgorithm(hamper);

        System.out.println("testGetHamper");
        Hamper actual = eff.getHamper();
        assertEquals("Get hamper did not return expected result: ",hamper, actual);
    }

    @Test
    public void testFindContributions(){
        int[] members = {1, 1,1,1};
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        FoodEfficiencyAlgorithm eff = new FoodEfficiencyAlgorithm(hamper);

        System.out.println("testFindContributions");
        double[] actual = eff.findContributions();
        assertNotNull("Find Contributions did not return a double array: ", actual);
        assertEquals("Double array was not of length four: ", 4, actual.length);
    }

    /* 
     * Note test for excpetion 
     * in findContributions cannot be tested
     * as requires database access
     */

    @Test
    public void testCheckEffieciency(){
        int[] members = {1, 1,1,1};
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        FoodEfficiencyAlgorithm eff = new FoodEfficiencyAlgorithm(hamper);

        System.out.println("testCheckEfficiency");
        int actual = eff.checkEfficiency();
        int expected = 0;
        assertEquals("Efficiency did not match expected: ",expected, actual);
    }
}
