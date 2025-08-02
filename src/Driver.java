import trade_department.Person;

public class Driver extends Person {
    private String license;

    public Driver(){
        super();
        this.license=" ";
    }

    public Driver(String name, int age, String license){
        super(name, age);
        this.license=license;
    }

    public String getlicense(String license){
        return this.license;
    }

    public void setLicense(String license){
        this.license=license;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Hi, my license is"+ license);
    }

    @Override
    public String toFileString(){
        return super.toFileString() + "License: " + license;
    }

    @Override
    public String toString(){
        return super.toString() + " License: " + license;
    }
}
