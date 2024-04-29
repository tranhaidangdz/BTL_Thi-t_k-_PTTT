package bai10_student;

public class Student {
    private String name;
    private double[] grades; // Mảng điểm các môn học
    private int numCourses; // Số lượng môn học

    public Student(String name, int numCourses) {
        this.name = name;
        this.numCourses = numCourses;
        this.grades = new double[numCourses];
    }

    // Phương thức để đặt điểm cho một môn học
    public void setGrade(int courseIndex, double grade) {
        if (courseIndex >= 0 && courseIndex < numCourses) {
            grades[courseIndex] = grade;
        } else {
            System.out.println("Invalid course index.");
        }
    }

    // Phương thức tính điểm trung bình cộng (TBC)
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

    // Phương thức tính điểm trung bình cộng của học kỳ
    public double calculateSemesterGPA(double[] semesterGrades) {
        double sum = 0;
        for (double grade : semesterGrades) {
            sum += grade;
        }

        return sum / semesterGrades.length;
    }

    // Getter và setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }
}
