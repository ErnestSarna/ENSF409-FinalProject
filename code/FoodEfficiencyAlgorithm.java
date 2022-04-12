package edu.ucalgary.ensf409;

import java.util.*;

public class FoodEfficiencyAlgorithm{
    private Hamper hamper;
    private ArrayList<FoodItem> foodItems;
    private ArrayList<FoodItem[]> validCombinations;

    private DataBase dataBase = new DataBase();

    public FoodEfficiencyAlgorithm(Hamper hamper) throws IllegalArgumentException{
        this.hamper = hamper;
        this.foodItems = dataBase.selectFoods();
    }

    public Hamper getHamper() {
        return this.hamper;
    }
    public ArrayList<FoodItem> getFoodItems() {
        return this.foodItems;
    }

    public void fillHamper() throws FoodShortageException{
        findCombinations(foodItems.size(), 1);

        if(foodItems.isEmpty()){
            throw new FoodShortageException();
        }
        
        FoodItem[] current = validCombinations.get(0);
        int neededCalories = (int)hamper.getFamily().getNeededCalories();
        for(int i=1;i<validCombinations.size();i++){

            int calories1 = 0;
            int calories2 = 0;
            for(int j=0;j<current.length;j++){
                calories1 += current[j].getTotalCalories();
            }
            for(int k=0;k<current.length;k++){
                calories2 += validCombinations.get(i)[k].getTotalCalories();
            }
            
            int temp1 = calories1 - neededCalories;
            int temp2 = calories2 - neededCalories;
            if(temp2 > temp1){
                current = validCombinations.get(i);
            }
        }
        ArrayList<FoodItem> foodList = new ArrayList<>(Arrays.asList(current));
        hamper.addFoodList(foodList);
    }
    
    public void updateInventory(){
        for(int i = 0; i < hamper.getItems(); i++){
            int id = hamper.getFoodList().get(i).getID();
            dataBase.deleteItem(id);
        }
    }    
        
    public void findCombinations(int n, int r){
        // A temporary array to store all combination one by one
        FoodItem data[] = new FoodItem[r];
 
        // Print all combination using temporary array 'data[]'
        combinationUtil(n, r, 0, data, 0);
    }

    public void combinationUtil(int n, int r, int index, FoodItem data[], int j){
        FoodItem[] temp = new FoodItem[r];
        // Current combination is ready to be printed, print it
        if (index == r){
            double fruitsVeg = 0, grains = 0, proteins = 0, other = 0;
            for(int i=0; i<temp.length; i++){
                fruitsVeg += temp[i].getTotalFruitsVeg();
                grains += temp[i].getTotalGrains();
                proteins += temp[i].getTotalProtein();
                other += temp[i].getTotalOther();
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
    }
}
