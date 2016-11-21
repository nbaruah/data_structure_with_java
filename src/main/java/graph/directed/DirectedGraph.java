package graph.directed;

import java.util.LinkedList;

/**
 * Created by nbaruah on 11/18/2016.
 */
public class DirectedGraph implements DiGraph {
    LinkedList<Integer>[] adjList;
    int V;
    int E;

    /**
     * Create an empty digraph with V vertices
     * @param v the number of vertices
     */
    public DirectedGraph(int v){
        this.V = v;
        this.E = 0;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    /**
     * Reverse of this digraph
     * @return reverse directed graph of this graph,
     * where every edge V-->W will be W-->V
     */
    public DiGraph reverse() {
        DiGraph reverseG = new DirectedGraph(this.V);
        for (int v = 0; v < this.V; v++) {
            for (int adjV : this.adjList[v]){
                reverseG.addEdge(adjV, v);
            }
        }
        return reverseG;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
        E++;
    }

    public Iterable<Integer> getAdjVertices(int v) {
        return adjList[v];
    }

    public int getDegree(int v) {
        return adjList[v].size();
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("V = " + this.V + "\t E = " + this.E + "\n");
        for (int v = 0; v < this.V; v++) {
            builder.append(v + " -> ");
            for (int adjV : adjList[v]){
                builder.append(adjV + ", ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args){
        DiGraph G = new DirectedGraph(6);
        G.addEdge(0, 1);
        G.addEdge(0, 5);
        G.addEdge(2, 0);
        G.addEdge(2, 3);
        G.addEdge(3, 2);
        G.addEdge(3, 5);
        G.addEdge(4, 2);
        G.addEdge(4, 3);
        G.addEdge(5, 4);

        System.out.println(G);
        System.out.println(G.reverse());
        System.out.println(G.getDegree(4));
        System.out.println(G.getAdjVertices(4));
    }
}
