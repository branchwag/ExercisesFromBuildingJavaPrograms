public class BinarySearchRecursive {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int key = 6;
		int result = binary(nums, 0, nums.length - 1, key);
		System.out.println("Index of element: " + result);
	}

	static int binary(int[] a, int fromIndex, int toIndex, int key) {
		if (fromIndex > toIndex) return -1;
		else {
			int middle = (fromIndex + toIndex) / 2;
			if (key == a[middle]) return middle;
			else if (key > a[middle]) {
				return binary(a, middle + 1, toIndex, key);
			}
			else if (key < a[middle]) {
				return binary(a, fromIndex, middle - 1, key);
			}
		}
		return -1;
	}
}
