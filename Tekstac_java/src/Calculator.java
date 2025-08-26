public class Calculator {

    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    double add(double a, double b) {
        return a + b;
    }

    // Main method for testing
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Add 2 ints: " + calc.add(5, 10));             // 15
        System.out.println("Add 3 ints: " + calc.add(1, 2, 3));           // 6
        System.out.println("Add 2 doubles: " + calc.add(3.5, 2.5));       // 6.0
    }
}
