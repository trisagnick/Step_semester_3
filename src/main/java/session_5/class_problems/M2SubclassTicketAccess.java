class ParentMovieTicket {

    protected double ticketPrice;

    ParentMovieTicket(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

class PremiumMovieTicket extends ParentMovieTicket {

    PremiumMovieTicket(double ticketPrice) {
        super(ticketPrice);
    }

    void showPrice() {
        System.out.println(
            "Price: Rs " + ticketPrice);
    }
}

public class M2SubclassTicketAccess {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";

            return "DENIED";
        }

        if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";

            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE") ||
                accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";

            return "DENIED";
        }

        if (fieldModifier.equals("public"))
            return "ALLOWED";

        return "DENIED";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        PremiumMovieTicket p =
            new PremiumMovieTicket(500);

        p.showPrice();
    }
}