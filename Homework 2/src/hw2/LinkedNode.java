package hw2;

/*
 * DO NOT MODIFY THIS CLASS.
 * This class represents general LinkedNodes that are used to build the Stack.
 * Each LinkedNode contains a reference to the next LinkedNode.
 * @author celiachen
 *
 */
public class LinkedNode {


	public LinkedNode next; // Singly linked list
	
	/**
	 * Construct an empty LinkedNode.
	 */
	public LinkedNode() { // Going to modify this in a class that extends this
		
	}
	
	public void setNext(LinkedNode next) { // Function to set the next Node in LinkedNode
		this.next = next;
	}
	
	public LinkedNode getNext() { // returns the node after the current one.
		return this.next;
	}
	
}
