package algo;

import java.util.ArrayList;

public class Facebook2018PhoneInterview {

	public static void main(String args[]) {
		// (2,1), (3,1), (1,1), (3,2), (2,1), (3,2)
		// (height, width)
		// Find out how many slots can contain water.

		/**
		 * 
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

		char[][] matrix = constructMatrix(input);

	}

	private static char[][] constructMatrix(ArrayList<ArrayList<Integer>> input) {
		int rows = 0;
		int cols = 0;
		/**
		 * Maximum value as the first element would be the number of rows in the
		 * resultant matrix.
		 */
		for (int i = 0; i < input.size(); i++) {
			ArrayList<Integer> tuple = input.get(i);
			rows = Math.max(rows, tuple.get(0));
			cols += tuple.get(1);
		}

		char[][] matrix = new char[rows][cols];
		int tupleIndex = 0;
		for (int i = cols - 1; i >= 0; i--) {
			for (int j = rows - 1; j >= 0; j--) {
				ArrayList<Integer> tuple = input.get(tupleIndex);
				int height = tuple.get(0);
				int width = tuple.get(1);

				if (height > 0) {
					matrix[i][j] = '#';
				}
				tuple.set(0, height--);

				tupleIndex++;

			}

		}
		return null;
	}

}
