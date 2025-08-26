public class ConstructorOverloading {
    String name;
    int age;

    // Default constructor
    public ConstructorOverloading() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor with name
    public ConstructorOverloading(String name) {
        this.name = name;
        this.age = 0;
    }

    // Constructor with name and age
    public ConstructorOverloading(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Main method for testing
    public static void main(String[] args) {
        ConstructorOverloading s1 = new ConstructorOverloading();
        ConstructorOverloading s2 = new ConstructorOverloading("Alice");
        ConstructorOverloading s3 = new ConstructorOverloading("Bob", 22);

        s1.display();
        s2.display();
        s3.display();
    }
}
