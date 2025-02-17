public class ch2e2 {
	public static void main(String[] args) {
		int number = 1;
		int diff = 3;
		System.out.print(number + " ");

		for (int i = 2; i <= 10; i++) {
			number += diff;
			diff += 2;
			System.out.print(number + " ");
		}
	}
}
