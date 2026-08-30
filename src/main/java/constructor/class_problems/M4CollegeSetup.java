package session_4.class_problems;

class SrmStudent {

    static String collegeName;
    static String academicYear;

    static {

        collegeName =
            "SRM Institute of Science and Technology";

        academicYear = "2026-27";

        System.out.println("College info loaded");
    }

    String name;

    public SrmStudent(String name) {
        this.name = name;

        System.out.println(
            "Student record created: " + this.name
        );
    }
}

public class M4CollegeSetup {

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        for (String name : names) {
            new SrmStudent(name);
        }
    }
}