package edu.ucalgary.ensf409;
import java.util.*;

class Order{
	//Member variables
	private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
	private String name;
	
	
	
	//Constructor
	public Order(int hamperNumbers, Family family, String name) throws IllegalArgumentException{
		this.name = name;

		for(int i = 0; i < hamperNumbers; i++){
			Hamper newHamper = new Hamper(family);
			hampers.add(newHamper);
		}

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
