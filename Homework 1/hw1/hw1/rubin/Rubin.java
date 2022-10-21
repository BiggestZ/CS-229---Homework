package hw1;

public class LinkedListTest {
	
	
	public static void main(String[] args) {
		Node <String> n1 = new Node <> ("hEllo");
		Node <String> n2 = new Node <> ("Steve");
		LinkedList <Integer> list1 = new LinkedList <>();
		LinkedList <Integer> list10 = new LinkedList <>(); 
		LinkedList <String> list2 = new LinkedList <>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		//list1.add(6);
		
		//System.out.println(list1.toString());
		//list1.reverse();
		
		list10.add(1);
		list10.add(2);
		list10.add(3);
		list10.add(4);
		list10.add(5);
		
		//System.out.println(list1.equals(list10));
		
		//System.out.println(list1.contains(1000));

		/*
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println();
		
		for(int i = 0; i < list10.size(); i++) {
			System.out.println(list10.get(i));
		}
		*/
		
		//System.out.println(list1.size());
		//System.out.println(list10.size());
		
		//System.out.println(list1.equals(list10));
		
		//System.out.println(list1.contains(1000)); // WHY?
		
		
		
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		list2.add("e");
		list2.add("f");
		
		//System.out.println(list2.contains("a")); // Works for strings
		
		//list2.add("H", 0);
		//list2.remove("h");
		
		//System.out.println(list2.contains("g"));
		
		//list2.replace("A", 1);
		
		/*
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		} */
		
		
		
		/*
		//list1.add(13);
		//list1.add(1700000000);
		//list1.add(200);
		list1.add(1);
		//System.out.println(list1.head.data);
		list1.add(2);
		//System.out.println(list1.head.next.data);
		list1.add(3);
		//System.out.println(list1.head.next.next.data);
		list1.add(4);
		//list1.add(200);
		//System.out.println(list1.get(1));
		//System.out.println(list1.head.data);
		//System.out.println((list1.size()));	
		//System.out.println(list1.get(1));
		list1.add(5, 4);
		//System.out.println(list1.head.data);
		//System.out.println((list1.size()));	
		//System.out.println((list1.size()));	
		//System.out.println(list1.head.data);
		//System.out.println(list1.get(0));
		//System.out.println(list1.get(1));
		//System.out.println(list1.get(3));
		//System.out.println(list1.head.data);
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		list1.remove(0);
		//System.out.println(list1.tail.data);
		//System.out.println(list1.head.data);
		//System.out.println(list1.size());
		
		
		//System.out.println(list1.contains(200));
		
		
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		} */
		
	}
}

