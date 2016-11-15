package graph.undirected;

import common.Queue;

import java.util.Stack;

/**
 * Created by nbaruah on 11/14/2016.
 */
public class BFSPaths implements Paths{
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] visited; // visited[v] = Is vertex v is visited from source
    private int[] visitedFrom; // visitedFrom[v] = last vertex in the path to vertex v
    private int[] distFromSrcTo; // distFromSrcTo[v] = length of the path from source to vertex v
    private int sizeOfG; // Stores the number of vertices in the graph to be processed

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

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return visited[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int currentVertex = v;
        while(distFromSrcTo[currentVertex] != 0){
            path.push(currentVertex);
            currentVertex = visitedFrom[currentVertex];
        }
        return path;
    }

    private void validateVertex(int v){
        if (v < 0 || v >= sizeOfG){
            throw new ArrayIndexOutOfBoundsException("Vertex: " + v + " is not in between 0 and " + (sizeOfG - 1));
        }
    }
}
