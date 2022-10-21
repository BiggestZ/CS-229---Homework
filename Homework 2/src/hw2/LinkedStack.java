package hw2;
import java.util.EmptyStackException;

// Author: Zahir Choudhry
/*
 * LinkedStack uses the linked-based implementation to implement
 * a Stack. 
 * 
 * Instance variables:
 * 		LinkedNode top: Keeps track of the top of the Stack
 * 		int size: Keeps track of the number of elements in the Stack
 * Make both instance variables private
 *
 * Methods:
 *		See comments above each methods to implement.
 *
 */
public class LinkedStack{
	
	private LinkedNode top;
	private int size;
	
	/*
	 * Returns true if the stack is empty.
	 * False otherwise.
	 */
	public boolean isEmpty() { // WORKS
		
		if (size == 0) { // If size is 0, the stack is empty
			return true;
		}
		// Else, the stack is not empty
		return false;
	}
	
	/*
	 * Returns the number of elements in the stack.
	 */
	// Just return size, it should account for all elements
	public int size() { // WORKS
		return size; 
	}
	
	/*
	 * Takes a LinkedNode n
	 * Push n to the top of the stack.
	 */
	public void push(LinkedNode n) { // WORKS
		// If stack is empty, set top to n
		if(this.isEmpty()) {
			this.top = n;
			size++;
		// Else if the array is full, create a new array
		} else {
			// Else, set n.next to point to the top
			// Then, re-reference top so it now points to n
			n.setNext(top);
			this.top = n;
			size++;
		}
	}
	
	/*
	 * Returns the top of the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public LinkedNode peek() { // WORKS
		if(isEmpty()) { // Check if the stack is empty
			throw new EmptyStackException(); // How throw empty stack exception?
		} else {
			
			// This function checks to see if the right node is being made the top
			
			if( this.top instanceof NumberNode) {
				NumberNode hold = (NumberNode)this.top;
				//System.out.println(hold.value);
				return hold;
			} else {
				OperatorNode hold = (OperatorNode)this.top;
				//System.out.println(hold.operator);
				return hold;
			}
			//return this.top;
		}
	}
	
	/*
	 * Returns the top of the stack
	 * and removes the top from the stack.
	 * Throws EmptyStackException if the stack is empty.
	 */
	public LinkedNode pop() { // WORKS
		if(isEmpty()) { // Check if the stack is empty
			throw new EmptyStackException(); // How throw empty stack exception?
		} else {
			// Create a current Node to point to the TBR element
			// Set top to top.next
			// return current
			LinkedNode current = this.top;
			this.top = this.top.getNext();
			
			// This function checks to see if the 
			// right value is popped and if the top
			// is successfully re-referenced.
			/*
			if( this.top instanceof NumberNode) {
				NumberNode hold = (NumberNode)this.top;
				System.out.println(hold.value);
				//return hold;
			} else {
				OperatorNode hold = (OperatorNode)this.top;
				System.out.println(hold.operator);
				//return hold;
			}
			*/
			
			size--;
			return current;
			
			}
		}
	
	/*
	 * Returns a String representation of the stack as follows:
	 * Top to Bottom: 5 -> 4 -> 3 -> 2 -> 1
	 */
	public String toString() { // WORKS
		// Create a current node that points to top
		// while current.next != null, print current + "->"
		// This will stop at the very last element.
		// Then, print the last node individually
		LinkedNode current = this.top;
		String op = "Top to Bottom: ";
		
		if(this.isEmpty()) {
			return op;
		}
		
		// While loop should get every value except the last Node
		while(current.getNext() != null) {
			if(current instanceof NumberNode) {
				NumberNode hold1 = (NumberNode)current;
				op +=  hold1.value + " -> ";
			} else {
				OperatorNode hold2 = (OperatorNode)current;
				op +=  hold2.operator + " -> ";
			}
			current = current.getNext();
		}
		// This Last If-Else should print the last node without an arrow
		if(current instanceof NumberNode) {
			NumberNode hold3 = (NumberNode)current;
			op +=  hold3.value;
		} else {
			OperatorNode hold4 = (OperatorNode)current;
			op +=  hold4.operator;
		}
		return op;
	}
}
