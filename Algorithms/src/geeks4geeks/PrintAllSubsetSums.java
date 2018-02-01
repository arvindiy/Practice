package geeks4geeks;

import java.util.ArrayList;

public class PrintAllSubsetSums {

	public static void main(String[] args) {
		// int[] arr = { 2, 3, 5, 6, 8, 10 };
		// int[] arr = {3, 34, 4, 12, 8, 2};
		// int sum = 11;

		// int[] arr = { 2, 3, 5, 6, 8, 10 };
		int[] arr = { 46, 34, 4, 12, 1, 43 };
		int sum = 47;

		printAllSubsets(arr, sum);
	}

	private static void printAllSubsets(int[] arr, int sum) {
		int n = arr.length;
		/*
		 * Define a 2D boolean array, where subsets[i][j] has true if a sum of "i"
		 * exists from 0...j-1 elements of the array. The array is of size [sum+1][n+1]
		 * because the sum can be 0<=i<=sum and the number of elements can be 0<=j<=n
		 */
		boolean sums[][] = new boolean[sum + 1][n + 1];

		/*
		 * A sum of "0" always exists, in the array, so we set [0][i] as true.
		 */
		for (int i = 0; i <= n; i++) {
			sums[0][i] = true;
		}
		/*
		 * a sum of "i" with 0 elements is always going to be false. but [0][0] means a
		 * sum of 0, with 0 elements, which is also true, so we start from 1 in the
		 * below loop
		 */
		for (int i = 1; i <= sum; i++) {
			sums[i][0] = false;
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
				sums[i][j] = sums[i][j - 1];
				// If the current element (j-1) is lesser than the current sum value, we are
				// trying to calculate
				if (i >= arr[j - 1]) {
					/*
					 * return the value from the previous column (no. of elements) or check if the
					 * sum can be obtained by including this element from the array
					 */
					sums[i][j] = sums[i][j] || sums[i - arr[j - 1]][j - 1];
				}
			}
		}

		// System.out.println(sums[sum][n]);

		// Now that the array is constructed, we would recursively
		// traverse this array, and print subarrays
		ArrayList<Integer> result = new ArrayList<Integer>();
		printSubsets(arr, n, sum, sums, result);
	}

	public static void printSubsets(int[] arr, int i, int targetSum, boolean[][] sums, ArrayList<Integer> result) {
		// System.out.println("evaluating for " + i + " for targetSum=" + targetSum);

		if (i == 1 && targetSum != 0 && sums[targetSum][1]) {
			// System.out.println("Checkpoint .01");
			result.add(arr[i - 1]);
			System.out.println(result);
			result.clear();
			return;
		}
		// If this is the last element, and sum is also 0
		// Then we print the list, clear the list (since its an object reference) and
		// return
		if (i == 1 && targetSum == 0) {
			System.out.println(result);
			result.clear();
			return;
		}

		// Don't include this element
		if (sums[targetSum][i]) {
			// System.out.println("Checkpoint 1");
			ArrayList<Integer> copyOfResult = new ArrayList<Integer>();
			copyOfResult.addAll(result);
			printSubsets(arr, i - 1, targetSum, sums, copyOfResult);
		}

		// System.out.println("arr[i-1]-->" + arr[i-1] + " targetSum - arr[i-1]--->" +
		// (targetSum - arr[i-1]));
		// System.out.println("sums[targetSum - arr[i-1]][i - 2] -> " + sums[targetSum -
		// arr[i-1]][i - 2]);

		// Include this element
		if (arr[i - 1] <= targetSum && sums[targetSum - arr[i - 1]][i - 1]) {
			// System.out.println("Checkpoint 2");
			result.add(arr[i - 1]);
			printSubsets(arr, i - 1, targetSum - arr[i - 1], sums, result);
		}
		// System.out.println("Checkpoint 3");

	}

}
