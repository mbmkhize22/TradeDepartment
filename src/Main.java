import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person doctor = new Doctor("Dr. Smith", 45, "Cardiology");
        Person driver = new Driver("John Doe", 30, "Truck");
        Person teacher = new Teacher("Ms. Johnson", 35, "Mathematics");
        Person student = new Student("Alice", 20, "Computer Science");

        ArrayList<Person> people = new ArrayList<>();
        people.add(doctor);
        people.add(driver);
        people.add(teacher);
        people.add(student);

        for (Person person : people) {
            person.introduce();
        }
    }
}