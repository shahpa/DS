package com.khanna111.path.djikstras;

import java.util.HashSet;
import java.util.Set;

import com.khanna111.graph.directed.weights.Edge;
import com.khanna111.graph.directed.weights.Graph;
import com.khanna111.graph.directed.weights.Vertex;
import com.khanna111.util.PrintUtil;

/**
 * Although Dijkstra's can operate on directed as well 
 * as undirected graphs, we would in this example operate
 * on a directed graph.
 * 
 * This is the naive implementation and runs in 
 * {@code O (E + V^2) }.
 * 
 * 
 * @author khanna
 *
 */
public class NaiveDijkstras {

    int[] findShortestPath(Vertex s, Graph g) {
	
//	List<Vertex> shortestPaths = new ArrayList<Vertex>();
	// The distance from the source to a vertex.
	// Each index specifies the id of the Vertex
	int[] dist = new int[g.getVerticeCount()];
	Set<Vertex> set = new HashSet<Vertex>();

	// Prepare the graph 
	prepareGraph(s, g, dist, set);
	
	Vertex v;
	/* This is invoked "v" times.*/
	while ((v = findMin(set, dist)) != null) {
	    // Mark this vertex as settled 
	    set.remove(v);
	    /* This is invoked for each outgoing edge adjacent to this vertex */
	    for (Edge e : g.getEdges(v)) {
		// if this edge's end vertex has a lesser combined 
		// weight than the previous distance then we have a 
		// new minimum distance to this edge's end vertex.
		if ( e.getWeight() + dist[v.getId()] < dist[e.getEnd()] ) {
		
		    dist[e.getEnd()] = e.getWeight() + dist[v.getId()];
		}
	    }
	    
	}
	return dist;

    }

    /**
     * Prepares the graph by setting distance to source to be 0 and to every
     * other vertex to be {@link java.lang.Integer#MAX_VALUE}.
     * 
     * Also populates the queue with all vertices.
     * 
     * @param s
     * @param g
     */
    void prepareGraph(Vertex s, Graph g, int[]dist, Set<Vertex> set) {

	for (Vertex v : g.getVertices()) {
	    set.add(v);
	    if (v.equals(s)) {
		dist[v.getId()] = 0;
		continue;
	    }
	    dist[v.getId()] = Integer.MAX_VALUE;
	}
    }

    /**
     * This returns the minimum distance captured in the 
     * {@code dist} argument.
     * Note that we check for only the vertices that are 
     * left in the {@code set}.
     * 
     * @param set
     * @param dist
     * @return
     */
    Vertex findMin(Set<Vertex> set, int[] dist) {
	int min = Integer.MAX_VALUE;
	// The index of the minimum element
	int id = -1;
	for (int index = 0; index < dist.length; index++) {
	    // if the vertex is in the queue.
	    if (set.contains(new Vertex(index)) && dist[index] < min) {
		min = dist[index];
		id = index;
	    }
	}
	return id == -1 ? null : new Vertex(id);
    }
    
    /**
     * Disregard m for now. Create a static graph
     * 
     */
    public Graph createGraph(int m) {
	Graph g = new Graph(9);
	g.addEdge(new Edge(0, 1, 10));
	g.addEdge(new Edge(0, 2, 30));
	g.addEdge(new Edge(0, 8, 20));
	g.addEdge(new Edge(1, 2, 10));
	g.addEdge(new Edge(2, 3, 30));
	g.addEdge(new Edge(2, 7, 40));
	g.addEdge(new Edge(3, 4, 10));
	g.addEdge(new Edge(3, 5, 20));
	g.addEdge(new Edge(4, 0, 50));
	g.addEdge(new Edge(6, 5, 100));
	g.addEdge(new Edge(7, 6, 70));
	g.addEdge(new Edge(7, 8, 10));
	return g;

    }

    public static void main(String[] args) {
	NaiveDijkstras dij = new NaiveDijkstras();
	Graph g = dij.createGraph(9);
	int dist[] = dij.findShortestPath(new Vertex(0), g);
	PrintUtil.printIntArray( dist);
    }
}
