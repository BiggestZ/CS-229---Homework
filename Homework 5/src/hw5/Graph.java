package hw5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph implements IGraph{

	// List of Vertices
	public List<Vertex> vertices;
	private Hashtable<String, Vertex> search;
	// ArrayList to be used as a priority queue
	private List<Vertex> tempHold;
	
	// Basic Graph Constructor
	public Graph () {
		vertices = new ArrayList<Vertex>();
		search = new Hashtable<String, Vertex>();
		tempHold = new ArrayList<Vertex>();
	}

	@Override
	// Works
	// Checks if the graph contains a certain vertex.
	public boolean hasVertex(Vertex v) {
		// This will print T/F depending on if vertex
		// is found in the Graph
		return vertices.contains(v);
	}

	/**
	 * getVertices returns the list of Vertices of the graph.
	 * Since List is a Collection, you need a concrete class when creating a list object.
	 * You may use any List type data structures (e.g., ArrayList, LinkedList, etc.)
	 * @return
	 */
	
	@Override
	// Work
	// Return all vertices in the graph 
	public List<Vertex> getVertices() {
		// Return the vertices list
		return vertices;
	}
	
	/**
	 * addVertex takes a Vertex v and add it to the graph.
	 * If the graph already contains a vertex with the same value, throw an IllegalArgumentException.
	 * @param v
	 */

	@Override
	// Works
	// Adds a vertex to the graph
	public void addVertex(Vertex v) {
		// If vertex already exists, throw exception
		if(hasVertex(v)) {
			throw new IllegalArgumentException();
		} else {
		// If not, add to the Graph
			vertices.add(v);
			search.put(v.value, v);
		}
	}

	@Override
	// Works
	// Returns a vertex if its in the graph
	public Vertex getVertex(String name) {
		if(search.get(name) != null) {
			//System.out.println(search.get(name));
			return search.get(name);
		} else {
			System.out.println("This Vertex does not exist.");
			return null;
		}
	}
	
	@Override
	// Works
	// Adds an edge between 2 vertices in the graph
	// *DIRECTED EDGE*
	public void addEdge(String start, String dest, Double cost) {
		Vertex s = getVertex(start);
		Vertex d = getVertex(dest);
		
		// Create one edge to show "s -> d"
		Edge connect = new Edge(cost, s, d);
		// Adds the edge to s
		getVertex(start).addEdge(connect);
	}
	
	@Override
	// Works
	// Adds an edge between 2 vertices in the graph
	// *UNDIRECTED EDGE*
	public void addUndirectedEdge(String start, String dest, Double cost) {
		// Add directed edges between start and dest, so the point to each other
		addEdge(start, dest, cost);
		addEdge(dest, start, cost);
	}
	
	// Custom function to make finding edges easier
	public Edge findEdge(Vertex source, Vertex dest) {
		for(int i = 0; i < source.neighbors.size(); i++) {
			if(source.neighbors.get(i).dest == dest) {
				return source.neighbors.get(i);
			}
		}
		return null;
	}
	
	// Context to use findClosestVertex:
	// Make a ArrayList to hold all the values that are adjacent to the given Vertex
	// This function will go throught that list and return the index of the smallest 
	// total distance. This turns the arraylist into the priority queue, by prioritizing the 
	// smallest value and returning its index so we can go through them all by the 
	// smallest value.
	
	// Works
	// Finds the vertex with the smallest value
	@Override
	public int findClosestVertex(List<Vertex> list) {
		
		double low = list.get(0).tDistance;
		int index = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).tDistance < low) {
				low = list.get(i).tDistance;
				index = i;
			}
		}
		return index;
	}
	
	// Works
	// Performs Dijsktra on a graph, creating an MST
	@Override
	public void dijkstra(String s) {
		/*
		 * I want to use the string to find the starting node, set that node to hV = t
		 * and then set its total distance to 0. After that, I to take all the neighbors of 
		 * the start and put them in an arraylist and set all their pre vertex to the start. 
		 * I want to run closestVertex and find the Vertex closest to the start. Then, I will
		 * set that closest vertex (cV for short) to hV = T and tD to the tD of start + the 
		 * weight of the edge between them. This will continue till all the nodes have been visited.
		 * 
		*/
		
		// Set all vertices to infinity
		for(int i = 0; i < vertices.size(); i++) {
			vertices.get(i).tDistance = Integer.MAX_VALUE;
			vertices.get(i).hasVisited = false;
		}
	
		// Create temporary vertex that will point @ starter vertex
		Vertex start = getVertex(s);
		start.tDistance = 0;
		start.hasVisited = true;
		start.pre = null;
		
		/*
		 For every neighbor of s, set the totalDistance to the cost of the edge
		 Now for every Vertex that has not been visited yet, pick the one that has the shortest distance
		 Visit that vertex by updating hasVisited to true and update all of its unvisited neighbors.
		 You keep doing this until every Vertex has been visited
		*/
		
		// This will go through the initial Vertex, look through all its neighbors
		// put them all in a ArrayList, and then choose the smallest value in that arrayList 
		// to be the new "start" and continue the cycle till that cycle is done
		for(int i = 0; i < start.neighbors.size(); i++) {
			// Create instance vars for cleaner code
			Edge e = start.neighbors.get(i);
			Vertex t = e.dest;
			
			// Set tDistane to weight of edge + distance of start
			t.tDistance = e.weight + start.tDistance;
			// Set the pre to start
			t.pre = start;
			// Add the vertices to the list
			tempHold.add(t);
		}
		
		/**
		 * We can make tempHold hold all the not visited nodes in it. When the node has been visited,
		 * we remove it from the list and mark it as hV. Then, whenever we come across the node again, we 
		 * check if hV. If so, we do not add it to the list. Else, we add it and keep going until the list is empty.
		 * 
		 * */
		
		// While the list of vertices is not empty
		while(!tempHold.isEmpty()) {
			
			int smallestPath = findClosestVertex(tempHold);
			// If the smallest path has already been visited, remove it from the list
			if(tempHold.get(smallestPath).hasVisited ==  true) {
				//System.out.println("This path has already been found: " + tempHold.get(smallestPath));
				tempHold.remove(smallestPath);
				//break;
				
			// If the vertex not already been visited, visit it
			} else {
				
				start = tempHold.get(smallestPath);
				//System.out.println(start);
				start.hasVisited = true;
				
				for(int i = 0; i < start.neighbors.size(); i++) {
					
					// Create instance vars for cleaner code
					Edge e = start.neighbors.get(i);
					Vertex t = start.neighbors.get(i).dest;
					
					if(e.weight + start.tDistance < t.tDistance) {
					// Set tDistane to weight of edge + distance of start
					t.tDistance = e.weight + start.tDistance;
					// Set the pre to start
					t.pre = start;
					// Add the vertices to the list
					tempHold.add(t);
					
							} 
						}
					}
			// Safeguard in case the start Vertex somehow has a predecessor
			if(getVertex(s).pre != null) {
				getVertex(s).pre = null;
			}
		}
	}	
	
	// Works
	// Functions finds the shortest path between 2 vertices on the graph
	@Override
	public List<Edge> getDijkstraPath(String start, String dest) {
		
		// A temporary vertex that will hold vertices between start and dest, inclusive.
		Vertex temp = getVertex(dest);
		
		// First run Dijkstra on the start string. Find the shortest routes
		dijkstra(start);
		
		// verticesPath will store all the vertices in the path
		ArrayList<Vertex> verticesPath = new ArrayList<Vertex>();
		
		// path will store all the edges that will be create the Dijkstra Path
		List<Edge> path = new ArrayList<Edge>();
		
		// Add all the Vertices to the list
		while(temp != null) {
			verticesPath.add(temp);
			temp = temp.pre;
			}
		
		// Note: temp will store values from dest -> start, all values will be stored backwards.
		// To undo this, we need to go through verticesPath from back to front.
		
		for(int i = verticesPath.size()-1; i > 0; i--) {
			
			// Instance Variables for cleaner code
			Vertex A = verticesPath.get(i);
			Vertex B = verticesPath.get(i-1);
			
			// Custom function. Finds edge between 2 vertices
			path.add(findEdge(A, B));
			
			// Checking to see if current edge.dest is same as temp
			// Do not want to create new edge
			// Grab all edges in temp.pre neighbor and find the edge that goes to temp
			// Then add that edge to list
			//System.out.println(path);
			
		}
		
		System.out.println(path); // Lit
		return path;
	}
	
	/**
	 * printGraph prints the entire graph in the following format:
	 * 
	 *  A: (A - B)(A - C)(A - E)
	 *  ......
	 * 
	 * A is a vertex and (A - B)(A - C)(A - E) are all the edges between A and its neighbors.
	 */

	@Override
	public void printGraph() {
		for(int i = 0; i < vertices.size(); i++) {
			// Prints the Vertex
			System.out.print(vertices.get(i) + ": ");
			// Prints all the edges
			System.out.print(vertices.get(i).neighbors);
			// Moves to the next line
			System.out.println();
		}
		// TODO Auto-generated method stub
		
	}

}
