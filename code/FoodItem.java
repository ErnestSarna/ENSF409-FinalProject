/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.2.1
@since      1.0
*/

/*
This class holds all the information about a food item from the database.
*/
package edu.ucalgary.ensf409;

public class FoodItem implements Cloneable{
	//Member variables
	private double grains;
	private double protein;
	private double fruitsVeg;
	private double other;
	private double calories;
	private int ID;
	private String name;
	
	//Constructor
	public FoodItem(String name, int ID, int grains, int protein, int fruitsVeg, int other, int calories) throws IllegalArgumentException{
		if(ID < 0 || grains < 0 || protein < 0 || fruitsVeg < 0 || other < 0 || calories < 0){
			throw new IllegalArgumentException();
		}
		
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
	
	
	
	//Method to find a certain percentage from a total value
	private double percentageToValue(int percentage){
		double ratio = (double) percentage / 100;
		return ratio * this.calories;
	}
	
	//Cloning method for making a deep copy of a FoodItem object
	@Override
	public FoodItem clone(){
		try{
			return (FoodItem)super.clone();
		}
		catch(CloneNotSupportedException e){
			System.out.println("Clone failed");
			return null;
		}
			
    }

}
