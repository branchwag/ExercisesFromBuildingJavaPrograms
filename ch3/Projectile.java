import java.util.*; //for scanner

public class Projectile { 
	//constant for earth acceleration in meters/second^2 aka gravity
	public static final double ACCELERATION = 9.81;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("This program computes the trajectory of a projectile given its initial velocity and its angle relative to the horizontal.");
		System.out.println();
		System.out.print("velocity (meters/second)? ");
		double velocity = console.nextDouble();
		System.out.print("angle (degrees)? ");
		double angle = Math.toRadians(console.nextDouble());
		System.out.print("number of steps to display? ");
		int steps = console.nextInt();
		System.out.println();
		printTable(velocity, angle, steps);
	}

	//prints table showing trajectory of object given initial velocity and angle along with steps
	public static void printTable(double velocity, double angle, int steps) {
		double xVelocity = velocity * Math.cos(angle);
		double yVelocity = velocity * Math.sin(angle);
		double totalTime = 2.0 * yVelocity / ACCELERATION;
		double timeIncrement = totalTime / steps;
		double xIncrement = xVelocity * timeIncrement;

		double x = 0.0;
		double y = 0.0;
		double t = 0.0;
		System.out.println("step\tx\ty\ttime(sec)");
		System.out.println("0\t0.0\t0.0\t0.0");
		for (int i = 1; i <= steps; i++) {
			t += timeIncrement;
			x += xIncrement;
			y = displacement(yVelocity, t, ACCELERATION);
			System.out.println(i + "\t" + round2(x) + "\t" + round2(y) + "\t" + round2(t));
		}
	}

	//returns vertical displacement for an object given initial velocity, elasped time, and acceleration
	//adjusted to minus to account for direction of gravity
	public static double displacement(double v, double t, double a) {
		return v * t - 0.5 * a * t * t;
	}

	//rounds n to 2 digits after decimal point
	public static double round2(double n) {
		return Math.round(n * 100.0) / 100.0;
	}
}
