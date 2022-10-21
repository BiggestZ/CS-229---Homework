package hw1;

// Author: Zahir Choudhry

public class LinkedListTest {
	public static void main (String []args) {
		
		// Linked Lists that will be used to test methods
		
		LinkedList <String> john = new LinkedList <String>();
		LinkedList <String> deacon = new LinkedList <String>();
		
		// Test the add function
		
		john.add("a");
		
		// Check head/tail assignment
		// System.out.println(john.head.data);
		// System.out.println(john.tail.data);
		
		john.add("b");
		john.add("c");
		
		// Re-check head/tail assignment
		// System.out.println(john.head.data);
		// System.out.println(john.tail.data);
		
		// Checks if add works & tests get function
		/*
		for(int i = 0; i < john.size(); i++) {
			System.out.println(john.get(i));
		}*/
		
		deacon.add("d");
		deacon.add("e");
		deacon.add("f");
		
		// Prints all values in deacon & tests get function
		/*
		for(int i = 0; i < deacon.size(); i++) {
			System.out.println(deacon.get(i));
		}  */
		
		//------------------------------------------------------------------
		
		// Test the add(item, pos) function
		
		john.add("A", 0); // The new head
		// System.out.println(john.head.data); // Check if head changes
		// System.out.println(john.tail.data);
		// System.out.println(john);
		
		// Test the contains function
		// System.out.println(john.contains("a")); // returns 1
		// System.out.println(john.contains("z")); // returns -1
		
		//------------------------------------------------------------------
		
		// Test the get Method:
		
		/*
		for(int i = 0; i < john.size(); i++) {
			System.out.println(john.get(i));
		}
		*/
		
		//------------------------------------------------------------------
		
		// Test the remove method (position)
		
	    // john.remove(0); // Removes the 'A'
		
		// Check to see if element is removed
		
		/*
		for(int i = 0; i < john.size(); i++) {
			System.out.println(john.get(i));
		}
		*/
		
		// Check if head changes, returns 'a'
		// System.out.println(john.head.data);
		
		//------------------------------------------------------------------
		
		// Test remove method (Object)
		
		//john.remove("a"); // removes the head, should replace with 'b'
		
		// Prints out list
		/*
		for(int i = 0; i < john.size(); i++) {
			System.out.println(john.get(i));
		}
		*/
		//check head data, returns 'b'
		//System.out.println(john.head.data); 
		
		//------------------------------------------------------------------
		
		// Test replace method
		// john.replace("X", 0); // replaces 'A' with X
		
		// Prints out list
		/*
		for(int i = 0; i < john.size(); i++) {
			System.out.println(john.get(i));
		}
		*/
		
		//------------------------------------------------------------------
		
		// Test equals function
		
		/*
		System.out.println(john.equals(deacon)); // Returns False
		LinkedList <String> john2 = john; // Create list equal to john
		System.out.println(john.equals(john2)); // returns True 
		*/
		
		//------------------------------------------------------------------
		
		// Tests the combine function
		
		// Create a new list that is John + Deacon and print to test
		/*
		LinkedList <String> test = john.combine(deacon);
		System.out.println(test);
		*/
		
		//------------------------------------------------------------------
		
		// Test the reverse function
		
		//System.out.println(john.reverse());
		
		//------------------------------------------------------------------
		
		// Test the ToString function
		
		//System.out.println(john);
		//System.out.println(deacon);
	}
}
