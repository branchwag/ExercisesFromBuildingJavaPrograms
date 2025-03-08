import java.io.*;
import java.util.Scanner;

public class FixSpacingFromFile {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter the path to the input file: ");
			String inputFilePath = scanner.nextLine();

			//String input = "blah   bah g dsd    sd";
			File inputFile = new File(inputFilePath);
			Scanner fileScanner = new Scanner(inputFile);

			PrintStream output = new PrintStream(new File("results.txt"));

			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] words = line.split("\\s+");
				String fixed = String.join(" ", words);
				output.println(fixed);
			}

			fileScanner.close(); //file scanner
			output.close(); //output one
			scanner.close(); // one that asked for input
			
			System.out.println("Results saved");

		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

