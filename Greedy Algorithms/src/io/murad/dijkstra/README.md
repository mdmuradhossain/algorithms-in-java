# Dijkstra's Algorithm

Dijkstra's algorithm allows us to find the shortest path between any two vertices of a graph.

It differs from the minimum spanning tree because the shortest distance between two vertices might not include all the vertices of the graph.

## How Dijkstra's Algorithm works

Dijkstra's Algorithm works on the basis that any subpath `B -> D` of the shortest path `A -> D` between vertices A and D is also the shortest path between vertices B and D.

![Each subpath is the shortest path](https://cdn.programiz.com/sites/tutorial2program/files/shortest-subpath.png)

Djikstra used this property in the opposite direction i.e we overestimate the distance of each vertex from the starting vertex. Then we visit each node and its neighbors to find the shortest subpath to those neighbors.

The algorithm uses a greedy approach in the sense that we find the next best solution hoping that the end result is the best solution for the whole problem.

## Example of Dijkstra's algorithm

It is easier to start with an example and then think about the algorithm.

![Start with a weighted graph](https://cdn.programiz.com/sites/tutorial2program/files/dj-1.png)

![Choose a starting vertex and assign infinity path values to all other devices](https://cdn.programiz.com/sites/tutorial2program/files/dj-2.png)

![Go to each vertex and update its path length](https://cdn.programiz.com/sites/tutorial2program/files/dj-3.png)

![If the path length of the adjacent vertex is lesser than new path length, don't update it](https://cdn.programiz.com/sites/tutorial2program/files/dj-4.png)

![Avoid updating path lengths of already visited vertices](https://cdn.programiz.com/sites/tutorial2program/files/dj-5.png)

![After each iteration, we pick the unvisited vertex with the least path length. So we choose 5 before 7](https://cdn.programiz.com/sites/tutorial2program/files/dj-6.png)

![Notice how the rightmost vertex has its path length updated twice](https://cdn.programiz.com/sites/tutorial2program/files/dj-7.png)

![Repeat until all the vertices have been visited](https://cdn.programiz.com/sites/tutorial2program/files/dj-8.png)

## kstra's algorithm pseudocode

We need to maintain the path distance of every vertex. We can store that in an array of size v, where v is the number of vertices.

We also want to be able to get the shortest path, not only know the length of the shortest path. For this, we map each vertex to the vertex that last updated its path length.

Once the algorithm is over, we can backtrack from the destination vertex to the source vertex to find the path.

A minimum priority queue can be used to efficiently receive the vertex with least path distance.

function dijkstra(G, S)
    for each vertex V in G
        distance[V] <- infinite
        previous[V] <- NULL
        If V != S, add V to Priority Queue Q
    distance[S] <- 0
	
    while Q IS NOT EMPTY
        U <- Extract MIN from Q
        for each unvisited neighbour V of U
            tempDistance <- distance[U] + edge_weight(U, V)
            if tempDistance < distance[V]
                distance[V] <- tempDistance
                previous[V] <- U
    return distance[], previous[]
    
## kstra's Algorithm Complexity
Time Complexity: `(E Log V)`

where, E is the number of edges and V is the number of vertices.

Space Complexity: `(V)`

## Dijkstra's Algorithm Applications
-  find the shortest path
-  social networking applications
-  a telephone network
-  find the locations in the map