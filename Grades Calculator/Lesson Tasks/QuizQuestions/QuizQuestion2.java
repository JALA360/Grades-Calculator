import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Speed of the car: ");
        int speed = scanner.nextInt();
        
        if (speed >= 40 && speed <= 80) {
            System.out.println("safe");
        } else {
            System.out.println("overspeed");
        }
        
        scanner.close();
    }
}