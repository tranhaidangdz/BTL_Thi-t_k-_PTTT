package bai7_N_Queen;

public class SolutionN {
    public static void main(String[] args) {
        int n = 8; // Số lượng quân hậu và kích thước bàn cờ NxN
        NQueens nQueens = new NQueens(n);
        nQueens.solve();
        PrintSolution.printAllSolutions(nQueens);
    }
}
