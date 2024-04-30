package bai13_ds_lop_hashMap;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Đọc sinh viên từ file
        manager.readStudentsFromFile("student.txt");

        // a. In danh sách lớp sắp xếp theo tên
        System.out.println("Sorted by name:");
        manager.printSortedByName();
        System.out.println();

        // b. In danh sách lớp sắp xếp theo ngày sinh từ già đến trẻ
        System.out.println("Sorted by date of birth (descending):");
        manager.printSortedByDob();
        System.out.println();
    }
}
