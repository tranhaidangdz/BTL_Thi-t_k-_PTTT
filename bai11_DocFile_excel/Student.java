package bai11_DocFile_excel;

public class Student {
    private String name;
    private double[] grades; // Mảng điểm các môn học
    private int numCourses; // Số lượng môn học

    public Student(String name, int numCourses) {
        this.name = name;
        this.numCourses = numCourses;
        this.grades = new double[numCourses];
    }

    public void setGrade(int courseIndex, double grade) {
        if (courseIndex >= 0 && courseIndex < numCourses) {
            grades[courseIndex] = grade;
        } else {
            System.out.println("Invalid course index.");
        }
    }

    public double calculateGPA() {
        if (numCourses == 0) {
            return 0.0; // Tránh chia cho 0
        }

        double sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }

        return sum / numCourses;
    }

    public String getName() {
        return name;
    }
}
