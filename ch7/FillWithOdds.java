import java.util.Arrays;

public class FillWithOdds {
	public static void main(String[] args) {
		int[] list = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = 2 * i + 1;
		}
		System.out.println(Arrays.toString(list));
	}
}
