import java.util.Scanner;

public class SimpleCalculator {

    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method for division
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation: +, -, *, /");
        String operation = scanner.nextLine();

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        switch (operation) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = subtract(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
                return; // Exit if the operation is invalid
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
