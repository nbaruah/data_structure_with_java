package graph.undirected;

/**
 * Created by nbaruah on 11/15/2016.
 */
public interface Paths {
    /**
     * This method returns true if there exists a path from source to vertex v
     * @param v the vertex
     * @return true if a path exist from to vertex v
     */
    boolean hasPathTo(int v);

    /**
     * This method returns a path if there exists a path between source and vertex v
     * @param v the vertex
     * @return path to source, null if there is no path to source
     */
    Iterable<Integer> pathTo(int v);
}
