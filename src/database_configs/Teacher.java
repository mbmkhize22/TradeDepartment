package database_configs;

public class Teacher {
    private int teacher_id;
    private String name;
    private int age;
    private String subject;

    public Teacher(){
        this.teacher_id=0;
        this.name="";
        this.age=0;
        this.subject="";
    }
    public Teacher(int teacher_id,String name,int age,String subject){
        this.teacher_id=teacher_id;
        this.name=name;
        this.age=age;
        this.subject=subject;
    }

    public int getTeacher_id(){return teacher_id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getSubject(){return  subject;}

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String toString(){
        return "teacher_id "+teacher_id+" name "+name+" age "+age+" subject "+subject;
    }
}
