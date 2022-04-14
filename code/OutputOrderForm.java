package edu.ucalgary.ensf409;
import java.time.LocalDate;
import java.io.*;
import java.util.*;

class OutputOrderForm{
	//Member variable
	private final Order ORDER_FORM;
	
	//Constructor
	public OutputOrderForm(Order info) throws IllegalArgumentException{
		this.ORDER_FORM = info;
	}
	
	//Method to return a string of order form
	public String checkOrderForm(){ 

		String orderForm = "<html>Example Food Bank <br>" +
			"Hamper Order Form <br>" +
			"<br>" +
			"Name: " + ORDER_FORM.getName() + "<br>" + 
			"Date: " + LocalDate.now().toString() + "<br>" +
			"\n" +
			"Original Request: <br>" +
			originalRequest() + "<br>" + 
			"<br>" + 
			hamperItems() + "<html>";

		return orderForm;			
	}
	
	//Method to print a file containing the order form string
	public void printForm(){
		String orderForm = "Example Food Bank \n" +
			"Hamper Order Form \n" +
			"\n" +
			"Name: " + ORDER_FORM.getName() + "\n" + 
			"Date: " + LocalDate.now().toString() + "\n" +
			"\n" +
			"Original Request: \n" +
			originalRequest() + "\n" + 
			"\n" + 
			hamperItems() + "\n";
		
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
	public String hamperItems(){ 
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder itemBuilder = new StringBuilder(); //Probably need to set a really large size, leaving it default for now
		
		int hamperNum = 1;
		while(iter.hasNext()){//Iterate through Order to grab each hamper
			ArrayList<FoodItem> foodList = iter.next().getFoodList();
			Iterator<FoodItem> foodIter = foodList.iterator();
			StringBuilder itemList = new StringBuilder(); //Size?
			
			
			while(foodIter.hasNext()){ //Iterate through food list
				FoodItem currentItem = foodIter.next();
				itemList.append(currentItem.getID() + "		" + currentItem.getName() + "\n");
			}	
			
			
			itemBuilder.append("Hamper " + hamperNum + " Items: \n" + itemList.toString() + "\n");
			hamperNum++;
				
		}
		return itemBuilder.toString();
	}
	
	public String originalRequest(){	
		ArrayList<Hamper> hampers = ORDER_FORM.getHampers();
		Iterator<Hamper> iter = hampers.iterator();
		StringBuilder requestBuilder = new StringBuilder(); //Set size?
		
		int hamperNum = 1;
		while(iter.hasNext()){	//Iterate through Order to grab each hamper
			ArrayList<Client> familyList = iter.next().getFamily().getFamilyMembers();
			Iterator<Client> familyIterator = familyList.iterator();
			
			StringBuilder familyGetter = new StringBuilder(); //Set size?
			
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
				requestBuilder.append("\n");
			}
			hamperNum++;
		}
		return requestBuilder.toString();
	}
		
		
	
		
	
	

}

