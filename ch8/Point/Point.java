public class Point {
	int x;
	int y;

	public Point() {
		x = 0;
		y = 0; 
	}

	public Point(int initialX, int initialY) {
		this.x = initialX;
		this.y = initialY;
	}

	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public String toString() {
	    return "(" + x + ", " + y + ")";
	}
}
