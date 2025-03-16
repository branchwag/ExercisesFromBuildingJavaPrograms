import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pairs {
	public static void main(String[] args) {
		//read file thousand.wrd
		//print an alphabetical list of all pairs of letters that DO NOT occur together
		//only list once Ex. not both qx and xq
		String filePath = "thousand.wrd";
		boolean[][] pairSeen = new boolean[26][26];

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String word;

			while ((word = reader.readLine()) != null) {
				word = word.toLowerCase();

				for (int i = 0; i < word.length(); i++) {
					char firstChar = word.charAt(i);

					if(!Character.isLetter(firstChar)) {
						continue;
					}

					int firstIndex = firstChar - 'a';

					for (int j=0; j < word.length(); j++) {
						if (i == j) {
							continue;
						}

						char secondChar = word.charAt(j);

						if (!Character.isLetter(secondChar)) {
							continue;
						}

						int secondIndex = secondChar - 'a';

						pairSeen[firstIndex][secondIndex] = true;
					
					}
				}
			}

			reader.close();

			printUnseenPairs(pairSeen);
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	private static void printUnseenPairs(boolean[][] pairSeen) {
		for (char firstChar = 'a'; firstChar <= 'z'; firstChar++) {
			int firstIndex = firstChar - 'a';

			StringBuilder line = new StringBuilder();
			line.append(firstChar).append(": ");

			boolean foundUnseenPair = false;

			for (char secondChar = 'a'; secondChar <= 'z'; secondChar++) {
				if (firstChar >= secondChar) {
					continue;
				}

				int secondIndex = secondChar - 'a';

				if (!pairSeen[firstIndex][secondIndex] && !pairSeen[secondIndex][firstIndex]) {
					line.append(secondChar).append(" ");
					foundUnseenPair = true;
				}
			}

			if (foundUnseenPair) {
				System.out.println(line.toString());
			}
		}
	}

}
