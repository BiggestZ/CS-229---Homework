package hw1;

// Author: Zahir Choudhry

public class LinkedList<T> implements LinkedListInterface<T> {

	// INSTANCE VARIABLES
	// The head and tail of Linked List
	Node <T> head;
	Node <T> tail;
	
	@Override
	public int size() {
	
	// Create a current Node and a counter var.
	// Iterate through current, increment counter
	// When current.next == null, end the loop @ the last element
	// set this.tail to current
	// return the count
	// *WORKS* 
			
		// Initialize count variables
		
		if(this.isEmpty()) {
			return 0;
		}
		
		int count = 0;
	    Node <T> current = this.head;
	    
		// This loop will stop just before the null
	    
		while(current != null) {
			count++;
			current = current.next;
		}
		this.tail = current; 
		return count;
	}

	@Override
	public boolean isEmpty() {
		
	// If the 1st element of the list is empty, then the whole list is empty.
	// *WORKS*
		
		return this.head == null;
	}

	@Override
	public int add(T item) {
	
	// Create a current Node and a count variable.
	// Create a Node that uses item as parameter (newNode)
	// use current.next != null to get to tail of the list
	// set current.next = newNode & newNode.prev = current
	// set the tail to newNode
	// do another count++ to get counter to be on newNode
	// return counter
	// *WORKS*
				
		int count = 0;
		Node <T> current = this.head;
		Node <T> end = new Node<T>(item);
				
		// If empty, set head and tail to item and return 0  
		
		if(this.isEmpty()) {
			this.head = end;
			this.tail = end;
			return 0;
		} else {
			while(current.next != null) {
				count++;
				current = current.next;
			}
			current.next = end;
			end.prev = current;
			this.tail = end; 
			count++;	
			return count;
		}
	}

	@Override // *WORKS*
	public void add(T item, int pos) {
		
		// Create a counter var and a current Node
		// Create a new Node that takes item as parameter
		// 3 scenarios, item is @ 0, item is at end, and item is in between.
		// if pos == 0, set newNode.next = head and head.prev = newNode
		// Then, set head = newNode.
		// for pos == size(), do the normal add function
		// for in between: loop till counter = pos - 1
		// Then, set newNode.next = current.next and current.next.prev = newNode
		// After, set current.next = newNode and newNode.prev = current.
		// Void, so no return
		// STILL NEEDS TO BE TESTED
				
		// Out of bounds exception
		
		if (pos > this.size() || pos < 0) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		}
				
		// Instance Variables
		
		int counter = 0;
		Node <T> current = this.head;
		Node <T> newNode = new Node <T>(item); // Convert item to Node
				
		// If the list is empty 
		
