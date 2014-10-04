package com.khanna111.graph.weights;

import java.io.PrintStream;

/**
 * 
 * @author gkhanna
 *
 */
public interface GraphRepresentationI extends Cloneable {
    public void addEdge(Edge e);

    public int getVerticeCount();
    
    public int[] getVertices();
    
    public Iterable<Edge> getEdges(int node);

    public void print(PrintStream out);

    /**
     * Need to explicitly specify the clone method
     * as we want the client test code to invoke the clone as well.
     */
    public Object clone() throws CloneNotSupportedException;
    
    public GraphRepresentationI transpose();
}
