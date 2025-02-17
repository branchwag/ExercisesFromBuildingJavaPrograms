public class ch2e1 {
	public static void main(String[] args) {
		//System.out.println("testin");

		//kinematic equation
		//find position s of a body in linear motion AT at given time t
		//based on:
		//initial postion s0
		//initial velocity v0
		//rate of accerlation a
		// s = s0 + v0t + 1/2at^2
		double initialPosition = 0.0; //s0 in meters
		double initialVelocity = 10.0;; //v0 in meters per second
		double acceleration = 9.81; //a in meters per second squared
		double time = 5.0; //t in seconds
		
		double finalPosition = initialPosition + (initialVelocity * time) + (0.5 * acceleration * time * time);

		System.out.printf("Final position: %.2f meters%n", finalPosition);
	}
}
