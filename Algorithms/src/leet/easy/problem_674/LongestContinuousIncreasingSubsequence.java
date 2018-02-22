package leet.easy.problem_674;

//https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };
		// int[] nums = {1,3,2,5,7};
		// int[] nums = {2,2,2,2};
		LongestContinuousIncreasingSubsequence l = new LongestContinuousIncreasingSubsequence();
		System.out.println(l.findLengthOfLCIS(nums));

	}

	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int max_count = 1;
		int max_count_so_far = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				max_count_so_far++;
			} else {
				max_count_so_far = 1;
			}
			if (max_count_so_far > max_count)
				max_count = max_count_so_far;
		}
		return max_count;
	}

}
