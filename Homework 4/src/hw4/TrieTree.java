package hw4;

import java.util.ArrayList;

//Name: Zahir Choudhry

public class TrieTree {

	// Instance Variables
	public TrieNode root;
	int height = 0; // If height > length of new word, height = len of new word
	
	// Default Constructor
	public TrieTree() {
		this.root = new TrieNode('c'); // Value of root does not matter, only its children
		/*for(int i = 0; i < 26; i++) {
			root.childList.add(i, null); // Sets all values in the arraylist to be null
		}*/
	}
	// Insert Function
	public void insert(String word) {
		int len = word.length();
		int index = 0;
		
		TrieNode current = root;
		// If the trie is empty
		if(root == null) {
			System.out.println("Trie is empty.");
			return;
		}
		// If the trie is not empty
		for(int i = 0; i < len; i++) {
			// finds the value letter in the array
			// EX: 'b' = 98 and 'a' = 97, so 'b' - 'a' = 1. So 'b' is at 1.
			char character = word.charAt(i);
			index = character - 'a'; 
			// If the space is null...
			if(current.childList.get(index) == null) {
				TrieNode insert = new TrieNode(character);
				current.childList.set(index, insert);
			}	
			// Moves to next node along the trie
			current = current.childList.get(index);	
		}
		// Once for loop ends on last node, can set as the end
		current.isEnd = true;			
	}
	// Remove Function
	public void remove(String word) {
		int len = word.length();
		int index = 0; 
		TrieNode current = root; 
		// If Trie is empty 
		if(root == null) {
			System.out.println("Trie is empty.");
			return;
		}
		// If Trie is not empty
		for (int i = 0; i < len; i++) {
			index = word.charAt(i) - 'a';
			if(current.childList.get(index) == null) {
				System.out.println("This word does not exist in this dictionary");
				return;
			}
			current = current.childList.get(index);
		}
		// Once gets to last char, removes its letter status.
		current.isEnd = false;
		
	}
	// Search Function
	public boolean search(String word) {
		int len = word.length( );
		int index = 0;
		
		TrieNode current = root;
		// If Trie is empty
		if(root == null) {
			System.out.println("Trie is empty.");
			return false;
		}
		// If Trie is not empty
		for(int i = 0; i < len; i++) {
			index = word.charAt(i) - 'a';
			//System.out.println(i);
			// As soon as the letter can't be found, return false
			if(current.childList.get(index) == null) {
				//System.out.println(word);
				return false;
			}
			// Else, continue moving through the Trie
			current = current.childList.get(index);	
		}
		// If stops on "isEnd" then we have successfully found the word.
		return current.isEnd; 
	}
	// Notes for Pre-fix Search:
	// Want to go till the last char of look and examine its Children.
	// If there are any Children where isEnd == true, add that character 
	// NOTE; Want to use recursion for this.
	// 1. Only recommend words same length as original word
	// 2. The Prefix is the original word minus the last character
	
	// Prefix Search Function
	public ArrayList<String> wordListForPrefix(String prefix){
		// The ArrayList to hold all possible suggestiongs
		ArrayList<String> suggest = new ArrayList();
		
		if(prefix.length() <= 1) {
			System.out.println("Please input a longer word.");
			return suggest;
		}
		
		// Removes last letter from the string.
		String look = prefix.substring(0,prefix.length()-1);
		
		// Length and index needed to search through Trie
		int len = look.length( );
		int index = 0;
		
		// Starts at the root and works down
		TrieNode current = root;
		
		// If Trie is empty, end code, return empty list
		if(root == null) {
			System.out.println("Trie is empty.");
			return suggest;
		}
		
		// Will Loop until the last char in look
		for(int i = 0; i < len; i++) {
			index = look.charAt(i) - 'a';
			// As soon as the letter can't be found, returns empty ArrayList
			if(current.childList.get(index) == null) {
				return suggest;
			}
			// Else, continue moving through the Trie
			current = current.childList.get(index);	
		}
		// This program will stop on the last node
		// Want to loop through childlist
		for(int i = 0; i < current.childList.size(); i++) {
			if(current.childList.get(i) != null && current.childList.get(i).isEnd == true) {
				String add = look;
				add += current.childList.get(i).data;
				suggest.add(add);
			}
		}
		return suggest;
	}
}
