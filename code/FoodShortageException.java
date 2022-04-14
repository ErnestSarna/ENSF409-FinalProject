package edu.ucalgary.ensf409;

/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.1
@since      1.0
*/

/*
This class is a custom exception thrown when there is not enough
food items in the database to fill a hamper.
*/

import java.lang.Exception;

//Custom expection that is thrown when there are not enough food items in the database to fill a required hamper
public class FoodShortageException extends Exception{
    public FoodShortageException(){
        super("Food Shortage Exception");
    }
}
