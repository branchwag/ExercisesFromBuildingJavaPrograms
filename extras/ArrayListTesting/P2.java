import java.util.*;

class P2
{
  static void mystery (ArrayList<String> list)
  {
    //gets passed in as:
    //  to be or not to be
    for (int i = 0; i < list.size() - 1; i += 2)
    {
       String first = list.remove(i);
       list.add (i + 1, first);
    }
  }

  public static void main (String [] args)
  {
     ArrayList<String> test = new ArrayList<String>();
     test.add ("to");
     test.add ("be");
     test.add ("or");
     test.add ("not");
     test.add ("to");
     test.add ("be");
     mystery (test);
     for (String s : test) System.out.println (s);
  }
}

//correct output is:
//be to not or be to
