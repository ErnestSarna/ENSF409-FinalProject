package edu.ucalgary.ensf409;

public class Family {
	private ArrayList<Client> familyMembers = new ArrayList<Client>();
	private double neededGrains = 0;
	private double neededProtein = 0;
	private double neededFV = 0;
	private double neededOther = 0;
	private double neededCalories = 0;
	
	//getters
	public double getNeededGrains { return this.neededGrains; }
	public double getNeededProtein { return this.neededProtein; }
	public double getNeededFV { return this.neededFV; }
	public double getNeededOther { return this.neededOther; }
	public double getNeededCalories { return this.neededCalories; }
	public ArrayList<Client> getFamilyMembers { return this.familyMembers; }
	
	//Constructor
	public Family(int[] members) throws IllegalArgumentException {
		
		//fill client ArrayList
		for (int i = 0; i < members.length; i++) {
			if (members[i] > 0) {
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
		}
		
		//go through familyMembers and increment totals
		for (int i = 0; i < familyMembers.size(); i++) {
			this.neededGrains += familyMembers.get(i).getWholeGrains();
			this.neededProtein += familyMembers.get(i).getProtein();
			this.neededFV += familyMembers.get(i).getFruitsVeggies();
			this.neededOther += familyMembers.get(i).getOther();
			this.neededCalories += familyMembers.get(i).getCalories();
		}
	}
}
