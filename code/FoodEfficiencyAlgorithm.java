package edu.ucalgary.ensf409;

import java.util.*;

public class FoodEfficiencyAlgorithm{
    private Hamper hamper;
    private static ArrayList<FoodItem> foodItems;
    private ArrayList<ArrayList<FoodItem>> validCombinations = new ArrayList<>();

    private DataBase dataBase = new DataBase();

    //Constructors
    public FoodEfficiencyAlgorithm(Hamper hamper) throws IllegalArgumentException{
        this.hamper = hamper;
    }

    //instantiates the static fooditems list from database to be used
    public void setFoodItems(){
        dataBase.createConnection();
        this.foodItems = dataBase.selectFoods();
    }
    
    //getters
    public Hamper getHamper() {
        return this.hamper;
    }
    public ArrayList<FoodItem> getFoodItems() {
        return this.foodItems;
    }

    //chooses most efficient hamper package and fills hamper
    //with those food items
    public void fillHamper() throws FoodShortageException{
        ArrayList<FoodItem> curr = new ArrayList<>();
        powerSet(-1,curr);

	//if powerset found no valid hampers throw a food shortage exception
        if(validCombinations.size() == 0){
            throw new FoodShortageException();
        }
        
        ArrayList<FoodItem> current = validCombinations.get(0);
        int neededCalories = (int) hamper.getFamily().getNeededCalories();
	//Finds most efficient and valid food hamper
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
	//deletes food items from foodlist
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
    
    public void powerSet(int index, ArrayList<FoodItem> curr)
    {
        int n = foodItems.size();
 
        // base case
        if (index == n)
        {
            return;
        }
 
        // First print current subset
	double fruitsVeg = 0, grains = 0, proteins = 0, other = 0;
            for(int i=0; i<curr.size(); i++){
		fruitsVeg += curr.get(i).getTotalFruitsVeg();
		grains += curr.get(i).getTotalGrains();
		proteins += curr.get(i).getTotalProtein();
		other  += curr.get(i).getTotalOther();
            }
            if(fruitsVeg >= hamper.getFamily().getNeededFV() && grains >= hamper.getFamily().getNeededGrains() && 
                proteins >= hamper.getFamily().getNeededProtein() && other >= hamper.getFamily().getNeededOther()){
		    System.out.println("adding array of size: " + curr.size());
                    validCombinations.add(curr);
            }
 
        // Try appending remaining characters
        // to current subset
        for (int i = index + 1; i < n; i++)
        {
            curr.add(foodItems.get(i));
            powerSet(i, curr);
 
            // Once all subsets beginning with
            // initial "curr" are printed, remove
            // last character to consider a different
            // prefix of subsets.
	    curr.remove(curr.size()-1);
        }
    }
	
/*
    //Finds all subsets of an array
    //Code adapted from: https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
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
	
        powerSet(index + 1, curr);
	curr.add(foodItems.get(index));
        powerSet(index + 1, curr);
     } */
    //updates fooditems in the database using food id
    public void updateInventory(){
        for(int i = 0; i < hamper.getItems(); i++){
            int id = hamper.getFoodList().get(i).getID();
            dataBase.deleteItem(id);
        }
    }    
}
