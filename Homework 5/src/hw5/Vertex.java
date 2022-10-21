package hw5;

import java.util.ArrayList;

public class Vertex implements IVertex {

	/**
	 * Here is the general information regarding your Vertex class.
	 * Each vertex should have:
	 		a String type value (e.g. "A" or "Boston"), 
	 		and a list of neighbors (e.g. [(A - B), (A - C)]).	
	 
	 * Here are addition instance variables you need in this case:		
	 	* In order to visualize the map, you also need to keep track of its x and y coordinates on the map.
	 	
	 	* In order to calculate the shortest path between two vertices, you also need to keep track of:
	 		total distance (e.g. 19.23 or 1000),
	 		has visited or not e.g. true or false), 
	 		and where it is coming from (e.g. Vertex A).
	 */
	
	// Holds the city name
	public String value;
	
	// Points to the vertex pointing to this
	public Vertex pre;
	
	// Holds edges
	public ArrayList <Edge> neighbors; 
	
	// Holds the x,y coordinates
	public int x;
	public int y;
	
	// Total Distance
	public double tDistance;
	
	// Checks if the Vertex has been visited
	public boolean hasVisited;
		
	/**
	 * Constructors:
	 * 		Constructor 1: This constructor should take only a String value as its parameter.
	 * 					   In the constructor, initialize edge list, set x, y, total distance to 0; hasVisited to false
	 * 
	 * 
	 * 		Constructor 2: This constructor should take a String value, an x value and a y value as its parameter.
	 * 					   In the constructor, initialize and set all the instance variables.
	 */
	
	// 1st Constructor
	public Vertex (String name) {
		this.value = name;
		this.neighbors = new ArrayList<Edge>();
		this.x = this.y = 0;
		this.tDistance = 0;
		hasVisited = false;
	}
	
	// 2nd Constructor
	public Vertex(String name, int x, int y) {
		this.value = name;
		this.neighbors = new ArrayList<Edge>();
		this.x = x;
		this.y = y;
		this.tDistance = 0;
		hasVisited = false;
	}
	
	// Adds an edge to this Vertexes edges
	@Override
	public void addEdge(Edge e) {
		neighbors.add(e);
	}
	
	// Print function
	public String toString() {
		return this.value;
	}
	

}
