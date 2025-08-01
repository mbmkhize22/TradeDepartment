<<<<<<< HEAD
  public class Student extends Person{
=======
import trade_department.Person;

public class Student extends Person {
>>>>>>> 698b1fb1ee76ae968da883c87ea15e540d69e53a

        private String grade;
        public Student(){
            super();
            this.grade="";
        }
        public Student(String name,int age, String subject){
            super(name,age);
            this.grade=grade;
        }
        @Override
        public void introduce(){
            System.out.println("I'm Orton and I scored an  : "+grade+" in Mathematics.");}

        @Override
        public String toFileString(){return "grade : "+grade;}

        public String getGrade(){return grade;}

}
