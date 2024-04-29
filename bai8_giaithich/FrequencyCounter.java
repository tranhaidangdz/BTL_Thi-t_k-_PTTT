package bai8_giaithich;

/*
 * FrequencyCounter: Đây có thể là một chương trình ứng dụng để đếm tần suất
 * xuất hiện của các phần tử trong một tập dữ liệu. Ví dụ, nếu bạn có một danh
 * sách từ vựng trong một văn bản, FrequencyCounter có thể giúp bạn xác định tần
 * suất xuất hiện của mỗi từ.
 */
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 1, 2, 3, 1, 2 };

        Map<Integer, Integer> frequencies = countFrequencies(data);

        System.out.println("Frequencies: " + frequencies);
    }

    public static Map<Integer, Integer> countFrequencies(int[] data) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : data) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return freqMap;
    }

}
