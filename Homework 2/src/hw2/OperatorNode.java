package hw2;
/*
 * DO NOT MODIFY THIS CLASS.
 * OperatorNode inherits from LinkedNode. 
 * Each OperatorNode contains a String value.
 * @author celiachen
 */
public class OperatorNode extends LinkedNode{ // Extension of Linked Node

	public String operator;
	
	public OperatorNode(String operator) { // returns strings
		this.operator = operator;
	}
}
