/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;
//https://leetcode.com/problems/maximum-product-subarray/description/
/**
 *
 * @author akrishnaniyer
 */
public class MaxProductSubarray {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		 int nums[] = { -2, -1, 3, 4, -1, -2, -1, -5, -4 };
		//int nums[] = { 4, 5, 6 };
		int prod = maxProdSubarray(nums);
		System.out.println(prod);
	}

	private static int maxProdSubarray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int curMax, curMin, returnValue;
		curMax = curMin = returnValue = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int temp = curMax;
			curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
			curMin = Math.min(Math.min(temp * nums[i], curMin * nums[i]), nums[i]);
			returnValue = Math.max(returnValue, curMax);
		}
		return returnValue;
	}

}
