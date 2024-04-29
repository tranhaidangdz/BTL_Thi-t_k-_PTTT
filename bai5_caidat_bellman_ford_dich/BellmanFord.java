package bai5_caidat_bellman_ford_dich;

import java.util.*;

public class BellmanFord {
    public int[] shortestPaths(Graph graph, int start) {
        int V = graph.getEdges().size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : graph.getEdges()) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : graph.getEdges()) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative cycle");
                return null;
            }
        }

        return dist;
    }
}
