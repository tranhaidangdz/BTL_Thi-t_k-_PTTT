package bai2_dijkstra_dich;

import java.util.Arrays;

public class Main {
public static void main (String[] args) {
        // Đây là ma trận trọng số của đồ thị. Mỗi phần tử graph[i][j] đại diện cho
        // trọng số của cạnh từ đỉnh i đến đỉnh j. Giá trị 0 biểu thị không có cạnh nối
        // trực tiếp giữa các đỉnh.
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
        // Định nghĩa đỉnh đích mà chúng ta muốn tìm đường đi ngắn nhất đến nó.
        int destinationVertex = 1;
        // Gọi phương thức dijkstra để tính toán đường đi ngắn nhất từ tất cả các đỉnh
        // đến đỉnh đích được chỉ định:
        int[][] shortestPaths = DijkstraAllShortestPath.dijkstra(graph, destinationVertex);
        printShortestPaths(shortestPaths, destinationVertex);
        }

    public static void printShortestPaths(int[][] shortestPaths, int destination) {
        // Định nghĩa phương thức printShortestPaths nhận vào hai đối số:
        // shortestPaths: mảng hai chiều chứa các khoảng cách tạm thời từ mỗi đỉnh đến
        // đỉnh đích.
        // destination: đỉnh đích cụ thể mà chúng ta đang tìm đường đi ngắn nhất đến nó.

        System.out.println("Shortest Paths to Vertex " + destination + ":");// In tiêu đề thông báo cho kết quả, chỉ ra
                                                                            // rằng chúng ta đang in ra các đường đi
                                                                            // ngắn nhất đến đỉnh destination.

        for (int i = 0; i < shortestPaths.length; i++) {// Bắt đầu vòng lặp để duyệt qua mảng shortestPaths, mỗi phần tử
                                                        // trong mảng này đại diện cho một đỉnh trong đồ thị.

            // In ra thông tin về khoảng cách ngắn nhất từ đỉnh i đến đỉnh destination. Cụ
            // thể, chúng ta in ra "From Vertex " + i + ": " +
            // shortestPaths[i][destination].
            System.out.println("From Vertex " + i + ": " + shortestPaths[i][destination]);
        }
    }

}