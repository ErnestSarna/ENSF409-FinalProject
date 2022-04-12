package edu.ucalgary.ensf409;

abstract class Client {
    private static final double WHOLE_GRAINS;
    private static final double PROTEINS;
    private static final double FRUITS_VEGGIES;
    private static final double OTHER;
    private static final int CALORIES;

    public Client(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories){
        CALORIES = calories;
        WHOLE_GRAINS = percentageToValue(grainsPercent);
        PROTEINS = percentageToValue(proteinsPercent);
        FRUITS_VEGGIES = percentageToValue(fruitsVeggiesPercent);
        OTHER = percentageToValue(otherPercent);
    }

    public static double getWholeGrains() {
        return WHOLE_GRAINS;
    }
    public static double getProteins() {
        return PROTEINS;
    }
    public static double getFruitsVeggies() {
        return FRUITS_VEGGIES;
    }
    public static double getOther() {
        return OTHER;
    }
    public static int getCalories() {
        return CALORIES;
    }
    abstract int getClientID();

    private static double percentageToValue(int percentage){
		double ratio = (double) percentage / 100;
		return ratio * CALORIES;
	}
}
