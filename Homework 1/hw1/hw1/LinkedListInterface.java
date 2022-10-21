package hw1;

/**
 * This interface will be implemented with the LinkedList class.  
 * Do not modify this file.
 * Your LinkedList has to implement this interface.
 * @author Celia Chen
 */

public interface LinkedListInterface<T>{
  
	/**
	 * This method returns the number of items in the list.
	 * @return the size of the list
	 */
	public int size();
	
	/**
	 * This method returns true if the list has no items.
	 * @return true if the list is empty.
	 */
	public boolean isEmpty();
	
	/**
    * This method takes an item as parameter and add the item to the end of the list.
    * It returns the index of the new tail
    * @param item the item to be added to the end of the list
    * @return the integer signifying the index of the tail
    */
   public int add(T item);
   
   /**
    * This method takes an item and a position as parameters.
    * It add the item at the position specified by pos.
    * All subsequent items will be moved to the right.  
    * Throw an IndexOutOfBoundsException if the position is invalid.  
    * @param item the item to be added
    * @param pos the position to add the item at
    * @throws IndexOutOfBoundsException if position is invalid
    */
   public void add(T item, int pos);
   
   /**
    * This method takes an item as parameter
    * and returns the index of the item if the list contains this item.
    * Return -1 if the list does not contain this item.
    * @param item the item to be examined
    * @return the index of the item from the list
    */
   public int contains(T item);
   
   
   /**
    * This method takes a position as parameter
    * and returns the item that is located in the position.
    * Throw an IndexOutOfBoundsException if the position is invalid. 
    * @param pos the position to get the item 
    * @return item at the position
    * @throws IndexOutOfBoundsException if position is invalid
    */
   public T get(int pos);
   
   
   /**
    * This method takes a position as parameter
    * and removes the item at the position specified by pos.  
    * When the item is removed, all subsequent items (if any) will move to the left.  
    * Throw an IndexOutOfBoundsException if the position is invalid.
    * @param pos The position to remove the object from.
    * @return The removed item.
    * @throws IndexOutOfBoundsException if position is invalid.
    */
   public T remove(int pos);
  
   /**
    * This method takes an item as parameter
    * and removes the item if the list contains the item. 
    * It returns the index of the removed item.
    * Return -1 if the list does not contain the item. 
    * When the item is removed, all subsequent items (if any) will move to the left.  
    * @param item The item to be removed.
    * @return the index of the removed item.
    */
   
   public int remove(T item);
  
   /**
    * This method takes an item and a position as parameters
    * and replaces the existing item at the position with the new item.
    * Throw an IndexOutOfBoundsException if position is invalid.
    * @param item The new item to be replaced
    * @param pos The position to replace
    * @throws IndexOutOfBoundsException if position is invalid.
    */
   public void replace(T item, int pos);
   
   
   /**
    * This method takes another LinkedList as parameter
    * and returns true if this list and list2 contains the same values.
    * @param list2 Another LinkedList
    * @return true if two LinkedLists have the same values.
    */
   public boolean equals(LinkedList<T> list2);
   
   
   /**
    * This method takes another LinkedList as parameter
    * and combines the other LinkedList with this LinkedList
    * It returns a new LinkedList that combines both LinkedLists.
    * @param list2 The other LinkedList
    * @return A new LinkedList with combined items from both lists.
    */
   public LinkedList<T> combine(LinkedList<T> list2);
   
   
   /**
    * This method reverses the list
    * and returns the reversed list. 
    * @return The reversed list
    */
   public LinkedList<T> reverse();
   
   /**
    * This method returns a formatted String for the list.
    * The String should look something like this:
    * 	Head to tail: 1->2->3->4->5
    * 	Tail to head: 5->4->3->2->1
    * Note that you are required to use both head and tail references
    * to get traverse your list to make sure both next and prev references
    * are set correctly.
    * @return A formatted String
    */
   public String toString();
}
