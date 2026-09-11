public class M4MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    public M4MovieBookingProfile() {
        name = "";
        confirmed = false;
    }

    public M4MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {

        if (otp != null &&
            otp.matches("\\d{4,6}")) {

            this.otp = otp;
        }
    }

    public static void main(String[] args) {

        M4MovieBookingProfile p =
            new M4MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(
            p.isConfirmed());

        p.setOtp("4471");
    }
}