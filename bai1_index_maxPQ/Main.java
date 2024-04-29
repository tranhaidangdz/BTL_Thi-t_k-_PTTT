package bai1_index_maxPQ;

public class Main {
    public static void main(String[] args) {
        // Tạo một hàng đợi với kích thước 10
        IndexMaxPQ<Integer> pq = new IndexMaxPQ<>(10);

        // Chèn các giá trị vào hàng đợi
        pq.insert(1, 10);
        pq.insert(2, 20);
        pq.insert(3, 30);

        // In ra giá trị của phần tử có ưu tiên cao nhất và xóa nó khỏi hàng đợi
        System.out.println("Max element: " + pq.delMax());

        // Tăng ưu tiên của phần tử với index 2 lên 25
        pq.increaseKey(2, 25);

        // In ra giá trị của phần tử có ưu tiên cao nhất sau khi tăng ưu tiên và xóa nó
        // khỏi hàng đợi
        System.out.println("Max element after increase: " + pq.delMax());
    }

}
