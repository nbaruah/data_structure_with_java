package graph.directed;

import java.util.Stack;

/**
 * Created by nbaruah on 11/23/2016.
 */
public class DFSTopoSort {
    private boolean[] visited;
    private Stack<Integer>postOrder = new Stack<Integer>();
    private boolean hasCycle;

    public DFSTopoSort(DiGraph G){
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]){
                dfs(G, v);
            }
        }
    }

    private void dfs(DiGraph G, int sv){
        visited[sv] = true;
        for (int adjVertex : G.getAdjVertices(sv)){
            if (!visited[adjVertex]){
                dfs(G, adjVertex);
            } else {
                hasCycle = true;
            }
        }
        postOrder.push(sv);
    }

    public Iterable<Integer> getTopologicalSort(){
        return postOrder;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){
        DiGraph G = new DirectedGraph(7);
        G.addEdge(0, 5);
        G.addEdge(0, 2);
        G.addEdge(0, 1);
        G.addEdge(3, 6);
        G.addEdge(3, 5);
        G.addEdge(3, 4);
        G.addEdge(5, 4);
        G.addEdge(6, 4);
        G.addEdge(6, 0);
        G.addEdge(3, 2);
        G.addEdge(1, 4);
        //G.addEdge(4, 0);

        DFSTopoSort topoSort = new DFSTopoSort(G);
        System.out.println("Has cycle: " + topoSort.hasCycle());
        System.out.println(topoSort.getTopologicalSort());
    }
}
