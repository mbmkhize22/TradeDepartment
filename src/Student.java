public class Student extends Person{

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
            System.out.println("Student's grade : "+grade);
        }
        @Override
        public String toFileString(){return "grade : "+grade;}

        public String getGrade(){return grade;}

}
