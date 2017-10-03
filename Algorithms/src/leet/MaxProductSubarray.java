/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;

/**
 *
 * @author akrishnaniyer
 */
public class MaxProductSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nums[] = {-2, -1, 3, 4, -1, -2, -1, -5, -4};
        int prod = maxProdSubarray(nums);
        System.out.println(prod);
    }

    private static int maxProdSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min_prod, max_prod = 0;
        int max_so_far = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
        }
        return max_so_far;
    }

}
