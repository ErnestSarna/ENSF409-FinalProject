/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    2.1.0
@since      1.0
*/
/*
This class uses the order object in order to either output the order form to the GUI or
to print a text file containing the order form
*/

package edu.ucalgary.ensf409;
import java.time.LocalDate;
import java.io.*;
import java.util.*;

public class OutputOrderForm{
	//Member variable
	private final Order ORDER_FORM;
	
	//Constructor
	public OutputOrderForm(Order info) throws IllegalArgumentException{
		if(info == null){
			throw new IllegalArgumentException();
		}
		this.ORDER_FORM = info;
	}
	
	//Method to return the order form as a string
	public String checkOrderForm(){ 

		String orderForm = "<html>Example Food Bank <br>" +
			"Hamper Order Form <br>" +
			"<br>" +
			"Name: " + ORDER_FORM.getName() + "<br>" + 
			"Date: " + LocalDate.now().toString() + "<br>" +
			"<br>" +
			"Original Request: <br>" +
			originalRequestString() + "<br>" + 
			"<br>" + 
			hamperItemsString() + "<html>";

		return orderForm;			
	}
	
	//Method to print a file containing the order form 
	public void printForm(){
		String orderForm = "Example Food Bank \n" +
			"Hamper Order Form \n" +
			"\n" +
			"Name: " + ORDER_FORM.getName() + "\n" + 
			"Date: " + LocalDate.now().toString() + "\n" +
			"\n" +
			"Original Request: \n" +
			originalRequestPrint() + "\n" + 
			"\n" + 
			hamperItemsPrint() + "\n";
		
		try{
			String fileName = ORDER_FORM.getName() + "'s_Order.txt";
			BufferedWriter outputStream = new BufferedWriter(new FileWriter(fileName));
			outputStream.write(orderForm);
			outputStream.close();
		}
		catch(IOException e){
			System.out.println("An IO Error Occured");
		}


		
	}
	
	//Helper methods for creating order form string
	
	
	//Generates a string containing each hamper with all of its associated food items and IDs
	//Uses \n for new line for format in text files
	private String hamperItemsPrint(){ 
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder itemBuilder = new StringBuilder(); 
		
		int hamperNum = 1;
		while(iter.hasNext()){ //Iterate through Order to grab each hamper
			ArrayList<FoodItem> foodList = iter.next().getFoodList();
			Iterator<FoodItem> foodIter = foodList.iterator();
			StringBuilder itemList = new StringBuilder(); 
			
			
			while(foodIter.hasNext()){ //Iterate through food list to grab each item
				FoodItem currentItem = foodIter.next();
				itemList.append(currentItem.getID() + "		" + currentItem.getName() + "\n");
			}	
			
			
			itemBuilder.append("Hamper " + hamperNum + " Items: \n" + itemList.toString() + "\n");
			hamperNum++;
				
		}
		return itemBuilder.toString();
	}
	
	//Generates a string containing each hamper with all of its associated food items and IDs
	//Uses <br> for new line for format in GUI
	private String hamperItemsString(){ 
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder itemBuilder = new StringBuilder(); 
		
		int hamperNum = 1;
		while(iter.hasNext()){//Iterate through Order to grab each hamper
			ArrayList<FoodItem> foodList = iter.next().getFoodList();
			Iterator<FoodItem> foodIter = foodList.iterator();
			StringBuilder itemList = new StringBuilder(); //Size?
			
			
			while(foodIter.hasNext()){ //Iterate through food list
				FoodItem currentItem = foodIter.next();
				itemList.append(currentItem.getID() + "		" + currentItem.getName() + "<br>");
			}	
			
			
			itemBuilder.append("Hamper " + hamperNum + " Items: <br>" + itemList.toString() + "<br>");
			hamperNum++;
				
		}
		return itemBuilder.toString();
	}
	
