package graph.undirected;

import graph.common.Graph;

import java.util.Stack;

/**
 * This class answers various path related questions from a source vertex s.
 * It is initialized With a graph G and a source vertex s.
 * On initialization it performs a DFS from the source vertex and computes various path related questions.
 * Created by nbaruah on 11/13/2016.
 */
public class DFSPaths implements Paths{
    private boolean[] visited; // vertex indexed array to mark when a vertex is visited
    private int[] edgeTo; // vertex indexed array to track back from which vertex we reached a particular vertex for the first time
    private int source; // source vertex
    private int sizeOfG; // number of vertices in the graph

    /**
     * Find paths in G from source vertex
     * @param G the Graph
     * @param source vertex
     */
    public DFSPaths(Graph G, int source){
        sizeOfG = G.V();
        validateVertex(source);
        this.source = source;
        visited = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, source);
    }

    /**
     * Is there a path between source vertex and vertex v?
     * @param v vertex
     * @return true if exist
     * @throws ArrayIndexOutOfBoundsException if v is not a valid vertex
     */
    public boolean hasPathTo(int v){
        validateVertex(v);
        return visited[v];
    }

    /**
     * Returns a path between vertex v and source or null if no such path
     * @param v the vertex
     * @return A path to source vertex and null if there is no path to source
     */
    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int currentVertex = v;
        while (currentVertex != this.source){
            path.push(currentVertex);
            currentVertex = edgeTo[currentVertex];
        }
        path.push(this.source);
        return path;
    }

    /**
     * Performs a DFS from v, to visit each vertex that has a path with v (undirected graph)
     * @param G the graph on which DFS is to perform
     * @param v the vertex from which dfs is performed
     */
    private void dfs(Graph G, int v){
        visited[v] = true;
        for (int adjV : G.getAdjVertices(v)){
            if (!visited[adjV]){
                dfs(G, adjV);
                edgeTo[adjV] = v;
            }
        }
    }

    private void validateVertex(int v){
        if (v < 0 || v >= sizeOfG){
            throw new ArrayIndexOutOfBoundsException("Vertex: " + v + " is not in between 0 and " + (sizeOfG - 1));
        }
    }

    public static void main(String[] args){
        Graph G = new AdjacencyList(6);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(3, 4);

        DFSPaths DFSPathsFrom_0 = new DFSPaths(G, 0);
        System.out.println(DFSPathsFrom_0.pathTo(3));
    }
}
