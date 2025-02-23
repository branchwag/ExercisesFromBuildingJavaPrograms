public class Point {
	private int x;
	private int y;

	public Point() {
		//x = 0;
		//y = 0; 
		this(0 , 0);
	}

	public Point(int x, int y) {
		setLocation(x, y);
	}

	public double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	public void translate(int dx, int dy) {
		//x += dx;
		//y += dy;
		setLocation(x + dx, y + dy);
	}

	public String toString() {
	    return "(" + x + ", " + y + ")";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point other = (Point) o;
			return x == other.x && y == other.y;
		} else {
			return false;
		}
	}
}
