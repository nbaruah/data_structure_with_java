package graph.undirected;

import graph.common.Graph;

import java.util.LinkedList;

/**
 * This class represents a graph.
 * It is implemented using Adjacency list
 * Created by nbaruah on 11/12/2016.
 */
public class AdjacencyList implements Graph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adjList;

    public AdjacencyList(int v){
        if (v < 0) {
            throw new IllegalArgumentException("Number of vertices can not be negative");
        }
        this.V = v;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int x, int y) {
        validateVertex(x);
        validateVertex(y);
        E++;
        adjList[x].add(y);
        adjList[y].add(x);
    }

    public Iterable<Integer> getAdjVertices(int x) {
        validateVertex(x);
        return adjList[x];
    }

    public int getDegree(int v) {
        validateVertex(v);
        return adjList[v].size();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("# of vertices: " + V + "\n# of edges: " + E + "\n");
        for (int i = 0; i < V; i++) {
            builder.append(i + ":");
            for (int v : adjList[i]){
                builder.append(" =>" + v);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Check whether the vertex is in the range
     * @param v
     * @throws ArrayIndexOutOfBoundsException
     */
    private void validateVertex(int v){
        if (v < 0 || v >= V){
            throw new ArrayIndexOutOfBoundsException("Vertex: " + v + " is not in between 0 and " + (V-1));
        }
    }
}
