class RecursivePrint {

	private static final String[] ONES = {
	"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "elven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private static final String[] TENS = {
		"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	public static void main(String[] args) {
		printNumber(143);
		printNumber(-24549);
		printNumber(1000000);
		printNumber(0);
		printNumber(Integer.MAX_VALUE);
	}

	public static void printNumber(int n) {
		//takes in this number and prints out in english
		//negative sign is 'minus'
		if (n == 0) {
			System.out.println("zero");
			return;
		}

		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				System.out.println("minus two billion one hundred forty seven million four hundred eighty three thousand six hundred forty eight");
				return;
			}
			System.out.print("minus ");
			printNumber(-n);
			return;
		}

		switch (String.valueOf(n).length()) {
			case 10:
				printBillions(n);
				break;
			case 9:
			case 8: //hundreds of millions
				printMillions(n);
				break;
			case 7: 
				printMillions(n);
				break;
			case 6:
			case 5:
			case 4:
				printThousands(n);
				break;
			case 3:
				printHundreds(n);
				break;
			case 2:
				printTens(n);
				break;
			case 1:
				System.out.print(ONES[n]);
				break;
		}
	}


	private static void printBillions(int n) {
		    printNumber(n / 1000000000);
		    System.out.print(" billion ");
		    if (n % 1000000000 != 0) {
			printNumber(n % 1000000000);
		    }
		}

	private static void printMillions(int n) {
			printNumber(n / 1000000);
			System.out.print( " million ");
			if (n % 1000000 != 0) {
				printNumber(n % 1000000);
			}
	}

	private static void printThousands(int n) {
		printNumber(n / 1000);
		System.out.print(" thousand ");
		if (n % 1000 != 0) {
			printNumber(n % 1000);
		}
	}

	private static void printHundreds(int n) {
		printNumber(n / 100);
		System.out.print(" hundred ");
		if (n % 100 != 0) {
			printNumber(n % 100);
		}
	}

	private static void printTens(int n) {
		if (n < 20) {
			System.out.print(ONES[n]);
		} else {
			System.out.print(TENS[n / 10]);
			if (n % 10 != 0) {
				System.out.print(" " + ONES[n % 10]);
			}
		}
	}
}
