package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int nums[] = { 4, 2, 56, 11, 45645, 0, -2, -23, 42 };
		doSelectionSort(nums);
		printArray(nums);
	}

	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}

	private static void doSelectionSort(int nums[]) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int min = nums[i];
			for (int j = i+1; j < n; j++) {
				if (nums[j] < min) {
					min = nums[j];
				}
			}
			nums[i] = min;
		}
	}

}
