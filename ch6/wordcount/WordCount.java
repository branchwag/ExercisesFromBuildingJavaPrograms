import java.io.*;
import java.util.*;

public class WordCount {

	private static final String INPUT_PROMPT = "Input file: ";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner input = getInput(console);
		int count = 0;
		while (input.hasNext()) {
			String word = input.next();
			count++;
		}
		System.out.println("total words = " + count);
	}


	public static Scanner getInput(Scanner console) throws FileNotFoundException {
		File f;
		do {
			System.out.print(INPUT_PROMPT);
			f = new File(console.nextLine());
			
			if (!f.canRead()) {
				System.out.println("File not found. Try again.");
			}
		} while (!f.canRead());
		//good at this point
		return new Scanner(f);
	}
}
