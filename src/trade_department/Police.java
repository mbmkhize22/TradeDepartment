package trade_department;

public class Police extends Person {

    private String badgeNumber;

    public Police() {
        super();
        this.badgeNumber = "";
    }

    public Police(String name, int age, String badgeNumber) {
        super(name, age);
        this.badgeNumber = badgeNumber;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a police officer with badge number " + badgeNumber + ".");
    }

    @Override
    public String toFileString() {
        return super.toFileString() + ", Badge Number: " + badgeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Badge Number: " + badgeNumber;
    }
}
