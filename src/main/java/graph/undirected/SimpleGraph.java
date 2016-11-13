package graph.undirected;

import java.util.LinkedList;

/**
 * Created by nbaruah on 11/12/2016.
 */
public class SimpleGraph implements Graph {
    private int v;
    private LinkedList<Integer>[] adjList;

    public SimpleGraph(int v){
        if (v >= 0){
            this.v = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
        } else {
            throw new IllegalArgumentException("Number of vertices can not be negative");
        }
    }

    public int V() {
        return v;
    }

    public int E() {
        return 0;
    }

    public void addEdge(int x, int y) {
        if (x < this.v && y < this.v){
            adjList[x].add(y);
            adjList[y].add(x);
        } else {
            throw new IllegalArgumentException("provided vertex pair doesn't exist");
        }
    }

    public Iterable<Integer> adj(int x) {
        if (x < this.v){
            return adjList[x];
        } else{
            throw new IllegalArgumentException("Vertex " + x + " doesn't exist");
        }

    }
}
