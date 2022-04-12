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
	public void clearHamper(){
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
