package bai15_ford_fulkerson;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = null;
        int source = 0;
        int sink = 0;

        try {
            // Đọc dữ liệu từ file input.txt
            /*
             * 5 // Số lượng đỉnh trong đồ thị
             * 0 3 5 0 0 // Ma trận trọng số của các cạnh
             * 0 0 1 2 0
             * 0 0 0 0 4
             * 0 0 0 0 0
             * 0 0 0 0 0
             * 0 // Đỉnh nguồn
             * 4 // Đỉnh đích
             */
            Scanner scanner = new Scanner(new File("D://Downloads//BTL_TKPTTT//bai15_ford_fulkerson//input.txt"));
            int V = scanner.nextInt();
            graph = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }
            source = scanner.nextInt();
            sink = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            return; // Thoát khỏi chương trình nếu không tìm thấy file
        } catch (IOException e) {
            System.err.println("Error reading/writing file!");
            return; // Thoát khỏi chương trình nếu có lỗi khi đọc ghi file
        }

        // Áp dụng thuật toán Ford-Fulkerson
        FordFulkerson ff = new FordFulkerson(graph);
        int maxFlow = ff.maxFlow(source, sink);

        // In ra luồng cực đại
        System.out.println("Max Flow: " + maxFlow);

        // Lấy và in ra đường đi của luồng cực đại
        List<Integer> augmentingPath = ff.getAugmentingPath();
        System.out.println("Augmenting Path: " + augmentingPath);

        try {
            // Ghi kết quả ra file output.txt
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
            writer.println("Max Flow: " + maxFlow);
            writer.println("Augmenting Path: " + augmentingPath);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing file!");
        }
    }
}
