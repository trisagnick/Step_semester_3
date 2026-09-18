class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;


    public LibraryMember(
            String memberId,
            int borrowLimit) {

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }


    public void displayInfo(
            StringBuilder sb) {

        sb.append(
                "General | Books: "
        ).append(booksBorrowed);
    }
}


class StudentMember extends LibraryMember {

    private String course;


    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);

        this.course = course;
    }


    @Override
    public void displayInfo(
            StringBuilder sb) {

        sb.append(
                "Student | Course: "
        )
        .append(course)
        .append(
                " | Books: "
        )
        .append(booksBorrowed);
    }


    public String getCourse() {

        return course;
    }
}


public class P4CirculationReport {

    static String batchPrint(
            LibraryMember[] members) {

        StringBuilder sb =
                new StringBuilder();


        for (LibraryMember member : members) {

            member.displayInfo(sb);


            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                sb.append(
                        " [Course via downcast: "
                )
                .append(student.getCourse())
                .append("]");
            }


            sb.append(" | ");
        }


        return sb.toString();
    }


    public static void main(String[] args) {

        LibraryMember[] members = {

                new LibraryMember(
                        "LB5",
                        3
                ),

                new StudentMember(
                        "STU6",
                        3,
                        "ECE"
                )
        };


        System.out.println(
                batchPrint(members)
        );
    }
}