/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.4
@since      1.0
*/

/*
This Program connects to a database containing information about a food 
bank and retrieves data to be used elsewhere from it.
*/

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private Connection dbConnect;
    private ResultSet results;
    
    public DataBase(){} //Empty constructor

    public void createConnection(){ //Method for opening the database connection
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory", "student", "ensf");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<FoodItem> selectFoods(){ //Method for selecting all the food items from the database
        ArrayList<FoodItem> foodItems = new ArrayList<>(); //ArrayList of FoodItem objects used to store all the entries from the database

        try{
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");

            //Loops over all the entries in the table and instantiates a new FoodItem object using the values in the table.
            //It then adds the object to the ArrayList.
            while(results.next()){
                FoodItem item = new FoodItem(results.getString("Name"),results.getInt("ItemID"),results.getInt("GrainContent"),
                    results.getInt("ProContent"), results.getInt("FVContent"), results.getInt("Other"), results.getInt("Calories"));

                foodItems.add(item);
            }

            myStmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return foodItems; //Returns the ArrayList with all the entries from the table as FoodItem objects
    }

    public void selectClientNeeds(){ //Method for selecting the table of client needs from the database
        try{
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");

            //Loops over the entire table and checks which entry is an AdultMale, AdultFemale, etc. It then instantiates
            //a Client object depending on which type of client it is and sets all the required variables.
            while(results.next()){
                if(results.getInt("ClientID") == 1){
                    AdultMale male = new AdultMale(results.getInt("WholeGrains"),results.getInt("Protein"), 
                        results.getInt("FruitVeggies"), results.getInt("Other"), results.getInt("Calories"));
                }
                else if(results.getInt("ClientID") == 2){
                    AdultFemale female = new AdultFemale(results.getInt("WholeGrains"),results.getInt("Protein"), 
                        results.getInt("FruitVeggies"), results.getInt("Other"), results.getInt("Calories"));
                }
                else if(results.getInt("ClientID") == 3){
                    ChildOver8 childOver8 = new ChildOver8(results.getInt("WholeGrains"),results.getInt("Protein"), 
                        results.getInt("FruitVeggies"), results.getInt("Other"), results.getInt("Calories"));
                }
                else if(results.getInt("ClientID") == 4){
                    ChildUnder8 childUnder8 = new ChildUnder8(results.getInt("WholeGrains"),results.getInt("Protein"), 
                        results.getInt("FruitVeggies"), results.getInt("Other"), results.getInt("Calories"));
                }
            }

            myStmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteItem(int itemID){ //Method for deleting entries from the database
        try{
            String query = "DELETE FROM AVAILABLE_FOOD WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1,itemID);
            myStmt.execute();

            myStmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void close(){ //Method for closing the database connection
        try{
            dbConnect.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
