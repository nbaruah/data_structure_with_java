package graph.undirected;

import graph.common.Graph;

/**
 * Created by nbaruah on 11/15/2016.
 */
public class GraphUtility {
    public static int degree(Graph G, int v){
        if (v < 0 || v >= G.V()){
            throw new ArrayIndexOutOfBoundsException("Vertex: " + v + " is not in between 0 and " + (G.V() - 1));
        }
        int degree = 0;
        for (int vertex : G.getAdjVertices(v)) {
            degree ++;
        }
        return degree;
    }

    public static int maxDegree(Graph G){
        return 0;
    }

    public static int avgDegree(Graph G){
        return 0;
    }

    public static int numOfSelfLoops(Graph G){
        return 0;
    }
}
