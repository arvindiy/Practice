package leet;

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
		int rows = matrix.length;
		int cols = matrix[0].length;

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;

		int top = 0;
		int right = cols - 1;
		int bottom = rows - 1;
		int left = 0;

		while (result.size() < (rows * cols)) {
			for (int i = top; i <= right; i++) {
				result.add(matrix[top][i]);
			}
			top++;

			for (int i = right; i <= bottom; i++) {
				result.add(matrix[i][right]);
			}
			right--;

			if (bottom > top)
				break;

			for (int i = bottom; i >= left; i--) {
				result.add(matrix[bottom][i]);
			}
			bottom--;

			if (left < right)
				break;

			for (int i = left; i >= top; i--) {
				result.add(matrix[i][left]);
			}
			left++;
		}
		return result;
	}

}
