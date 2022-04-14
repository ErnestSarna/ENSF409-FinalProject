/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.2.2
@since      1.0
*/


package edu.ucalgary.ensf409;
import java.util.*;

class Order{
	//Member variables
	private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
	private String name = " ";
	
	
	
	//Constructor
	public Order(){}
	
	//Add method
	public void add(Hamper newHamper){
		hampers.add(newHamper);
	}
	
	//Clear Hampers
	public void clear(){
		Iterator<Hamper> itr = hampers.iterator();
		while(itr.hasNext()){
			itr.next().emptyHamper();
		}
		hampers.clear();
	}
		
	//Setter
	public void setName(String name){
		this.name = name;
	}
	
	//Getters
	public int getHamperAmount(){
		return hampers.size();
	}
	
	public ArrayList<Hamper> getHampers(){
		return this.hampers;
	}
	
	public String getName(){
		return this.name;
	}

}
