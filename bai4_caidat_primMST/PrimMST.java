package bai4_caidat_primMST;

import java.util.Scanner;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PrimMST {
    public List<Edge> primMST(Graph graph) {
        int V = graph.getAdjList().length;
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mst = new ArrayList<>();

        key[0] = 0;
        minHeap.add(new Edge(-1, 0, 0));

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int u = edge.dest;

            if (visited[u])
                continue;

            visited[u] = true;
            if (edge.src != -1)
                mst.add(edge);

            for (Edge e : graph.getAdjList()[u]) {
                int v = e.dest;
                int weight = e.weight;
                if (!visited[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    minHeap.add(new Edge(u, v, weight));
                }
            }
        }

        return mst;
    }

    public void printMST(List<Edge> mst) {
        int totalWeight = 0;
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight: " + totalWeight);
    }
}
