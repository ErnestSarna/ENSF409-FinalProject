import org.junit.*;
import static org.unit.Assert.*;
import java.util.ArrayList;

public class UnitTestHamper{

    HamperTest(){}

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

}

