import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

class UnitHamperTest{

    UnitHamperTest(){}

    //tests functionallity of adding a food item
    // and getting the foodlist
    @Test
    public void testAddFoodItem(){
        int[] members = {1, 2};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        Family family = new Family(members, 1);
        Hamper hamper = new Hamper(family);

        System.out.println("addFoodItem");
        hamper.addFoodItem(orange);
        ArrayList <FoodItem> array = hamper.getFoodList();
        assertEquals("Food item insertion was incorrect: ", orange, array.get(0));
    }

    //Tests searching for a food item in a hamper using
    //parameters of food items nutrition
    @Test
    public void testFindFoodItem1(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);

        System.out.println("findFoodItem #1");
        FoodItem actual = hamper.findFoodItem(13, 17, 54, 14, 100);
        assertEquals("Food item found does not match the expected item: ", apple, actual);
    }

    //Searches using name of product
    @Test
    public void testFindFoodItem2(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("findFoodItem #2");
        FoodItem actual = hamper.findFoodItem("Canned corn");
        assertEquals("Food Item found does not match the expected item: ", cannedCorn, actual);
    }

    //test to make sure as food items are added that
    //grains are calculated properly in the hamper
    @Test
    public void testGetTotalGrains(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getTotalGrains");
        double expected = 150*(10/100) + 100*(13/100) + 125*(20/100);
        double actual = hamper.getTotalGrains();
        assertEquals("The total grains does not match the expected value: ", expected, actual, 0.01);
    }

    //Checks if protien is calculated properly as new
    //items are added
    @Test
    public void testGetTotalProtien(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getTotalProtien");
        double expected = 150*(14/100) + 100*(17/100) + 125*(10/100);
        double actual = hamper.getTotalProtien();
        assertEquals("The total protien does not match the expected value: ", expected, actual, 0.01);
    }

    //Checks if fruits and vegetables are calculated
    //properly as fooditems are added
    @Test
    public void testGetTotalFV(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getTotalFV");
        double expected = 150*(35/100) + 100*(54/100) + 125*(30/100);
        double actual = hamper.getTotalFV();
        assertEquals("The total fruits and veggies does not match the expected value: ", expected, actual, 0.01);        
    }

    //Checks is the total calories of the
    //hamper are calculated properly as fooditems are added
    @Test
    public void testGetTotalCalories(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getTotalCalories");
        double expected = 150 + 100 + 125;
        double actual = hamper.getTotalCalories();
        assertEquals("The total calories does not match the expected value: ", expected, actual, 0);
    }

    //Checks if the other category of calories
    //are calculated properly in hamper
    @Test
    public void testGetTotalOther(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getTotalOther");
        double expected = 150*(10/100) + 100*(14/100) + 125*(20/100);
        double actual = hamper.getTotalOther();
        assertEquals("The total of other calories does not match the expected value: ", expected, actual, 0.01);
    }

    //Checks is empty hamper clears the foodlist ArrayList
    @Test
    public void testEmptyHamper(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("emptyHamper");
        hamper.emptyHamper();
        ArrayList<FoodItem> expected = new ArrayList<FoodItem>();
        ArrayList<FoodItem> actual = hamper.getFoodList();
        assertEquals("The hamper did not empty the foodlist: ", expected, actual);
    }

    //Checks if correct family is returned with a hamper
    @Test
    public void testGetFamily(){
        int[] members = {1, 2, 0, 0};
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);

        System.out.println("getFamily");
        Family expected = family;
        Family actual = hamper.getFamily();
        assertEquals("The total protien does not match the expected value: ", expected, actual);
    }
    
    //Checks if as new items are added
    //that the item counter is incremented correctly
    @Test
    public void testGetItems(){
        int[] members = {1, 2, 0, 0};
        FoodItem orange = new FoodItem("orange", 1234, 10, 14, 35, 10, 150);
        FoodItem apple = new FoodItem("apple", 1235, 13, 17, 54, 14, 100);
        FoodItem cannedCorn = new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125);
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodItem(orange);
        hamper.addFoodItem(apple);
        hamper.addFoodItem(cannedCorn);

        System.out.println("getItems");
        int actual = hamper.getItems();
        int expected = 3;
        assertEquals("The number of items in hamper does not match expected: ", expected, actual);
    }

    //test to ensure contructor makes empty hamper with
    //correct local variable values
    @Test
    public void testConstructor(){
        int[] members = {1, 2, 0, 0};
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);

        System.out.println("Constructor");
        double actual = hamper.getTotalGrains();
        double expected = 0;
        assertEquals("Total grains does not match expected value: ", expected, actual, 0);
        actual = hamper.getTotalProtien();
        assertEquals("Total protien does not match expected value: ", expected, actual, 0);
        actual = hamper.getTotalFV();
        assertEquals("Total fruits and veggies does not match expected value: ", expected, actual, 0);
        actual = hamper.getTotalOther();
        assertEquals("Total other calories does not match expected value: ", expected, actual, 0);
        actual = hamper.getTotalCalories();
        assertEquals("Total calories does not match expected value: ", expected, actual, 0);
        actual = hamper.getItems();
        assertEquals("Total protien does not match expected value: ", expected, actual, 0);
        ArrayList<FoodItem> actual2 = hamper.getFoodList();
        ArrayList<FoodItem> expected2 = new ArrayList<FoodItem>();
        assertEquals("Foodlist does not match expected list: ", expected2, actual2);
        Family actual3 = hamper.getFamily();
        Famliy expected3 = family;
        assertEquals("The family does not match expected one: ", expected3, actual3);
    }
    
    //Test exception is thrown when invalid 
    //arguments are given to the constructor
    @Test
    public void testConstructorInvalidArgument(){
        boolean exceptionThrown;
        try{
            int family = 3;
            Hamper hamper = new Hamper(family);
            exceptionThrown = false;
        }
        catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        AssertEquals("The exception was not thrown when given invalid arguments: " true, exceptionThrown);
    }
}

