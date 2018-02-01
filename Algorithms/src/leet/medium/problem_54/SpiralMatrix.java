package leet.medium.problem_54;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/description/

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int rowBegin = 0;
		int rowEnd = rows - 1;
		int colBegin = 0;
		int colEnd = cols - 1;

		while (result.size() < (rows * cols)) {
			
			//Traverse from top left to top right
			for (int i = colBegin; i <= colEnd; i++) {
				result.add(matrix[rowBegin][i]);
			}
			rowBegin++;

			//Traverse from top right to bottom right
			for (int i = rowBegin; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;

			//Traverse from bottom right to bottom left
			if (rowBegin <= rowEnd) {
				for (int i = colEnd; i >= colBegin; i--) {
					result.add(matrix[rowEnd][i]);
				}
			} else
				System.out.println("A------" + rowBegin + " " + rowEnd);
			rowEnd--;

			//Traverse from bottom left to top left
			if (colBegin <= colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--) {
					result.add(matrix[i][colBegin]);
				}
			} else {
				System.out.println("B------" + colBegin + " " + colEnd);
			}
			colBegin++;
		}
		return result;
	}

}
