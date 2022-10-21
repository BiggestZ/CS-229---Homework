package hw2;
import java.util.EmptyStackException;

// Author: Zahir Choudhry

/*
 * ArrayStack uses the array-based implementation to implement
 * a Stack. 
 * 
 * Instance variables:
 * 		Double[] array: Keeps track of the whole stack in an array
 * 		int size: Keeps track of the number of elements in the Stack
 * Make both instance variables private
 * 
 * Constructor:
 * 		The constructor takes no parameter 
 * 		and initialize the array to length of 5
 *
 *	Methods:
 *		See comments above each methods to implement.
 *		
 */
public class ArrayStack{
	
	// Instance Variables
	private double [] array;
	private int size;
	// NOTE: Size will always be 1 greater than the desired index

	public ArrayStack() {
		array = new double[5];
		size = 0;
	}
	/*
	 * Returns true if the stack is empty.
	 * False otherwise.
	 */
	public boolean isEmpty() { // WORKS
		if(size == 0) {
			return true;
		} else
		return false;
	}
	/*
	 * Returns the number of elements in the stack.
	 */
	public int size() { // WORKS
		return this.size;
	}
	/*
	 * Takes a double d
	 * Push d to the top of the stack.
	 */
	public void push(double d) { // WORKS
		// First, check if the array is empty. If so, place at index 0
		if(isEmpty()){
			array[size] = d;
			size++;
		// Then check if the array is full.
		// If full, then create a new array twice the length of size
		// Then add 'd' to size++
		// Then increment size
		} else if ( size == array.length ){
			double [] hold = new double[size*2];
			for(int i = 0; i < size;i++) {
				hold[i] = array[i];
			}
			array = hold; 
			array[size] = d;
			size++;
			
		// Else, then there is still space in the array
		// So, add 'd' to size++.
		// Then increment size
		} else { 
			array[size] = d;
			size++;
		} 
	}
	/*
	 * Returns the top of the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public double peek() { // WORKS
		if(isEmpty()) {
			throw new EmptyStackException();
		} else {
			return array[size-1];
		}
	}
	/*
	 * Returns the top of the stack
	 * and removes the top from the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public double pop() { // WORKS
		// If array is empty, throw exception
		if(isEmpty()) {
			throw new EmptyStackException();
		// Else, delete the element at array[size]
		// First create a new array of the same length
		// Then, copy all the elements except the last one into the new array
		// Then, point the old array to the new array
		//  Finally, return the deleted element
		} else {
			double result = array[size-1];
			double [] hold = new double[array.length];
			for(int i = 0; i < size-1; i++) {
				hold[i] = array[i];
			}
			array = hold;
			size--;
			return result;
		}
	}
	/*
	 * Returns a String representation of the stack as follows:
	 * Top to Bottom: 5 -> 4 -> 3 -> 2 -> 1
	 */
	public String toString() { // WORKS
		String result = "Top to Bottom: ";
		// Loop backwards so that it stops just before the first element
		// In loop: print all element and arrow
		// at end of loop, print the first element in the array
		for(int i = size-1; i > 0; i--) {
			result += array[i] + " -> ";
		}
		result += array[0]; 
		return result;
	}
}
