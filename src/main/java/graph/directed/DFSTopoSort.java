package graph.directed;

import java.util.Stack;

/**
 * Created by nbaruah on 11/23/2016.
 */
public class DFSTopoSort {
    private boolean[] visited;
    private boolean[] inRecursionStack;
    private Stack<Integer>postOrder = new Stack<Integer>();
    private boolean hasCycle;

    public DFSTopoSort(DiGraph G){
        visited = new boolean[G.V()];
        inRecursionStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]){
                dfs(G, v);
            }
        }
    }

    private void dfs(DiGraph G, int sv){
        visited[sv] = true;
        inRecursionStack[sv] = true;
        for (int adjVertex : G.getAdjVertices(sv)){
            if (!visited[adjVertex]){
                dfs(G, adjVertex);
            }
            else if (inRecursionStack[adjVertex]){
                hasCycle = true;
            }
        }
        postOrder.push(sv);
        inRecursionStack[sv] = false;
    }

    public Iterable<Integer> getTopologicalSort(){
        return postOrder;
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){
        DiGraph G = new DirectedGraph(4);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        //G.addEdge(2, 0);
        G.addEdge(2, 3);
        //G.addEdge(3, 3);

        DFSTopoSort topoSort = new DFSTopoSort(G);
        System.out.println("Has cycle: " + topoSort.hasCycle());
        //System.out.println(topoSort.getTopologicalSort());
    }
}
