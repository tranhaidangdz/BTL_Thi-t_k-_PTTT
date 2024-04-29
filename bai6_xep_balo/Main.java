package bai6_xep_balo;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(50);

        // Thêm các món hàng vào ba lô
        knapsack.addItem(new Item(10, 60));
        knapsack.addItem(new Item(20, 100));
        knapsack.addItem(new Item(30, 120));

        // Tính toán giá trị và in tổng giá trị của các món hàng đã chọn
        int totalValue = knapsack.maxValue();
        System.out.println("Tong gia tri cua cac mon hang da chon: " + totalValue);

        // In trọng lượng của balo đã chọn và danh sách các món hàng đã chọn
        System.out.println("Trong luong cua balo da chon: " + knapsack.getSelectedWeight());
        System.out.println("Cac mon hang da chon:");
        for (Item item : knapsack.selectedItems()) {
            System.out.println("Trong luong: " + item.getWeight() + ", Gia tri: " + item.getValue());
        }
    }
}
