package trade_department;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", and I'm " + age + " years old.");
    }

    public String toFileString() {
        return "trade_department.Person," + name + "," + age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age;
    }
}