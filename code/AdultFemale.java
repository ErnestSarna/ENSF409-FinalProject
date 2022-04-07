package edu.ucalgary.ensf409;

public class AdultFemale extends Client{
    private static int CLIENT_ID = 2;

    public AdultFemale(double grainsPercent, double proteinsPercent, double fruitsVeggiesPercent, double otherPercent, int calories){
        super(grainsPercent, proteinsPercent, fruitsVeggiesPercent, otherPercent, calories);
    }

    @Override
    public int getClientID(){
        return CLIENT_ID;
    }
}
