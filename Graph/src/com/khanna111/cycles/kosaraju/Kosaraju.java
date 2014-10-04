package com.khanna111.cycles.kosaraju;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.khanna111.graph.directed.Graph;
import com.khanna111.util.PrintUtil;

/**
 * 
 * Implemented as per wiki:
 * <a href = "http://en.wikipedia.org/wiki/Kosaraju%27s_algorithm" > Kosaraju </a>
 * 
 * <pre>
 * <ol>
 * <li> Let G be a directed graph and S be an empty stack.
 * <li> While S does not contain all vertices:
 * <ul>
 * <li> Choose an arbitrary vertex v not in S. Perform a depth-first search starting at v. Each time that depth-first search finishes expanding a vertex u, push u onto S.
 * </ul>
 * <li> Reverse the directions of all arcs to obtain the transpose graph.
 * <li> While S is nonempty:
 * <ul>
 * <li> Pop the top vertex v from S. Perform a depth-first search starting at v in the transpose graph. The set of visited vertices will give the strongly connected component containing v; record this and remove all these vertices from the graph G and the stack S. Equivalently, breadth-first search (BFS) can be used instead of depth-first search.
 * </ul>
 * </ol>
 * </pre>
 * 
 * @author gkhanna
 */
public class Kosaraju {

    Graph g;

    Graph gRev;

    private Stack<Integer> finishingTime = new Stack<Integer>();
    private Set<Integer> discoveredNodes = new HashSet<Integer>();

    private List<Integer> listOfStronglyConnectedNodes = new ArrayList<Integer>();

    /**
     * Step 2 from description above
     */
    public void gatherFinishingTime() {
	for (int i = g.getVerticeCount() -1; i >=0; i--){
//	for (int i : g.getVertices()) {
	    if (!discoveredNodes.contains(i)) {
		DFSLoop1(g, i);
	    }
	}
    }

    public void DFSLoop1(Graph gArg, int startingNode) {
	discoveredNodes.add(startingNode);
	for (int edge : gArg.getEdges(startingNode)) {
	    if (!discoveredNodes.contains(edge)) {
		DFSLoop1(gArg, edge);
	    }
	}
	finishingTime.push(startingNode);

    }

    /**
     * Step 1 from description above:
     * 
     * Precondition: gRev is available.
     * 
     */
    public void gatherStronglyConnected() {
	discoveredNodes.clear();
	while (!finishingTime.isEmpty()) {
	    int v = finishingTime.pop();
	    if (discoveredNodes.contains(v)) {
		continue;
	    }
	    listOfStronglyConnectedNodes.clear();
	    DFSLoop2(gRev, v);
	    PrintUtil.printList(listOfStronglyConnectedNodes);
	}
    }

    public void DFSLoop2(Graph gArg, int startingNode) {
	discoveredNodes.add(startingNode);
	listOfStronglyConnectedNodes.add(startingNode);

	for (int edge : gArg.getEdges(startingNode)) {
	    if (!discoveredNodes.contains(edge)) {
		DFSLoop2(gArg, edge);
	    }
	}
    }

    /**
     * Disregard m for now. Create a static graph
     * 
     */
    public Graph createGraph(int m) {
	Graph g = new Graph(9);
	g.addEdge(1, 4);
	g.addEdge(2, 8);
	g.addEdge(3, 6);
	g.addEdge(4, 7);
	g.addEdge(5, 2);
	g.addEdge(6, 0);
	g.addEdge(7, 1);
	g.addEdge(8, 6);
	g.addEdge(8, 5);
	g.addEdge(0, 7);
	g.addEdge(0, 3);
	return g;

    }

    public static void main(String[] args) {
	Kosaraju k = new Kosaraju();

	k.g = k.createGraph(5);
	k.gRev = k.g.reverseGraph();

	k.gatherFinishingTime();
	k.gatherStronglyConnected();
    }
}
