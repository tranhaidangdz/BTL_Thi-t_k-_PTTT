package bai2_dijkstra_dich;

import java.util.Arrays;

public class DijkstraAllShortestPath {
    private static final int INF = Integer.MAX_VALUE; // Khai báo một hằng số INF để biểu diễn giá trị vô cùng lớn, đại
    // diện cho khoảng cách không xác định.

    public static int[][] dijkstra(int[][] graph, int destination) {// Dòng này định nghĩa phương thức dijkstra nhận vào
                                                                    // một ma trận graph đại diện cho đồ thị và một
                                                                    // destination là đỉnh đích cụ thể mà chúng ta muốn
                                                                    // tìm đường đi ngắn nhất đến nó. Phương thức này
                                                                    // trả về một mảng hai chiều chứa các khoảng cách
                                                                    // tạm thời từ mỗi đỉnh đến đỉnh đích.

        // Khởi tạo một mảng hai chiều shortestPaths để lưu trữ các đường đi ngắn nhất
        // từ mỗi đỉnh đến đỉnh đích.
        int numVertices = graph.length;
        int[][] shortestPaths = new int[numVertices][];

        // Với mỗi đỉnh i trong đồ thị, gọi phương thức dijkstraFromVertex để tính
        // toán
        // đường đi ngắn nhất từ đỉnh i đến đỉnh đích.
        for (int i = 0; i < numVertices; i++) {
            shortestPaths[i] = dijkstraFromVertex(graph, i);
        }
        return shortestPaths; // Dòng này trả về mảng shortestPaths chứa các đường đi ngắn nhất từ mỗi đỉnh
                              // đến đỉnh đích.
    }

    public static int[] dijkstraFromVertex(int[][] graph, int start) {
        // Định nghĩa phương thức dijkstraFromVertex nhận vào hai đối số:
        // graph: mảng hai chiều chứa ma trận trọng số của đồ thị.
        // start: đỉnh bắt đầu từ đó chúng ta muốn tính toán đường đi ngắn nhất.

        int numVertices = graph.length;
        // Khởi tạo mảng dist để lưu trữ khoảng cách tạm thời từ đỉnh bắt đầu đến các
        // đỉnh khác, và mảng visited để theo dõi các đỉnh đã được duyệt.
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        // Khởi tạo tất cả các khoảng cách tạm thời ban đầu bằng giá trị vô cùng lớn
        // (INF), và khoảng cách từ đỉnh bắt đầu đến chính nó bằng 0.
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // Dùng vòng lặp để duyệt qua tất cả các đỉnh trong đồ thị. Với mỗi đỉnh, cập
        // nhật khoảng cách tạm thời nếu tìm thấy một đường đi ngắn hơn.
        for (int count = 0; count < numVertices - 1; count++) {// Bắt đầu một vòng lặp để duyệt qua tất cả các đỉnh
                                                               // trong đồ thị. Vòng lặp này chạy numVertices - 1 lần vì
                                                               // sau lần lặp thứ numVertices - 1, tất cả các đỉnh sẽ
                                                               // được duyệt.

            // Gọi hàm minDistance để tìm đỉnh chưa được duyệt có khoảng cách tạm thời nhỏ
            // nhất từ đỉnh bắt đầu. Biến u sẽ lưu trữ chỉ số của đỉnh đó.
            int u = minDistance(dist, visited);
            visited[u] = true;// Đánh dấu đỉnh u đã được duyệt bằng cách gán true cho phần tử tương ứng trong
                              // mảng visited.

            for (int v = 0; v < numVertices; v++) {// Bắt đầu vòng lặp trong vòng lặp ngoài để duyệt qua tất cả các đỉnh
                                                   // kề với đỉnh u.
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    // Kiểm tra xem đỉnh v có chưa được duyệt (!visited[v]), có kề với đỉnh u
                    // (graph[u][v] != 0), có khoảng cách tạm thời từ đỉnh bắt đầu đến u khác vô
                    // cùng lớn (dist[u] != INF), và có đường đi ngắn hơn từ u đến v qua u (dist[u]
                    // + graph[u][v] < dist[v]).
                    dist[v] = dist[u] + graph[u][v];// Nếu điều kiện trên được thỏa mãn, cập nhật khoảng cách tạm thời
                                                    // từ đỉnh bắt đầu đến đỉnh v bằng cách đi qua đỉnh u.

                }
            }
        }
        return dist;// Trả về mảng dist chứa các khoảng cách tạm thời từ đỉnh bắt đầu đến tất cả các
                    // đỉnh khác.
    }

    public static int minDistance(int[] dist, boolean[] visited) {
        // Định nghĩa phương thức minDistance nhận vào hai đối số:
        // dist: mảng chứa các khoảng cách tạm thời từ đỉnh bắt đầu đến các đỉnh khác.
        // visited: mảng boolean để theo dõi các đỉnh đã được duyệt.

        int min = INF;// Khởi tạo biến min với giá trị lớn nhất (INF) và minIndex với giá trị mặc định
                      // là -1.
        int minIndex = -1;// Biến minIndex sẽ lưu trữ chỉ số của đỉnh chưa được duyệt có khoảng cách tạm
                          // thời nhỏ nhất.

        for (int v = 0; v < dist.length; v++) {// bắt đầu vòng lặp để duyệt qua tất cả các đỉnh trong đồ thị.
            // Kiểm tra xem đỉnh v có chưa được duyệt và có khoảng cách tạm thời nhỏ hơn
            // hoặc bằng min hay không.
            if (!visited[v] && dist[v] <= min) {

                // Nếu điều kiện được thỏa mãn, cập nhật giá trị của min thành khoảng cách tạm
                // thời của đỉnh v và cập nhật minIndex thành chỉ số của đỉnh v.
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;// Trả về chỉ số của đỉnh chưa được duyệt có khoảng cách tạm thời nhỏ nhất từ
                        // đỉnh bắt đầu. Nếu không có đỉnh nào thỏa mãn điều kiện, phương thức sẽ trả về
                        // -1.
    }
}
