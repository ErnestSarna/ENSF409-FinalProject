package edu.ucalgary.ensf409;

import java.lang.Exception;

//Custom expection that is thrown when there are not enough food items in the database to fill a required hamper
public class FoodShortageException extends Exception{
    public FoodShortageException(){
        super("Food Shortage Exception");
    }
}
