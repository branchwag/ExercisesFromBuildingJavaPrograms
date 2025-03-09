import java.util.Scanner;

public class TokenCounter {
	public static void main(String[] args) {
		String input = "Hello there,how are you? I am \"very well\", thank you. 12 34 5.67 (8 + 9) \"10\"";

		Scanner scanner = new Scanner(input);

		int tokenCount = 0;
		System.out.println("Tokens found:");

		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				int intValue = scanner.nextInt();
				System.out.println((tokenCount + 1) + ". Integer: " + intValue + " (use scanner.nextInt())");
			} else if (scanner.hasNextDouble()) {
				double doubleValue = scanner.nextDouble();
				System.out.println((tokenCount + 1) + ". Double: " + doubleValue + " (use scanner.nextDouble())");
			} else {
				String token = scanner.next();
				System.out.println((tokenCount + 1) + ". String: \"" + token + "\" (use scanner.next())");
			}
			tokenCount++;
		}

		System.out.println("\nTotal number of tokens:" + tokenCount);

		scanner.close();

    }
}

