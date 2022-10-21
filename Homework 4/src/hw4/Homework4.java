package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Where the final product goes
public class Homework4 {
	public static void main(String [] args) throws FileNotFoundException{
		TrieTree dictionary = new TrieTree();
		
		ArrayList<String> longWords = new ArrayList<>();
		
		// This section reads in the dictionary to our Trie
		File file = new File(args[0]);
		// Scanner allows for file to be read into
		Scanner scan = new Scanner(file);
			
		//This code will fill the stack with the nodes
		while(scan.hasNextLine()) { // reads till file is empty
			String temp = scan.nextLine();
			// This serves as test for the 'Insert' Function
			dictionary.insert(temp);
			if(dictionary.height < temp.length()) {
				dictionary.height = temp.length();			
				}
			
			if(temp.length() == 28) {
				longWords.add(temp);
				}
			}
		
		scan.close();
		
		//System.out.println(dictionary.height);
		
		// System.out.println(dictionary.wordListForPrefix("yearx"));
		
		//dsSystem.out.println(longWords);
		
		// Tests successful assimilation of dictionary.
		//System.out.println(dictionary.search("abase"));
		
		
		// Reads in user input
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please enter a sentence:");

	    String sentence = myObj.nextLine();  // Read user input
	    
	    myObj.close();
	    
	    // These lines make the inputed string lowercase
	    // & without punctuation
	    sentence = sentence.toLowerCase();
	    sentence = sentence.replaceAll("\\p{Punct}", "");
	    
	    // Splits into an array, each word is an element
	    String[] ex = sentence.split(" ");
	    
	    // This is the string that will be returned
	    String resultant = "";
	    
	    for(int i = 0; i < ex.length; i++) {
	    		// If the word is found in the dictionary
	    	if(dictionary.search(ex[i])) {
	    		// Add said word and then add a space.
	    		resultant += ex[i];
	    		resultant += " ";
	    		// If the word is not found in the dictionary
	    	} else {
	    		ArrayList<String> temp = dictionary.wordListForPrefix(ex[i]);
	    		// If there are no common words found
	    		if (temp.isEmpty()) {
	    			// Add empty brackets
	    			resultant += "[] ";
	    		// If there are common words found
	    		} else {
	    			resultant += "[";
	    			for(int j = 0; j < temp.size(); j++) {
	    				resultant += temp.get(j);
	    				resultant += " ";
	    			}
	    		resultant += "]";
	    			
	    		}	
	    	}
	    }
	    System.out.println(resultant);
	    
	    // For the autocorrect, want to read in each word individually and 
	    // check if it exists in the dictionary. If not, then remove its last char
	    // and run a prefix search on the remaining string. This should return an arrayList of 
	    // words that could replace the given word. 
	    // *NOTE: words replacing the original should be the same length as the original.
	    // So only search one layer, do not need to go deep down. 
	    // So I want to reach the depth in the trie as far as this prefix takes
	    // me, and then examine all its children. Then, recursively go through all of its
	    // Children and return possible solutions
	    
	    //System.out.println(sentence);
	    
	    
		
	}
}
