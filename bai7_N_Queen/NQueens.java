package bai7_N_Queen;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private int n; // Số lượng quân hậu và kích thước bàn cờ NxN
    private List<int[]> solutions; // Danh sách chứa tất cả các lời giải

    public NQueens(int n) {
        this.n = n;
        solutions = new ArrayList<>();
    }

    // Kiểm tra xem quân hậu có thể đặt ở vị trí (row, col) không
    private boolean isValid(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    // Quay lui để đặt quân hậu vào hàng row
    private void placeQueen(int[] queens, int row) {
        if (row == n) {
            // Nếu đã đặt quân hậu vào hàng cuối cùng thì lưu kết quả
            solutions.add(queens.clone());
        } else {
            // Đặt quân hậu vào mỗi cột trong hàng row và tiếp tục đặt ở hàng tiếp theo
            for (int col = 0; col < n; col++) {
                if (isValid(queens, row, col)) {
                    queens[row] = col;
                    placeQueen(queens, row + 1);
                }
            }
        }
    }

    // Phương thức để giải bài toán
    public void solve() {
        int[] queens = new int[n];
        placeQueen(queens, 0); // Bắt đầu từ hàng 0
    }

    // Trả về danh sách các lời giải
    public List<int[]> getSolutions() {
        return solutions;
    }
}
