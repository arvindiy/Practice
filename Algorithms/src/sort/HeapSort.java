package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int nums[] = { 4, 2, 56, -23, 42 };
		new HeapSort().doHeapSort(nums);
		System.out.println("Sorted Array ... " + Arrays.toString(nums));

	}

	/**
	 * 1. Starting from the parent of the last element, we heapify the tree. 2. For
	 * all the elements, starting from the last but one element, swap the element
	 * with the first one 3. Heapify the tree recursively
	 * 
	 * @param nums
	 * @return
	 */
	public int[] doHeapSort(int[] nums) {
		int n = nums.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(nums, nums.length, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			swap(nums, 0, i);
			heapify(nums, i, 0);
		}
		return nums;
	}

	/**
	 * This method would heapify the tree
	 * @param arr
	 * @param n
	 * @param i
	 */
	private void heapify(int[] arr, int n, int i) {
		int largest = i; // Root Node
		int left = 2 * i + 1; // Left Element
		int right = 2 * i + 2; // Right Element

		// If the left node is larger than the root element,
		// make the left node as the largest
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		// If the right node is larger than the root element,
		// make the left node as the largest
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// If the largest element changed, swap the elements,
		// and heapify the tree again
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

	/**
	 * Swap two elements in an array
	 * 
	 * @param nums
	 * @param firstElement
	 * @param secondElement
	 */
	private void swap(int[] nums, int firstElement, int secondElement) {
		int tmp = nums[firstElement];
		nums[firstElement] = nums[secondElement];
		nums[secondElement] = tmp;
	}

}
