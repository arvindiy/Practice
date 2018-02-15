package leet.hard.problem_128;

import java.util.HashMap;

//https://leetcode.com/problems/longest-consecutive-sequence/description/

public class Longest_Consecutive_Sequence {

    public static void main(String[] args) {
        // int[] nums = { 100, 4, 200, 1, 3, 2 };
        // int[] nums = {0,0,0,0};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        // int[] nums = {100, 4, 200, 1, 3, 3, 2};

        System.out.println(new Longest_Consecutive_Sequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftElement = map.get(num - 1) == null ? 0 : map.get(num - 1);
                int rightElement = map.get(num + 1) == null ? 0 : map.get(num + 1);
                int tmpMaxSum = leftElement + rightElement + 1;
                length = Math.max(length, tmpMaxSum);
                map.put(num, length);
                map.put(num - leftElement, length);
                map.put(num + rightElement, length);
            }
        }
        return length;
    }
}
