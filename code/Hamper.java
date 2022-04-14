package edu.ucalgary.ensf409;
/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.6
@since      1.0
*/

/*
This class holds information about the total calories inside 
based on the number and type of fooditems held inside
*/

import java.util.*;

public class Hamper {
	private ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
	private Family family;
	private double totalGrains = 0;
	private double totalProtein = 0;
	private double totalFV = 0;
	private double totalOther = 0;
	private double totalCalories = 0;
	private int items = 0;
	
	//getters
	public ArrayList<FoodItem> getFoodList() { return this.foodList; }
	public double getTotalGrains() { return this.totalGrains; }
	public double getTotalProtein() { return this.totalProtein; }
	public double getTotalFV() { return this.totalFV; }
	public double getTotalOther() { return this.totalOther; }
	public double getTotalCalories() { return this.totalCalories; }
	public int getItems() { return this.items; }
	public Family getFamily() { return this.family; }
	
	//Constructor
	public Hamper(Family family) throws IllegalArgumentException {
		this.family = family;
	}
	
	//accepts foodItem to add to foodList
	//increments each value nutrients value accordingly
	public void addFoodList(ArrayList<FoodItem> foodList) {
		this.foodList = foodList;
		this.items = foodList.size();
		for (int i = 0; i < this.foodList.size(); i++){
			this.totalGrains += foodList.get(i).getTotalGrains();
			this.totalProtein += foodList.get(i).getTotalProtein();
			this.totalFV += foodList.get(i).getTotalFruitsVeg();
			this.totalOther += foodList.get(i).getTotalOther();
			this.totalCalories += foodList.get(i).getTotalCalories();
		}
	}
	
	//empties hamper if it cannot be filled
	public void emptyHamper() {
		this.foodList.clear();
		this.totalGrains = 0;
		this.totalProtein = 0;
		this.totalFV = 0;
		this.totalOther = 0;
		this.totalCalories = 0;
		this.items = 0;
	}
}
