package bai1_index_maxPQ;

import java.lang.Comparable;
import java.util.NoSuchElementException;

public class IndexMaxPQ<Key extends Comparable<Key>> {
    private int maxN; // số lượng phần tử tối đa trong hàng đợi
    private int n; // số lượng phần tử hiện tại trong hàng đợi
    private int[] pq; // heap-indexing
    private int[] qp; // inverse của pq: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // keys[i] = ưu tiên của key[i]

    // Khởi tạo hàng đợi với kích thước maxN
    @SuppressWarnings("unchecked")
    public IndexMaxPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1]; // index từ 1
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    // Kiểm tra hàng đợi có trống không
    public boolean isEmpty() {
        return n == 0;
    }

    // Kiểm tra xem i có nằm trong hàng đợi không
    public boolean contains(int i) {
        return qp[i] != -1;
    }

    // Thêm một key với ưu tiên mới
    public void insert(int i, Key key) {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    // Lấy và loại bỏ phần tử có ưu tiên cao nhất
    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        int max = pq[1];
        exchange(1, n--);
        sink(1);
        qp[max] = -1;
        Key maxKey = keys[max]; // Lấy giá trị của keys[max] trước khi xoá
        keys[max] = null;
        pq[n + 1] = -1;
        return maxKey; // Trả về giá trị của phần tử có ưu tiên cao nhất
    }

    // Tăng ưu tiên của phần tử i
    public void increaseKey(int i, Key key) {
        keys[i] = key;
        swim(qp[i]);
    }

    // Giảm ưu tiên của phần tử i
    public void decreaseKey(int i, Key key) {
        keys[i] = key;
        sink(qp[i]);
    }

    // Xóa phần tử với index i
    public void delete(int i) {
        int index = qp[i];
        exchange(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }

    // Lấy ưu tiên của phần tử i
    public Key keyOf(int i) {
        if (i < 1 || i > maxN) // Kiểm tra giới hạn kích thước mảng
            throw new IllegalArgumentException("Index is out of bounds");
        return keys[i];
    }

    // Kiểm tra xem hàng đợi có rỗng không
    public boolean isNotEmpty() {
        return n > 0;
    }

    // Sử dụng để đảm bảo thuộc tính của hàng đợi heap
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    // Sử dụng để đảm bảo thuộc tính của hàng đợi heap
    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }

    // Kiểm tra xem pq[i] có ít hơn pq[j] không
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    // Trao đổi vị trí của hai phần tử trong heap
    private void exchange(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
