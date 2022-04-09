package edu.ucalgary.ensf409;

class FoodItem{
	//Member variables
	private double grains;
	private double protein;
	private double fruitsVeg;
	private double other;
	private double calories;
	private int ID;
	private String name;
	
	//Constructor
	public FoodItem(String name, int ID, double grains, double protein, double fruitsVeg, double other, double calories) throws IllegalArgumentException{
		this.name = name;
		this.ID = ID;
		this.grains = grains;
		this.protein = protein;
		this.fruitsVeg = fruitsVeg;
		this.other = other;
		this.calories = calories;
	}
	
	
	//Getters
	public double getTotalGrains(){
		return grains;
	}
	
	public double getTotalProtein(){
		return protein;
	}
	
	public double getTotalFruitsVeg(){
		return fruitsVeg;
	}
	
	public double getTotalOther(){
		return other;
	}
	
	public double getTotalCalories(){
		return calories;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getID(){
		return this.ID;
	}
	
	
	
	//Converts
	private double percentageToValue(double ratio, double total){
		return ratio * total;
	}

}
