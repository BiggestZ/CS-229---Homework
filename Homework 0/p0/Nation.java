package p0;
/**
 * 
 * This class is built to act as a Nation simulation. It contains references to
 * a Nation's name, population, enemy and their ally. Name and population can 
 * be assigned upon creation of a Nation object, while assigning an enemy or 
 * ally can be done after the fact through the use of methods. Other methods 
 * include a backstab method which allows a Nation to betray its ally without
 * their ally knowing, a toString method, and a getRelationship method, which
 * prints out a nation's relationship status with other nations.
 * 
 */

public class Nation {
    String name;
    int population;
    Nation enemy;
    Nation ally;

    public Nation (String n, int p){ // Constructor
        name = n;
        population = p;
    }

    public void setEnemy (Nation n){ // Sets Enemy Nation *WORKS*
        /**
         * First, sets our nations enemy to given nation 'n'.
         * Then sets our nation to be the enemy of given nation 'n'.
         */
        
        this.enemy = n; 
        n.enemy = this; 
    }

    public void setAlly (Nation n){ // Sets Ally Nation *WORKS*
        /*
         * First, sets our nations ally to given nation 'n'.
         * Then sets our nation to be the ally of given nation 'n.'
         */
        this.ally = n; 
        n.ally = this; 
    }

    public String toString(){ // Creates a format to be printed out *WORKS*
        
        String starter = this.name + " has " + this.population + " people."; // The starting phrase of statement
        String end = "";
    
        // Determines a Nation's enemy and ally status
        if (this.enemy == null && this.ally == null) { // If there's no enemy and no ally
            end = " It has no enemy. It has no ally.";
        } else if (this.enemy != null && this.ally == null) { // If there's an enemy, but no ally
            end = " Its enemy is " + this.enemy.name + ". It has no ally.";
        } else if (this.enemy == null && this.ally != null) { // IF there's an ally, but no enemy
            end = " It has no enemy. Its ally is " + this.ally.name + ".";
        } else {
            end = " Its enemy is " + this.enemy.name + ". Its ally is " + this.ally.name + ".";
        }

        return starter + end;
    }

    public void backstab(){  //*WORKS*
    	/* 
    	   A is B's ally, which implies that B is also A's ally. 
    	   Backstabbing means A now considers B is its enemy while 
    	   B still thinks A is its ally.
    	*/

        if (this.ally != null){ // Checks to see if Nation has an ally to betray.
            this.enemy = this.ally; // for the given nation, turns its ally to its enemy.
    	    this.ally = null;	// After the ally becomes the enemy, the ally slot is null.
        } else {
            // Lets the user know that the nation cannot backstab anyone.
            System.out.println(this.name + " cannot backstab as they have no allies.");
        }
    }

    public String getRelationship(Nation n){ 
        // Returns 'enemy', 'ally', or 'no relationship' depending on a nation's status.
        if(this.enemy == n){
            return "Enemy";
        } else if (this.ally == n){
            return "Ally";
        } else {
            return "No Relationship";
        }
    }

}
