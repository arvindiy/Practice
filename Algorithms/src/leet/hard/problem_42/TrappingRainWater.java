package leet.hard.problem_42;

//https://leetcode.com/problems/trapping-rain-water/description/

//This was my facebook 2018 phone screening interview coding question

import java.util.ArrayList;
import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String args[]) {
		// (2,1), (3,1), (1,1), (3,2), (2,1), (3,2)
		// (height, width)
		// Find out how many slots can contain water.
		/**
		 * # ## ## ## ##### ########
		 *
		 */

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		{
			ArrayList<Integer> tuple = new ArrayList<Integer>();
			tuple.add(2);
			tuple.add(1);
			input.add(tuple);
			tuple = new ArrayList<Integer>();
			tuple.add(3);
			tuple.add(1);
			input.add(tuple);
			tuple = new ArrayList<Integer>();
			tuple.add(1);
			tuple.add(1);
			input.add(tuple);
			tuple = new ArrayList<Integer>();
			tuple.add(3);
			tuple.add(2);
			input.add(tuple);
			tuple = new ArrayList<Integer>();
			tuple.add(2);
			tuple.add(1);
			input.add(tuple);
			tuple = new ArrayList<Integer>();
			tuple.add(3);
			tuple.add(2);
			input.add(tuple);
		}

		ArrayList<Integer> towers = new ArrayList<Integer>();
		// Convert the tuples into an array
		for (int i = 0; i < input.size(); i++) {
			ArrayList<Integer> tuple = input.get(i);
			int height = tuple.get(0);
			int width = tuple.get(1);
			for (int j = 0; j < width; j++) {
				towers.add(height);
			}
		}
		System.out.println(towers);
		int arr[] = new int[towers.size()];
		int i = 0;
		for (Integer n : towers) {
			arr[i++] = n;
		}
		System.out.println(trapWater(arr));
		System.out.println(trapWater(new int[] { 2, 3, 1, 2, 2 }));
		System.out.println(new TrappingRainWater().trap(arr, arr.length));

	}

	/**
	 * This method would return the number of blocks of water this 2D structure can
	 * hold.
	 */
	private static int trapWater(int[] towers) {
		int answer = 0;
		// We can hold water only if there are more than 2 towers
		if (towers.length < 3)
			return answer;
		int left = 0;
		int right = towers.length - 1;
		// Keep moving to the right, until we find a tower taller than the one on the
		// left
		while (left < right && towers[left] <= towers[left + 1]) {
			left++;
		}

		// Keep moving to the left, until we find a tower taller than the one on the
		// right
		while (left < right && towers[right] <= towers[right - 1]) {
			right--;
		}

		// Move within the boundaries
		while (left < right) {
			int leftHeight = towers[left];
			int rightHeight = towers[right];
			if (leftHeight <= rightHeight) {
				// Move from left to right
				// Add all the volumes that are lesser than the left tower
				while (left < right && leftHeight >= towers[++left]) {
					answer += (leftHeight - towers[left]);
				}
			} else {
				// Move from right to left
				// Add all the volumes that are lesser than the right tower
				while (left < right && rightHeight >= towers[--right]) {
					answer += (rightHeight - towers[right]);
				}
			}
		}
		return answer;
	}

	/**
	 * an alternate implementation for the above method
	 * @param A
	 * @param n
	 * @return
	 */
	int trap(int A[], int n) {
		int left = 0;
		int right = n - 1;
		int res = 0;
		int maxleft = 0, maxright = 0;
		while (left <= right) {
			//Start with the smaller element
			if (A[left] <= A[right]) {				
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;
	}
}
