package hw3;

//Author: Zahir Choudhry

public class MovieBST {
	private Movie root; // Make private later
	private int size = 0;

 public MovieBST(){ // Base Class. Not needed

 }

 // Returns the number of movies the BST has in it
 public int size(){
     return this.size;
 } 

 // Lets us know if the tree is empty. Will change how nodes are added to BST
 public boolean isEmpty() {
     return this.root == null;
 	}
 
 // Add the given Movie object to the BST
 public void addMovie(Movie newM){
	 if(isEmpty()) {
		 this.root = newM;
		 size++;
	 } else {
		// This ensures the method starts at the root and works down
		 addMovie(this.root, newM);  // Random check it that movie actually added
	 }
 }
 
 //
 private Movie addMovie(Movie r, Movie newM) { // r stands for root. will start at root 
		if(newM.compareTo(r) < 0) { // This means that nm > r ("def" > "abc")
			if(r.left == null) {
			// If there is space, insert
				r.left = newM;
				size++;
			} else {
			// Else, continue to search left
				r.left = addMovie(r.left, newM);
			}	
		} else {
			// When moving to the right of the tree
			if(r.right == null) {
				// Insert
				r.right = newM;
				size++;
			} else {
				// Continue search
				r.right = addMovie(r.right, newM);
			}
		}
		return r;
	}
 
 // Returns the height of BST [ The length of the longest branch ]
 public int getHeight(){
     if(isEmpty()) {
    	return 0;
     } else {
    	return getHeight(this.root);
     }
 }
 
 private int getHeight(Movie r) {
	 if(r == null) {
	// If theres no data, do not add to height
		 return 0;
	 } else {
	// else, increment by one for all Nodes w data
		 return 1 + Math.max(getHeight(r.left), getHeight(r.right));
	 }
	 
 }
 
 // Prints movies in BST in Alphabetical Order
 public void inOrder(){ // Want to do in order search [left, root, right]
	if(isEmpty()) {
		System.out.println("The tree is empty");
	} else {
		inOrder(this.root);
	}
 }
 
 private void inOrder(Movie r) { // Left -> Root -> Right
	 if(r != null) {
		 if(r.left != null) {inOrder(r.left);} // While can go left, goes as left as possible
		 System.out.println(r.title); // After r goes as left as possible, will print root
		 if(r.right != null) {inOrder(r.right);} // After the root, the tree reads it right now.  
	 }
 }
 
 // Gives a rating based on a given title. Search throught BST
 // Do a search through every title by comparing each one to root. when found, return that movie.rating
 public double getRatingByTitle(String title){
	 if(title == null) {
		 System.out.println("Please enter a Title.");
		 return 0.0;
	 } else {
		 return getRatingByTitle(this.root, title);
		 }   
 }
 
 private double getRatingByTitle(Movie r, String title) {
	 Movie find = new Movie(title); // Create a movie obj to use CompareTo
	 
	 if(find.compareTo(r) == 0) { // If found,
		return r. rating;
		// System.out.println("FOUND IT");
	 } else if (find.compareTo(r) < 0) { // Goes left
	    // If m1 < m2, move left
		 if(r.left != null) {
		    // System.out.println("Done 1");
			return getRatingByTitle(r.left, title);
		} else {
			// System.out.println("The title does not exist in this database. a");
			 return -1;
		} 
	 } else { 
		    // System.out.println("Right");
			// If m1 > m2, move right
			if(r.right != null) {
				return getRatingByTitle(r.right, title);
			} else {
			// System.out.println("This title does not exist in this database. b");
				return -1;
			}
		}
 }
		
}	 
 

