
package edu.ucalgary.ensf409;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class FoodEfficiencyAlgorithmTest{
    /*
    For all other tests, no testing maybe be done
    as they are all reliant on database connection which
    was specified does not need to be tested
    */

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


}
