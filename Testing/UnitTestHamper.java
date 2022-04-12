import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

class HamperTest{

    HamperTest(){}

    //tests functionallity of adding a food item
    // and getting the foodlist
    @Test
    public void testAddFoodList(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        Family family = new Family(members, 1);
        Hamper hamper = new Hamper(family);

        System.out.println("addFoodList");
        hamper.addFoodList(foodlist);
        ArrayList <FoodItem> array = hamper.getFoodList();
        assertEquals("Food item insertion was incorrect: ", foodlist, array);
    }

    @Test
    public void testGetTotalGrains(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getTotalGrains");
        double expected = 150*(10/100) + 100*(13/100) + 125*(20/100);
        double actual = hamper.getTotalGrains();
        assertEquals("The total grains does not match the expected value: ", expected, actual, 0.01);
    }

    @Test
    public void testGetTotalProtien(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getTotalProtien");
        double expected = 150*(14/100) + 100*(17/100) + 125*(10/100);
        double actual = hamper.getTotalProtien();
        assertEquals("The total protien does not match the expected value: ", expected, actual, 0.01);
    }

    @Test
    public void testGetTotalFV(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getTotalFV");
        double expected = 150*(35/100) + 100*(54/100) + 125*(30/100);
        double actual = hamper.getTotalFV();
        assertEquals("The total fruits and veggies does not match the expected value: ", expected, actual, 0.01);        
    }

    @Test
    public void testGetTotalCalories(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getTotalCalories");
        double expected = 150 + 100 + 125;
        double actual = hamper.getTotalCalories();
        assertEquals("The total calories does not match the expected value: ", expected, actual, 0);
    }

    @Test
    public void testGetTotalOther(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getTotalOther");
        double expected = 150*(10/100) + 100*(14/100) + 125*(20/100);
        double actual = hamper.getTotalOther();
        assertEquals("The total of other calories does not match the expected value: ", expected, actual, 0.01);
    }

    @Test
    public void testEmptyHamper(){
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("emptyHamper");
        hamper.emptyHamper();
        ArrayList<FoodItem> expected = new ArrayList<FoodItem>();
        ArrayList<FoodItem> actual = hamper.getFoodList();
        assertEquals("The hamper did not empty the foodlist: ", expected, actual);
    }

    @Test
    public void testGetFamily(){
        int[] members = {0, 0, 0, 0};
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
        int[] members = {0, 0, 0, 0};
        ArrayList<FoodItem> foodlist = new ArrayList<>();
        foodlist.add(new FoodItem("orange", 1234, 10, 14, 35, 10, 150));
        foodlist.add(new FoodItem("apple", 1235, 13, 17, 54, 14, 100));
        foodlist.add(new FoodItem("Canned corn", 1432, 20, 10, 30, 20, 125));
        Family family = new Family(members);
        Hamper hamper = new Hamper(family);
        hamper.addFoodList(foodlist);

        System.out.println("getItems");
        int actual = hamper.getItems();
        int expected = 3;
        assertEquals("The number of items in hamper does not match expected: ", expected, actual);
    }

    //test to ensure contructor makes empty hamper with
    //correct local variable values
    @Test
    public void testConstructor(){
        int[] members = {0, 0, 0, 0};
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
        AssertEquals("The exception was not thrown when given invalid arguments: ", true, exceptionThrown);
    }

}
