package edu.ucalgary.ensf409;

public class ChildUnder8 extends Client{
    private static final int CLIENT_ID = 4;

    //Constructor for the ChildUnder8 class
    public ChildUnder8(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories) throws IllegalArgumentException{
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    public ChildUnder8(){ //An empty constructor for the ChildUnder8 class
        super();
    }

    @Override
    public int getClientID(){ //Getter for the CLIENT_ID
        return CLIENT_ID;
    }
}
