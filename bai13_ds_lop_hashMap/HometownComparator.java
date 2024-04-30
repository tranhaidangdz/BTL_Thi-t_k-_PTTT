package bai13_ds_lop_hashMap;

import java.util.Comparator;

public class HometownComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Sắp xếp theo tên nếu quê giống nhau
        int compareHometown = s1.getHometown().compareTo(s2.getHometown());
        if (compareHometown == 0) {
            return s1.getName().compareTo(s2.getName());
        }
        return compareHometown;
    }
}
