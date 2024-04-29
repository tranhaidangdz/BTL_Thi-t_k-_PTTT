package bai8_giaithich;

/*
 * FileIndex có thể là một chương trình ứng dụng để tạo ra và quản lý một chỉ
 * mục (index) của các tệp trong hệ thống tập tin. Chương trình này có thể giúp
 * tìm kiếm nhanh chóng các tệp trong hệ thống dựa trên các thuộc tính như tên
 * tệp, đường dẫn, kích thước, thời gian tạo và các thuộc tính khác.
 
 * Trong ví dụ trên, chúng ta đã triển khai một lớp FileIndex có các phương thức
  sau:
 * addFile: Thêm một tên tệp và đường dẫn tương ứng vào chỉ mục.
 * findFilePath: Tìm đường dẫn của một tên tệp trong chỉ mục.
 * Trong hàm main, chúng ta tạo một đối tượng FileIndex, thêm một số tên tệp vào
 * chỉ mục và sau đó tìm đường dẫn của một tệp trong chỉ mục.
 */
import java.util.HashMap;
import java.util.Map;

public class FileIndex {
    private Map<String, String> index; // Map lưu trữ tên tệp và đường dẫn

    public FileIndex() {
        index = new HashMap<>();
    }

    // Thêm một tên tệp và đường dẫn tương ứng vào chỉ mục
    public void addFile(String fileName, String filePath) {
        index.put(fileName, filePath);
    }

    // Tìm đường dẫn của một tên tệp trong chỉ mục
    public String findFilePath(String fileName) {
        return index.get(fileName);
    }

    public static void main(String[] args) {
        FileIndex fileIndex = new FileIndex();

        // Thêm các tệp vào chỉ mục
        fileIndex.addFile("document1.txt", "/path/to/document1.txt");
        fileIndex.addFile("document2.txt", "/path/to/document2.txt");
        fileIndex.addFile("image.jpg", "/path/to/image.jpg");

        // Tìm đường dẫn của một tệp trong chỉ mục
        String filePath = fileIndex.findFilePath("document1.txt");
        if (filePath != null) {
            System.out.println("File path for document1.txt: " + filePath);
        } else {
            System.out.println("File not found in index.");
        }
    }
}
