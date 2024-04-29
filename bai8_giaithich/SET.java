package bai8_giaithich;

import java.util.HashSet;
import java.util.Set;

public class SET {
    /*
     * SET: SET có thể đề cập đến một chương trình ứng dụng dùng để thực hiện các
     * hoạt động liên quan đến tập hợp (Set) trong lập trình. Các hoạt động này có
     * thể bao gồm thêm phần tử vào tập hợp, loại bỏ phần tử, kiểm tra xem một phần
     * tử có tồn tại trong tập hợp hay không, và các hoạt động tương tự.
     */

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Thêm phần tử vào tập hợp
        set.add("apple");
        set.add("banana");
        set.add("orange");

        // Kiểm tra sự tồn tại của phần tử
        System.out.println("Contains 'banana': " + set.contains("banana"));

        // Loại bỏ phần tử khỏi tập hợp
        set.remove("orange");
    }
}
