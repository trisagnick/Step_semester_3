public class A4LibraryMemberBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public A4LibraryMemberBean() {
        membershipId = null;
        name = "";
        premiumMember = false;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {

        if (answer != null) {
            securityAnswer =
                Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {

        A4LibraryMemberBean m =
            new A4LibraryMemberBean();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(
            m.getMembershipId());

        m.setMembershipId("FAKE-0000");

        System.out.println(
            m.getMembershipId());

        System.out.println(
            m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
    }
}