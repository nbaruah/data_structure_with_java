package graph.undirected;

import graph.common.Graph;

import java.util.Stack;

/**
 * Created by nbaruah on 11/16/2016.
 */
public class ConnComponents {
    private boolean[] visited; // visited[v] indicates that vertex v is visited
    private int[] id;
    private int[] edgeTo;
    private int count=0;
    private int V;

    public ConnComponents(Graph G){
        this.V = G.V();
        visited = new boolean[G.V()];
        id = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]){
                dfs(G, v);
                count++;
                edgeTo[v] = -1;
            }
        }
    }

    public boolean isConnected(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    public int count(){
        return count;
    }

    public int id(int v){
        validateVertex(v);
        return id[v];
    }

    private void dfs(Graph G, int v){
        visited[v] = true;
        id[v] = count;
        for (int adjVertex : G.getAdjVertices(v)){
            if (!visited[adjVertex]){
                dfs(G, adjVertex);
                edgeTo[adjVertex] = v;
            }
        }
    }

    public  Iterable<Integer> getPathTo(int v){
        validateVertex(v);
        Stack<Integer> path = new Stack<Integer>();
        for (int currentV = v; currentV != -1 ; currentV = edgeTo[currentV]) {
            path.push(currentV);
        }
        return path;
    }

    private void validateVertex(int v){
        if (v < 0 || v >= this.V){
            throw new ArrayIndexOutOfBoundsException(v + " is not a valid vertex");
        }
    }

    public static void main(String[] args){
        Graph g = new AdjacencyMatrix(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(2,3);
        g.addEdge(4,5);

        ConnComponents cc = new ConnComponents(g);
        System.out.println("Number of connected components: " + cc.count());
        System.out.println("Is 4 and 3 connected: " + cc.isConnected(4, 3));
        System.out.println("Is 0 and 3 connected: " + cc.isConnected(0, 3));
        System.out.println("Path to 3: " + cc.getPathTo(3));
    }
}
