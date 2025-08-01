import trade_department.Person;

public class Doctor extends Person {
    private String specialization;

    public Doctor(){
        super();
        this.specialization=" ";
    }

    public Doctor(String name, int age, String specialization){
        super(name, age);
        this.specialization=specialization;
    }

    public String getSpecialization(String specialization){
        return this.specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Hi, I am a doctor specializing in "+ specialization);
    }

    @Override
    public String toFileString(){
        return super.toFileString() + "Doctor: " + specialization;
    }

    @Override
    public String toString(){
        return super.toString() + " Doctor: " + specialization;
    }
}

