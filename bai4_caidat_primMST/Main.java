package bai4_caidat_primMST;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        PrimMST primMST = new PrimMST();
        List<Edge> mst = primMST.primMST(graph);
        primMST.printMST(mst);
    }
}
