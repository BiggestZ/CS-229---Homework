package hw5;

import java.util.ArrayList;
import java.util.List;

public class GraphTester {
	
	public static void main (String [] args) {
		Vertex test = new Vertex("Jeff", 100, 200);
		/*System.out.println(test.value);
		System.out.println(test.x);
		System.out.println(test.y);
		System.out.println(test.tDistance);
		System.out.println(test.hasVisited);
		System.out.println(test.neighbors);
		*/
		Vertex test2 = new Vertex("Dom", 100000, 2029290);
		
		Vertex test3 = new Vertex("Jack", 1, 3);
		
		Vertex test4 = new Vertex("Bob", 123, 456);
		
		//Edge e = new Edge(100, test, test2 );
		//Edge f = new Edge(100, test, test3 );
		
		//test.addEdge(e);
		//test.addEdge(f);
		
		//System.out.println(test.neighbors);
		
		Graph tester = new Graph();
		
		tester.addVertex(test);
		tester.addVertex(test2);
		tester.addVertex(test3);
		tester.addVertex(test4);
		
		//test.addEdge(null);
		
		// System.out.println(tester.vertices);
		
		tester.addEdge("Jeff", "Dom", 20.0);
		tester.addEdge("Jeff", "Jack", 200.0);
		//tester.addEdge("Dom", "Jeff", 2000.0);
		tester.addEdge("Dom", "Bob", 6.0);
		tester.addEdge("Bob", "Jeff", 8.0);
		tester.addUndirectedEdge("Dom", "Jack", 8.0);
		
		List <Vertex> sub = new ArrayList<Vertex>();
		
		for(int i = 0; i < test.neighbors.size(); i++) {
			sub.add(test.neighbors.get(i).dest);
			sub.get(i).tDistance = test.neighbors.get(i).dest.tDistance;
			//System.out.println(test.neighbors.get(i).dest.tDistance);
			//System.out.println(sub.get(i).tDistance + "22222");
		}
		
		//System.out.println(test.neighbors + " CCCC");
		
		//System.out.println(sub.get(0));
		
		/*
		System.out.println(tester.getVertex("Jeff") + " B");
		System.out.println(tester.getVertex("Jeff").tDistance + " B");
		
		System.out.println(tester.getVertex("Dom") + " 4");
		System.out.println(tester.getVertex("Dom").tDistance + " 4");
		*/
		
		//System.out.println(test2.tDistance);
		
		//System.out.println(sub.get(0).tDistance + "SSSS");
		//System.out.println(sub.get(1).tDistance + "A");
		
		//tester.addUndirectedEdge("Jeff", "Dom", 10.0);
		//tester.addUndirectedEdge("Jack", "Dom", 10.0); 
		
		//System.out.println(test.neighbors);
		//System.out.println(test2.neighbors);
		
		//tester.getVertex("Dom");
		
		//System.out.println(sub.get(tester.findClosestVertex(sub)));
		//System.out.println(tester.findClosestVertex(sub));
		
		//tester.dijkstra("Jeff");
		
		//System.out.println(test.pre);
		
		tester.getDijkstraPath("Jeff", "Bob");
		
		//tester.printGraph();
		
		
	}
}
	
	
