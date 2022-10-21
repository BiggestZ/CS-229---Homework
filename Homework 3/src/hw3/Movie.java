package hw3;

//Author: Zahir Choudhry

public class Movie implements Comparable<Movie> {
		
	// Instance Variables
	public String title;
	public int year;
	public double rating;
	
	// Tree Variables
	public Movie right = null;
	public Movie left = null;

	// Default Constructor
	public Movie(String t, int y, double r) {
		this.title = t;
		this.year = y;
		this.rating = r;
	}
	
	// Constructor for getRating function
	public Movie(String t) {
		this.title = t;
	}
	
	@Override
	/**
	 * An int value: 0 if the string is equal to the other string, ignoring case differences.
	 < 0 if the string is lexicographically less than the other string
	 > 0 if the string is lexicographically greater than the other string (more characters)
	 *
	 */
	
	// Compares the titles of 2 movies
	public int compareTo(Movie o) {
		String m1 = this.title;
		String m2 = o.title;
		return m1.compareToIgnoreCase(m2); // Will return a comparison of the strings
		// NOTE:
		// if returns > 0: m1 is greater than m2 (m1 = d, m2 = a)
		// if returns = 0: m1 and m2 are the same
		// if returns < 0: m1 is less than m2 (m1 = a, m2 = d)
	}
	
	// Set Left Branch
	public void setLeft(Movie left) { 
		this.left = left;
	}
	
	// Set Right Branch
	public void setRight(Movie right) { 
		this.right = right;
	}
	
	// Prints out the movie function
	public String toString() {
		return this.title + " (" + this.rating + ")";
	}

}
