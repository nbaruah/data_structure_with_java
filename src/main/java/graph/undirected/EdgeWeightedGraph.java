package graph.undirected;

import graph.common.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbaruah on 12/12/2016.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private List<Edge>[] adjList;

    public EdgeWeightedGraph(int V){
        this.V = V;
        adjList = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adjList[v] = new ArrayList<Edge>();
        }
    }

    /**
     * This method returns the number of vertices in the graph
     *
     * @return Number of vertices.
     */
    public int V() {
        return V;
    }

    /**
     * This method returns the number of edges in the graph
     *
     * @return Number of edges in the graph
     */
    public int E() {
        return E;
    }

    /**
     * This method adds an edge with incident vertices v and w
     *
     * @param e
     */
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adjList[v].add(e);
        adjList[w].add(e);
        E++;
    }

    /**
     * This method returns a list of adjacent vertices to v
     *
     * @param v@return Iterable
     */
    public Iterable<Edge> getAdjEdges(int v) {
        return adjList[v];
    }

    /**
     * Returns the degree of vertex v
     *
     * @param v@return degree of vertex v
     */
    public int getDegree(int v) {
        return adjList[v].size();
    }

    public static void main(String[] args){
        EdgeWeightedGraph G = new EdgeWeightedGraph(4);
        G.addEdge(new Edge(0, 1, 11));
        G.addEdge(new Edge(0, 2, 44));
        G.addEdge(new Edge(0, 3, 22));
        G.addEdge(new Edge(1, 3, 33));
        G.addEdge(new Edge(2, 3, 55));

        for (int i = 0; i < G.V(); i++) {
            System.out.println(G.getAdjEdges(i));
        }
    }
}
