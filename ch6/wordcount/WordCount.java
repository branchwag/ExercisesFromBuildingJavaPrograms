import java.io.*;
import java.util.*;

public class WordCount {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("hamlet.txt"));
		int count = 0;
		while (input.hasNext()) {
			String word = input.next();
			count++;
		}
		System.out.println("total words = " + count);
	}
}
