package bai5_caidat_bellman_ford_dich;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 7);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, -3);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 4, 7);

        BellmanFord bellmanFord = new BellmanFord();
        int[] dist = bellmanFord.shortestPaths(graph, 0);

        if (dist != null) {
            System.out.println("Shortest distances from vertex 0:");
            for (int i = 0; i < dist.length; i++) {
                System.out.println("Vertex " + i + ": " + dist[i]);
            }
        }
    }
}
