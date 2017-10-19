package leet;

import java.util.Arrays;

/**
 *
 * @author akrishnaniyer
 */
public class MinimumMovesToEqualArrayElements453 {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(minMoves(nums));
	}

	public static int minMoves(int[] nums) {
		int sum = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			sum += num;
			if (num < min)
				min = num;
		}
		return sum - min * nums.length;
	}

}
