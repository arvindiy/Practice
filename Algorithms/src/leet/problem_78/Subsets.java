package leet.problem_78;
//https://leetcode.com/submissions/detail/126225935/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	/**
	 * 1. Iterate over the input array
	 * 2. Instantiate a result arraylist, and add an empty list
	 * 3. Iterate over the size of the result array list.
	 * 4. For every iteration, keep adding elements to the list
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		for (int i : nums) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				List<Integer> a = new ArrayList<>(res.get(j));
				a.add(i);
				res.add(a);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = new Subsets().subsets(nums);
		System.out.println(result);
	}

}
