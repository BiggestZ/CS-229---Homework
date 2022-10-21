package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.simple.JSONObject;


// Author: Zahir Choudhry

public class MovieBSTTester {
	public static void main (String args[]){
		
		// Create a BST
		MovieBST jim = new MovieBST(); 
		
		// Tests the "isEmpty" function
		// System.out.println(jim.isEmpty());
		
		// Create collection of movies to add to BST
		Movie jom = new Movie("jom", 2002, 1.1);
		Movie adam = new Movie("Adam", 1999, 5.0);
		Movie aaron = new Movie("Aaron", 199, 5.10);
		Movie brad = new Movie("Brad", 1000, 12.0);
		Movie zach = new Movie("zach", 5, 69.0);
		Movie zurcher = new Movie("zurcher", 19, 21.0);
		Movie zyrcher = new Movie("zvrcher", 19, 21.0);
		
		// Add the movies to the list
		jim.addMovie(jom);
		jim.addMovie(adam); // adam should go left of jom
		jim.addMovie(aaron);
		jim.addMovie(brad);
		jim.addMovie(zach);
		jim.addMovie(zurcher);
		jim.addMovie(zyrcher);
		
		// Tests the ToString Function
		// System.out.println(jom);
		
		// Re-tests the "isEmpty" function
		// System.out.println(jim.isEmpty());
		
		// Tests the "size" function
		// System.out.println(jim.size());
		
		// Tests the "getRatingByTitle"
		// System.out.println(jim.getRatingByTitle("aaron"));
		
		// Tests the "getHeight" function 
		// System.out.println(jim.getHeight());
		
		// Test the "inOrder" function
		// jim.inOrder(); 
		
	}
}
