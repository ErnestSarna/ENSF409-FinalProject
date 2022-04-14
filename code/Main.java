/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.8.2
@since      1.0
*/

/*
This program prompts runs the whole food bank user interface from the start of
order to the end when an order form is printed.
*/

package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        //Initialization of variables
        DataBase dataBase = new DataBase();
        dataBase.createConnection();
        dataBase.selectClientNeeds();
        dataBase.close();
        Order order = new Order();
        GUI gui = new GUI();
        gui.setVisible(true);

        while(true){
            FoodEfficiencyAlgorithm set = new FoodEfficiencyAlgorithm(null);
            set.setFoodItems();
            //Loops until user is done adding hampers
            while(gui.getAddAnother()){
                //Waits for user to choose hamper details
                while(gui.getWaiting()){
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch(Exception e){}
                }
                int[] clients = gui.getClients();
                //adds another hamper to the order
                order.add(new Hamper(new Family(clients)));   

                //Fills the new hamper with fooditems
                FoodEfficiencyAlgorithm algo = new FoodEfficiencyAlgorithm(
                    order.getHampers().get(order.getHamperAmount() - 1)); 
                //Checks for a foodshortage exception
                try{
                    algo.fillHamper();
                }
                catch(FoodShortageException e){
                    gui.foodShortage();
                    System.exit(1);
                }

                //Moves gui to the next screen
                gui.processComplete();
                //Waits for user to select yes or no
                while(gui.getYesNoScreen()){
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch(Exception e){}
                }
            }

            //Sets user name in order
            order.setName(gui.getName());

            //allows user to check their order
            OutputOrderForm output = new OutputOrderForm(order);
            gui.setOrderLabel(output.checkOrderForm());
            
            //Goes to confirmation screen
            gui.orderComplete();

            //Waits for user to confirm their order
            while(gui.getConfirmScreen()){
                try{
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(Exception e){}
            }

            //if the users order is incorrect clear order and start again
            if(gui.getClearOrder()){
                order.clear();
            }
            //else print the order and terminate
            else{
                output.printForm();
                for(int i = 0; i < order.getHamperAmount(); i++){
                    FoodEfficiencyAlgorithm algo = new FoodEfficiencyAlgorithm(order.getHampers().get(i));
                    algo.updateInventory();
                }
                break;
            }
        }
    }
}
