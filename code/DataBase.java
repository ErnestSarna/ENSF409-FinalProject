package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private Connection dbConnect;
    private ResultSet results;
    
    public DataBase(){}

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "student", "ensf");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<FoodItem> selectFoods(){
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        try{
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");

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

        return foodItems;
    }

    public void selectClientNeeds(){
        try{
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM DAILY_CLIENT_NEEDS");

            while(results.next()){
                if(results.getInt("ClientID") == 1){
                    AdultMale male = new AdultMale()
                }
                else if(results.getInt("ClientID") == 2){

                }
                else if(results.getInt("ClientID") == 3){
                    
                }
                else if(results.getInt("ClientID") == 4){

                }
            }

            myStmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteItem(int itemID){
        try{
            String query = "DELETE FROM AVAILABLE_FOOD WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1,itemID);

            myStmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void close(){
        try{
            dbConnect.close();
            results.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
