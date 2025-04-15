public class XandY {
    public static void main (String[] args) {
      int x = 17;
      int y = -4;

    //XOR - when comparing, it only returns 1 for bit positions where exactly one operand has a 1
    // X = 00010001
    // Y = 11111100
    //--------------
    //     11101101
      x = x ^ y; //11101101
      y = x ^ y; //i think this is the new x xored with y soooo:
        //new x = 11101101
        //y=      11111100
        // ----------------
        //        00010001
      x = x ^ y; //ok so now we have a new x and a new y soooo:
        //new x  = 11101101
        //new y  = 00010001 
        //------------------
        //         11111100
      System.out.println ("x = " + x); //11111100 -> 252 - but wait, this can also be -4
      System.out.println ("y = " + y); //00010001 -> 17
        //i think we just flipped the values of x and y doing this
    }
}
