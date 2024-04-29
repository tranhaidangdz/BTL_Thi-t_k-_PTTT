package bai3_dijkstra_2dinh;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        int[][][] allShortestPaths = DijkstraAlgorithm.allPairsShortestPaths(graph);

        printAllShortestPaths(allShortestPaths);
    }

    private static void printAllShortestPaths(int[][][] allShortestPaths) {
        for (int i = 0; i < allShortestPaths.length; i++) {
            System.out.println("Shortest Paths from vertex " + i + ":");
            for (int j = 0; j < allShortestPaths[i].length; j++) {
                System.out.print("To vertex " + j + ": ");
                if (allShortestPaths[i][j][j] == Integer.MAX_VALUE) {
                    System.out.println("No path");
                } else {
                    System.out.println(allShortestPaths[i][j][j]);
                }
            }
            System.out.println();
        }
    }
}
