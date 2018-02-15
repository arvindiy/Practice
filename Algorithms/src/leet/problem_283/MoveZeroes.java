package leet.problem_283;

//https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String a[]) {
        int nums[] = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }

}
