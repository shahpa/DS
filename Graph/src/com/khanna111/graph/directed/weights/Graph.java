package com.khanna111.graph.directed.weights;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * A Directed Weighed Graph.
 * 
 * The graph could be represented internally by an implementation of the
 * {@link GraphRepresentationI} that, for instance, could be an AdjacencyList of
 * AdjacencyMatrix.
 * 
 * In this instance, the difference is that the edges have weights.
 * 
 * This particular instance is backed by an Adjacency List.
 * 
 * @author gkhanna
 *
 */
public class Graph {

    public static final String NEW_LINE = "\n";

    GraphRepresentationI gRep;
    
    
    static class AdjacencyList implements GraphRepresentationI, Cloneable {
	List<Set<Edge>> list;
	int[] vertices;

	AdjacencyList(int m) {
	    list = new ArrayList<Set<Edge>>(m);
	    vertices = new int[m];
	    for (int i = 0; i < m; i++) {
		list.add(i, new HashSet<Edge>());
		vertices[i] = i;
	    }

	}

	public void addEdge(Edge e) {
	    list.get(e.start).add(e);
	}

	public int getVerticeCount() {
	    return list.size();
	}

	public int[] getVertices() {
	    return vertices;
	}

	public AdjacencyList clone() throws CloneNotSupportedException {
	    AdjacencyList clone = (AdjacencyList) super.clone();
	    clone.list = new ArrayList<Set<Edge>>(getVerticeCount());
	    for (int i = 0; i < getVerticeCount(); i++) {
		// shallow clone of HashSet is fine since the HashSet invokes
		// the clone of the enclosed HashMap and this HashMap is
		// pointing to
		// the existing Integer instances along with the original
		// HashMap.
		clone.list.add(i, (Set<Edge>) ((HashSet<Edge>) list.get(i)).clone());
	    }
	    return clone;

	}

	public AdjacencyList transpose() {
	    AdjacencyList revAdjList = new AdjacencyList(getVerticeCount());
	    for (int v = 0; v < getVerticeCount(); v++) {
		for (Edge i : list.get(v)) {
		    Edge e = new Edge(i.getEnd(), i.getStart() /* or v */, i.getWeight());
		    revAdjList.addEdge(e);
		}
	    }
	    return revAdjList;
	}

	public Iterable<Edge> getEdges(int node) {
	    return list.get(node);
	}

	public void print(PrintStream out) {
	    StringBuilder strB = new StringBuilder();
	    strB.append("Vertices: " + getVerticeCount()).append(NEW_LINE);
	    strB.append("Edges: ").append(NEW_LINE);
	    for (int v = 0; v < getVerticeCount(); v++) {
		strB.append("V: ").append(v).append(":").append(NEW_LINE);
		for (Edge i : list.get(v)) {
		    strB.append("     " + i).append(NEW_LINE);

		}
	    }
	    out.println(strB.toString());
	}
    } // end AdjacencyList

    /**
     * Create a graph of m vertices.
     * 
     * @param m
     */
    public Graph(int m) {
	gRep = new AdjacencyList(m);
	// gRep = new AdjacencyMatrix();
    }

    /**
     * Create a graph with this representation.
     * 
     * @param g
     */
    public Graph(GraphRepresentationI g) {
	this.gRep = g;
    }

    public void addEdge(Edge e) {
	gRep.addEdge(e);
    }

    public Graph reverseGraph() {
	return new Graph(gRep.transpose());
	// gRep.clone();
	//
	// return reverse;
    }

    public int[] getVertices() {
	return gRep.getVertices();
    }

    public int getVerticeCount() {
	return gRep.getVerticeCount();
    }

    public Iterable<Edge> getEdges(int node) {
	return gRep.getEdges(node);
    }

    public void print(PrintStream out) {
	gRep.print(out);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
	Graph g = new Graph(5);
	g.addEdge(new Edge (0, 1, 10));
	g.addEdge(new Edge (0, 3, 30));
	g.addEdge(new Edge (1, 2, 30));
	g.addEdge(new Edge (2, 4, 40));
	g.addEdge(new Edge (3, 4, 40));

	g.print(System.out);

	GraphRepresentationI clone = (GraphRepresentationI) g.gRep.clone();
	clone.print(System.out);
	clone.addEdge(new Edge (0, 4, 40));
	clone.print(System.out);

	System.out.println("Check if the extra edge has made it to the original");
	g.print(System.out);

	System.out.println("-----------------------------");
	System.out.println("Reversing the list: ");
	System.out.println("-----------------------------");
	g.reverseGraph().print(System.out);

    }
}
