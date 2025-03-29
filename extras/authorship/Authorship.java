import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authorship {
	public static void main(String [] args) {
		//import file
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Name of input file: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		
		//Plan:
		//As long as file has lines, look at each word
		//make a total word counter
		//count number of chars in each word
		//maybe do key/value pairs to store numofletters and how often say 2-letter words occur? 
	
		int totalWords = 0;
		Map<Integer, Integer> wordLengthCounts = new HashMap<>();

		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
				String[] words = line.split("\\s+");

				for (String word : words) {
					word = word.replaceAll("[^a-zA-Z]", "");

				if (word.isEmpty()) {
					continue; //check on this 
				}

				totalWords++;

				int length = word.length();

				wordLengthCounts.put(length, wordLengthCounts.getOrDefault(length, 0) + 1);
			}
		}

		fileScanner.close();

		int maxLength = 0;
		for (int length : wordLengthCounts.keySet()) {
			if (length > maxLength) {
				maxLength = length;
			}
		}

		for (int length = 1; length <= maxLength; length++) {
			int count = wordLengthCounts.getOrDefault(length, 0);
			double proportion = (totalWords > 0) ? (count * 100.0 / totalWords) : 0;

			if (count > 0) {
				System.out.printf("Proportion of %d-letter words: %.1f%% (%d words)%n", length, proportion, count);
			}
		}

		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found - " + fileName);
		}

	}
}
