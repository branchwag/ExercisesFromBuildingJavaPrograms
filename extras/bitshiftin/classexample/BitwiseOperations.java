class BitwiseOperations
{
   public static void main (String [] args)
   {
       int setA = 0b11010011;
       int setB = 0b01000001;

       System.out.printf ("OR: %x\n" ,  (setA | setB) );
       System.out.printf ("AND: %x\n" ,  (setA & setB) );
       System.out.printf ("XOR: %x\n" ,  (setA ^ setB) );
       System.out.printf ("Bit flipping:%x\n " ,  ~setA );
   }
}
