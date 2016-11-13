package graph.undirected;

/**
 * Created by nbaruah on 11/13/2016.
 */
public class GraphClient {
    public static void main(String[] args){
        Graph g = new AdjacencyList(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 0);

        System.out.println(g);
        System.out.println(g.getAdjVertices(0));
    }
}
