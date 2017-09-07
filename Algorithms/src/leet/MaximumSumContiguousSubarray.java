package leet;

/**
 *
 * @author akrishnaniyer
 * Find the contiguous sub-array within an array
 * with the largest sum. 
 * Also, print out the starting and ending index of that sub array.
 */
public class MaximumSumContiguousSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        //int nums[] = {-2, -1, -3, -4, -1};
        int nums[] = {-2, 1, -3, 4, -1, 2, -1, -8, -5, 4};
        int sum = finMaxSumCont(nums);
        System.out.println(sum);
    }

    private static int finMaxSumCont(int[] nums) {
        int max_so_far = Integer.MIN_VALUE, startingIndex = 0, endingIndex = 0;        
        int max_ending_here = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpStartingIndex = Integer.MIN_VALUE, tmpEndingIndex = Integer.MIN_VALUE;
            if(max_ending_here + nums[i] > nums[i] ){
                max_ending_here = max_ending_here + nums[i];
                tmpEndingIndex = i;
            }
            else{
                tmpStartingIndex = tmpEndingIndex = i;                
                max_ending_here = nums[i];
            }
            
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                if(tmpStartingIndex != Integer.MIN_VALUE){
                    startingIndex = tmpStartingIndex;
                }
                endingIndex = tmpEndingIndex;
            }
        }
        System.out.println("Starting at ->" + startingIndex + " Ending at ->" + endingIndex);
        return max_so_far;
    }

}
