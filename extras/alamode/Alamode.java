class Alamode {
	public static void main(String[] args) {
		// Test cases to demonstrate the mode method
		int[] test1 = {1, 2, 3, 2, 4, 2, 5}; // mode is 2
		int[] test2 = {1, 1, 1, 2, 3, 4}; // mode is 1
		int[] test3 = {5, 5, 5, 5, 5}; // mode is 5
		int[] test4 = {1, 2, 3, 4, 4, 4, 3, 3}; // mode is 4
		
		System.out.println("Mode of test1: " + mode(test1)); // Should print 2
		System.out.println("Mode of test2: " + mode(test2)); // Should print 1
		System.out.println("Mode of test3: " + mode(test3)); // Should print 5
		System.out.println("Mode of test4: " + mode(test4)); // Should print 4	
	}

	public static int mode(int[] nums) {

		int modeValue = nums[0];
		int maxCount = 0;

		for (int i = 0; i < nums.length; i++) {
			int occurredCount = 0;

			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == nums[i]) {
					occurredCount++;
				}
			}

			if (occurredCount > maxCount) {
				maxCount = occurredCount;
				modeValue = nums[i];
			}
		}
		
		return modeValue;	

	}
}
