import java.util.LinkedList;
import java.util.Queue;

public class ch14p6 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);
		queue.add(2);
		queue.add(3);

		int removedValue = queue.remove();
		System.out.println("Removed value: " + removedValue);

		System.out.println("Remaining queue: " + queue);
	}
}
