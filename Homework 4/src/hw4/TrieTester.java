package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Name: Zahir Choudhry

public class TrieTester {
	
	public static void main (String []args) throws FileNotFoundException{
		
		TrieTree dictionary = new TrieTree();
		
		// This section reads in the dictionary to our Trie
		File file = new File(args[0]);
		// Scanner allows for file to be read into
		Scanner scan = new Scanner(file);
			
		//This code will fill the stack with the nodes
		while(scan.hasNextLine()) { // reads till file is empty
			String temp = scan.nextLine();
			// This serves as test for the 'Insert' Function
			dictionary.insert(temp);
			}
		scan.close();
		
		//System.out.println(dictionary.search("door"));
		
		System.out.println(dictionary.wordListForPrefix("door"));
		
		/*
		TrieTree test = new TrieTree();
		
		System.out.println(test.root.childList);
		
		test.insert("apple");
		
		System.out.println(test.root.childList.get(0).childList);
		
		System.out.println(test.search("apple"));
		
		//test.remove("apple");
		
		System.out.println(test.search("apple"));
		
		System.out.println(test.wordListForPrefix("apple"));
		*/
	}
}
