/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;

import java.util.HashMap;

/**
 *
 * @author akrishnaniyer
 */
public class TwoSum1 {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4 };
		int b[] = new TwoSum1().twoSum(a, 6);
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
			int j = nums[i];
			if (hm.get(j) != null) {
				retVal[0] = i + 1;
				retVal[1] = hm.get(j) + 1;
			} else {
				hm.put((target - j), i);
			}
		}
		return retVal;
	}
}
