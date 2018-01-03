package leet.problem_566;

//https://leetcode.com/problems/reshape-the-matrix/description/

public class ReshapeTheMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		ReshapeTheMatrix obj = new ReshapeTheMatrix();
		int[][] result = obj.matrixReshape(matrix, 2, 2);
	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			return nums;
		}
		int row = nums.length;
		int col = nums[0].length;
		if (r * c != row * col)
			return nums;
		int[][] result = new int[r][c];
		for (int i = 0; i < r * c; i++) {
			result[i / c][i % c] = nums[i / r][i % r];			
		}
		return result;
	}

}
