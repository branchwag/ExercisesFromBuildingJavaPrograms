import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FixSpacing {
	public static void main(String[] args) {
		try {
			String input = "blah   bah g dsd    sd";
			String[] words = input.split("\\s+");
			String fixed = String.join(" ", words);
			PrintStream output = new PrintStream(new File("results.txt"));
			output.println(fixed);
			output.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}
}

