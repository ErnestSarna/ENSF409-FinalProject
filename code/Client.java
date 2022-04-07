package edu.ucalgary.ensf409;

abstract class Client {
    private static final double WHOLE_GRAINS;
    private static final double PROTEINS;
    private static final double FRUITS_VEGGIES;
    private static final double OTHER;
    private static final int CALORIES;

    public Client(double grainsPercent, double proteinsPercent, double fruitsVeggiesPercent, double otherPercent, int calories){
        CALORIES = calories;
        WHOLE_GRAINS = percentToValue(grainsPercent, CALORIES);
        PROTEINS = percentToValue(proteinsPercent, CALORIES);
        FRUITS_VEGGIES = percentToValue(fruitsVeggiesPercent, CALORIES);
        OTHER = percentToValue(otherPercent, CALORIES);
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

    private double percentToValue(double ratio, double total){
        return total * ratio;
    }
}
