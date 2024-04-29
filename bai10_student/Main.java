package bai10_student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập tên và số lượng môn học của sinh viên
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số lượng môn học: ");
        int numCourses = scanner.nextInt();

        // Tạo một sinh viên mới
        Student student = new Student(name, numCourses);

        // Nhập điểm cho từng môn học
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Nhập điểm cho môn học " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            student.setGrade(i, grade);
        }

        // Tính và làm tròn điểm trung bình cộng của sinh viên
        double averageGPA = student.calculateGPA();
        double roundedAverageGPA = roundToTwoDecimalPlaces(averageGPA);

        // In ra điểm trung bình cộng đã làm tròn của sinh viên
        System.out.println("GPA của " + student.getName() + ": " + roundedAverageGPA);

        scanner.close(); // Đóng scanner sau khi sử dụng
    }

    // Phương thức để làm tròn số đến 2 chữ số sau dấu thập phân
    public static double roundToTwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
