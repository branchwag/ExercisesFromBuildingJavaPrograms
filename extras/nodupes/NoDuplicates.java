import java.io.*;
import java.util.*;

public class NoDuplicates {
	public static void main(String[] args) {

		if(args.length != 2) {
			System.out.println("Usage: java NoDuplicates inputFile.txt outputFile.txt");
			return;
		}

		String inputFileName = args[0];
		String outputFileName = args[1];

		try {

		File inputFile = new File(inputFileName);
		Scanner fileReader = new Scanner(inputFile);

		ArrayList<Integer> uniqueNumbers = new ArrayList<>();

		int previousNumber = Integer.MIN_VALUE;

		System.out.println("ORIGINAL FILE: " + inputFileName + " contains the values");
		StringBuilder originalValues = new StringBuilder();

		while (fileReader.hasNextInt()) {
			int currentNumber = fileReader.nextInt();
			originalValues.append(currentNumber).append(" ");

			if (currentNumber != previousNumber) {
				uniqueNumbers.add(currentNumber);
			}

			previousNumber = currentNumber;
		}

		System.out.println(originalValues.toString().trim());

		fileReader.close();

		FileWriter fileWriter = new FileWriter(outputFileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		System.out.println("OUTPUT FILE: " + outputFileName + " contains the values");
		StringBuilder outputValues = new StringBuilder();

		for (int number : uniqueNumbers) {
			printWriter.print(number + " ");
			outputValues.append(number).append(" ");
		}

		System.out.println(outputValues.toString().trim());

		printWriter.close();

		System.out.println("Duplicate removal complete.");

		} catch (FileNotFoundException e) {
			System.out.println("Error: could not find input file " + inputFileName);
		} catch (IOException e) {
			System.out.println("Error: Problem writing to output file " + outputFileName);
		}
	}
}
