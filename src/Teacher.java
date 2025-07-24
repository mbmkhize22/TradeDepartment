import trade_department.Person;

public class Teacher extends Person {
    private String subject;
    public Teacher(){
        super();
        this.subject="";
    }
    public Teacher(String name,int age, String subject){
        super(name,age);
        this.subject=subject;
    }
    @Override
    public void introduce(){
        System.out.println("Subject : "+subject);
    }
    @Override
    public String toFileString(){return "Subject : "+subject;}

    public String getSubject(){return subject;}
}
