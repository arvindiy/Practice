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
public class TwoSum1 {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 5, 7, 9, 20};
        int b[] = new TwoSum1().twoSum(a, 5);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] retVal = new int[2];
        boolean br = false;
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j && t - nums[j] == 0) {
                    retVal[0] = i;
                    retVal[1] = j;
                    br = true;
                    break;
                }
            }
            if (br) {
                break;
            }
        }
        return retVal;
    }
}
