package edu.ucalgary.ensf409;

abstract class Client {
    private static double wholeGrains;
    private static double protiens;
    private static double fruitsVeggies;
    private static double other;
    private static int calories;

    //Constructor for the client class that sets all the variables, it uses the percentageToValue method to convert the different food group
    //percentages into actual numbers using the total amount of calories
    public Client(int grainsPercent, int protiensPercent, int fruitsVeggiesPercent, int otherPercent, int totalCalories) throws IllegalArgumentException{
        calories = totalCalories;
        wholeGrains = percentageToValue(grainsPercent);
        protiens = percentageToValue(protiensPercent);
        fruitsVeggies = percentageToValue(fruitsVeggiesPercent);
        other = percentageToValue(otherPercent);
    }

    public Client(){} //An empty constructor for the Client class

    public static double getWholeGrains() { //Getter for the wholeGrains variable
        return wholeGrains;
    }
    public static double getProtiens() { //Getter for the proteins variable
        return protiens;
    }
    public static double getFruitsVeggies() { //Getter for the fruitsVeggies variable
        return fruitsVeggies;
    }
    public static double getOther() { //Getter for the other variable
        return other;
    }
    public static int getCalories() { //Getter for the calories variable
        return calories;
    }

    //Abstract method for the getter for the clientID which will be overwritten in each individual client class
    abstract int getClientID();

    private static double percentageToValue(int percentage){ //Method to find a certain percentage from a total value
		double ratio = (double) percentage / 100;
		return ratio * calories;
	}
}
