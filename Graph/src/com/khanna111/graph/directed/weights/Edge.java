package com.khanna111.graph.directed.weights;

public class Edge implements Cloneable {
    int weight;
    int start;
    int end;
    
    public Edge(int start, int end, int weight) {
	super();
	this.weight = weight;
	this.start = start;
	this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
	return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
    }
    
   

}
