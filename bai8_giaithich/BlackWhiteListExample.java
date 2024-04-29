package bai8_giaithich;

import java.util.HashSet;
import java.util.Set;

/*BlackList: BlackList có thể là một chương trình ứng dụng để quản lý danh sách các phần tử bị cấm hoặc bị từ chối. 
Ví dụ, trong hệ thống bảo mật, BlackList có thể được sử dụng để liệt kê các địa chỉ IP hoặc tên người dùng bị cấm truy cập.

WhiteList: Ngược lại với BlackList, WhiteList có thể là một chương trình ứng dụng để quản lý danh sách các phần tử được
 chấp nhận hoặc được phép. Ví dụ, trong cấu hình email, WhiteList có thể được sử dụng để xác định danh sách các địa chỉ
  email được chấp nhận, trong khi tất cả các địa chỉ email khác sẽ bị từ chối. */
public class BlackWhiteListExample {
    public static void main(String[] args) {
        Set<String> blackList = new HashSet<>();
        Set<String> whiteList = new HashSet<>();

        // Thêm phần tử vào danh sách đen và danh sách trắng
        blackList.add("spam@example.com");
        whiteList.add("user@example.com");

        // Kiểm tra phần tử có trong danh sách đen hoặc trắng hay không
        System.out.println("Is 'spam@example.com' blacklisted? " + blackList.contains("spam@example.com"));
        System.out.println("Is 'user@example.com' whitelisted? " + whiteList.contains("user@example.com"));
    }
}
