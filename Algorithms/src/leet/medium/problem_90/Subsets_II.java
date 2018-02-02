package leet.medium.problem_90;

//https://leetcode.com/problems/subsets-ii/discuss/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 2 };
		System.out.println(new Subsets_II().subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		//Sort the array, so that equal elements are grouped together
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;

		res.add(new ArrayList<Integer>());
		res.add(new ArrayList<Integer>());
		res.get(1).add(nums[0]);

		/*
		 * This is the number of lists the previous element was added to.
		 * If the number is not a duplicate, we add it to all lists.
		 * If the number is a duplicate, we add it to only those lists, that already have the 
		 * duplicate number (not all lists) 
		 */
		int prev = 1;
		for (int i = 1; i < nums.length; ++i) {
			int size = res.size();
			if (nums[i] != nums[i - 1])
				prev = size;
			for (int j = size - prev; j < size; ++j) {
				List<Integer> a = new ArrayList<Integer>(res.get(j));
				a.add(nums[i]);
				res.add(a);
			}
		}
		System.out.println(res.size());
		return res;
	}
}
