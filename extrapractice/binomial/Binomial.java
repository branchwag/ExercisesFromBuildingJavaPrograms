/*The numbers C(n, k) are defined for all n ≥ 0, k ≥ 0 by the following three
rules:
• C(n, 0) = 1
• C(n, k) = 0, if k > n
• C(n, k) = C (n-1, k) + C(n-1, k-1), for 0 < k ≤ n
Write a recursive method that computes C(n, k).
These numbers are called the binomial coefficients, and appear in a number of
areas. For example, they count the number of arrangements in a row that one
can make from n objects, k of which are red, and n-k of which are green.
They also are the coefficients of xnyn-k in the expansion of (x+y)n. For
instance, (x + y)3 may be written x3 + 3x2y + 3xy2 + y3. Note that 1, 3, 3, 1 are
C(3,0), C(3,1), C(3,2), and C(3,3). If we write the binomial coefficients in a
table, with k increasing from left to right, and n increasing as we go down the
table, we produce what is known as Pascal’s Triangle. Below are the first four
rows. Notice that it mirrors the definition, since each term is the sum of the
one above it and the one above and to the left.
1
1 1
1 2 1
1 3 3 1
Write a complete Java program that prints the first n rows of Pascal’s Triangle,
where n is input by the user from the keyboard. Use your recursive method
for computing C(n, k) in writing the program.
*/

import java.util.Scanner;

class Binomial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of rows to print: ");
		int n = scanner.nextInt();

		System.out.println("\n Pascal's Triangle:");

		for (int i = 0; i < n; i++) {
			printRow(i);
		}

		scanner.close();
	}

	public static void printRow(int row) {
		for (int k = 0; k <= row; k++) {
			System.out.print(binomialCoeff(row, k));
			if (k < row) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	public static int binomialCoeff(int n, int k) {
		if (k == 0) {
			return 1;
		}

		if (k > n) {
			return 0;
		}

		return binomialCoeff(n - 1, k) + binomialCoeff(n - 1, k - 1);
	}
}

