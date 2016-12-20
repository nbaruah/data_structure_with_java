package graph.mst;

import graph.common.Edge;

/**
 * Created by nbaruah on 12/13/2016.
 */
public interface Mst {
    /**
     * This method returns the edges of the MST
     * @return Edges in the MST
     */
    public Iterable<Edge> edges();

    /**
     * Returns the total weight of the MST
     * @return total weight
     */
    public double totalWeight();
}
