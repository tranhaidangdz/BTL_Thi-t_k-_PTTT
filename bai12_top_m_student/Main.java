package bai12_top_m_student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong sinh vien: ");
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            System.out.print("Ten: ");
            String firstName = scanner.next();
            System.out.print("Ho: ");
            String lastName = scanner.next();
            System.out.print("Tuoi: ");
            int age = scanner.nextInt();
            System.out.print("Diem GPA: ");
            double gpa = scanner.nextDouble();

            students.add(new Student(firstName, lastName, age, gpa));
        }

        // Lấy top M sinh viên theo GPA
        int m = 2; // Số lượng sinh viên top M
        List<Student> topStudents = TopStudents.getTopMByCriteria(students, m, "GPA");

        // Tính điểm trung bình của các sinh viên top
        double totalGPA = 0;
        for (Student student : topStudents) {
            totalGPA += student.getGpa();
        }
        double averageGPA = totalGPA / m;

        System.out.println("Diem trung binh cua " + m + " sinh vien top theo GPA: " + averageGPA);

        scanner.close();
    }
}
