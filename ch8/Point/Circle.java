public class Circle {
	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}
}
