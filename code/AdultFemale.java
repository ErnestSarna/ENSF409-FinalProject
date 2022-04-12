package edu.ucalgary.ensf409;

public class AdultFemale extends Client{
    private static final int CLIENT_ID = 2;

    //Constructor for the AdultFemale class
    public AdultFemale(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories) throws IllegalArgumentException{
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    public AdultFemale(){ //An empty constructor for the AdultFemale class
        super();
    }

    @Override
    public int getClientID(){ //Getter for the CLIENT_ID
        return CLIENT_ID;
    }
}
