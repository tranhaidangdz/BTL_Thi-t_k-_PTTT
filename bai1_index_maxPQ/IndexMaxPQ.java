package bai1_index_maxPQ;

import java.lang.Comparable;
import java.util.NoSuchElementException;//Comparable để so sánh các đối tượng và NoSuchElementException cho việc xử lý nếu hàng đợi trống.

public class IndexMaxPQ<Key extends Comparable<Key>> {
    private int maxN; // số lượng phần tử tối đa trong hàng đợi
    private int n; // số lượng phần tử hiện tại trong hàng đợi
    private int[] pq; // heap-indexing
    private int[] qp; // inverse của pq: qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys; // keys[i] = ưu tiên của key[i]

    // Khởi tạo hàng đợi với kích thước maxN
    @SuppressWarnings("unchecked") // @SuppressWarnings("unchecked") được sử dụng để loại bỏ cảnh báo kiểu không
                                   // kiểm tra vì việc tạo ra một mảng kiểu Key từ một mảng kiểu Comparable là
                                   // không an toàn.
    public IndexMaxPQ(int maxN) { // constructor của lớp IndexMaxPQ, nhận đối số maxN là số lượng phần tử tối đa
                                  // mà hàng đợi có thể chứa.
        this.maxN = maxN;// Gán giá trị maxN của đối tượng bằng giá trị được truyền vào.

        n = 0;// Khởi tạo số lượng phần tử hiện tại trong hàng đợi là 0.

        keys = (Key[]) new Comparable[maxN + 1]; // Khởi tạo mảng keys để lưu trữ các phần tử trong hàng đợi. Mảng này
                                                 // có kích thước là maxN + 1 với chỉ số bắt đầu từ 1.
        pq = new int[maxN + 1];// Khởi tạo mảng pq để lưu trữ chỉ số các phần tử trong hàng đợi.
        qp = new int[maxN + 1];// Khởi tạo mảng qp để thực hiện tìm kiếm ngược, nơi lưu trữ vị trí của các phần
                               // tử trong hàng đợi.

        for (int i = 0; i <= maxN; i++)// Vòng lặp này gán giá trị -1 cho mỗi phần tử trong mảng qp. Điều này đảm bảo
                                       // rằng khi một phần tử không còn tồn tại trong hàng đợi, vị trí của nó trong qp
                                       // sẽ được đánh dấu là -1.
            qp[i] = -1;
    }

    // Kiểm tra hàng đợi có trống không
    public boolean isEmpty() {
        return n == 0;
    }

    // Kiểm tra xem i có nằm trong hàng đợi không
    public boolean contains(int i) {
        return qp[i] != -1; // trả về true nếu qp[i] có trong hàng đợi (gtri sẽ khác -11)
    }

    // Thêm một key với ưu tiên mới vào hàng đợi ưu tiên dựa trên chỉ số
    public void insert(int i, Key key) {
        n++; // Tăng số lượng phần tử trong hàng đợi:Khi một phần tử được thêm vào hàng đợi,
             // số lượng phần tử hiện tại trong hàng đợi (n) được tăng lên.
        qp[i] = n;// Gán vị trí của phần tử có chỉ số i trong mảng qp bằng với số lượng phần tử
                  // hiện tại trong hàng đợi (n).
                  // Điều này cho phép dễ dàng tìm kiếm phần tử trong qp bằng cách sử dụng chỉ số
                  // của phần tử.

        pq[n] = i; // Gán chỉ số của phần tử trong mảng pq bằng chỉ số i của phần tử được thêm vào.
                   // pq được sử dụng để lưu trữ các phần tử trong hàng đợi theo thứ tự ưu tiên.
        keys[i] = key;// Sau khi phần tử mới được thêm vào hàng đợi, phương thức swim được gọi để đảm
                      // bảo rằng tính chất của heap được duy trì.
                      // Phương thức swim sẽ di chuyển phần tử mới thêm lên trên trong hàng đợi nếu
                      // cần thiết để đảm bảo tính chất của heap.
        swim(n);// Sau khi phần tử mới được thêm vào hàng đợi, phương thức swim được gọi để đảm
                // bảo rằng tính chất của heap được duy trì.
                // Phương thức swim sẽ di chuyển phần tử mới thêm lên trên trong hàng đợi nếu
                // cần thiết để đảm bảo tính chất của heap.
    }

