package graph.undirected;

/**
 * Created by nbaruah on 11/12/2016.
 */
public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
}
