package hw2;

// Import File and Scanner for I/O
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RPNCalculator {
	
	/** Steps for RPN Calculator
	 * 1. determine if the data is NumberNode or Operator Node
	 * 2. If NumberNode, push Node onto stack
	 * 3. If OperatorNode, pop 2 Nodes into variables and perform operation on their values
	 * Then, push the computed value back onto the stack.
	 * 4. Do this process till the stack runs out
	 * 
	 * NOTE: 1. If there's an operator called and stack size <= 1, call error
	 * and exit program with System.exit().
	 * 2. If "/" is called and the divisor is 0, throw ArithmeticException and end prog.
	 * @throws FileNotFoundException 
	 * 
	 * */
	
	// All Methods for addition/subtraction/etc are all here
	
	// Adds NumberNodes
	public static NumberNode sum (NumberNode a, NumberNode b) {
		double temp = a.value + b.value;
		NumberNode n1 = new NumberNode(temp);
		return n1;
	}
	// Subtracts NumberNodes
	public static NumberNode subtract (NumberNode a, NumberNode b) {
		double temp = a.value - b.value;
		//System.out.println(temp + " minus");
		NumberNode n1 = new NumberNode(temp);
		return n1;
	}
	// Multiplies NumberNodes
	public static NumberNode mult (NumberNode a, NumberNode b) {
		double temp = a.value * b.value;
		//System.out.println(temp + " mult");
		NumberNode n1 = new NumberNode(temp);
		return n1;
	}
	// Divides NumberNodes
	public static NumberNode div (NumberNode a, NumberNode b) {
	// Throw exception when trying to divide by 0
		if(b.value == 0) {
			throw new ArithmeticException("Cannot divide by Zero.");
		} else {
			double temp = a.value / b.value;
			//System.out.println(temp + " div");
			NumberNode n1 = new NumberNode(temp);
			return n1;
		}
	}
	// Gets exponent of 2 NumberNodes
	public static NumberNode expo (NumberNode a, NumberNode b) {
		double temp = Math.pow(a.value, b.value);
		//System.out.println(temp + " Expo");
		NumberNode n1 = new NumberNode(temp);
		return n1;
	}
	
	// Get Modulus of 2 NumberNodes
	public static NumberNode mod(NumberNode a, NumberNode b) {
		double temp = a.value % b.value;
		//System.out.println(temp + " Mod");
		NumberNode n1 = new NumberNode(temp);
		return n1;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		LinkedStack RPN = new LinkedStack(); // Creates the initial stack
		
		// Change this line to change which text file get read into the program
		File file = new File(args[0]);
		// Scanner allows for file to be read into
		Scanner scan = new Scanner(file);
			
		//This code will fill the stack with the nodes
		while(scan.hasNextLine()) { // reads till file is empty
			String temp = scan.nextLine();
			//System.out.println(temp);
			try { // If is number, will push it onto the stack as numberNode
				double n = Double.parseDouble(temp);
				NumberNode n1 = new NumberNode(n);
				RPN.push(n1); // push number onto stack
			} catch (NumberFormatException e) {
				OperatorNode n2 = new OperatorNode(temp);
				RPN.push(n2);
			}
		}
		// Closes scanner when done reading the file
		scan.close(); 
		
		//System.out.println(RPN); // Checks to see if stack has been filled correctly
			
		/** Now, all elements from the text file are part of the stack, and are in order
		 *  I need to create a double array for the length of the array to hold all my 
		 *  popped values. 
		 *  
		 *  Or, I can create a second stack, where I will pop all my numbers onto, to later push them back
		 *  onto the first stack. 
		 *  
		 *  While(numbernode): pop value onto the array/stack.
		 *  
		 *  then, if (operator node), pop the first 2 nodes on stack and perform math
		 *  then, pop that 
		 */	
			
		// This is the second stack, to hold all the numbers
		LinkedStack nums = new LinkedStack();
		// Runs till RPN is empty
		while(RPN.size() != 0) { 
			if(RPN.peek() instanceof NumberNode) { // If the top is a number...
				nums.push(RPN.pop()); // Add that number to the nums stack
			} else { 
				// If the Node is an operator, perform operation
				// But, if there aren't enough numbers, kill code
				if(nums.size() <= 1) {
					System.out.println("Error, Fix Notation");
					System.exit(0);
				}
				// If the top is an operator node
				// Pop the first 2 values into 2 doubles
				// The, determine what to do for each different operator
				OperatorNode n1 = (OperatorNode)RPN.pop(); 
				NumberNode b = (NumberNode)nums.pop();
				NumberNode a = (NumberNode)nums.pop();
				
				// Addition
				if(n1.operator.equals("+")) {
					nums.push(sum(a,b));
				// Multiplication
				} else if(n1.operator.equals("*")) {
					nums.push(mult(a,b));
				// Subtraction
				} else if (n1.operator.equals("-")){
					nums.push(subtract(a,b));
				// Division
				} else if (n1.operator.equals("/")) {
					nums.push(div(a,b));
				// Exponent
				} else if (n1.operator.equals("^")) {
					nums.push(expo(a,b));
				// Remainder (Assumes no other operators will be used in this situation)
				} else {
					nums.push(mod(a,b));
				}
			}
			
		}
		// After RPN is empty and a calculation are done, print nums stack and return nums.top
		System.out.println(nums);
		nums.peek();
	}
	
}