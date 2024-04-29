package bai5_caidat_bellman_ford_dich;

import java.util.*;

public class Graph {
    private int V;
    private List<Edge> edges;

    public Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
