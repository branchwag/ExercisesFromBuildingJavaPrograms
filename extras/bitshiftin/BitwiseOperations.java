class BitwiseOperations {
    public static void main(String[] args) {
        int setA = 0b10100011; //this is decimal 163
        int setB = 0b01000001; //this is decimal 65

/*
        OR - returns 1 for each bit position where at least one of the operands has a 1 
  1 0 1 0 0 0 1 1  (setA = 163)
| 0 1 0 0 0 0 0 1  (setB = 65)
-----------------
  1 1 1 0 0 0 1 1  (result = 227)       
*/
        System.out.printf("OR: %s\n", (setA | setB));
        

/*     AND - returns 1 only for bit positions where both operands have a 1
  1 0 1 0 0 0 1 1  (setA = 163)
& 0 1 0 0 0 0 0 1  (setB = 65)
-----------------
  0 0 0 0 0 0 0 1  (result = 1)
*/
        System.out.printf("AND: %s\n", (setA & setB));
        

/*     XOR - returns 1 only for bit positions where exactly one operand has a 1:
  1 0 1 0 0 0 1 1  (setA = 163)
^ 0 1 0 0 0 0 0 1  (setB = 65)
-----------------
  1 1 1 0 0 0 1 0  (result = 226)
 */
        System.out.printf("XOR: %s\n", (setA ^ setB));
        

/* NOT (bit flippin)
  ~ 1 0 1 0 0 0 1 1  (setA = 163)
  -----------------
    0 1 0 1 1 1 0 0
Java uses two's complement for negative numbers. In a byte, flipping 10100011 gives 01011100, but Java treats this as a signed integer, so we need to consider all 32 bits.
The actual calculation is:

~163 = -(163 + 1) = -164

This is because in two's complement, the bitwise NOT of a number is equivalent to negating the number and then subtracting 1
*/
        System.out.printf("Bit flipping:%s\n", ~setA);
    }
}
