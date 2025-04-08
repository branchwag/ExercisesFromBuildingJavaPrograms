import java.util.Stack;

public class ch14p5 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);

		int poppedValue = stack.pop();

		System.out.println("Popped value: " + poppedValue);

		System.out.println("Remaining stack: " + stack);
	}
}
