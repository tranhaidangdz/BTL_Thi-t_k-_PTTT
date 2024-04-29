package bai4_caidat_primMST;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<Edge>[] adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        Edge edge1 = new Edge(src, dest, weight);
        Edge edge2 = new Edge(dest, src, weight);
        adjList[src].add(edge1);
        adjList[dest].add(edge2);
    }

    public List<Edge>[] getAdjList() {
        return adjList;
    }
}
