package edu.ucalgary.ensf409;

class public FoodItem{
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
		this.calories = (double) calories;
		this.name = name;
		this.ID = ID;
		this.grains = percentageToValue(grains);
		this.protein = percentageToValue(protein);
		this.fruitsVeg = percentageToValue(fruitsVeg);
		this.other = percentageToValue(other);
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
	private double percentageToValue(int percentage){
		double ratio = (double) percentage / 100;
		return ratio * this.calories;
	}

}
