package bai19_closet_pair;

// Main.java
import java.io.IOException;

/*
Thuật toán Closest Pair (cặp điểm gần nhất) được triển khai trong mã nguồn trên là một giải thuật phân chia và trị, nó được sử dụng để tìm cặp điểm có khoảng cách gần nhất trong một tập hợp các điểm trong không gian 2D.

Dưới đây là ý tưởng cơ bản của thuật toán Closest Pair:

Sắp xếp tất cả các điểm theo tọa độ x.
Phân chia tập hợp các điểm thành hai phần bằng cách chia chính giữa.
Đệ quy tìm cặp điểm gần nhất trên hai nửa tập hợp, và tính khoảng cách tối thiểu trong hai nửa này.
Tìm khoảng cách nhỏ nhất trong phạm vi dọc theo đường phân chia.
So sánh khoảng cách nhỏ nhất giữa hai nửa và khoảng cách nhỏ nhất dọc theo đường phân chia, chọn khoảng cách nhỏ nhất giữa hai. */
public class Main {
    public static void main(String[] args) {
        try {
            FarthestPair.findAndWriteFarthestPair("D://Downloads//BTL_TKPTTT//bai19_closet_pair//input.txt",
                    "output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
