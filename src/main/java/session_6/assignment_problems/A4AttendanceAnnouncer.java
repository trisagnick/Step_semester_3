class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;


    public GymMember(
            String memberId,
            int monthlyFee) {

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }


    public void displayInfo(
            StringBuilder sb) {

        sb.append(
                "Standard | Sessions: "
        )
        .append(sessionsAttended);
    }
}


class PremiumMember extends GymMember {

    private String trainerName;


    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);

        this.trainerName = trainerName;
    }


    @Override
    public void displayInfo(
            StringBuilder sb) {

        sb.append(
                "Premium | Trainer: "
        )
        .append(trainerName)
        .append(
                " | Sessions: "
        )
        .append(sessionsAttended);
    }


    public String getTrainerName() {

        return trainerName;
    }
}


public class A4AttendanceAnnouncer {

    static String batchPrint(
            GymMember[] members) {

        StringBuilder sb =
                new StringBuilder();


        for (GymMember member : members) {

            member.displayInfo(sb);


            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                sb.append(
                        " [Trainer via downcast: "
                )
                .append(
                        premium.getTrainerName()
                )
                .append("]");
            }


            sb.append(" | ");
        }


        return sb.toString();
    }


    public static void main(String[] args) {

        GymMember[] members = {

                new GymMember(
                        "MEM6",
                        1000
                ),

                new PremiumMember(
                        "MEM7",
                        2000,
                        "Coach Riya"
                )
        };


        System.out.println(
                batchPrint(members)
        );
    }
}