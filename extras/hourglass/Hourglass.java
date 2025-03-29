public class Hourglass {
	public static void main(String[] args) {
		drawLine();
		drawTop();
		drawBottom();
		drawLine();
	}

	public static void drawLine() {
		System.out.print("+");
		//changing from 6 to 5 to see if this helps align the lines with the edges of the hourglass
		for (int i = 0; i <= 5; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}

	// | \../ |
	// for the spaces, the number of them we need is line number -1 - this makes more spaces the further down we go
	// number of dots is 6 - 2 * line - less dots further down
	//
	// The output we want to produce is the following:
	/*
	+------+
	|\..../|
	| \../ |
	|  \/  |
	|  /\  |
	| /..\ |
	|/....\|
	+------+
	*/

	public static void drawTop() {
		for (int line = 1; line <= 3; line++) {
			System.out.print("|");
			for (int i = 1; i <= (line - 1); i++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			for (int i = 1; i <= (6 - 2 * line); i++) {
				System.out.print(".");
			}
			System.out.print("/");
			for (int i = 1; i <= (line - 1); i++) {
				System.out.print(" ");
			}
			System.out.println("|");
		}
	}

	public static void drawBottom() {
		for (int line = 1; line <= 3; line++) {
			System.out.print("|");
			for (int i = 1; i <= (3 - line); i++) {
				System.out.print(" ");
			}
			System.out.print("/");
			for (int i = 1; i <= 2 * (line - 1); i++) {
				System.out.print(".");
			}
			System.out.print("\\");
			for (int i = 1; i <= (3 - line); i++) {
				System.out.print(" ");
			}
			System.out.println("|");
		}
	}
}
