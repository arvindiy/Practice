package geeks4geeks;

//https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

public class SubsetSum {

    public static void main(String[] args) {
        //int[] arr = { 2, 3, 5, 6, 8, 10 };
        int[] arr = {3, 34, 4, 12, 8, 2};
        int sum = 7;
        System.out.println(subSetSum(arr, sum));
    }

    /**
     * A dynamic programming solution to find out if a subset exists with the sum
     * "sum" in the array "arr"
     *
     * @param arr
     * @param sum
     * @return
     */
    private static boolean subSetSum(int[] arr, int sum) {
        int n = arr.length;
        /*
         * Define a 2D boolean array, where subsets[i][j] has true if a sum of "i"
         * exists from 0...j-1 elements of the array. The array is of size [sum+1][n+1]
         * because the sum can be 0<=i<=sum and the number of elements can be 0<=j<=n
         */
        boolean subsets[][] = new boolean[sum + 1][n + 1];

        /*
         * A sum of "0" always exists, in the array, so we set [0][i] as true.
         */
        for (int i = 0; i <= n; i++) {
            subsets[0][i] = true;
        }
        /*
         * a sum of "i" with 0 elements is always going to be false. but [0][0] means a
         * sum of 0, with 0 elements, which is also true, so we start from 1 in the
         * below loop
         */
        for (int i = 1; i <= sum; i++) {
            subsets[i][0] = false;
        }

        /*
         * Iterate from 1, on both dimensions, to avoid the values set above.
         */
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                /*
                 * If a sum of 2 is possible from 3 elements, sum of 2 should be possible from 4
                 * elements too.
                 */
                subsets[i][j] = subsets[i][j - 1];
                // If the current element (j-1) is lesser than the current sum value, we are
                // trying to calculate
                if (i >= arr[j - 1]) {
                    /*
                     * return the value from the previous column (no. of elements) or check if
                     * the sum can be obtained by including this element from the array
                     */
                    subsets[i][j] = subsets[i][j] || subsets[i - arr[j - 1]][j - 1];
                }
            }
        }
        return subsets[sum][n];
    }

}
