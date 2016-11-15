package graph.undirected;

import common.Queue;

/**
 * Created by nbaruah on 11/14/2016.
 */
public class BFSPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] visited; // visited[v] = Is vertex v is visited from source
    private int[] visitedFrom; // visitedFrom[v] = last vertex in the path to vertex v
    private int[] distFromSrcTo; // distFromSrcTo[v] = length of the path from source to vertex v

    public BFSPaths(Graph G, int source){
        visited = new boolean[G.V()];
        visitedFrom = new int[G.V()];
        distFromSrcTo = new int[G.V()];
    }

    private void bfs(Graph G, int source){
        Queue<Integer> nodesQ = new Queue<Integer>();
        for (int i = 0; i < G.V(); i++) {
            distFromSrcTo[i] = INFINITY;
        }
        visited[source] = true;
        distFromSrcTo[source] = 0;
        nodesQ.enqueue(source);

        while (!nodesQ.isEmpty()){
            int v = nodesQ.dequeue();
            for (int adjVertex : G.getAdjVertices(v)){
                if (!visited[adjVertex]){
                    visited[adjVertex] = true;
                    visitedFrom[adjVertex] = v;
                    distFromSrcTo[adjVertex] = distFromSrcTo[v] + 1;
                    nodesQ.enqueue(adjVertex);
                }
            }
        }
    }
}
