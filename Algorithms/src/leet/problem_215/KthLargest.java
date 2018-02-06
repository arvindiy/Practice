package leet.problem_215;

import java.util.Arrays;

public class KthLargest {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 3, 5, 5, 2, 2, 4, 5, 63, 0 };
		System.out.println(new KthLargest().findKthLargest(nums, 2));
	}

	/**
	 * Implement a quick select algorithm for getting the kth element
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}

	/**
	 * After every invocation of this method
	 * the position that this method returns would have all 
	 * elements lesser than that to its left,
	 * and elements larger than that to its right.
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	private int findKthLargest(int[] nums, int start, int end, int k) {
		if (start > end)
			return Integer.MIN_VALUE;

		int pivot = nums[end];
		int left = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= pivot) {
				swap(nums, left++, i);
			}
		}
		swap(nums, left, end);
		if (k == left) {
			return nums[k];
		} else if (left > k) {
			return findKthLargest(nums, start, left - 1, k);
		} else {
			return findKthLargest(nums, left + 1, end, k);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	/*
	 * public int findKthLargest(int[] nums, int k) { //Do a sort. This keeps the
	 * time down to nLogn, and then return the kth from the last element
	 * Arrays.sort(nums);
	 * 
	 * return nums[nums.length - k]; }
	 *
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k];
	}*/

}
