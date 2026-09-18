class GymMember {

    protected int monthlyFee;

    private int[] lateFeeHistory;
    private int feeCount;
    private int totalLateFees;


    public GymMember(
            String memberId,
            int monthlyFee) {

        this.monthlyFee = monthlyFee;

        lateFeeHistory = new int[10];

        feeCount = 0;

        totalLateFees = 0;
    }


    protected void chargeLateFee(int amount) {

        if (feeCount < lateFeeHistory.length) {

            lateFeeHistory[feeCount] = amount;

            feeCount++;
        }

        totalLateFees += amount;
    }


    public int[] getLateFeeHistory() {

        int[] copy =
                new int[feeCount];

        for (int i = 0; i < feeCount; i++) {

            copy[i] = lateFeeHistory[i];
        }

        return copy;
    }


    public int getTotalLateFees() {

        return totalLateFees;
    }
}


class PremiumMember extends GymMember {

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);
    }


    @Override
    protected void chargeLateFee(int amount) {

        super.chargeLateFee(amount / 2);
    }
}


public class A3LateFeeLedger {

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                        "MEM5",
                        2000,
                        "Coach Riya"
                );


        p.chargeLateFee(200);


        System.out.println(
                "Total Late Fee: " +
                p.getTotalLateFees()
        );


        int[] history =
                p.getLateFeeHistory();

        history[0] = 999;


        System.out.println(
                "Actual Fee History: " +
                p.getLateFeeHistory()[0]
        );
    }
}