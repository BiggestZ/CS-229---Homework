package hw5;

public class Edge implements IEdge {
	
	/**
	 * Here is the general information regarding your Edge class.
	 * Each edge should have:
	 		a non negative weight (e.g. 4 or 101.2), 
	 		a source vertex (e.g. Vertex A),
	 		and a dest vertex (e.g. Vertex B).
	 */
	
	// Instance Variables
	double weight;
	Vertex source;
	Vertex dest;
	
	// Basic Constructor
 	public Edge (double w, Vertex s, Vertex d) {
		this.weight = w;
		this.source = s;
		this.dest = d;
	}
		
	// Print Function
	public String toString() {
		return source.value + " - " + dest.value;
	}
	
}
