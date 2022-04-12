package edu.ucalgary.ensf409;

public class AdultMale extends Client{
    private static final int CLIENT_ID = 1;

    //Constructor for the AdultMale class
    public AdultMale(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories) throws IllegalArgumentException{
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    public AdultMale(){ //An empty constructor for the AdultMale class
        super();
    } 

    @Override
    public int getClientID(){ //Getter for the CLIENT_ID
        return CLIENT_ID;
    }
}
