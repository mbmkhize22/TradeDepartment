public class Driver extends Person {

    private String licenceType;

    public Driver(String name, int age, String licenceType) {
        super(name, age);
        this.licenceType = licenceType;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("I am a driver with a " + licenceType + " license.");
    }
    @Override
    public String toFileString(){
        return super.toFileString()+ ", License type: "+licenceType;
    }
}

