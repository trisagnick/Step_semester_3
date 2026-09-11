class GroupBookingReceipt extends M5BookingReceipt {

    private int groupSize;

    public GroupBookingReceipt(
            String bookingId,
            String[] seatNumbers,
            int groupSize) {

        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

public class M5BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public M5BookingReceipt(
            String bookingId,
            String[] seatNumbers) {

        this.bookingId = bookingId;

        // Defensive copy
        this.seatNumbers =
            seatNumbers.clone();
    }

    public String[] getSeatNumbers() {

        // Defensive copy
        return seatNumbers.clone();
    }

    public M5BookingReceipt withUpdatedSeat(
            int index,
            String newSeat) {

        String[] copy =
            seatNumbers.clone();

        if (index >= 0 &&
            index < copy.length) {

            copy[index] = newSeat;
        }

        return new M5BookingReceipt(
            bookingId,
            copy);
    }

    public static String processNightlySettlement(
            M5BookingReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (M5BookingReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed +
               " processed | " +
               nullSkipped +
               " null skipped | " +
               group +
               " group | " +
               individual +
               " individual";
    }

    public static void main(String[] args) {

        M5BookingReceipt b =
            new M5BookingReceipt(
                "CH-1001",
                new String[]{"A1", "A2"});

        String[] seats =
            b.getSeatNumbers();

        seats[0] = "X";

        System.out.println(
            b.getSeatNumbers()[0]);

        M5BookingReceipt updated =
            b.withUpdatedSeat(1, "A3");

        System.out.println(
            java.util.Arrays.toString(
                b.getSeatNumbers()));

        System.out.println(
            java.util.Arrays.toString(
                updated.getSeatNumbers()));

        M5BookingReceipt[] receipts = {

            new GroupBookingReceipt(
                "CH-2002",
                new String[]{"B1", "B2"},
                2),

            null,

            new M5BookingReceipt(
                "CH-3003",
                new String[]{"C1"})
        };

        System.out.println(
            processNightlySettlement(receipts));
    }
}