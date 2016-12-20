package graph.common;

import common.In;
import graph.undirected.AdjacencyList;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a Graph with vertex in any string
 * Created by nbaruah on 11/28/2016.
 */
public class SymbolGraph {
    private Map<String, Integer> symbolTable; // Vertex name -> Index
    private String[] keys; // Index -> Vertex name
    private Graph G; // vertex indexed representation

    public SymbolGraph(String filename, String delimiter){
        symbolTable = new HashMap<String, Integer>();

        //First pass will prepare the index or mapping vertex_name --> index in symbol table
        In in = new In(new File(filename));
        while (!in.isEmpty()){ //Complexity is E (number of edges)
            String[] vNames = in.readLine().split(delimiter);
            for (String vrtxName : vNames){
                if (!symbolTable.containsKey(vrtxName)){
                    symbolTable.put(vrtxName, symbolTable.size());
                }
            }
        }

        // inverted index to get string keys in an aray
        keys = new String[symbolTable.size()];
        for (Map.Entry<String, Integer> entry : symbolTable.entrySet()){
            keys[entry.getValue()] = entry.getKey();
        }

        // second pass builds the graph by connecting first vertex on each line to all others
        G = new AdjacencyList(keys.length);
        in = new In(new File(filename));
        while(in.hasNextLine()){
            String[] a = in.readLine().split(delimiter);
            int v = symbolTable.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = symbolTable.get(a[i]);
                G.addEdge(v, w);
            }

        }
    }

    /**
     * Does the graph contain the vertex named {@code s}?
     * @param name the name of a vertex
     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
     */
    public boolean contains(String name){
        return symbolTable.containsKey(name);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     */
    public int indexOf(String s) {
        return symbolTable.get(s);
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @return the name of the vertex associated with the integer {@code v}
     */
    public String nameOf(int v) {
        return keys[v];
    }

    /**
     * Returns the graph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph graph() {
        return G;
    }

    public static void main(String[] args){
        SymbolGraph graph = new SymbolGraph("D:\\personal_workspace\\data_structure_with_java\\src\\main\\java\\graph\\common\\graph.txt", ";");
        System.out.println(graph.graph());
    }
}
