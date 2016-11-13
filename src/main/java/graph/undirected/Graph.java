package graph.undirected;

/**
 * Created by nbaruah on 11/12/2016.
 */
public interface Graph {
    /**
     * This method returns the number of vertices in the graph
     * @return Number of vertices.
     */
    int V();

    /**
     * This method returns the number of edges in the graph
     * @return Number of edges in the graph
     */
    int E();

    /**
     * This method adds an edge with incident vertices v and w
     * @param vertex v
     * @param vertex w
     */
    void addEdge(int v, int w);

    /**
     *This method returns a list of adjacent vertices to v
     * @param vertex v
     * @return Iterable
     */
    Iterable<Integer> getAdjVertices(int v);

    /**
     * Returns the degree of vertex v
     * @param vertex v
     * @return degree of vertex v
     */
    int getDegree(int v);
}
