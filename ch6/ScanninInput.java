import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScanninInput {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner inputfile = new Scanner(new File("input.txt"));
		while(inputfile.hasNextLine()) {
			String line = inputfile.nextLine();
			System.out.println(line);
		}
		inputfile.close();
	}
}
