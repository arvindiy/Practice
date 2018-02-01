package leet.easy.problem_1;

//https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4 };
		int b[] = new TwoSum().twoSum(a, 6);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}

	// The following algorithm does not take into account the fact that
	// the array is sorted.
	// There exists another solution to this problem, which splits the
	// array based on the target sum, and finds out the two indices more
	// effeciently.

	public int[] twoSum(int[] nums, int target) {
		int[] retVal = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(target - nums[i])) {
				retVal[1] = i;
				retVal[0] = hm.get(target-nums[i]);
				return retVal;
			}
			hm.put(nums[i], i);
		}
		return retVal;
	}
}
