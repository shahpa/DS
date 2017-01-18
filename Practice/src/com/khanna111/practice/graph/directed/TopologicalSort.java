package com.khanna111.practice.graph.directed;

import static org.testng.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

import com.khanna111.graph.directed.Graph;

public class TopologicalSort {

    int[] state;
    final int PROCESSED = 0;
    final int UNDISCOVERED = 1;
    final int DISCOVERED = 2;
    List<Integer> topResults;

    void find(Graph g) {
	int vertices[] = g.getVertices();
	state = new int[vertices.length];
	topResults = new LinkedList<>();

	// set visited for all nodes to false
	IntStream.range(0, vertices.length).forEach(i -> state[i] = UNDISCOVERED);

	for (int v : g.getVertices()) {
	    if (state[v] != PROCESSED) {
		dfs(g, v);
	    }
	}
	print(topResults);

    }

    void dfs(Graph g, int node) throws RuntimeException {
	if (state[node] == PROCESSED) {
	    return;
	}
	else if (state[node] == DISCOVERED) {
	    print("Reached a cycle");
	    print("Node: " + node);
	    throw new RuntimeException("CYCLE");
	}
	else {
	    state[node] = DISCOVERED;
	    Iterable<Integer> next = g.getEdges(node);
	    for (int n : next) {
		dfs(g, n);
	    }
	    state[node] = PROCESSED;
	    topResults.add(0, node);
	}

    }

    private void print(Object s) {
	System.out.println(s);

    }

    @Test(expectedExceptions = { RuntimeException.class })
    public void testTopSortCycle1() {
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
	find(g);
    }

    @Test
    public void testTopSort1() {
	Graph g = new Graph(7);
	g.addEdge(0, 1);
	g.addEdge(1, 3);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	g.addEdge(4, 3);
	g.addEdge(2, 5);
	g.addEdge(5, 4);
	g.addEdge(6, 0);
	g.addEdge(6, 5);
	find(g);
	assertEquals(topResults, IntStream.of(6, 0, 1, 2, 5, 4, 3).boxed().collect(Collectors.toList()),
		"Top sort not correct");
    }
}
