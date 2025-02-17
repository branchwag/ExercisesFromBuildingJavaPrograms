import java.awt.*;

public class PointExample {
	public static void main(String[] args) {
		Point p1 = new Point(3, 8);
		Point p2 = new Point();
		System.out.println("Distance from origin for p1 = " + p1.distanceFromOrigin());
		System.out.println("Distance from origin for p2 = " + p2.distanceFromOrigin());

		System.out.println("p1 is (" + p1.getX() + ", " + p1.getY() + ")");
	}
}
