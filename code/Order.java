/*
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">
@version    1.2.2
@since      1.0
*/

/*
The order class holds the name for the order made throughout the program and
holds an array list containing each hamper which is filled. It is also able to
clear all hampers within the array list.
*/



package edu.ucalgary.ensf409;
import java.util.*;

public class Order{
	//Member variables
	private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
	private String name = " ";
	
	
	
	//Constructor
	public Order(){}
	
	//Add method
	public void add(Hamper newHamper){
		hampers.add(newHamper);
	}
	
	//Empties hampers within hampers Array List and clear the array list
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
