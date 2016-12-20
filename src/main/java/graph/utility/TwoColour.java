package graph.utility;

import common.Queue;
import graph.common.Graph;
import graph.undirected.AdjacencyMatrix;

/**
 * Created by nbaruah on 11/24/2016.
 */
public class TwoColour {
    private static final short BLACK = 1;
    private static final short WHITE = 2;
    private static final short UNCOLOURED = 0;

    private short[] colour;
    private boolean[] visited;
    private boolean BIPARTITE = true;

    public TwoColour(Graph g){
        colour = new short[g.V()];
        visited = new boolean[g.V()];
        for (int v = 0; v < g.V(); v++) {
            if (!visited[v]){
                colour[v] = BLACK;
                bfs(g, v);
            }
        }
    }

    private void bfs(Graph g, int s){
        Queue<Integer> queue = new Queue<Integer>();
        visited[s] = true; //source visited
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue(); // vertex v is first time visited (Perform some operation if needed)
            for (int w : g.getAdjVertices(v)){
                if (!visited[w]){ //edge v -> w is first time visited (Perform some operation if needed)
                    queue.enqueue(w);
                    visited[w] = true;
                }
                processEdge(v, w); //check the colour of adjacent vertex
            }
        }
    }

    private void processEdge(int v, int w){
        if (colour[v] == colour[w]){
            BIPARTITE = false;
            System.out.println("Graph is not bipartite due to " + v + " --> " + w);
            return;
        }
        colour[w] = complementColour(colour[v]);
    }

    private short complementColour(short colour){
        if (colour == BLACK) return WHITE;
        if (colour == WHITE) return BLACK;
        return UNCOLOURED;
    }

    public static void main(String[] args){
        Graph g = new AdjacencyMatrix(6);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 5);
        g.addEdge(5, 3);
        g.addEdge(3, 4);

        TwoColour colour = new TwoColour(g);
    }
}
