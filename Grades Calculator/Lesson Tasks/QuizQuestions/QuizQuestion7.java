import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter pressure: ");
        int pressure = scanner.nextInt();
        
        System.out.print("Enter temperature: ");
        int temperature = scanner.nextInt();
        
        if (pressure >= 150 && temperature >= 700) {
            System.out.println("High risk");
        } else {
            System.out.println("Normal");
        }
        
        scanner.close();
    }
}