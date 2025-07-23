

public class Doctor extends Person {

    private String specialization;


    public Doctor(String name, int age, String specialization) {
        super(name, age);
        String Specialization=this.specialization;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I am a doctor specializing in " + specialization+ ".");
    }

    @Override
    public String toFileString() {
        return super.toFileString() + ", specialization: " + specialization;
    }
}
