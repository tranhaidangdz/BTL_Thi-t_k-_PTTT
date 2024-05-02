package bai13_ds_lop_hashMap;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Đọc sinh viên từ file
        manager.readStudentsFromFile("D://Downloads//BTL_TKPTTT//bai13_ds_lop_hashMap//student.txt");

        // Sắp xếp sinh viên theo tên và ghi vào file "SortedByName.txt"
        List<Student> sortedByName = manager.getSortedByName();
        writeToFile(sortedByName, "SortedByName.txt");

        // Sắp xếp sinh viên theo ngày sinh và ghi vào file "SortedByDob.txt"
        List<Student> sortedByDob = manager.getSortedByDob();
        writeToFile(sortedByDob, "SortedByDob.txt");

        System.out.println("Sorting and writing to files completed.");
    }

    private static void writeToFile(List<Student> students, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Student student : students) {
                writer.println(
                        student.getName() + "," + dateFormat.format(student.getDob()) + "," + student.getHometown());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
