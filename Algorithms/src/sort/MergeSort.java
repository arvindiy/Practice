package sort;

public class MergeSort {
	public static void main(String[] args) {
		int nums[] = { 4, 2, 56, 11, 45645, 0, -2, -23, 42 };
		doMergeSort(nums);
		printArray(nums);
	}

	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static void doMergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}

	private static void mergeSort(int[] nums, int lo, int hi) {

		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(nums, lo, mid);
			mergeSort(nums, mid + 1, hi);
			mergeArrays(nums, lo, mid, hi);
		}
	}

	private static void mergeArrays(int[] nums, int lo, int mid, int hi) {
		int n1 = mid - lo + 1;
		int n2 = hi - mid;
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			arr1[i] = nums[lo + i];
		}
		for (int j = 0; j < n2; j++) {
			arr2[j] = nums[mid + 1 + j];
		}

		int i = 0, j = 0, k = lo;
		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				nums[k] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				nums[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			nums[k] = arr1[i];
			k++;
			i++;
		}
		while (j < n2) {
			nums[k] = arr2[j];
			k++;
			j++;
		}
	}

}