		if(this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
			
		//If pos == 0: point to head, then point head to newNode *NOT WORK*
			
		} else if(pos == 0) {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
			
			while(current.next != null) {
				current = current.next;
			}
			this.tail = current;
	
		//If pos == size(): use the add function from before
		// Ask teacher about if it would be placed last or second to last	
			
		} else if(pos == this.size()) {
			this.add(item);
			
		// If pos != 0 || size()
		// Loop to find the position. Stops before position 
			
		} else {
		while (counter < pos-1) { // pos -1 is key???
			counter++;
			current = current.next;
		}
		// Before:
		// 1 ->  <- 2 -> <- 3 -> <- 4 -> <- 5 
		// add(8, 2)
		// After:
		// 1-><- 2 -><- _8_ -><- 3 -><- 4 -><- 5
				
		// Once the position is found, set newNode.next to current.next
		
		newNode.next = current.next; // 8 -> 3
		current.next.prev = newNode; // 8 -> <- 3
		
		// Then, set current.next to newNode
		
		current.next = newNode; // 2 -> 8 -><- 3
		newNode.prev = current; // 2 -><- 8 -><- 3	
	}
				
			
	}

	@Override
	public int contains(T item) { 
		
		// Create current Node and counter
		// while current != null, counter ++ (count after next line)
		// if current.data = item, break the loop and return the counter
		// else return -1
		// *WORKS*
				
		Node <T> current = this.head;
		
		if (this.isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < this.size(); i++) {
				if(current.next == null) {
					this.tail = current;
				}
				if(current.data.equals(item)) {
					return i;
				} else {
					current = current.next;
				}	
			}
			return -1;
		}
	}

	@Override
	public T get(int pos) { 
		
		// Create exception if pos is too big or <0
		// Create current Node and counter
		// while counter < pos
		// counter++
		// current = current.next
		// return current.data
		// *WORKS*	
		
		// Throws exception on pos
		
		if (pos > this.size() || pos < 0) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		}
				
		// Instance variables
		
		int counter = 0;
		Node <T> current = this.head;
				
		// Loops till gets to the position of the desired data
		
		while(counter < pos) {
			counter++;
			current = current.next;
		}
		
		//Why does it want to change data type even though data is a 'T'
		
		return current.data;
	}

	@Override
	public T remove(int pos) { 
		
		// Create a counter variable and a current node
		// 3 scenarios, pos == 0, pos == size() and pos is in between
		// if pos == 0: set removed to head. set head to current.next
		// set head.prev to null. return to removed
		// if pos == size(): loop till pos -1( stop just before the tail)
		// Then, set removed = tail and tail = current. then set tail.next = null
		// return removed
		// If pos is between: loop prior to the element that going to be removed
		// set removed to current.next
		// set current.next.next.prev = current and current.next = current.next.next
		//*WORKS*
		
		// Checks OOB exception
		
		if(pos < 0 | pos > this.size()) {
			throw new IndexOutOfBoundsException("Position is out of bounds.");
		}
				
		// Instance Variables
		
		Node <T>current = this.head;
		int counter = 0;
		Node <T> removed; // This will hold the removed object
				
		// If position is 0, set head to current.next
		
		if (pos == 0) {
			
			removed = this.head;
			this.head = current.next;
			this.head.prev = null;
			return removed.data;
			
		} else if (pos == this.size()-1) {	
			Node <T> fTail = this.head;  // Tail was null, this ensures tail is found 
			while(fTail.next != null) {
				fTail = fTail.next;
			}
			removed = fTail; // removed now point to the tail
			this.tail = removed.prev;
			this.tail.next = null;
			removed.prev = null;
			
			return removed.data;
			
		} else {
			// if position is inside the node
			// This stops just before the value to be removed
			
			while (counter < pos ) {
				counter++;
				current = current.next;
			}
			
			// Before:
			// 1 ->  <- 2 -> <- 3 -> <- 4 -> <- 5 
			// remove(2)
			// After:
			// 1-><- 2 -><- 4 -><- 5
					
			removed = current; // Hold the value to be removed  
			current.prev.next = current.next; // 2-> 4
			current.next.prev = current.prev; // 2 -> <-4 
					
			// Break all the links that 'removed' has to other nodes
			
			removed.next = null;
			removed.prev = null;
					
			return removed.data;
			
		}
				
		
	}

	@Override
	public int remove(T item) { 
		
		// Create a counter and a Current Node and
		// While current.data != object, counter++ and current = current.next
		// one you hit the desired object:
		// 1. set current.prev.next = current.next
		// 2. set current.next.prev = current.prev
		// 3. set current.prev && current.next to null
		// return counter
		// *WORKS*
				
		// Before:
		// Node1 ->  <- Node2 -> <- Node3 -> <- Node4 -> <- Node5 
		// remove(Node3)
		// After:
		// Node1-><- Node2 -><- Node4 -><- Node5
		// return: 2
				
		Node <T> current = this.head;
		
		//This will assign data to tail, sometimes tail is null
		
		Node <T> fTail = this.head;	
		while(fTail.next != null) {
			fTail = fTail.next;
		}	
		this.tail = fTail;

		
		// If the list is empty, return -1, its not in the list
		
		if(this.isEmpty()) {
			return -1;
			
		// If the first element == item, return 1;
			
		} else if(this.head.data == item) {
			this.head = current.next;
			this.head.prev = null;
			return 0;
			
		} else if (this.tail.data == item) {
			Node <T> pawn = this.tail; // Assign tail
			this.tail = this.tail.prev; // Go back an element
			this.tail.next = null; // Sever the links
			pawn.prev = null; // Sever the links
			return size()-1;
		} else {
			for(int counter = 0; counter < this.size(); counter++) {
				if(current.data == item) {
					
					// Reassign the Node before & after element to be removed
					
					current.prev.next = current.next;
					current.next.prev = current.prev;
					current.next = null; // Sever the links
					current.prev = null; // Sever the links
					return counter;
					
				} else {
					current = current.next;
				}
			}
		}
		return -1;
	}

	@Override
	public void replace(T item, int pos) { 
		
		// Before:
		// Node1 ->  <- Node2 -> <- Node3 -> <- Node4 -> <- Node5 
		// replace(Node7, 1)
		// After:
		// Node1-> <- Node7 -> <- Node3 -> <- Node4 -> <- Node5
		// return: None
		
		// Write exception for when position is too big/small
		// Create a counter var, a current node and a new node w item
		// 3 scenarios: 1. replace the head, 2. replace the tail 3. replace in between
		// 1. replace the head. set newNode to head.next
		// then set head.next.prev to newNode
		// set head.next = null and set head to newNode (no return)
		
		// 2. Replace the tail
		// set tail.prev.next = newNode
		// set tail.prev = null and set tail to newNode
		
		// 3. Replace in between
		// increment through counter till get to position before desired place
		// set newNode.next = current.next.next and current.next.next = null
		// set newNode.prev = current and current.next.prev = null
		// *WORKS*
		
		// Throw exception
		
		if(pos < 0 || pos >= this.size()) {
			throw new IndexOutOfBoundsException("Position is invalid.");
		}
		
		Node <T> current = this.head;
		
		// If want to replace the head
		if(pos == 0) {
			this.head.data = item;
		
		// If you want to replace the tail
		} else if (pos == this.size()-1) {
			if(this.tail == null) {
				Node <T> fTail = this.head;
				
				while(fTail.next != null) {
					fTail = fTail.next;
				}
				this.tail = fTail;
			}
			this.tail.data = item;	
		
		} else {
			// Should loop to the position
			for(int i = 0; i < pos; i++) {
				current = current.next;
			}	
			current.data = item;
		}
	}

	@Override
	public boolean equals(LinkedList<T> list2) { 
		
		// If both lists are empty, return true
		// if both lists aren't the same length, return false
		// else:
		// while iterating through both lists
		// if there is a Node that does not match, return false
		// However, if all the Nodes match up, return true
		// *WORKS*
		
		if(this.isEmpty() && list2.isEmpty()) {
			return true;
		} else if (this.size() != list2.size()) {
			return false;
		} else { // if both aren't empty and are the same size
			
			for(int counter = 0; counter < this.size(); counter++) {
				if(this.get(counter).equals(list2.get(counter))) {
				}	else {
					return false;
				}
			}
			return true;
		}
	}

	@Override 
	public LinkedList<T> combine(LinkedList<T> list2) {
		// If List1 is empty and List 2 is 
		LinkedList <T> meh = new LinkedList<T>();
		Node <T> current = this.head;
		Node <T> banana = list2.head; 
		
		if(this.isEmpty() && list2.isEmpty()) {
			return meh;
		} else if (this.isEmpty()) {
			return list2;
		} else if (list2.isEmpty()) {
			return this;
		} else {
			while (current != null) {
				meh.add(current.data);
				current = current.next;
			}
			while (banana != null) {
				meh.add(banana.data);
				banana = banana.next;
			}
			return meh;	
		}
	}

	@Override
	public LinkedList<T> reverse() { 
		// *WORKS*
		// Make sure tail is not null
		
		if(this.tail == null) {
			Node <T> fTail = this.head;
			while(fTail.next != null) {
				fTail = fTail.next;
			}
			this.tail = fTail;
		}
	
		if (this.isEmpty()) {
			return this;
		}	
		
		LinkedList <T> bw = new LinkedList<>();
		Node <T> current = this.tail; // Start current at the end
		
		while(current != null) {
			bw.add(current.data);
			current = current.prev;
		}
		
		for(int i = 0; i < this.size(); i++) {
			System.out.println(bw.get(i));
		}	
		return bw;
	}
	
	@Override
	public String toString() { 
		// *WORKS*
		
		Node <T> current = this.head;
		String fB = " Head to tail: ";
		String bF = " Tail to head: ";
		
		if(this.isEmpty()) {
			return " The List is Empty.";
		}

		for (int i = 0; i < this.size()-1; i++) {
			fB += current.data + "->";
			current = current.next;
		}
		fB += current.data;

		for (int i = 0; i < this.size()-1; i++) {
			bF += current.data + "->";
			current = current.prev;
		}
		bF += current.data;
		
		return fB + "\n" + bF;
	}
}

	