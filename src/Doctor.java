import trade_department.Person;

public class Doctor extends Person {
    private String doctor;

    public Doctor(){
        super();
        this.doctor=" ";
    }

    public Doctor(String name, int age, String doctor){
        super(name, age);
        this.doctor=doctor;
    }

    public String getDoctor(String doctor){
        return this.doctor;
    }

    public void setDoctor(String doctor){
        this.doctor=doctor;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Hi, I am a doctor specializing in "+ doctor);
    }

    @Override
    public String toFileString(){
        return super.toFileString() + "Doctor: " + doctor;
    }

    @Override
    public String toString(){
        return super.toString() + " Doctor: " + doctor;
    }
}

