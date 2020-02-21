import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (operation.equals("sum")) {
            System.out.println("Result: " + (a + b));
        }
        if (operation.equals("mul")) {
            System.out.println("Result: " + (a * b));
        }
    }
}