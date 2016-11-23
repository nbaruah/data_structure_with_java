package graph.undirected;

import graph.common.Graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nbaruah on 11/21/2016.
 */
public class AdjacencyMatrix implements Graph {
    private final int V;
    private int E;
    private boolean[][] adjMatrix;

    public AdjacencyMatrix(int V){
        if(V<0){
            throw new IllegalArgumentException("Number of vertices must be non negative");
        }
        this.V = V;
        this.E = 0;
        adjMatrix = new boolean[V][V];
    }
    /**
     * This method returns the number of vertices in the graph
     *
     * @return Number of vertices.
     */
    public int V() {
        return V;
    }

    /**
     * This method returns the number of edges in the graph
     *
     * @return Number of edges in the graph
     */
    public int E() {
        return E;
    }

    /**
     * This method adds an edge with incident vertices v and w
     *
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        if (!adjMatrix[v][w]){
            E++;
        }
        adjMatrix[v][w] = true;
        adjMatrix[w][v] = true;
    }

    /**
     * This method returns a list of adjacent vertices to v
     *
     * @param v@return Iterable
     */
    public Iterable<Integer> getAdjVertices(int v) {
        validateVertex(v);
        return new AdjIterator(v);
    }

    /**
     * Returns the degree of vertex v
     *
     * @param v@return degree of vertex v
     */
    public int getDegree(int v) {
        validateVertex(v);
        int count=0;
        for (int adjVertex : getAdjVertices(v)){
            count++;
        }
        return count;
    }

    /**
     * Check whether the vertex is in the range
     * @param v
     * @throws ArrayIndexOutOfBoundsException
     */
    private void validateVertex(int v){
        if (v < 0 || v >= V){
            throw new ArrayIndexOutOfBoundsException("Vertex: " + v + " is not in between 0 and " + (V-1));
        }
    }

    private class AdjIterator implements Iterable<Integer>, Iterator<Integer>{
        private int v;
        private int w;

        public AdjIterator(int v){
            this.v = v;
            this.w = 0;
        }

        /**
         * Returns an iterator over a set of elements of type T.
         *
         * @return an Iterator.
         */
        public Iterator<Integer> iterator() {
            return this;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        public boolean hasNext() {
            while (this.w < V){
                if (adjMatrix[this.v][this.w]){
                    return true;
                }
                w++;
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public Integer next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return w++;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder("\t");
        for (int i = 0; i < this.V; i++) {
            builder.append(i + "\t\t");
        }
        builder.append("\n---------------------------------------------\n");
        for (int v = 0; v < this.V; v++) {
            builder.append(v + " | ");
            for (int w = 0; w < this.V; w++) {
                builder.append(adjMatrix[v][w] + "\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Graph G = new AdjacencyMatrix(4);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 3);
        G.addEdge(2, 3);

        System.out.println(G);
        System.out.println("|0| = " + G.getDegree(0));

        for (int adjVertex : G.getAdjVertices(0)){
            System.out.print("-> " + adjVertex);
        }
    }
}