    // Lấy và loại bỏ phần tử có ưu tiên cao nhất dựa trên chỉ số
    public Key delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
            // trước khi loại bỏ phần tử có ưu tiên cao nhất, chúng ta kiểm tra xem hàng đợi
            // có trống không hay không bằng cách sử dụng phương thức isEmpty().
            // Nếu hàng đợi trống, một NoSuchElementException sẽ được ném ra để báo lỗi.
        }
        int max = pq[1]; // Chỉ số 1 trong mảng pq là phần tử có ưu tiên cao nhất.
                         // max lưu trữ chỉ số của phần tử có ưu tiên cao nhất.
        exchange(1, n--); // Ta hoán đổi phần tử có ưu tiên cao nhất (tại vị trí 1 trong pq) với phần tử
                          // cuối cùng của hàng đợi và giảm kích thước của hàng đợi (n) đi một đơn vị.
                          // Điều này đảm bảo phần tử có ưu tiên cao nhất được chuyển đến cuối hàng đợi để
                          // loại bỏ dễ dàng hơn.
        sink(1); // Sau khi hoán đổi, phần tử mới ở vị trí 1 có thể không tuân thủ tính chất của
                 // heap, vì vậy ta gọi phương thức sink(1) để tái thiết heap từ vị trí 1 đó.
        qp[max] = -1;// Sau khi loại bỏ phần tử có ưu tiên cao nhất, cập nhật vị trí của nó trong
                     // mảng qp thành -1 để chỉ ra rằng phần tử không còn tồn tại trong hàng đợi.

        Key maxKey = keys[max]; // Lưu trữ giá trị của phần tử có ưu tiên cao nhất trong biến maxKey.
        keys[max] = null; // Loại bỏ giá trị của phần tử này trong mảng keys bằng cách gán null cho phần
                          // tử tại chỉ số max.

        pq[n + 1] = -1;// Gán -1 cho phần tử cuối cùng trong pq, chỉ ra rằng phần tử này không còn tồn
                       // tại trong hàng đợi.

        return maxKey; // Trả về giá trị của phần tử có ưu tiên cao nhất thông qua biến maxKey.
    }

    // Tăng ưu tiên của phần tử i
    public void increaseKey(int i, Key key) {
        keys[i] = key; // Cập nhật giá trị ưu tiên của phần tử:Gán giá trị ưu tiên mới (key) cho phần
                       // tử có chỉ số i.
                       // Điều này cho phép thay đổi ưu tiên của phần tử mà không cần loại bỏ và thêm
                       // lại phần tử vào hàng đợi.
        swim(qp[i]); // Duy trì tính chất của heap bằng cách thực hiện swim:Gọi phương thức swim với
                     // chỉ số của phần tử trong mảng qp tương ứng với chỉ số i.
                     // Phương thức swim sẽ di chuyển phần tử lên trên trong hàng đợi nếu cần thiết
                     // để duy trì tính chất của heap sau khi thay đổi ưu tiên của phần tử.
    }

    // Giảm ưu tiên của phần tử i
    public void decreaseKey(int i, Key key) {
        keys[i] = key; // Cập nhật giá trị ưu tiên của phần tử:Gán giá trị ưu tiên mới (key) cho phần
                       // tử có chỉ số i.
                       // Điều này cho phép thay đổi ưu tiên của phần tử mà không cần loại bỏ và thêm
                       // lại phần tử vào hàng đợi.
        sink(qp[i]);// Duy trì tính chất của heap bằng cách thực hiện sink:Gọi phương thức sink với
                    // chỉ số của phần tử trong mảng qp tương ứng với chỉ số i.
                    // Phương thức sink sẽ đảm bảo rằng phần tử được đưa xuống dưới trong hàng đợi
                    // nếu cần thiết để duy trì tính chất của heap sau khi thay đổi ưu tiên của phần
                    // tử.
    }

    // Xóa phần tử với index i
    public void delete(int i) {
        int index = qp[i];// Lấy vị trí của phần tử trong mảng qp tương ứng với chỉ số i và lưu vào biến
                          // index.
                          // Biến index lưu trữ chỉ số của phần tử trong mảng pq, nơi lưu trữ các phần tử
                          // theo thứ tự ưu tiên.

        exchange(index, n--); // Hoán đổi phần tử ở vị trí index với phần tử cuối cùng trong hàng đợi.
        // Sau đó, giảm kích thước của hàng đợi đi một đơn vị (n--).
        swim(index);// Gọi phương thức swim và sink với vị trí của phần tử trong mảng pq (chỉ số
                    // index).
        sink(index);// Phương thức swim và sink sẽ điều chỉnh vị trí của phần tử để đảm bảo rằng
                    // tính chất của heap được duy trì sau khi loại bỏ phần tử.

        keys[i] = null; // Gán giá trị null cho phần tử có chỉ số i trong mảng keys, đồng thời gán -1
                        // cho vị trí của phần tử trong mảng qp.
        // Điều này đảm bảo rằng phần tử không còn tồn tại trong hàng đợi và không được
        // sử dụng nữa.
        qp[i] = -1;
    }

    // Lấy ưu tiên của phần tử i
    public Key keyOf(int i) {
        if (i < 1 || i > maxN) // Kiểm tra giới hạn kích thước mảng:Trước khi truy xuất giá trị ưu tiên của
                               // phần tử, phương thức kiểm tra xem chỉ số i có nằm trong khoảng cho phép hay
                               // không.
            // Nếu chỉ số i không nằm trong khoảng từ 1 đến maxN (kích thước tối đa của hàng
            // đợi), nó sẽ ném ra một IllegalArgumentException để báo lỗi.
            throw new IllegalArgumentException("Index is out of bounds");
        return keys[i];// Trả về giá trị ưu tiên của phần tử:Sau khi kiểm tra và xác nhận rằng chỉ số i
                       // hợp lệ, phương thức trả về giá trị ưu tiên của phần tử có chỉ số i trong mảng
                       // keys.
                       // Nếu chỉ số i hợp lệ, phương thức này sẽ trả về giá trị của phần tử có chỉ số
                       // i.
    }

    // Kiểm tra xem hàng đợi có rỗng không
    public boolean isNotEmpty() {
        return n > 0;
    }

    // Sử dụng để đảm bảo thuộc tính của hàng đợi heap
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) { // Vòng lặp kiểm tra và điều chỉnh phần tử:Vòng lặp này sẽ được thực hiện khi
                                          // vị trí của phần tử (k) trong hàng đợi lớn hơn 1 (vị trí của phần tử gốc) và
                                          // phần tử cha của nó có giá trị nhỏ hơn phần tử con (k).
                                          // Điều này đảm bảo rằng phần tử được xem xét (k) đang không nằm ở vị trí đúng
                                          // trong heap.
            exchange(k, k / 2); // Hoán đổi giá trị của phần tử ở vị trí k với giá trị của phần tử cha của nó (ở
                                // vị trí k/2) trong hàng đợi.
                                // Điều này giúp đưa phần tử lên trên đúng vị trí trong heap.
            k = k / 2; // Cập nhật chỉ số của phần tử để tiếp tục kiểm tra:Sau khi hoán đổi, vị trí của
                       // phần tử đã được di chuyển lên trên, nên chúng ta cập nhật lại chỉ số k để
                       // tiếp tục kiểm tra và điều chỉnh nếu cần.
        }
    }

    // Sử dụng để đảm bảo thuộc tính của hàng đợi heap
    private void sink(int k) {
        while (2 * k <= n) { // Vòng lặp kiểm tra và điều chỉnh phần tử:Vòng lặp này sẽ được thực hiện khi
                             // phần tử k có ít nhất một phần tử con trong heap (tại vị trí 2 * k).
                             // Điều này đảm bảo rằng chúng ta chỉ kiểm tra và điều chỉnh các phần tử có phần
                             // tử con.
            // Xác định phần tử con lớn nhất:
            int j = 2 * k; // Chúng ta xác định phần tử con lớn nhất của phần tử k bằng cách so sánh phần
                           // tử con ở vị trí 2 * k và 2 * k + 1 (nếu tồn tại).
            if (j < n && less(j, j + 1))// Nếu phần tử con j có giá trị nhỏ hơn n (điều kiện j < n) và phần tử con tại
                                        // vị trí j lớn hơn phần tử con tại vị trí j + 1 (nếu tồn tại), chúng ta tăng
                                        // chỉ số j lên một đơn vị để xác định phần tử con lớn nhất.
                j++;
            // Kiểm tra và điều chỉnh tính chất của heap:
            if (!less(k, j))// Sau khi xác định được phần tử con lớn nhất j, chúng ta kiểm tra xem phần tử
                            // cha k có nhỏ hơn phần tử con lớn nhất không.
                            // Nếu điều kiện không thỏa mãn (phần tử cha lớn hơn phần tử con), chúng ta dừng
                            // vòng lặp bằng cách sử dụng break.
                break;
            exchange(k, j);// Nếu điều kiện thỏa mãn, chúng ta hoán đổi vị trí giữa phần tử cha k và phần
                           // tử con lớn nhất j, sau đó cập nhật chỉ số k thành j để tiếp tục kiểm tra và
                           // điều chỉnh tính chất của heap tại vị trí mới của phần tử.
            k = j;
        }
    }

    // Kiểm tra xem pq[i] có ít hơn pq[j] không:so sánh giá trị ưu tiên của hai phần
    // tử pq[i] và pq[j] trong hàng đợi ưu tiên dựa trên chỉ số.
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;// Trong hàng đợi ưu tiên, phần tử pq[i] và pq[j] lưu trữ chỉ số
                                                      // của các phần tử trong mảng keys, và chúng ta muốn so sánh giá
                                                      // trị ưu tiên của hai phần tử này.
                                                      // Để thực hiện so sánh, chúng ta truy cập giá trị ưu tiên của hai
                                                      // phần tử này
                                                      // trong mảng keys bằng cách sử dụng chỉ số được lưu trữ trong
                                                      // pq[i] và pq[j]:
                                                      // keys[pq[i]] và keys[pq[j]].
                                                      // Sử dụng phương thức compareTo của đối tượng Key (được giới hạn
                                                      // bởi
                                                      // Comparable) để so sánh hai giá trị ưu tiên này.
                                                      // Nếu giá trị ưu tiên của pq[i] nhỏ hơn giá trị ưu tiên của
                                                      // pq[j], phương thức
                                                      // sẽ trả về true, ngược lại, sẽ trả về false.
    }

    // Trao đổi vị trí của hai phần tử trong heap
    private void exchange(int i, int j) {
        int swap = pq[i];// Trước khi hoán đổi, giá trị của phần tử tại vị trí i trong mảng pq được lưu
                         // trữ vào biến tạm thời swap.

        pq[i] = pq[j];// Giá trị của phần tử tại vị trí i được thay thế bằng giá trị của phần tử tại
                      // vị trí j, và ngược lại.
                      // Sau đó, hai phần tử đã được hoán đổi vị trí.
        pq[j] = swap;

        qp[pq[i]] = i;// Sau khi hoán đổi vị trí của hai phần tử, cần phải cập nhật lại chỉ số của
                      // chúng trong mảng qp.
                      // Với phần tử tại vị trí i, chỉ số của nó trong mảng qp được cập nhật thành i.
                      // Tương tự, với phần tử tại vị trí j, chỉ số của nó trong mảng qp được cập nhật
                      // thành j.
        qp[pq[j]] = j;
    }
}
