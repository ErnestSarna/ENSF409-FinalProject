package edu.ucalgary.ensf409;

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
			this.totalOther += foodItem.get(i)getTotalOther();
			this.totalCalories += foodItem.get(i).TotalCalories();
		}
	}
	
	//empties hamper if it cannot be filled
	public void emptyHamper() {
		this.foodList.removeAll();
		this.totalGrains = 0;
		this.totalProtein = 0;
		this.totalFV = 0;
		this.totalOther = 0;
		this.totalCalories = 0;
		this.items = 0;
	}
}