	//Generates a string which contains each hamper with the associated family member types
	//Uses \n for next line for formatting in a text file
	private String originalRequestPrint(){	
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder requestBuilder = new StringBuilder(); 
		
		int hamperNum = 1;
		while(iter.hasNext()){	//Iterate through Order to grab each hamper
			ArrayList<Client> familyList = iter.next().getFamily().getFamilyMembers();
			Iterator<Client> familyIterator = familyList.iterator();
			
			StringBuilder familyGetter = new StringBuilder(); 
			
			int numMen = 0;
			int numWomen = 0;
			int numChildOverEight = 0;
			int numChildUnderEight = 0;
			
			while(familyIterator.hasNext()){ //Iterate through family to grab each member
				int famMember = familyIterator.next().getClientID();
				if(famMember == 1){
					numMen++;
				}
				else if(famMember == 2){
					numWomen++;
				}
				else if(famMember == 3){
					numChildOverEight++;
				}
				else if (famMember == 4){
					numChildUnderEight++;
				}
			}
			if(numMen != 0){
				if(numMen == 1){
					familyGetter.append(numMen + " Adult Male");
				}
				else{
					familyGetter.append(numMen + " Adult Males");
				}
				if(numWomen != 0 || numChildOverEight != 0 || numChildUnderEight != 0){ //Append comma if needed
					familyGetter.append(", ");
				}
			}
			if(numWomen != 0){
				if(numWomen == 1){
					familyGetter.append(numWomen + " Adult Female");
				}
				else{
					familyGetter.append(numWomen + " Adult Females");
				}
				if(numChildOverEight != 0 || numChildUnderEight != 0){
					familyGetter.append(", ");
				}
			}
			if(numChildOverEight != 0){
				if(numChildOverEight == 1){
					familyGetter.append(numChildOverEight + " Child over 8 ");
				}
				else{
					familyGetter.append(numChildOverEight + " Children over 8");
				}
				if(numChildUnderEight != 0){
					familyGetter.append(", ");
				}
			}
			if(numChildUnderEight != 0){
				if(numChildUnderEight == 1){
					familyGetter.append(numChildUnderEight + " Child under 8");
				}
				else{
					familyGetter.append(numChildUnderEight + " Children under 8");
				}
			}

			requestBuilder.append("Hamper " + hamperNum + ": " + familyGetter) ;
			if(iter.hasNext()){
				requestBuilder.append("\n");
			}
			hamperNum++;
		}
		return requestBuilder.toString();
	}
	
	//Generates a string which contains each hamper with the associated family member types
	//Uses <br> for next line for formatting in a text file
	private String originalRequestString(){	
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder requestBuilder = new StringBuilder(); 
		
		int hamperNum = 1;
		while(iter.hasNext()){	//Iterate through Order to grab each hamper
			ArrayList<Client> familyList = iter.next().getFamily().getFamilyMembers();
			Iterator<Client> familyIterator = familyList.iterator();
			
			StringBuilder familyGetter = new StringBuilder(); 
			
			int numMen = 0;
			int numWomen = 0;
			int numChildOverEight = 0;
			int numChildUnderEight = 0;
			
			while(familyIterator.hasNext()){ //Iterate through family to grab each member
				int famMember = familyIterator.next().getClientID();
				if(famMember == 1){
					numMen++;
				}
				else if(famMember == 2){
					numWomen++;
				}
				else if(famMember == 3){
					numChildOverEight++;
				}
				else if (famMember == 4){
					numChildUnderEight++;
				}
			}
			if(numMen != 0){
				if(numMen == 1){
					familyGetter.append(numMen + " Adult Male");
				}
				else{
					familyGetter.append(numMen + " Adult Males");
				}
				if(numWomen != 0 || numChildOverEight != 0 || numChildUnderEight != 0){
					familyGetter.append(", ");
				}
			}
			if(numWomen != 0){
				if(numWomen == 1){
					familyGetter.append(numWomen + " Adult Female");
				}
				else{
					familyGetter.append(numWomen + " Adult Females");
				}
				if(numChildOverEight != 0 || numChildUnderEight != 0){
					familyGetter.append(", ");
				}
			}
			if(numChildOverEight != 0){
				if(numChildOverEight == 1){
					familyGetter.append(numChildOverEight + " Child over 8 ");
				}
				else{
					familyGetter.append(numChildOverEight + " Children over 8");
				}
				if(numChildUnderEight != 0){
					familyGetter.append(", ");
				}
			}
			if(numChildUnderEight != 0){
				if(numChildUnderEight == 1){
					familyGetter.append(numChildUnderEight + " Child under 8");
				}
				else{
					familyGetter.append(numChildUnderEight + " Children under 8");
				}
			}

			requestBuilder.append("Hamper " + hamperNum + ": " + familyGetter) ;
			if(iter.hasNext()){
				requestBuilder.append("<br>");
			}
			hamperNum++;
		}
		return requestBuilder.toString();
	}
		
		
	
		
	
	

}

