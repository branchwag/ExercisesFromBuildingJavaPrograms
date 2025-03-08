import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmpHoursCalcConsole {
	public static void main(String[] args) {
		//String filePath = "employee_hours.txt";
		Scanner consoleScanner = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String filePath = consoleScanner.nextLine();

		try {
			Scanner fileScanner = new Scanner(new File(filePath));
			
			while (fileScanner.hasNext()) {
				String name = fileScanner.next();

				double totalHours = 0.0;
				while (fileScanner.hasNextDouble()) {
					double hours = fileScanner.nextDouble();
					totalHours += hours;
				}

				System.out.printf("%s worked a total fo %.2f hours%n", name, totalHours);
			}
		fileScanner.close();
		consoleScanner.close();
	
		} catch(FileNotFoundException e) {
			System.err.println("Error: File not found - " + filePath);
			e.printStackTrace();
		}
	}
}
