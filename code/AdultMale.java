package edu.ucalgary.ensf409;

public class AdultMale extends Client{
    private static int CLIENT_ID = 1;

    public AdultMale(double grainsPercent, double proteinsPercent, double fruitsVeggiesPercent, double otherPercent, int calories){
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    @Override
    public int getClientID(){
        return CLIENT_ID;
    }
}
