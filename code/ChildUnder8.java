package edu.ucalgary.ensf409;

/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.4
@since      1.0
*/

/*
This class holds all the information for the Child Under 8 client type.
*/

public class ChildUnder8 extends Client{
    private static final int CLIENT_ID = 4;
    private static double wholeGrains;
    private static double proteins;
    private static double fruitsVeggies;
    private static double other;
    private static int calories;

    //Constructor for the ChildUnder8 class that sets all the variables, it uses the percentageToValue method to convert the different food group
    //percentages into actual numbers using the total amount of calories
    public ChildUnder8(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int totalCalories) throws IllegalArgumentException{
        if(grainsPercent < 0 || proteinsPercent < 0 || fruitsVeggiesPercent < 0 
            || otherPercent < 0 || totalCalories < 0){
            throw new IllegalArgumentException();
        }

        calories = totalCalories * 7;
        wholeGrains = percentageToValue(grainsPercent, calories);
        proteins = percentageToValue(proteinsPercent, calories);
        fruitsVeggies = percentageToValue(fruitsVeggiesPercent, calories);
        other = percentageToValue(otherPercent, calories);
    }

    public ChildUnder8(){ //An empty constructor for the AdultMale class
        super();
    } 

    //Overridden getters for all the variables

    @Override
    public int getClientID(){
        return CLIENT_ID;
    }

    @Override
    public double getWholeGrains() {
        return wholeGrains;
    }

    @Override
    public double getProteins() {
        return proteins;
    }

    @Override
    public double getFruitsVeggies() {
        return fruitsVeggies;
    }

    @Override
    public double getOther() {
        return other;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}

