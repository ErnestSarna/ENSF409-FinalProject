/**
@author     Robert Hauta   <a href="mailto:robert.hauta@ucalgary.ca">
@author     Joshua Weir    <a href="mailto:joshua.weir@ucalgary.ca">
@author     Ernest Sarna   <a href="mailto:ernest.sarna@ucalgary.ca"">
@auhor      Aaron Frerichs <a href="mailto:aaron.frerichs@ucalgary.ca">

@version    1.3
@since      1.0
*/


/*
Class which describes a family, used to determine caloric needs for food bank order
*/

package edu.ucalgary.ensf409;

import java.util.*;

public class Family {
	//Information about family and its needs
	private ArrayList<Client> familyMembers = new ArrayList<Client>();
	private double neededGrains = 0;
	private double neededProtein = 0;
	private double neededFV = 0;
	private double neededOther = 0;
	private double neededCalories = 0;
	
	/** Getters **/
	public double getNeededGrains() { return this.neededGrains; }
	public double getNeededProtein() { return this.neededProtein; }
	public double getNeededFV() { return this.neededFV; }
	public double getNeededOther() { return this.neededOther; }
	public double getNeededCalories() { return this.neededCalories; }
	public ArrayList<Client> getFamilyMembers() { return this.familyMembers; }
	
	/**
	Constructor
	@param members in an integer array with indices 0-3 representing the amount of each
		type of clients in the family
	**/
	public Family(int[] members) throws IllegalArgumentException {
		//validate correct amount of client types in parameter array
		if (members.length != 4) {
			throw new IllegalArgumentException();
		}
		
		//fill client ArrayList by Clinet type
		for (int i = 0; i < members.length; i++) {
			//no negative amounts of client types
			if (members[i] >= 0) {
				if (i == 0){
					for (int j = 0; j < members[i]; j++) {
						this.familyMembers.add(new AdultMale());
					}
				}
				else if (i == 1) {
					for (int j = 0; j < members[i]; j++) {
						this.familyMembers.add(new AdultFemale());
					}
				}
				else if (i == 2) {
					for (int j = 0; j < members[i]; j++) {
						this.familyMembers.add(new ChildOver8());
					}
				}
				else {
					for (int j = 0; j < members[i]; j++) {
						this.familyMembers.add(new ChildUnder8());
					}
				}
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		
		//go through familyMembers and increment totals
		for (int i = 0; i < familyMembers.size(); i++) {
			this.neededGrains += familyMembers.get(i).getWholeGrains();
			this.neededProtein += familyMembers.get(i).getProteins();
			this.neededFV += familyMembers.get(i).getFruitsVeggies();
			this.neededOther += familyMembers.get(i).getOther();
			this.neededCalories += familyMembers.get(i).getCalories();
		}
	}
}
