package com.khanna111.practice.graph.directed;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import com.khanna111.graph.directed.Graph;

public class TopologicalSort {

    boolean visited[];
    
    void find(Graph g) {
	int vertices[] = g.getVertices();

	// set visited for all nodes to false
	IntStream.range(0, vertices.length).forEach(i ->visited[i] = false);
	
    }
}
