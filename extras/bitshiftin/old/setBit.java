public class setBit {

	private static byte[] byteArray = new byte[10];
	
	public static void main(String[] args) {
		setBit(3);
		printByteArray();
	}


	static void setBit (int n) {
		int whichByte = n / 8;
		int whichBit = n % 8;
		byteArray[whichByte] |= (1 << whichBit);
	}

	static void printByteArray() {
		for (int i = 0; i < byteArray.length; i++) {
			System.out.println("byteArray[" + i + "] = " + byteArray[i] + " (binary: " + Integer.toBinaryString(byteArray[i] & 0xFF) + ")");
		}
	}
}
