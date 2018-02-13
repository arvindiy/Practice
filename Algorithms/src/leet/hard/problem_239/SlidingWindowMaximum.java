package leet.hard.problem_239;

import java.util.Arrays;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, 3)));
		System.out.println(Arrays.toString(obj.maxSlidingWindow_quick(nums, 3)));

	}

	/**
	 * We can implement this method more eficiently. this is an expensive solution.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return new int[0];
		int n = nums.length - k + 1;
		int[] ret = new int[n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			int max = Integer.MIN_VALUE;
			for (int l = i; l < i + k; l++) {
				if (nums[l] > max) {
					max = nums[l];
				}
			}

			ret[j++] = max;
		}
		return ret;
	}

	/**
	 * This is an O(n) implementation of the same solution
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow_quick(int[] nums, int k) {
		if (nums.length == 0)
			return new int[0];
		int max[] = new int[nums.length - k + 1];
		int[] max_left = new int[nums.length];
		int[] max_right = new int[nums.length];

		max_left[0] = nums[0];
		max_right[nums.length - 1] = nums[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			max_left[i] = (i % k == 0 ? nums[i] : Math.max(max_left[i - 1], nums[i]));
			int j = nums.length - i - 1;
			max_right[j] = (j % k == 0 ? nums[j] : Math.max(nums[j], max_right[j + 1]));
		}

		for (int i = 0, j = 0; i + k <= nums.length; i++) {
			max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
		}

		return max;
	}

}
