public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = {3, 5, 7, 2, 8, 10, 6};
		int target = 8;

		int result = linearSearch(arr, target);

		if (result != -1) {
			System.out.println("Target " + target + " found at index " + result);
		} else {
			System.out.println("Target " + target + " not found.");
		}
	}

	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
