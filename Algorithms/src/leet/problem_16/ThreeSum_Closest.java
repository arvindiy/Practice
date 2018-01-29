package leet.problem_16;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/description/

public class ThreeSum_Closest {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(new ThreeSum_Closest().threeSumClosest(nums, 1));
	}

	/**
	 * 1. Sort the array
	 * 2. In a loop, pick one element
	 * 3. Iterate over the rest of the elements
	 * 4. Keep two pointers, say left and right. 
	 * 5. left = i + 1, right = length - 1
	 * 6. Iterate over another loop until left < right
	 * 7. Add these three elements, and check if the sum is closest to the target
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] nums, int target) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(sum - target);
				if(diff == 0) return sum;
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= target)
					j++;
				else
					k--;
			}
		}
		return result;
	}

}
