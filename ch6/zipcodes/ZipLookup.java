import java.util.*;
import java.io.*;

public class ZipLookup {
	public static final double RADIUS = 3956.6; //in miles
	

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome. Provide a 5-digit zip code and proximity. Output will be where that zip code is located along with a list of other zip codes within the given proximity");

		Scanner console = new Scanner(System.in);
		System.out.print("What zip code are you interested in? ");
		String target = console.next();
		System.out.print("And what proximity (in miles)? ");
		double miles = console.nextDouble();
		System.out.println();

		Scanner input = new Scanner(new File("zipcode.txt"));
		String targetCoordinates = find(target, input);
		input = new Scanner(new File("zipcode.txt"));
		showMatches(targetCoordinates, input, miles);
	}

	//returns coordinates. Otherwise 0, 0
	public static String find(String target, Scanner input) {
		while (input.hasNextLine()) {
			String zip = input.nextLine();
			String city = input.nextLine();
			String coordinates = input.nextLine();
			if (zip.equals(target)) {
				System.out.println(zip + ": " + city);
				return coordinates;
			}
		}
		//zip code not in file 
		return "0 0";
	}

	//shows matches for given coordinates within given miles
	public static void showMatches(String targetCoordinates, Scanner input, double miles) {
		Scanner data = new Scanner(targetCoordinates);
		double lat1 = data.nextDouble();
		double long1 = data.nextDouble();
		System.out.println("zip codes within " + miles + " miles: ");
		while (input.hasNextLine()) {
			String zip = input.nextLine();
			String city = input.nextLine();
			String coordinates = input.nextLine();
			data = new Scanner(coordinates);
			double lat2 = data.nextDouble();
			double long2 = data.nextDouble();
			double distance = distance(lat1, long1, lat2, long2);

			if (distance <= miles) {
				System.out.printf("	%s %s, %3.2f miles\n", zip, city, distance);
			}
		}
	}

	//return spherical distance in miles given lat and long of two points
	public static double distance(double lat1, double long1, double lat2, double long2) {
		lat1 = Math.toRadians(lat1);
		long1 = Math.toRadians(long1);
		lat2 = Math.toRadians(lat2);
		long2 = Math.toRadians(long2);
		double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
		double arcLength = Math.acos(theCos);
		return arcLength * RADIUS;
	}
}

