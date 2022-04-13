package edu.ucalgary.ensf409;

import java.util.*;

public class FoodEfficiencyAlgorithm{
    private Hamper hamper;
    private static ArrayList<FoodItem> foodItems;
    private ArrayList<ArrayList<FoodItem>> validCombinations = new ArrayList<>();

    private DataBase dataBase = new DataBase();

    public FoodEfficiencyAlgorithm(Hamper hamper) throws IllegalArgumentException{
        this.hamper = hamper;
    }

    public void setFoodItems(){
        dataBase.createConnection();
        this.foodItems = dataBase.selectFoods();
    }
    
    public Hamper getHamper() {
        return this.hamper;
    }
    public ArrayList<FoodItem> getFoodItems() {
        return this.foodItems;
    }

    public void fillHamper() throws FoodShortageException{
        ArrayList<FoodItem> curr = new ArrayList<>();
        powerSet(0,curr);

        if(validCombinations.size() == 0){
            throw new FoodShortageException();
        }
        
        ArrayList<FoodItem> current = validCombinations.get(0);
        int neededCalories = (int) hamper.getFamily().getNeededCalories();
        for(int i=1;i<validCombinations.size();i++){

            int calories1 = 0;
            int calories2 = 0;
            for(int j=0;j<current.size();j++){
                calories1 += current.get(j).getTotalCalories();
            }
            for(int k=0;k<current.size();k++){
                calories2 += validCombinations.get(i).get(k).getTotalCalories();
            }
            
            int temp1 = calories1 - neededCalories;
            int temp2 = calories2 - neededCalories;
            if(temp2 < temp1){
                current = validCombinations.get(i);
            }
        }
        ArrayList<FoodItem> foodList = current;
        for(int i = 0; i < foodList.size(); i++){
            int id = foodList.get(i).getID();
            for(int j = 0; j < foodItems.size(); j++){
                if(id == foodItems.get(j).getID()){
                    foodItems.remove(j);
                    break;
                }
            }
        }
        hamper.addFoodList(foodList);
    }
    
    public void powerSet(int index, ArrayList<FoodItem> curr){
        int n = foodItems.size();
 
        // base case
        if (index == n){
            double fruitsVeg = 0, grains = 0, proteins = 0, other = 0;
            for(int i=0; i<curr.size(); i++){
		fruitsVeg += curr.get(i).getTotalFruitsVeg();
		grains += curr.get(i).getTotalGrains();
		proteins += curr.get(i).getTotalProtein();
		other  += curr.get(i).getTotalOther();
            }
            if(fruitsVeg >= hamper.getFamily().getNeededFV() && grains >= hamper.getFamily().getNeededGrains() && 
                proteins >= hamper.getFamily().getNeededProtein() && other >= hamper.getFamily().getNeededOther()){
                    validCombinations.add(curr);
            }
            return;
        }
 
        // Two cases for every character
        // (i) We consider the character
        // as part of current subset
        // (ii) We do not consider current
        // character as part of current
        // subset
        powerSet(index + 1, curr.add(fooditems.get(index)));
        powerSet(index + 1, curr);
     }
    
    public void updateInventory(){
        for(int i = 0; i < hamper.getItems(); i++){
            int id = hamper.getFoodList().get(i).getID();
            dataBase.deleteItem(id);
        }
    }    
    /* 
    private void findCombinations(int n, int r){
        // A temporary array to store all combination one by one
        FoodItem data[] = new FoodItem[r];
 
        // Print all combination using temporary array 'data[]'
        combinationUtil(n, r, 0, data, 0);
    }

    private void combinationUtil(int n, int r, int index, FoodItem data[], int j){
        // Current combination is ready to be printed, print it
        if (index == r){
            double fruitsVeg = 0, grains = 0, proteins = 0, other = 0;
            for(int i=0; i<data.length; i++){
                fruitsVeg += data[i].getTotalFruitsVeg();
                grains += data[i].getTotalGrains();
                proteins += data[i].getTotalProtein();
                other += data[i].getTotalOther();
            }
            if(fruitsVeg >= hamper.getFamily().getNeededFV() && grains >= hamper.getFamily().getNeededGrains() && 
                proteins >= hamper.getFamily().getNeededProtein() && other >= hamper.getFamily().getNeededOther()){
                    validCombinations.add(data);
            }
            return;
        }
 
        // When no more elements are there to put in data[]
        if (j >= n){
            return;
        }

        // current is included, put next at next location
        data[index] = foodItems.get(j);

        combinationUtil(n, r, index+1, data, j+1);
 
        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(n, r, index, data, j+1);
    } */
}
