package bai15_ford_fulkerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FordFulkerson {
    private int[][] graph;
    private boolean[] visited;
    private int source, sink;
    private int[] parent;
    private int V;

    public FordFulkerson(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.visited = new boolean[V];
        this.parent = new int[V];
    }

    // Function to perform Ford Fulkerson algorithm
    public int maxFlow(int source, int sink) {
        this.source = source;
        this.sink = sink;
        int maxFlow = 0;

        while (bfs()) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, graph[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                graph[u][v] -= pathFlow;
                graph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    // Function to perform BFS to find augmenting path
    private boolean bfs() {
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    // Function to print the augmenting path
    public void printAugmentingPath() {
        int u = sink;
        List<Integer> path = new ArrayList<>();
        while (u != source) {
            path.add(u);
            u = parent[u];
        }
        path.add(source);
        Collections.reverse(path);

        System.out.println("Augmenting Path: " + path);
    }

    // Function to retrieve the augmenting path
    public List<Integer> getAugmentingPath() {
        List<Integer> path = new ArrayList<>();
        int u = sink;
        while (u != source) {
            path.add(u);
            u = parent[u];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

}
