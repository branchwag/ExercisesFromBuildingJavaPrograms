import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (dividend): ");
        int dividend = scanner.nextInt();

        System.out.print("Enter the second number (divisor): ");
        int divisor = scanner.nextInt();

        System.out.println(dividend + " divided by " + divisor + " is " + (dividend/divisor) + " with a remainder of " + (dividend % divisor));

        scanner.close();
    }
}
