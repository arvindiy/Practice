package leet.problem_215;

import java.util.Arrays;

public class KthLargest {

	public static void main(String[] args) {
		int[] nums = {1,1,1,3,5,5,2,2,4,5,63,0};
		System.out.println(new KthLargest().findKthLargest(nums, 2));
	}

	public int findKthLargest(int[] nums, int k) {
		//Do a sort. This keeps the time down to nLogn, and then return the kth from the last element
		Arrays.sort(nums); 
		
		return nums[nums.length - k];
	}

}
