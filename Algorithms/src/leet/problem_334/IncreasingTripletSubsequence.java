package leet.problem_334;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        // int nums[] = {2,1,5,0,4,6};
        // int nums[] = {1,2,3,1,2,1};
        int nums[] = {5, 1, 5, 5, 2, 5, 4};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

    private boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];
            if (x >= z)
                x = z;
            else if (y >= z)
                y = z;
            else
                return true;
        }
        return false;
    }


    /**
     * The following method is INCORRECT!!
     * This method would return true is there is are three "consecutive"
     * elements which are increasing
     * @param nums
     * @return public boolean increasingTriplet(int[] nums) {
    boolean retVal = false;
    int length = 1;
    for (int i = 1; i < nums.length; i++) {
    if (nums[i] > nums[i - 1]) {
    length++;
    retVal = true;
    } else {
    length = 1;
    retVal = false;
    }
    if (length >= 3 && retVal)
    return true;
    }
    return length >= 3 && retVal;
    }*/

}
