package io.murad.topogicalsorting.Kahntopologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

	// A list of lists to represent an adjacency list
	List<List<Integer>> adjList = null;

	// stores indegree of a vertex
	List<Integer> indegree = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// initialize indegree of each vertex by 0
		indegree = new ArrayList<>(Collections.nCopies(n, 0));

		// add edges to the directed graph
		for (Edge edge : edges) {
			int src = edge.src;
			int dest = edge.dest;

			// add an edge from source to destination
			adjList.get(src).add(dest);

			// increment in-degree of destination vertex by 1
			indegree.set(dest, indegree.get(dest) + 1);
		}
	}

}
