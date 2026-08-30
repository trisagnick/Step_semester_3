package session_4.class_problems;

class FeeAccount {

    protected double amountPaid;

    public FeeAccount() {
        this.amountPaid = 0;
    }

    public void processPayment(double amount) {
        this.amountPaid += amount;
    }
}

class HostelFeeAccount extends FeeAccount {

    public void payInTwoInstallments(double amount) {

        this.amountPaid += amount;

        System.out.println(
            "Paid in two installments (hostel account)"
        );
    }
}

public class M5AccountBatchPayments {

    public static void processPayment(
            FeeAccount account,
            double amount) {

        if (account instanceof HostelFeeAccount) {

            HostelFeeAccount hostel =
                (HostelFeeAccount) account;

            hostel.payInTwoInstallments(amount);

        } else {

            account.processPayment(amount);

            System.out.println(
                "Paid in one go (day-scholar account)"
            );
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000;

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount account : accounts) {

            processPayment(account, amount);

            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println(
            "Hostel accounts processed: " +
            hostelCount +
            " | Day-scholar accounts processed: " +
            dayScholarCount
        );
    }
}