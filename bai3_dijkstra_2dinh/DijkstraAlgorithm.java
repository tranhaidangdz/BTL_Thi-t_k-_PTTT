package bai3_dijkstra_2dinh;

import java.util.Arrays;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static int[][][] allPairsShortestPaths(int[][] graph) {
        int numVertices = graph.length;
        int[][][] shortestPaths = new int[numVertices][][];

        for (int i = 0; i < numVertices; i++) {
            shortestPaths[i] = dijkstra(graph, i);
        }

        return shortestPaths;
    }

    private static int[][] dijkstra(int[][] graph, int start) {
        int numVertices = graph.length;
        int[][] shortestPaths = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            shortestPaths[i] = dijkstraFromVertex(graph, start, i);
        }

        return shortestPaths;
    }

    private static int[] dijkstraFromVertex(int[][] graph, int start, int destination) {
        int numVertices = graph.length;
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
