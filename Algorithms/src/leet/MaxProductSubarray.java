package leet;

/**
 *
 * @author akrishnaniyer Find the contiguous array with the maximum product
 */
public class MaxProductSubarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int arr[] = {6, -3, -10, 0, 2};
        //int arr[] = {-1, -3, -21, 0, 60};
        //int arr[] = {-2, -3, 0, -2, -40};
        //int arr[] = {-2, -1, 3, 4, -1, -2, -1, -5, -4};        

        int prod = maxProdSubarray(arr);
        System.out.println(prod);
    }

    private static int maxProdSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = nums[0];
        
        for (int i = 1, max_so_far = p, min_so_far = p; i < nums.length; i++) {
            
            //x = x ^ y ^ (y = x); Integers
            //a += (b - (b = a)); Doubles and Floats

            if (nums[i] < 0) {
                int tmp = max_so_far;
                max_so_far = min_so_far;
                min_so_far = tmp;
            }

            max_so_far = Math.max(nums[i], nums[i] * max_so_far);
            min_so_far = Math.min(nums[i], nums[i] * min_so_far);

            p = Math.max(max_so_far, p);
        }
        return p;
    }
}