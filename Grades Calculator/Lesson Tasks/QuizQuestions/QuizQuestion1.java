import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Integer: ");
        int y = scanner.nextInt();
        
        if (y >= 10 && y <= 30) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
        
        scanner.close();
    }
}