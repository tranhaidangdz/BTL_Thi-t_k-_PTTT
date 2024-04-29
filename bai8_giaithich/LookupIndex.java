package bai8_giaithich;

/*
 * LookupIndex có thể là một chương trình ứng dụng được thiết kế để tìm kiếm
 * thông tin từ một chỉ mục (index). Điều này có thể liên quan đến việc tìm kiếm
 * thông tin trong một cơ sở dữ liệu hoặc tìm kiếm thông tin từ một tập dữ liệu
 * lớn mà đã được chỉ mục trước đó để tối ưu hóa thời gian tìm kiếm.
 */

/*
  Trong ví dụ trên, chúng ta đã triển khai một lớp LookupIndex có các phương
  thức sau:
  
  addEntry: Thêm một từ khoá và giá trị tương ứng vào chỉ mục.
  findValue: Tìm giá trị của một từ khoá trong chỉ mục.
  Trong hàm main, chúng ta tạo một đối tượng LookupIndex, thêm một số từ khoá
  và giá trị tương ứng vào chỉ mục và sau đó tìm giá trị của một từ khoá trong
  chỉ mục.
 */
import java.util.HashMap;
import java.util.Map;

public class LookupIndex {
    private Map<String, String> index; // Map lưu trữ từ khoá và giá trị tương ứng

    public LookupIndex() {
        index = new HashMap<>();
    }

    // Thêm một từ khoá và giá trị tương ứng vào chỉ mục
    public void addEntry(String keyword, String value) {
        index.put(keyword, value);
    }

    // Tìm giá trị của một từ khoá trong chỉ mục
    public String findValue(String keyword) {
        return index.get(keyword);
    }

    public static void main(String[] args) {
        LookupIndex lookupIndex = new LookupIndex();

        // Thêm các từ khoá và giá trị tương ứng vào chỉ mục
        lookupIndex.addEntry("apple", "A fruit");
        lookupIndex.addEntry("banana", "A fruit");
        lookupIndex.addEntry("carrot", "A vegetable");

        // Tìm giá trị của một từ khoá trong chỉ mục
        String value = lookupIndex.findValue("banana");
        if (value != null) {
            System.out.println("Value for 'banana': " + value);
        } else {
            System.out.println("Keyword not found in index.");
        }
    }
}
