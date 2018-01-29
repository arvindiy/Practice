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
		
		//Split the array into two parts
		//Sort those parts
		//Merge those two parts

		if (lo < hi) {
			int mid = (lo + hi) / 2;
			
			//Sort the first half
			mergeSort(nums, lo, mid);
			
			//Sort the second half
			mergeSort(nums, mid + 1, hi);
			
			//Merge the two arrays
			mergeArrays(nums, lo, mid, hi);
		}
	}

	private static void mergeArrays(int[] nums, int lo, int mid, int hi) {

		//Get the number of elements in the first half 
		int n1 = mid - lo + 1;
		//Get the number of elements in the second half
		int n2 = hi - mid;
		
		//Create two more arrays, of half the size
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		
		//Copy the first half of the array into arr1
		for (int i = 0; i < n1; i++) {
			arr1[i] = nums[lo + i];
		}
		//Copy the second half of the array into arr2
		for (int j = 0; j < n2; j++) {
			arr2[j] = nums[mid + 1 + j];
		}
		
		//Iterate over the main array, and copy the elements from arr1 & arr2
		//In increasing order into the main array.

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
		
		//If there are elements in one of the arrays
		//That have not been copied over to the main array, copy those elements

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
