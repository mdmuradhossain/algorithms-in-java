hackerearth
# Topological Sort

Topological sorting of vertices of a Directed Acyclic Graph is an ordering of the vertices  in such a way, that if there is an edge directed towards vertex  from vertex , then  comes before . For example consider the graph given below:

![enter image description here](https://he-s3.s3.amazonaws.com/media/uploads/d6be27e.png)

A topological sorting of this graph is: **1 2 3 4 5** 
There are multiple topological sorting possible for a graph. For the graph given above one another topological sorting is: **1 2 3 4 5**   
In order to have a topological sorting the graph must not contain any cycles. In order to prove it, let's assume there is a cycle made of the vertices . That means there is a directed edge between  and   and between  and . So now, if we do topological sorting then  must come before  because of the directed edge from  to . Clearly,  will come after , because of the directed from  to , that means  must come before . Well, clearly we've reached a contradiction, here. So topological sorting can be achieved for only directed and acyclic graphs.

Le'ts see how we can find a topological sorting in a graph. So basically we want to find a permutation of the vertices in which for every vertex , all the vertices  having edges coming out and directed towards  comes before . We'll maintain an array  that will denote our topological sorting. So, let's say for a graph having  vertices, we have an array  of size  whose  element tells the number of vertices which are not already inserted in  and there is an edge from them incident on vertex numbered . We'll append vertices  to the array , and when we do that we'll decrease the value of  by  for every edge from  to . Doing this will mean that we have inserted one vertex having edge directed towards . So at any point we can insert only those vertices for which the value of  is .
The algorithm using a BFS traversal is given below:
`topological_sort(N, adj[N][N])`
      `  T = []`
      `  visited = []`
        `in_degree = []`
       ` for i = 0 to N`
               ` in_degree[i] = visited[i] = 0`

        for i = 0 to N
                for j = 0 to N
                        if adj[i][j] is TRUE
                                in_degree[j] = in_degree[j] + 1

        for i = 0 to N
                if in_degree[i] is 0
                        enqueue(Queue, i)
                        visited[i] = TRUE

        while Queue is not Empty
                vertex = get_front(Queue)
                dequeue(Queue)
                T.append(vertex)
                for j = 0 to N
                        if adj[vertex][j] is TRUE and visited[j] is FALSE
                                in_degree[j] = in_degree[j] - 1
                                if in_degree[j] is 0
                                        enqueue(Queue, j)
                                        visited[j] = TRUE
        return T
Let's take a graph and see the algorithm in action. Consider the graph given below:
enter image description here

Initially  and  is empty
enter image description here

So, we delete  from  and append it to . The vertices directly connected to  are  and  so we decrease their  by . So, now  and so  is pushed in .

enter image description here

Next we delete  from  and append it to . Doing this we decrease  by , and now it becomes  and  is pushed into .

enter image description here

So, we continue doing like this, and further iterations looks like as follows:

enter image description here
So at last we get our Topological sorting in  i.e. : , , , , , 
Solution using a DFS traversal, unlike the one using BFS, does not need any special  array. Following is the pseudo code of the DFS solution:

T = []
visited = []

topological_sort( cur_vert, N, adj[][] ){
    visited[cur_vert] = true
    for i = 0 to N
        if adj[cur_vert][i] is true and visited[i] is false
        topological_sort(i)
    T.insert_in_beginning(cur_vert)
}
The following image of shows the state of stack and of array  in the above code for the same graph shown above.
enter image description here

Time and Space Complexity
Breaking the algorithm into chunks, we:

Determine the indegree for each node. This is O(M)O(M) time (where MM is the number of edges), since this involves looking at each directed edge in the graph once.
Find nodes with no incoming edges. This is a simple loop through all the nodes with some number of constant-time appends. O(N)O(N) time (where NN is the number of nodes).
Add nodes until we run out of nodes with no incoming edges. This loop could run once for every node—O(N)O(N) times. In the body, we:
Do two constant-time operations on an array to add a node to the topological ordering.
Decrement the indegree for each neighbor of the node we added. Over the entire algorithm, we'll end up doing exactly one decrement for each edge, making this step O(M)O(M) time overall.
Check if we included all nodes or found a cycle. This is a fast O(1)O(1) comparison.
All together, the time complexity is O(M+N)O(M+N).

That's the fastest time we can expect, since we'll have to look at all the nodes and edges at least once.

What about space complexity? Here are the data structures we created:

indegrees—this has one entry for each node in the graph, so it's O(N)O(N) space.
nodesWithNoIncomingEdges—in a graph with no edges, this would start out containing every node, so it's O(N)O(N) space in the worst case.
topologicalOrdering—in a graph with no cycles, this will eventually have every node. O(N)O(N) space.
All in all, we have three structures and they're all O(N)O(N) space. Overall space complexity: O(N)O(N).

This is the best space complexity we can expect, since we must allocate a return array which costs O(N)O(N) space itself.