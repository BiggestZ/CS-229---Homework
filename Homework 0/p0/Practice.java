package p0;

public class Practice {
	
	/** WORKS
	 *	
	 * There were three main errors in the reverseOrder method:
	 * 
	 * # 1: The reversedArray Object had not been declared
	 * # 2: The for loop was not incrementing
	 * 
	 * The third and final error was caused by the the index starting at 0. 
	 * Because index started at 0, when the array tried to use an index for the set method
	 * by subtracting index 'i' from the arrays size, it would result in the array size minus zero.
	 * This would result in an out of bounds exception.
	 */


	public static MyIntArray reverseOrder(MyIntArray arr) {
		
		MyIntArray reversedArray = new MyIntArray(arr.size); //Creates an array the same size as input array

		for (int i = 0; i < arr.size; i++) { // for loops
			int val = arr.get(i); // holds temporary value
			reversedArray.set(reversedArray.size-(i+1), val); // changes last element in array and works way back
		}	
		return reversedArray; 
	}
	
	
	
	/** WORKS
	 * 
	 * 3 main errors 
	 * 
	 * #1: 'clumps' was not assigned value. Trying to increment an integer without a value leads to error.
	 * #2: The array started at 0, which led to out of bounds exception error in the if statements.
	 * #3: There was no if statement to get inClumps to become false correctly.
	 */
	public static int findClumps(MyIntArray arr) {
		
		int clumps = 0;	// The # of clumps
		Boolean inClump = false; // if in a clump or not
		
		if(arr.size == 0) {
			return clumps;
		}
		
		for (int i=1; i<arr.size; i++) { // for loop
			
			if (arr.get(i) == arr.get(i-1) && !inClump) { // if the the current & prior element are the same 
														  // and aren't in a clump...
				clumps += 1;	// Increment clumps
				inClump = true; // make inClump status true
			}
			
			if (arr.get(i) != arr.get(i-1) && inClump) {	
				/* if inClump is true but the current
				   & prior element do not match, return false
				*/
				inClump = false;
			}	
		}
		return clumps;		
	}
	
	
	/** WORKS
	 * 
	 * 
	 * #1: Tried to access a private variable directly
	 * #2: .replace creates an instance, does not change 'base' variable. 
	 * #3: The class was not void yet did not return a MyString object
	 * 
	 * @param myString base: the original myString
	 * @param myString remove: the sequence to remove from myString
	 * @return base = base - remove
	 */
	public static MyString removeMyString(MyString base, MyString remove) {
		
		String control = base.getContents(); //Holder for 'base'

		String rid = remove.getContents(); // Holder for 'remove'

		MyString newBase; // New mystring that will be returned

		newBase = new MyString(control.replace(rid, ""));
		return newBase;
	}
	
	
	
	/** WORKS
	 * 
	 * 
	 * #1: baseString tried to access a private variable directly
	 * 
	 * @param MyString base
	 * @param char c
	 * @return the number of times c appears in base
	 */
	public static int countChar(MyString base, char c) {
			
			String baseString = base.getContents();
			return countCharHelper(baseString, c, 0);
			
	}
	
	
	/** WORKS
	 * 
	 * #1: Did not have a stop case
	 * 
	 * 
	 * @param String baseString
	 * @param char c
	 * @param int index
	 * @return the number of times c appears in base
	 */
	public static int countCharHelper(String baseString, char c, int index) {
		
		if(index == baseString.length()){
			return 0;
		}

		if(baseString.charAt(index) == c){ // if the char at the index equals c
			return 1 + countCharHelper(baseString, c, index+1); 
		} else {
			return countCharHelper(baseString, c, index+1);
		}
	}
}
