import java.util.Scanner;

public class HelloWorldWithScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        // User input for the first number
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        // User input for the second number
        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();
        
        scanner.close();
    }
}
