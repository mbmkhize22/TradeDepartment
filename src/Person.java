public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", and I'm " + age + " years old.");
    }

    public String toFileString() {
        return "Person," + name + "," + age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}