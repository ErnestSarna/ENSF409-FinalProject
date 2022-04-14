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
This class acts as the super class for all the individual client types.
*/

abstract class Client {

    public Client(){} //An empty constructor for the client class

    //Abstract getters for all the variables in the subclasses that will be overwritten
    abstract double getWholeGrains();
    abstract double getProteins();
    abstract double getFruitsVeggies();
    abstract double getOther();
    abstract int getCalories();
    abstract int getClientID();

    //Method to find a certain percentage from a total value
    protected static double percentageToValue(int percentage, int total){
		double ratio = (double) percentage / 100;
		return ratio * total;
	}
}
