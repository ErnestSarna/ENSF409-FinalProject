package edu.ucalgary.ensf409;

public class ChildOver8 extends Client{
    private static final int CLIENT_ID = 3;

    //Constructor for the ChildOver8 class
    public ChildOver8(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories) throws IllegalArgumentException{
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    @Override
    public int getClientID(){ //Getter for the CLIENT_ID
        return CLIENT_ID;
    }
}
