import java.util.Scanner;

public class ModTest {
	public static void main (String [] args) {
		System.out.println("Enter a positive number: ");
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int result = n % 10;

		System.out.println(n + " % 10 is " + result);
		scanner.close();
	}
}
