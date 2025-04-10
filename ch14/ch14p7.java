import java.util.LinkedList;
import java.util.Queue;

public class ch14p7 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		q.add(2);
		q.add(3);

		for (Integer thing : q) {
			System.out.println("It's a " + thing);
		}
	}
}
