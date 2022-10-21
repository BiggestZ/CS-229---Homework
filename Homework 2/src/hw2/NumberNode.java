package hw2;

/*
 * DO NOT MODIFY THIS CLASS.
 * NumberNode inherits from LinkedNode. 
 * Each NumberNode contains a double value.
 * @author celiachen
 */
public class NumberNode extends LinkedNode{ // Extension of LinkedNode

	public double value;
	
	public NumberNode (double value) { // Node specifically for doubles
		this.value = value;
	}
}
