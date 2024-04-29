package bai8_giaithich;

import java.util.Arrays;

public class TopM {
    /*
     * TopM: Đây có thể là một chương trình ứng dụng để xác định và hiển thị các
     * phần tử hàng đầu (top M) trong một tập dữ liệu. Ví dụ, nếu bạn có một danh
     * sách điểm số từ các bài kiểm tra, TopM có thể giúp bạn xác định top M học
     * sinh có điểm cao nhất.
     */

    public static void main(String[] args) {
        int[] data = { 10, 5, 8, 3, 9, 12, 6 };
        int m = 3;

        int[] topElements = findTopM(data, m);

        System.out.print("Top " + m + " elements: ");
        for (int element : topElements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static int[] findTopM(int[] data, int m) {
        Arrays.sort(data); // Sắp xếp mảng
        int n = data.length;

        int[] topM = new int[m];
        for (int i = 0; i < m; i++) {
            topM[i] = data[n - i - 1]; // Lấy top M phần tử từ cuối mảng
        }
        return topM;
    }
}
