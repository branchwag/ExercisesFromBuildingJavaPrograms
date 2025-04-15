import java.awt.Color;

public class SeeingRed {
    public static void main (String[] args) {
        int c = Color.PINK.getRGB();
        int red = getTheRed(c);

        System.out.println(red);
    }

    public static int getTheRed (int c) {
        /*
        11111111  11111111  10101111   10101111
        alpha     red       green      blue
        */

        //PLANNING:
        //4 bytes
        //so we have to move the red bit to the right just to get the red - 16 places
        //then discard everything else (mask it off?)
        //return red is now equal to this
        return (c >> 16) & 0b11111111;
    }
}




