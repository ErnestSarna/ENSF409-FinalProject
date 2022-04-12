package edu.ucalgary.ensf409;

abstract class Client {
    private static double wholeGrains;
    private static double protiens;
    private static double fruitsVeggies;
    private static double other;
    private static int calories;

    public Client(int grainsPercent, int protiensPercent, int fruitsVeggiesPercent, int otherPercent, int totalCalories){
        calories = totalCalories;
        wholeGrains = percentageToValue(grainsPercent);
        protiens = percentageToValue(protiensPercent);
        fruitsVeggies = percentageToValue(fruitsVeggiesPercent);
        other = percentageToValue(otherPercent);
    }

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
    abstract int getClientID();

    private static double percentageToValue(int percentage){ //Method to find
		double ratio = (double) percentage / 100;
		return ratio * calories;
	}
}
