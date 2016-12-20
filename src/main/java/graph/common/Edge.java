package graph.common;

/**
 * Created by nbaruah on 12/11/2016.
 */
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        return this.v == vertex ? this.w : this.v;
    }

    public double getWeight(){
        return weight;
    }

    public int compareTo(Edge that){
        if (this.weight > that.weight) return 1;
        else if (this.weight < that.weight) return -1;
        else return 0;
    }

    public String toString(){
        return "[v=" + this.v + ", w=" + this.w + ", weight=" + this.weight + "]";
    }
}
