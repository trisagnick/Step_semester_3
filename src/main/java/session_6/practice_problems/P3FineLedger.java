class LibraryMember {

    protected double balanceDue;

    private int[] fineHistory;
    private int fineCount;
    private int totalFine;


    public LibraryMember(int borrowLimit) {

        balanceDue = 0;

        fineHistory = new int[10];

        fineCount = 0;

        totalFine = 0;
    }


    protected void chargeFine(int amount) {

        balanceDue += amount;

        if (fineCount < fineHistory.length) {

            fineHistory[fineCount] = amount;

            fineCount++;
        }

        totalFine += amount;
    }


    public int[] getFineHistory() {

        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {

            copy[i] = fineHistory[i];
        }

        return copy;
    }


    public int getTotalFine() {

        return totalFine;
    }
}


class StudentMember extends LibraryMember {

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(borrowLimit);
    }


    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }
}


public class P3FineLedger {

    public static void main(String[] args) {

        StudentMember student =
                new StudentMember(
                        "STU5",
                        3,
                        "CSE"
                );


        student.chargeFine(100);

        System.out.println(
                "Total Fine: " +
                student.getTotalFine()
        );


        int[] history =
                student.getFineHistory();

        history[0] = 999;


        int[] actualHistory =
                student.getFineHistory();

        System.out.println(
                "Fine History: " +
                actualHistory[0]
        );
    }
}