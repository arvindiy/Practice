/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;

/**
 *
 * @author akrishnaniyer
 * Find the contiguous sub-array within an array
 * with the largest sum. 
 * Also, print out the starting and ending index of that sub array.
 */
public class MaximumSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int nums[] = {-2, 1, 3, -4, 1, -2, -1, -5, -4};
        int sum = finMaxSumCont(nums);
        System.out.println(sum);
    }

    private static int finMaxSumCont(int[] nums) {
        int cont_sum = Integer.MIN_VALUE, startingIndex = 0, endingIndex = 0;
        int s = 0, currSum = 0;
        int tmp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //tmp = Math.max(nums[i], tmp + nums[i]);
            currSum = tmp + nums[i];
            
            if(tmp < cont_sum){
                s = i;
            }
            
            if (nums[i] > currSum) {
                tmp = nums[i];
            } else {
                tmp = currSum;
            }

            if (tmp > cont_sum) {
                cont_sum = tmp;
                startingIndex = s;
                endingIndex = i;
            }
            
            
            
            //cont_sum = Math.max(cont_sum, tmp);
        }
        System.out.println("Starting at ->" + startingIndex + " Ending at ->" + endingIndex);
        return cont_sum;
    }

}
