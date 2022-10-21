package p0;

public class FireNation extends Nation {
	String uniqueUnit;
    int numOfUnits;

    public FireNation(String n, int p, String unique, int units){ // Constructor
        super(n,p); // Grabs from Nation's Constructor to assign values
        this.uniqueUnit = unique;
        this.numOfUnits = units;
    }

    public String toString(){ // toString Method
        String starter = this.name + " has " + this.population + " people."; // The starting phrase of statement
        String mid = "";

        // Code for displaying Enemies and Allies
        if (this.enemy == null && this.ally == null) { // If there's no enemy and no ally
            mid= " It has no enemy. It has no ally.";
        } else if (this.enemy != null && this.ally == null) { // If there's an enemy, but no ally
            mid = " Its enemy is " + this.enemy.name + ". It has no ally.";
        } else if (this.enemy == null && this.ally != null) { // IF there's an ally, but no enemy
            mid = " It has no enemy. Its ally is " + this.ally.name + ".";
        } else {
            mid = " Its enemy is " + this.enemy.name + ". Its ally is " + this.ally.name + "."; // 
        }

        //Code for unique units
        String end  = " It has " + this.numOfUnits + " unique units of " + this.uniqueUnit + ".";

        return starter + mid + end;
    }

}
