package edu.ucalgary.ensf409;

public class ChildUnder8 extends Client{
    private static int CLIENT_ID = 4;

    public ChildUnder8(int grainsPercent, int proteinsPercent, int fruitsVeggiesPercent, int otherPercent, int calories){
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    @Override
    public int getClientID(){
        return CLIENT_ID;
    }
}
