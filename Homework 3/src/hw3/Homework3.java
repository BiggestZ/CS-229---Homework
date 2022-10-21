package hw3;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 * You may use the helper methods provided. 
 * Feel free to add any additional helper methods if needed.
 * @author Celia Chen
 *
 */

public class Homework3 {
	
	/**
	 * This method takes a MovieArrayList and a movie title,
	 * calls getRatingByTitle(movieTitle) method,
	 * returns the elasped time it took in nanoseconds.
	 */

	private static long getElapsedTime(MovieArrayList list, String movieTitle) {
		long startTime = System.nanoTime();
		System.out.println(list.getRatingByTitle(movieTitle));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
	}
	
	/**
	 * This method takes a MovieBST and a movie title,
	 * calls getRatingByTitle(movieTitle) method,
	 * returns the elasped time it took in nanoseconds.
	 */

	private static long getElapsedTime(MovieBST tree, String movieTitle) {
		long startTime = System.nanoTime();
		System.out.println(tree.getRatingByTitle(movieTitle));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
	}
	
	/**
	 * This method takes a JSONObject movie,
	 * parse and extract the title, the year and the rating from the JSONObject,
	 * constructs and returns a Movie object containing the information.
	 */

	/**
	 * While(JSONObject is not empty){
	 * 		add parseMovieObject(movie.next) to BST & Movie Array
	 * 		Move on to next JSON object
	 * 		
	 * 
	 */ 
	
	private static Movie parseMovieObject(JSONObject movie) {
        
        //Get movie title
        String title = (String) movie.get("title");             
        //Get movie year
        String year = (String) movie.get("year");         
        //Get movie rating
        String rating = (String) movie.get("rating");
        
        Movie m = new Movie(title, Integer.parseInt(year), Double.parseDouble(rating));
        return m;
	}
	
	// My Tester Code
	public static void main(String[] args) {
		
		MovieBST gram = new MovieBST(); // Create a BST
		MovieArrayList bam = new MovieArrayList(); // Create ArrayList

		// Because of the nature of Command Line Args, need to combine into 1 string
		String title = "";
		
		// Reads in the title from Command Line Args
		for(int i = 1; i < args.length-1; i++) {
			title += args[i];
			title += " ";
			
		}
		title += args[args.length-1];
		//System.out.println(title);
		
		// Testing the isEmpty function
		// System.out.println(gram.isEmpty());
		
		JSONParser parser = new JSONParser(); // Method to parse JSON Objects
		try {

		Object obj = parser.parse(new FileReader(args[0]));
		JSONArray movielist = (JSONArray)obj;
		
		// Loop Movies into BST and ArrayList + Tests the add function
		for(int i = 0; i < movielist.size(); i++) {
			JSONObject temp = (JSONObject)movielist.get(i);
			Movie temp1 = parseMovieObject(temp);
			gram.addMovie(temp1);
			bam.add(temp1);	
			}
		} catch (Exception e) {
			System.out.println("Please make sure the Movie File is entered in the Command Line.");
			e.printStackTrace(); // Not sure what this means
		}
		
		// Testing Methods Section
		
		// Re-testing isEmpty Function
		// gram.isEmpty();
		
		
		// Testing Size Function
		/*
		System.out.println(bam.size());
		System.out.println(gram.size());
		*/
		
		// Testing InOrder function
		// gram.inOrder();
		
		// Testing the getRatingByTitle function
		//System.out.println(title);
		//System.out.println(gram.getRatingByTitle(title));
		
		// Testing the height function
		// System.out.println(gram.getHeight());
		
		// Printer
		/*
		for(int i = 0; i < 3; i++) {
			System.out.println(getElapsedTime(bam, title)); // Array
		}
		
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			System.out.println(getElapsedTime(gram, title)); // Array
		}
		*/
		
		
	}
}
