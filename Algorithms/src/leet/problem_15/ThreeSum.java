package leet.problem_15;

//https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String a[]) {
        int[] nums = {0, 0, 1, 2, -1, -2};
        System.out.println(new ThreeSum().threeSum(nums));

    }

    /**
     * 1. Sort the array
     * 2. Pick one element
     * 3. Ignore if the elements are the same, to handle duplicates
     * 4. Loop through the rest of the elements
     * 5. Maintain two pointers (lo and hi), which are starting and ending points of the array, without the element chosen in step 2
     * 6. Check if a[i] + a[lo] + a[hi] == 0. If it is, add the three numbers to an array
     * 7. Handle duplicates
     * 8. If the sum is > 0, move the right pointer one to the left
     * 9. If the sum is < 0, move the left pointer one to the right
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[i] + nums[lo] + nums[hi] == 0) {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[lo]);
                        l.add(nums[hi]);
                        result.add(l);
                        lo++;
                        hi--;
                        // handle duplicate here
                        while (lo < hi && nums[lo] == nums[lo - 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi + 1])
                            hi--;
                    } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}
