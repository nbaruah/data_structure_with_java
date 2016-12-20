package graph.mst;

import common.LinkedQueue;
import common.MinPQ;
import common.UF;
import graph.common.Edge;
import graph.undirected.EdgeWeightedGraph;

/**
 * Created by nbaruah on 12/13/2016.
 */
public class KruskalMst implements Mst{
    private LinkedQueue<Edge> mst = new LinkedQueue<Edge>(); //captures the MST

    public KruskalMst(EdgeWeightedGraph G){
        MinPQ<Edge> pq = new MinPQ<Edge>();
        //build the Priority Q
        for (Edge e : G.edges()){
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)){
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }

    /**
     * This method returns the edges of the MST
     *
     * @return Edges in the MST
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the total weight of the MST
     *
     * @return total weight
     */
    public double totalWeight() {
        double weight = 0;
        for (Edge e : mst){
            weight = weight + e.getWeight();
        }
        return weight;
    }
}
