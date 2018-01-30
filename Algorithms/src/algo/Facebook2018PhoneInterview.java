package algo;

//https://leetcode.com/problems/trapping-rain-water/description/

import java.util.ArrayList;
import java.util.Arrays;

public class Facebook2018PhoneInterview {

	public static void main(String args[]) {
		// (2,1), (3,1), (1,1), (3,2), (2,1), (3,2)
		// (height, width)
		// Find out how many slots can contain water.
		/**
		 *  # ## ##
		 * ## #####
		 * ########		 
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
		//Convert the tuples into an array
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
		int i =0;
		for (Integer n : towers) {
			arr[i++] = n;
		}
		int answer = trapWater(arr);
		System.out.println(answer);
		
	}
	
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

		while (left < right) {
			int leftHeight = towers[left];
			int rightHeight = towers[right];
			if(leftHeight <= rightHeight) {
				while(left < right && leftHeight >= towers[++left]) {
					answer += (leftHeight - towers[left]);
				}
			}
			else {
				while(left < right && rightHeight >= towers[--right]) {
					answer += rightHeight - towers[right];
				}
			}
			
		}

		return answer;
	}

	

}
