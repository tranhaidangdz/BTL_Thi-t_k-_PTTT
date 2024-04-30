package bai12_top_m_student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopStudents {
    public static List<Student> getTopMByCriteria(List<Student> students, int m, String criteria) {
        List<Student> topM = new ArrayList<>(students);

        switch (criteria) {
            case "Age":
                topM.sort(Comparator.comparingInt(Student::getAge).reversed());
                break;
            case "GPA":
                topM.sort(Comparator.comparingDouble(Student::getGpa).reversed());
                break;
            case "FirstName":
                topM.sort(Comparator.comparing(Student::getFirstName));
                break;
            case "LastName":
                topM.sort(Comparator.comparing(Student::getLastName));
                break;
            default:
                throw new IllegalArgumentException("Invalid criteria");
        }

        return topM.subList(0, Math.min(m, topM.size()));
    }
}
