package bai7_N_Queen;

import java.util.List;

public class PrintSolution {
    // In một lời giải
    public static void printSolution(int[] queens) {
        System.out.print("[ ");
        for (int i = 0; i < queens.length; i++) {
            System.out.print(queens[i] + 1 + " ");
        }
        System.out.println("]");
    }

    // In tất cả các lời giải
    public static void printAllSolutions(NQueens nQueens) {
        List<int[]> solutions = nQueens.getSolutions();
        int count = 1;
        for (int[] solution : solutions) {
            System.out.print("Ket qua thu " + count + ": ");
            printSolution(solution);
            count++;
        }
        System.out.println("Tong so luong ket qua: " + solutions.size());
    }
}
