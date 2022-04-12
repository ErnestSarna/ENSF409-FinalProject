package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        DataBase dataBase = new DataBase();
        dataBase.selectClientNeeds();
        Order order = new Order();
        GUI gui = new GUI();
        gui.setVisible(true);

        while(true){
            //While user is still adding hampers
            while(gui.getAddAnother()){
                //Waits for user to choose hamper details
                while(gui.getWaiting()){
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    }
                    catch(Exception e){}
                }

                int[] clients = gui.getClients();
                order.add(new Hamper(new Family(clients)));   

                //Fills the new hamper with fooditems
                FoodEfficiencyAlgorithm algo = new FoodEfficiencyAlgorithm(
                    order.getHampers().at(order.getHamperAmount() - 1));                       
                algo.fillHamper();

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
                break;
            }
        }
    }
}
