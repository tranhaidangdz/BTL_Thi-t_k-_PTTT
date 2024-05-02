package bai13_ds_lop_hashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentManager {
    private HashMap<String, List<Student>> studentMap;

    public StudentManager() {
        studentMap = new HashMap<>();
    }

    public void readStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(parts[1].trim());
                    String hometown = parts[2].trim();
                    addStudent(new Student(name, dob, hometown));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        List<Student> students = studentMap.getOrDefault(student.getHometown(), new ArrayList<>());
        students.add(student);
        studentMap.put(student.getHometown(), students);
    }

    // Các phương thức khác không thay đổi

    public void printSortedByName() {
        List<Student> allStudents = getAllStudents();
        allStudents.sort(Comparator.comparing(Student::getName));
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    public void printSortedByDob() {
        List<Student> allStudents = getAllStudents();
        allStudents.sort(Comparator.comparing(Student::getDob).reversed());
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    private List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (List<Student> students : studentMap.values()) {
            allStudents.addAll(students);
        }
        return allStudents;
    }

    public List<Student> getSortedByName() {
        List<Student> allStudents = getAllStudents();
        allStudents.sort(Comparator.comparing(Student::getName));
        return allStudents;
    }

    public List<Student> getSortedByDob() {
        List<Student> allStudents = getAllStudents();
        allStudents.sort(Comparator.comparing(Student::getDob).reversed());
        return allStudents;
    }
}
