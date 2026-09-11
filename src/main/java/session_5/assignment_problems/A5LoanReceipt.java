import java.util.Arrays;

class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId,
                       String[] bookIds) {

        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(
            int index, String newId) {

        String[] copy = bookIds.clone();

        if (index >= 0 && index < copy.length) {
            copy[index] = newId;
        }

        return new LoanReceipt(memberId, copy);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

public class A5LoanReceipt {

    static String branchCode;

    static {
        branchCode = "PT-LIB";
    }

    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed
            + " processed | "
            + nullSkipped
            + " null skipped | "
            + referenceOnly
            + " reference-only | "
            + regular
            + " regular";
    }

    public static void main(String[] args) {

        LoanReceipt r =
            new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"});

        String[] ids = r.getBookIds();

        ids[0] = "HACKED";

        System.out.println(
            Arrays.toString(r.getBookIds()));

        LoanReceipt corrected =
            r.withCorrectedBookId(1, "BK-102");

        System.out.println(
            Arrays.toString(r.getBookIds()));

        System.out.println(
            Arrays.toString(
                corrected.getBookIds()));

        LoanReceipt[] receipts = {

            new ReferenceOnlyLoanReceipt(
                "LIB-001",
                new String[]{"BK-200"},
                "Reading Room 3"),

            null,

            new LoanReceipt(
                "LIB-002",
                new String[]{"BK-201"})
        };

        System.out.println(
            processNightlyCirculation(receipts));
    }
}