public class setBit {
    // Define the byteArray as a class member
    private static byte[] byteArray = new byte[10]; // Size can be adjusted as needed
    
    public static void main(String[] args) {
        setBit(3);
        // Print the byteArray to see the result
        printByteArray();
    }
   
    //turn on appropriate bit for value n
    static void setBit(int n) {
        int whichByte = n / 8;
        int whichBit = n % 8;
        byteArray[whichByte] |= (1 << whichBit);
    }
    
    // Helper method to print the byteArray contents
    static void printByteArray() {
        for (int i = 0; i < byteArray.length; i++) {
            System.out.println("byteArray[" + i + "] = " + byteArray[i] + 
                               " (binary: " + Integer.toBinaryString(byteArray[i] & 0xFF) + ")");
        }
    }
}
