package bai11_DocFile_excel;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng môn học: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        Student student = new Student(name, numCourses);

        // Nhập điểm cho từng môn học
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Nhập điểm cho môn học " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            student.setGrade(i, grade);
        }

        double averageGPA = student.calculateGPA();
        System.out.println("Điểm trung bình của " + student.getName() + " là: " + averageGPA);

        scanner.close();
    }
}
