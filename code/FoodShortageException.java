package edu.ucalgary.ensf409;

import java.lang.Exception;

public class FoodShortageException extends Exception{
    public FoodShortageException(){
        super("Food Shortage Exception");
    }
}
