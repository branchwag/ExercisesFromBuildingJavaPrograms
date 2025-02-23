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
		//make sure object passed is a point
		if (o instanceof Point) {
			//cast it to Point and store in new var called other
			//After confirming that o is a Point, Java doesn't automatically treat o as a Point. Even though o is known to be an instance of Point, Java still sees o as a general Object type. This is because o is declared as Object o in the method signature. So, in order to access x and y (which are specific to the Point class), we need to cast o to Point.
			Point other = (Point) o;
			//compare
			return x == other.x && y == other.y;
		} else {
			return false;
		}
	}
}
