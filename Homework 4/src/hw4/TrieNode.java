package hw4;

//Name: Zahir Choudhry

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	public char data;
	public boolean isEnd; // Not entirely sure about this
	public List<TrieNode> childList = new ArrayList<TrieNode>();
	
	// Constructor Class
	public TrieNode (char c) {
		this.data = c;
		for(int i = 0; i < 26; i++) {
			this.childList.add(i, null); // Sets all values in the arraylist to be null
		}
	}
	
	//GetChild Method
	public TrieNode getChild(char c) {
		// If the list is empty
		if(childList.isEmpty()) {
			return null;
		} else {
		// If list is not empty
			for(int i = 0; i < childList.size(); i++) {
				// If found value
				if(childList.get(i).data == c) {
					return childList.get(i);
				}
			}
			// If value is not found in list
			return null;
		}
	}
	
}