/*
 * // Instance Variable:
	// The head and tail of Linked List
	Node head;
	Node tail;
	
	@Override
	public int size() {
		
		// Create a current Node and a counter var.
		// Iterate through current, increment counter
		// When current.next == null, end the loop @ the last element
		// set this.tail to current
		// return the count
		// NEEDS TO BE TESTED
		
		// Initialize count variable
		int count = 0;
		Node current = this.head;
		// This loop will stop just before the null
		while(current.next != null) {
			count++;
			current = current.next;
		}
		this.tail = current; 
		return count;
	}

	@Override
	public boolean isEmpty() {
		// If the 1st element of the list is empty, then the whole list is empty.
		return this.head == null;
	}

	@Override
	public int add(Object item) {
		
		// Create a current Node and a count variable.
		// Create a Node that uses item as parameter (newNode)
		// use current.next != null to get to tail of the list
		// set current.next = newNode & newNode.prev = current
		// set the tail to newNode
		// do another count++ to get counter to be on newNode
		// return counter
		// NEEDS TO BE TESTED
		
		int count = 0;
		Node current = this.head;
		Node end = new Node(item);
		
		// If empty, set head and tail to item and return 0   
		if(this.isEmpty()) {
			this.head = end;
			this.tail = end;
			return 0;
		}
		
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

	@Override
	public void add(Object item, int pos) {
		
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
		Node current = this.head;
		Node newNode = new Node(item); // Convert item to Node
		
		// If the list is empty 
		if(this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		
		//If pos == 0: point to head, then point head to newNode
		if(pos == 0) {
			newNode.next = this.head; 
			this.head.prev = newNode;
			this.head = newNode;
		}
		
		//If pos == size(): use the add function from before
		// Ask teacher about if it would be placed last or second to last
		if(pos == this.size()) {
			this.add(item);
		}
		
		
		// If pos != 0 || size()
		// Loop to find the position. Stops before position 
		while (counter < pos) {
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

	@Override
	public int contains(Object item) {
		
		// Create current Node and counter
		// while current != null, counter ++ (count after next line)
		// if current.data = item, break the loop and return the counter
		// else return -1
		// Still needs to be tested
		
		int counter = 0;
		Node current = this.head;
		
		while(current != null) {
			if(current.data == item) {
				return counter;
			}
			counter++;
		}
		return -1;
	}

	@Override
	public Object get(int pos) {

		// Create exception if pos is too big or <0
		// Create current Node and counter
		// while counter < pos
		// counter++
		// current = current.next
		// return current.data
		
		// Throws exception on pos
		if (pos > this.size() || pos < 0) {
			throw new IndexOutOfBoundsException("Position is out of bounds");
		}
		
		// Instance variables
		int counter = 0;
		Node current = this.head;
		
		// Loops till gets to the position of the desired data
		
		while(counter < pos) {
			counter++;
			current = current.next;
		}
		
		return current.data;
	}

	@Override
	public Object remove(int pos) {
		
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
		
		
		
		// Checks OOB exception
		if(pos < 0 | pos > this.size()) {
			throw new IndexOutOfBoundsException("Position is out of bounds.");
		}
		
		// Instance Variables
		Node current = this.head;
		int counter = 0;
		Node removed; // This will hold the removed object
		
		// If position is 0, set head to current.next
		if (pos == 0) {
			removed = this.head;
			this.head = current.next;
			this.head.prev = null;
			return removed;
		}
		
		// If the position is the end, make the second to last node.next = null
		if (pos == this.size()) {
			removed = this.tail;
			// Loop to the second to last element
			for(int i = 0; i < pos; i++) {
				current = current.next;
			}
			current.next = null;
			removed.prev = null;
			this.tail = current; //reassign the tail
			return removed;
		}
		
		// if position is inside the node
		// This stops just before the value to be removed
		while (counter < pos) {
			counter++;
			current = current.next;
		}
		// Before:
		// 1 ->  <- 2 -> <- 3 -> <- 4 -> <- 5 
		// remove(2)
		// After:
		// 1-><- 2 -><- 4 -><- 5
		
		removed = current.next; // Hold the value to be removed  
		current.next = current.next.next; // 2-> 4
		current.next.next.prev = current; // 2 -> <-4 
		
		// Break all the links that 'removed' has to other nodes
		removed.next = null;
		removed.prev = null;
		
		return removed;
	}

	@Override
	public int remove(Object item) {
		
		// Create a counter and a Current Node and
		// While current.data != object, counter++ and current = current.next
		// one you hit the desired object:
		// 1. set current.prev.next = current.next
		// 2. set current.next.prev = current.prev
		// 3. set current.prev && current.next to null
		// return counter
		
		// Before:
		// Node1 ->  <- Node2 -> <- Node3 -> <- Node4 -> <- Node5 
		// remove(Node3)
		// After:
		// Node1-><- Node2 -><- Node4 -><- Node5
		// return: 2
		
		Node current = this.head;
		int counter = 0;

		// While the object is not found, iterate through list
		while(item != current) {
			counter++;
			current = current.next;
		// if item isn't found, then return -1
			if (counter >= size()) {
				return -1;
			}
		}
		// if the item is found, set the prior node.next to current.next
		// set the nexts node.prev to the current.prev
		if (current == item) {
			// here, current = Node3
			current.prev.next = current.next; //Node2 -> Node4
			current.next.prev = current.prev; //Node 2 -><- Node4
			current.prev = null; // Node2 <x- Node 3
			current.next = null; // Node3 -x> node4
		}	
		return counter;
	}

	@Override
	public void replace(Object item, int pos) {
		
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
		
		
		// Throw exception
		if(pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException("Position is invalid.");
		}
		
		Node rep = new Node(item);
		Node current = this.head;
		
		// If want to replace the head
		if(pos == 0) {
			rep.next = this.head.next; // Both point to Node2
			current = current.next; // Shift to Node2
			current.prev = rep; // have Node2 point back to parameter	
			this.head = rep; // reassign head now that parameter is in front
		} 
		else if(pos == this.size()) {
			this.tail.prev.next = rep;
			rep.prev = this.tail.prev;
			this.tail.prev = null;
			this.tail = rep;
		} 
		else {
			// When replacing for a node between the head and tail
			// Loop through the till the position BEFORE pos
			for(int counter = 0; counter < pos; counter++) {
				current = current.next;
			}
			rep.next = current.next.next; 
			current.next = rep; 
			rep.prev = current;									
		}	
	}

	@Override
	public boolean equals(LinkedList<T> list2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<T> combine(LinkedList<T> list2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}

}

 * 
 * 
 * */
