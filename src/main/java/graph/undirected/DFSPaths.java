package graph.undirected;

import java.util.Stack;

/**
 * This class answers various path related questions from a source vertex s.
 * It is initialized With a graph G and a source vertex s.
 * On initialization it performs a DFS from the source vertex and computes various path related questions.
 * Created by nbaruah on 11/13/2016.
 */
public class DFSPaths {
    private boolean[] visited; // vertex indexed array to mark when a vertex is visited
    private int[] visitedFrom; // vertex indexed array to track back from which vertex we reached a particular vertex for the first time
    private int source; // Stores the source vertex
    private int sizeOfG; // Stores the number of vertices in the graph to be processed

    /**
     * Find paths in G from source
     * @param G the Graph
     * @param source vertex
     */
    public DFSPaths(Graph G, int source){
        sizeOfG = G.V();
        validateVertex(source);
        this.source = source;
        visited = new boolean[G.V()];
        visitedFrom = new int[G.V()];
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
            currentVertex = visitedFrom[currentVertex];
        }
        path.push(this.source);
        return path;
    }

    /**
     * Performs a DFS from source, to visit each vertex that has a path with source (undirected graph)
     * @param G
     * @param source
     */
    private void dfs(Graph G, int source){
        visited[source] = true;
        for (int adjV : G.getAdjVertices(source)){
            if (!visited[adjV]){
                dfs(G, adjV);
                visitedFrom[adjV] = source;
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
        for (int v : DFSPathsFrom_0.pathTo(2)){
            System.out.print(" => " +v);
        }
        System.out.println();

        System.out.println(DFSPathsFrom_0.hasPathTo(2));
    }
}
