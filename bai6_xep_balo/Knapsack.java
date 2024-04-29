package bai6_xep_balo;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Item> items;
    private int capacity;
    private int[][] dp; // Thêm biến dp
    private int selectedWeight; // Thêm biến lưu trọng lượng balo đã chọn

    public Knapsack(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
        dp = new int[0][0]; // Khởi tạo dp với kích thước mặc định, sẽ được cập nhật sau khi thêm item
        selectedWeight = 0; // Khởi tạo trọng lượng balo đã chọn
    }

    public void addItem(Item item) {
        items.add(item);
        dp = new int[items.size() + 1][capacity + 1]; // Cập nhật kích thước dp khi thêm item mới
    }

    public int maxValue() {
        int n = items.size();

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (items.get(i - 1).getWeight() <= w)
                    dp[i][w] = Math.max(items.get(i - 1).getValue() + dp[i - 1][w - items.get(i - 1).getWeight()],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Cập nhật trọng lượng balo đã chọn
        selectedWeight = 0;
        for (Item item : selectedItems()) {
            selectedWeight += item.getWeight();
        }

        return dp[n][capacity];
    }

    public List<Item> selectedItems() {
        int n = items.size();
        int w = capacity;
        List<Item> selected = new ArrayList<>();

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selected.add(items.get(i - 1));
                w -= items.get(i - 1).getWeight();
            }
        }

        return selected;
    }

    public int getSelectedWeight() {
        return selectedWeight;
    }
}
