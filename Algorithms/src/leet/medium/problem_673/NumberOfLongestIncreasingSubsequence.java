package leet.medium.problem_673;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5, 4, 7 };
		// int[] nums = {1,3,2,5,7};
		// int[] nums = {2,2,2,2};
		NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();
		System.out.println(n.findNumberOfLIS(nums));
	}

	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		// Maintain two arrays. Length of the longest increasing subsequence
		int[] len = new int[nums.length];
		// Count of the longest increasing subsequence
		int[] cnt = new int[nums.length];
		int maxLen = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			len[i] = cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] == len[j] + 1)
						cnt[i] += cnt[j];
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];
					}
				}
			}
			if (maxLen == len[i])
				res += cnt[i];
			if (maxLen < len[i]) {
				maxLen = len[i];
				res = cnt[i];
			}
		}
		return res;
	}

}
