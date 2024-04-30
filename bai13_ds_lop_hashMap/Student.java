package bai13_ds_lop_hashMap;

import java.util.Date;

public class Student {
    private String name;
    private Date dob;
    private String hometown;

    public Student(String name, Date dob, String hometown) {
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", DOB: " + dob + ", Hometown: " + hometown;
    }
}
