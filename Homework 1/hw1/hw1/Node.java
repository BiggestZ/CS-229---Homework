package hw1;

// Author: Zahir Choudhry

public class Node <T> {
	// Instance Variables:
	// data of Nodes, the next Node, the previous Node
	T data;
	Node <T> next; 
	Node <T> prev;
	
	// Constructor
	public Node (T value) {
		this.data = value;
	}
	
}
